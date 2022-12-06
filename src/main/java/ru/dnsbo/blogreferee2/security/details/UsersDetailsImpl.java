package ru.dnsbo.blogreferee2.security.details;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.dnsbo.blogreferee2.models.Role;
import ru.dnsbo.blogreferee2.models.State;
import ru.dnsbo.blogreferee2.models.Users;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UsersDetailsImpl implements UserDetails {

    private Users users;

    public UsersDetailsImpl(Users users) {
        this.users = users;
    }

    public Users getUsers() {
        return users;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        String usersRole = users.getRole().name();
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(usersRole);
        return Collections.singletonList(simpleGrantedAuthority);

    }

    @Override
    public String getPassword() {
        return users.getPassword();
    }

    @Override
    public String getUsername() {
        return users.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !users.getState().equals(State.BANNED);
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
        return users.getState().equals(State.ACTIVE);
    }
}
