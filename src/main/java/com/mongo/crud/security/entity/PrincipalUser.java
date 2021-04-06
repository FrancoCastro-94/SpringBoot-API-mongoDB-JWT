package com.mongo.crud.security.entity;

import java.util.ArrayList;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public class PrincipalUser implements UserDetails {
    
    private static final long serialVersionUID = 1L;
    
    private String name;
    private String userName;
    private String email;
    private String password;
    private List<GrantedAuthority> authorities;

    public PrincipalUser(String nombre, String nombreUsuario, String email, String password, List<GrantedAuthority> authorities) {
        this.name = nombre;
        this.userName = nombreUsuario;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static PrincipalUser build(User user){
        List<GrantedAuthority> authorities = new ArrayList();             
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        if(user.getRoles().contains("ROLE_ADMIN"))
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return new PrincipalUser(user.getName(), user.getUserName(), user.getEmail(), user.getPassword(), authorities);
    }

    @Override
    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
