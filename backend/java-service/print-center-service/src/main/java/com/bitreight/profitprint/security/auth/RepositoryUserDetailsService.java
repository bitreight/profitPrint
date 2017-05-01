package com.bitreight.profitprint.security.auth;

import com.bitreight.profitprint.repository.UserCredentialsRepository;
import com.bitreight.profitprint.repository.model.UserCredentialsEntity;
import com.bitreight.profitprint.repository.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author bitreight
 */
@Service
public class RepositoryUserDetailsService implements UserDetailsService {

    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredentialsEntity userCredentials = userCredentialsRepository.findOneByLogin(username);
        if (userCredentials == null) {
            throw new UsernameNotFoundException("Login \"" + username + "\" not found.");
        }

        UserEntity user = userCredentials.getUser();

        return new AuthenticatedUser()
                    .setId(user.getId())
                    .setLogin(userCredentials.getLogin())
                    .setPassword(userCredentials.getPassword())
                    .setAuthorities(Stream.of(userCredentials.getUserRole())
                                    .map(role -> new SimpleGrantedAuthority(role.name()))
                                    .collect(Collectors.toList()));
    }
}
