package micro.naut.services;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import micro.naut.constants.RoleConstants;
import micro.naut.dtos.UserDto;
import micro.naut.entities.User;
import micro.naut.repositories.RoleRepository;
import micro.naut.repositories.UserRepository;
import micro.naut.util.BcryptPasswordEncoderService;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Karanbir Singh on 1/27/2019.
 **/
@Singleton
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Inject
    private UserRepository userRepository;

    @Inject
    private RoleRepository roleRepository;

    @Inject
    BcryptPasswordEncoderService encoderService;

    public UserDto saveUser(UserDto userDto){
        if (userDto==null){
            logger.error("New User Details were null");
            return userDto;
        }
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(encoderService.encode(userDto.getPassword()));

        long newUsersRoleId = userDto.getId() == null ? RoleConstants.USER : userDto.getId();

        /*if(loggedInUserDto != null){
            logger.error("Logged in User Details not null");
            User loggedInUser = jpaUserRepository.findByUsername(loggedInUserDto.getUsername());
            user.setUpdatedBy(loggedInUser);
        }*/

        user.setEditable(userDto.isEditable());
        user.setEnabled(userDto.isEnabled());
        user.setDeleted(userDto.isDeleted());
        user.setExpired(userDto.isExpired());
        user.setCheckPasswordHistory(userDto.isCheckPasswordHistory());

        user.setRole(roleRepository.findById(newUsersRoleId).get());

        try {
            userRepository.save(user);
            userDto.setCreatedSuccessfully(true);
        }catch (ConstraintViolationException e){
            logger.error("Username -> "+userDto.getUsername()+" -> Already Exists");
            userDto.setCreatedSuccessfully(false);
            //throw new UsernameAlreadyExistsException(userDto.getUsername());
        }
        return userDto;
    }

}
