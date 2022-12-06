package ru.dnsbo.blogreferee2.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.dnsbo.blogreferee2.data.UsersRepository;
import ru.dnsbo.blogreferee2.models.Users;

import java.util.Optional;

@Service
public class UsersDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        Optional<Users> usersCandidate = usersRepository.findByEmail(email);
        if (usersCandidate.isPresent())
            return new UsersDetailsImpl(usersCandidate.get());
        else try {
            throw new IllegalAccessException("Users not found");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
