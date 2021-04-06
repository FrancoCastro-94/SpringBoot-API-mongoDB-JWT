package com.mongo.crud.security.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public class JwtDto {
    
    private String token;
    private String bearer = "Bearer";
    private String userName;
    private List<GrantedAuthority> authorities;

    public JwtDto(String token, String userName, List<GrantedAuthority> authorities) {
        this.token = token;
        this.userName = userName;
        this.authorities = authorities;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getUserName() {
        return userName;
    }

    public void setNombreUsuario(String userName) {
        this.userName = userName;
    }

    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
