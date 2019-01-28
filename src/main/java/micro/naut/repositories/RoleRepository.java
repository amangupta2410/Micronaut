package micro.naut.repositories;

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import io.micronaut.spring.tx.annotation.Transactional;
import micro.naut.entities.Role;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * Created by Karanbir Singh on 1/27/2019.
 **/
@Singleton
public class RoleRepository implements GenericRepository<Role> {

    @PersistenceContext
    EntityManager entityManager;

    public RoleRepository(@CurrentSession EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Optional<Role> findById(@NotNull Long id) {
        return Optional.ofNullable(entityManager.find(Role.class, id));
    }

    @Override
    public Role save(@NotBlank Role name) {
        return null;
    }

    @Override
    public void deleteById(@NotNull Long id) {

    }

    @Override
    public int update(@NotNull Long id, @NotNull Role name) {
        return 0;
    }
}
