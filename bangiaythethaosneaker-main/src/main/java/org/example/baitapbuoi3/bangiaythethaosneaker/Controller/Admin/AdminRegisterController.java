package org.example.baitapbuoi3.bangiaythethaosneaker.Controller.Admin;

import lombok.RequiredArgsConstructor;
import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.Account;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.AccountRepository;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.EmployeeTempRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class AdminRegisterController {
    private final AccountRepository acrepo;
    private final PasswordEncoder passwordEncoder;
    private final EmployeeTempRepository etr;

    @GetMapping("/register")
    public String register() {
        return "admin/registerbyadmin";
    }
    @PostMapping("/register")
    public String registerUser(String username, String password, String email, String roles, Model model) {

        Optional<Account> accountByEmail = acrepo.findByEmail(email);
        if (accountByEmail.isPresent()) {
            model.addAttribute("error", "Email đã được sử dụng");
            return "admin/registerbyadmin";
        }

        Optional<Account> accountByUsername = acrepo.findByUserName(username);
        if (accountByUsername.isPresent()) {
            model.addAttribute("error", "Tên đăng nhập đã được sử dụng");
            return "admin/registerbyadmin";
        }

        String encodePassword = passwordEncoder.encode(password);
        Account newAccount = new Account();
        newAccount.setUserName(username);
        newAccount.setPassword(encodePassword);
        newAccount.setEmail(email);
        newAccount.setRoles(roles);
        newAccount.setNgayDangKi(LocalDate.now());
        newAccount.setTrangThai(true);
        acrepo.save(newAccount);

        return "redirect:/login";
    }


}
