package com.modelo.seguridad.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "permission_role")
public class permission_role{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_roleid")
    private int permission_roleid;

    @ManyToOne
    @JoinColumn(name = "pageid", nullable = false)
    private page page;

    @ManyToOne
    @JoinColumn(name = "roleid", nullable = false)
    private role role;

    @Column(name = "type", nullable = false)
    private String type;


    public permission_role(int permission_roleid, page page, role role, String type) {
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
