package com.modelo.seguridad.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "recovery_request")
public class recovery_request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recovery_requestid")
    private int recovery_requestid;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "token", length = 255, nullable = false)
    private String token;

    @Column(name = "expiration_time", nullable = false)
    private long expirationTime;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private user user;

    public recovery_request(int recovery_requestid, String email, String token, long expirationTime, user user) {
        this.recovery_requestid = recovery_requestid;
        this.email = email;
        this.token = token;
        this.expirationTime = expirationTime;
        this.user = user;
    }

    public int getRecovery_requestid() {
        return recovery_requestid;
    }
    public void setRecovery_requestid(int recovery_requestid) {
        this.recovery_requestid = recovery_requestid;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    public long getExpirationTime() {
        return expirationTime;
    }
    public void setExpirationTime(long expirationTime) {
        this.expirationTime = expirationTime;
    }

    public user getUser() {
        return user;
    }
    public void setUser(user user) {
        this.user = user;
    }
    
}
