package cyan.toolkit.token.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import cyan.toolkit.rest.RestValue;
import cyan.toolkit.rest.util.common.GeneralUtils;
import org.springframework.lang.NonNull;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>AuthorityType</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:08 2021/6/29
 */
public enum AuthorityType implements RestValue<Integer, String> {
    GUEST(RoleType.GUEST),
    USER(GUEST,RoleType.USER),
    MEMBER(USER,RoleType.MEMBER),
    LEADER(MEMBER,RoleType.LEADER),
    MANAGER(LEADER,RoleType.MANAGER),
    ADMIN(MANAGER,RoleType.ADMIN),
    SUPER(ADMIN,RoleType.SUPER)
    ;

    private final Integer key;
    private final String value;
    private final Set<RoleType> roles;

    AuthorityType(AuthorityType authority, RoleType role) {
        List<RoleType> values = authority.getRoles();
        values.add(role);
        this.roles = new HashSet<>(values);
        this.value = role.getValue();
        this.key = enrole(values);
    }

    AuthorityType(RoleType role) {
        this.roles = new HashSet<>(Collections.singletonList(role));
        this.value = role.getValue();
        this.key = enrole(role);
    }

    @Override
    @JsonValue
    public Integer getKey() {
        return this.key;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    public List<RoleType> getRoles() {
        return new ArrayList<>(this.roles);
    }

    public Integer toAuthority(Integer... privileges) {
        int complex = this.key;
        if (GeneralUtils.isNotEmpty(privileges)) {
            for (Integer privilege : privileges) {
                complex = privilege | complex;
            }
        }
        return complex;
    }

    @JsonCreator
    public static AuthorityType parserKey(@NonNull Integer key) {
        AuthorityType sortTypeEnum = RestValue.parserKey(AuthorityType.class, key);
        return Optional.ofNullable(sortTypeEnum).orElse(AuthorityType.GUEST);
    }

    public static AuthorityType parserValue(@NonNull String value) {
        AuthorityType sortTypeEnum = RestValue.parserValue(AuthorityType.class, value);
        return Optional.ofNullable(sortTypeEnum).orElse(AuthorityType.GUEST);
    }

    public static Integer enrole(RoleType... roleTypes) {
        Collection<RoleType> roleTypeList = Collections.emptyList();
        if (GeneralUtils.isNotEmpty(roleTypes)) {
            roleTypeList = new ArrayList<>(Arrays.asList(roleTypes));
        }
        return enrole(roleTypeList);
    }

    public static Integer enrole(Collection<RoleType> roleTypes) {
        Collection<Integer> privileges = Collections.emptyList();
        if (GeneralUtils.isNotEmpty(roleTypes)) {
            privileges = roleTypes.stream().map(RoleType::getKey).collect(Collectors.toList());
        }
        return encode(privileges);
    }

    public static Integer encode(Integer... privileges) {
        Collection<Integer> privilegeList = Collections.emptyList();
        if (GeneralUtils.isNotEmpty(privileges)) {
            privilegeList = new ArrayList<>(Arrays.asList(privileges));
        }
        return encode(privilegeList);
    }

    public static Integer encode(Collection<Integer> privileges) {
        int complex = 1;
        if (GeneralUtils.isNotEmpty(privileges)) {
            for (Integer privilege : privileges) {
                complex = privilege | complex;
            }
        }
        return complex;
    }

    public static boolean derole(AuthorityType complex, RoleType roleType) {
        return derole(complex.getKey(),roleType);
    }

    public static boolean derole(Integer complex, RoleType roleType) {
        if (GeneralUtils.isNotEmpty(complex) && GeneralUtils.isNotEmpty(roleType)) {
            return GeneralUtils.isNotEmpty(roleType.getKey() & complex);
        }
        return false;
    }

    public static boolean decode(AuthorityType complex, Integer privilege) {
        return decode(complex.getKey(),privilege);
    }

    public static boolean decode(Integer complex, Integer privilege) {
        if (GeneralUtils.isNotEmpty(complex) && GeneralUtils.isNotEmpty(privilege)) {
            return GeneralUtils.isNotEmpty(complex & privilege);
        }
        return false;
    }
}
