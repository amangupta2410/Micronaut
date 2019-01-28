package micro.naut.constants;

import java.util.*;

/**
 * Created by Karanbir Singh on 1/27/2019.
 **/
public class RoleConstants {

    public static final Long SYSTEM = 1L;
    public static final Long SUPER_ADMIN = 2L;
    public static final Long ADMIN = 3L;
    public static final Long AUDITOR = 4L;
    public static final Long GUEST = 5L;
    public static final Long USER = 6L;

    public static final String SYSTEM_ROLE_NAME = "SYSTEM";
    public static final String SUPER_ADMIN_ROLE_NAME = "SUPER_ADMIN";
    public static final String ADMIN_ROLE_NAME = "ADMIN";
    public static final String GUEST_ROLE_NAME = "GUEST";
    public static final String AUDITOR_ROLE_NAME = "AUDITOR";
    public static final String USER_ROLE_NAME = "USER";

    private static final Map<Long, String> ROLE_NAMES_INIT_MAP = new HashMap<>();
    private static final Map<String, Long> ROLE_ID_INIT_MAP = new HashMap<>();

    public static final Map<Long, String> ROLE_NAMES_MAP;
    public static final Map<String, Long> ROLE_ID_MAP;

    public static final List<String> ALLOWED_ROLES_FOR_LOGIN = new ArrayList<>();

    static {
        ROLE_ID_INIT_MAP.put(SYSTEM_ROLE_NAME,SYSTEM);
        ROLE_ID_INIT_MAP.put(SUPER_ADMIN_ROLE_NAME,SUPER_ADMIN);
        ROLE_ID_INIT_MAP.put(ADMIN_ROLE_NAME,ADMIN);
        ROLE_ID_INIT_MAP.put(GUEST_ROLE_NAME,GUEST);
        ROLE_ID_INIT_MAP.put(AUDITOR_ROLE_NAME,AUDITOR);
        ROLE_ID_INIT_MAP.put(USER_ROLE_NAME,USER);

        ROLE_NAMES_INIT_MAP.put(SYSTEM,SYSTEM_ROLE_NAME);
        ROLE_NAMES_INIT_MAP.put(SUPER_ADMIN,SUPER_ADMIN_ROLE_NAME);
        ROLE_NAMES_INIT_MAP.put(ADMIN,ADMIN_ROLE_NAME);
        ROLE_NAMES_INIT_MAP.put(GUEST,GUEST_ROLE_NAME);
        ROLE_NAMES_INIT_MAP.put(AUDITOR,AUDITOR_ROLE_NAME);
        ROLE_NAMES_INIT_MAP.put(USER,USER_ROLE_NAME);

        ALLOWED_ROLES_FOR_LOGIN.add(SYSTEM_ROLE_NAME);
        ALLOWED_ROLES_FOR_LOGIN.add(ADMIN_ROLE_NAME);

        ROLE_ID_MAP = Collections.unmodifiableMap(ROLE_ID_INIT_MAP);
        ROLE_NAMES_MAP = Collections.unmodifiableMap(ROLE_NAMES_INIT_MAP);
    }

    public Map<Long, String> getRoleNamesMap(){
        return ROLE_NAMES_MAP;
    }

    public Map<String, Long> getRoleIdMap(){
        return ROLE_ID_MAP;
    }

}