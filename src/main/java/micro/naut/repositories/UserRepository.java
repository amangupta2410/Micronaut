package micro.naut.repositories;

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import io.micronaut.spring.tx.annotation.Transactional;
import micro.naut.entities.User;
import org.springframework.stereotype.Repository;

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
@Repository
public class UserRepository implements GenericRepository<User> {

    @PersistenceContext
    EntityManager entityManager;

    public UserRepository(@CurrentSession EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Optional<User> findById(@NotNull Long id) {
        return Optional.empty();
    }

    @Transactional
    public Optional<User> findByUsername(@NotNull String username){
        return Optional
                .ofNullable(
                        entityManager
                                .createQuery("select u from User where u.username = :username",User.class)
                                .setParameter("username", username)
                                .setMaxResults(1).getSingleResult()
                );
    }

    @Override
    @Transactional
    public User save(@NotNull User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    @Transactional
    public void deleteById(@NotNull Long id) {

    }

    @Override
    @Transactional
    public int update(@NotNull Long id, @NotNull User name) {
        return 0;
    }

}