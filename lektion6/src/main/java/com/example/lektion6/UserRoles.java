package com.example.lektion6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.lektion6.UserPermission.*;


public enum UserRoles {
    USER(GET, POST),
    ADMIN(GET, POST, DELETE, PUT);

    private final List<String> permissions;

    UserRoles(UserPermission... permissionList) {
        this.permissions = Arrays.stream(permissionList)
                .map(UserPermission::getPermission)
                .toList();
    }

    public List<String> getListOfPermissions() {
        return permissions;
    }

    public List<SimpleGrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> simpleGrantedAuthorityList = new ArrayList<>();
        simpleGrantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_" + this.name())); // Springs Requirement for Authority Role (ROLE_)
                simpleGrantedAuthorityList.addAll(getListOfPermissions().stream().map(SimpleGrantedAuthority::new).toList());
        return simpleGrantedAuthorityList;
    }


}
