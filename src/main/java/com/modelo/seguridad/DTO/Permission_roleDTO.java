package com.modelo.seguridad.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.modelo.seguridad.model.page;
import com.modelo.seguridad.model.role;

public class Permission_roleDTO {
    @JsonProperty("id")
    private int permission_roleid;
    private page page;
    private role role;
    private String type;

    public Permission_roleDTO() {
    }

    public Permission_roleDTO(int permission_roleid, page page, role role, String type) {
        this.permission_roleid = permission_roleid;
        this.page = page;
        this.role = role;
        this.type = type;
    }

    public int getPermission_roleid() {
        return permission_roleid;
    }
    public void setPermission_roleid(int permission_roleid) {
        this.permission_roleid = permission_roleid;
    }

    public page getPage() {
        return page;
    }
    public void setPage(page page) {
        this.page = page;
    }

    public role getRole() {
        return role;
    }
    public void setRole(role role) {
        this.role = role;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

}
