package com.kp.crud;

import com.kp.crud.entities.Account;
import com.kp.crud.entities.Login;
import com.kp.crud.entities.MyUserDetails;
import com.kp.crud.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyLoginDetailsService implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Account> account = accountRepository.findByUsername(userName);

        account.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return account.map(MyUserDetails::new).get();
    }
}
