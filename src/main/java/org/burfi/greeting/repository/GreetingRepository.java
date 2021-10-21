package org.burfi.greeting.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class GreetingRepository implements PanacheRepositoryBase<Greeting, UUID> {

    public List<Greeting> findWithLimit(final int limit) {
        return findAll().page(0, limit).list();
    }
}
