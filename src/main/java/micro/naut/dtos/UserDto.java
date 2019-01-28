package micro.naut.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Karanbir Singh on 1/27/2019.
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class UserDto extends AbstractDto<Long>{

    private String username;

    /**
     * Ignoring it so that it is not returned in response but only available to be part of request wherever applicable
     * Allowed only while writing
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String roleName;

    private String roleId;

    private String encodedPassword;

    private boolean checkPasswordHistory;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public void setEncodedPassword(String encodedPassword) {
        this.encodedPassword = encodedPassword;
    }

    public boolean passwordMatches(){
        return new BCryptPasswordEncoder().matches(this.password, this.encodedPassword);
    }

    public String getEncodedPassword() {
        return encodedPassword;
    }

    public boolean isCheckPasswordHistory() {
        return checkPasswordHistory;
    }

    public void setCheckPasswordHistory(boolean checkPasswordHistory) {
        this.checkPasswordHistory = checkPasswordHistory;
    }
}