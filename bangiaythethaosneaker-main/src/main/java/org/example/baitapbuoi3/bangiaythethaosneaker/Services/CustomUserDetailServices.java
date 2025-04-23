//package org.example.baitapbuoi3.bangiaythethaosneaker.Services;
//
//import org.example.baitapbuoi3.bangiaythethaosneaker.Config.CustomUserDetail;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//import java.util.HashSet;
//
//@Service
//public class CustomUserDetailServices implements UserDetailsService {
//    @Autowired
//    private AccountServices accountServices;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Account account = accountServices.findByUsername(username);
//        if (account == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        Collection<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        Role role = account.getRole();
//        if (role != null) {
//            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
//        }
//        return new CustomUserDetail(account, grantedAuthorities);
//    }
//}
