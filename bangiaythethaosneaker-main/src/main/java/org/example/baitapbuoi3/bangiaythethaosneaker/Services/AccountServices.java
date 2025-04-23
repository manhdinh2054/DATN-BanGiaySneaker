package org.example.baitapbuoi3.bangiaythethaosneaker.Services;

import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.Account;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServices implements UserDetailsService {
    @Autowired
    private AccountRepository aci;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = aci.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        return User.builder()
                .username(account.getUserName())
                .password(account.getPassword())
                .roles(account.getRoles())
                .build();
    }

    public Page<Account> findAllAccountsByRole(String role, int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        return aci.findAllByRoles(role,pageable);
    }

    public Account getCurrentlyLoggedInAccount() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            System.out.println("No authentication found or user not authenticated.");
            return null;
        }
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            System.out.println("Logged in user: " + username);
            return aci.findByUserName(username).orElse(null);
        }
        return null;
    }


}
