package org.example.baitapbuoi3.bangiaythethaosneaker.Controller;

import lombok.RequiredArgsConstructor;
import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.Account;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.AccountRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@RequiredArgsConstructor
@Controller

public class UserRegisterController {
    private final AccountRepository acrepo;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/user/register")
    public String register() {
        return "registerbyuser";
    }
    @PostMapping("/user/register")
    public String registerUser(String username, String password) {
        String encodePassword = passwordEncoder.encode(password);

        Account newAccount = new Account();
        newAccount.setUserName(username);
        newAccount.setPassword(encodePassword);
        newAccount.setRoles("CUSTOMER");
        newAccount.setNgayDangKi(LocalDate.now());
        newAccount.setTrangThai(true);
        acrepo.save(newAccount);
        return "redirect:/user/login";
    }

}
