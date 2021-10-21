package org.burfi.greeting.resource;

import lombok.RequiredArgsConstructor;
import org.burfi.greeting.dto.NewGreetingDto;
import org.burfi.greeting.service.GreetingService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/greetings")
@RequiredArgsConstructor
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GreetingResource {

    private final GreetingService greetingService;

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") UUID id) {
        return greetingService.getById(id).map(g -> Response.ok(g).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @GET
    public Response getWithLimit(@Min(1) @DefaultValue("5") @QueryParam("limit") int limit) {
        return Response.ok(greetingService.getWithLimit(limit)).build();
    }

    @POST
    @Transactional
    public Response add(@NotNull @Valid NewGreetingDto greetingDto) {
        return Response.ok(greetingService.add(greetingDto)).build();
    }
}