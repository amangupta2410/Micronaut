package micro.naut.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Karanbir Singh on 1/27/2019.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleDto extends AbstractDto<Long> {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RoleDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
