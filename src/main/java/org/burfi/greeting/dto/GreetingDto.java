package org.burfi.greeting.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
public class GreetingDto {

    private UUID id;

    private String name;

    private LocalDateTime timestamp;
}
