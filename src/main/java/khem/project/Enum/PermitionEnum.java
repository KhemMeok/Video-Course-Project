package khem.project.Enum;

import lombok.Getter;

@Getter
public enum PermitionEnum {
    ADMIN("full"), SUBSCRIBER("video:read"), UNSUBSCRIBE("video:view");
   
    private final String description;

    private PermitionEnum(String description){
        this.description = description;
    }
}
