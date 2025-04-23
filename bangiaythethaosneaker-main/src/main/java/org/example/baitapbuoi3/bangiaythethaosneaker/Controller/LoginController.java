package org.example.baitapbuoi3.bangiaythethaosneaker.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class LoginController {
    @GetMapping("/login")
    public String loginPageAdEm(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không chính xác.");
        }
        return "adminemployeelogin";
    }
    @GetMapping("/user/login")
    public String loginPageUser(@RequestParam(value = "error", required =false)String error, Model model) {
        if(error != null) {
            model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không chính xác.");
        }
        return "userlogin";
    }
}
