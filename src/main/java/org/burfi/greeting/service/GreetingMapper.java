package org.burfi.greeting.service;

import org.burfi.greeting.dto.GreetingDto;
import org.burfi.greeting.dto.NewGreetingDto;
import org.burfi.greeting.repository.Greeting;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface GreetingMapper {

    GreetingDto map(Greeting greeting);

    Greeting map(NewGreetingDto dto);
}
