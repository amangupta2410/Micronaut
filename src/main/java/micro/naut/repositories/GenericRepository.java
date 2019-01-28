package micro.naut.repositories;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

/**
 * Created by Karanbir Singh on 1/27/2019.
 **/
public interface GenericRepository<T> {

    Optional<T> findById(@NotNull Long id);

    T save(@NotBlank T name);

    void deleteById(@NotNull Long id);

    int update(@NotNull Long id, @NotNull T name);

}