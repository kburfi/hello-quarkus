package org.burfi.greeting.service;

import lombok.RequiredArgsConstructor;
import org.burfi.greeting.dto.GreetingDto;
import org.burfi.greeting.dto.NewGreetingDto;
import org.burfi.greeting.repository.GreetingRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
@RequiredArgsConstructor
public class GreetingService {

    private final GreetingRepository greetingRepository;
    private final GreetingMapper greetingMapper;

    public Optional<GreetingDto> getById(UUID id) {
        return greetingRepository.findByIdOptional(id).map(greetingMapper::map);
    }

    public List<GreetingDto> getWithLimit(final int limit) {
        return greetingRepository.findWithLimit(limit).stream().map(greetingMapper::map).collect(Collectors.toList());
    }

    @Transactional
    public GreetingDto add(NewGreetingDto greetingDto) {
        var newEntity = greetingMapper.map(greetingDto);
        greetingRepository.persist(newEntity);
        return greetingMapper.map(newEntity);
    }
}
