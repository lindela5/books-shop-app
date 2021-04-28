package com.innowise.darya.security;

import com.innowise.darya.entity.Account;
import com.innowise.darya.repositoty.AccountRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Log
@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Autowired
    public UserDetailsServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User doesn't exists"));
        log.info(account.getUsername() + " " + account.getPassword());
        return SecurityUser.fromUser(account);
    }
    // еще один метод с логином и паролем метод login
    // findByUsername(username) если нет ошибку ловит контролер
    //если есть проверка пароля, кодировать и проверить пароль в акаунте
    // если все хорошо возвращается userdetails
}
