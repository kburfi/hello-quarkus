package org.burfi.greeting.dto;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Builder
@Getter
public class NewGreetingDto {

    @NotNull
    @Length(max = 100)
    private String name;

    @NotNull
    private LocalDateTime timestamp;
}
