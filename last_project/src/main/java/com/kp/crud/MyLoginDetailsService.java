package com.kp.crud;

import com.kp.crud.models.Login;
import com.kp.crud.models.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyLoginDetailsService implements UserDetailsService {

    @Autowired
    AccountRepositoryy accountRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Login> account = accountRepository.findByUsername(userName);

        account.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return account.map(MyUserDetails::new).get();
    }
}
