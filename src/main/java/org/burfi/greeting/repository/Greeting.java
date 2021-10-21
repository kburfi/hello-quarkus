package org.burfi.greeting.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Greeting {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private UUID id;

    private String name;

    private LocalDateTime timestamp;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Greeting greeting = (Greeting) o;

        return Objects.equals(id, greeting.id);
    }

    @Override
    public int hashCode() {
        return 1471711281;
    }
}
