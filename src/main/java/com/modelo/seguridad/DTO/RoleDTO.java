package com.modelo.seguridad.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoleDTO {
    @JsonProperty("id")
    private int roleid;
    private String name;
    private String description;

    public RoleDTO() {
    }

    public RoleDTO(int roleid, String name, String description) {
        this.roleid = roleid;
        this.name = name;
        this.description = description;
    }

    public int getRoleid() {
        return roleid;
    }
    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
