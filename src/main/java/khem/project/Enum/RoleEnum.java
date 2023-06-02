package khem.project.Enum;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import lombok.Getter;

@Getter
public enum RoleEnum {

    ADMIN(Set.of(PermitionEnum.ADMIN)),
    UserUnSubscriber(Set.of(PermitionEnum.UNSUBSCRIBE)),
    UserSubscriber(Set.of(PermitionEnum.SUBSCRIBER));


    private final Set<PermitionEnum> permissionEnums;

    RoleEnum(Set<PermitionEnum> permissionEnum){
        this.permissionEnums = permissionEnum;
    }
    public Set<SimpleGrantedAuthority> grantedAuthorities(){
        return this.getPermissionEnums().stream()
            .map(per -> new SimpleGrantedAuthority(per.getDescription()))
            .collect(Collectors.toSet());
    }
}
