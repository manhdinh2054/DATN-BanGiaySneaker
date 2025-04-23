package org.example.baitapbuoi3.bangiaythethaosneaker.Controller;


import org.example.baitapbuoi3.bangiaythethaosneaker.Services.ForgotPasswordService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class ForgotPasswordController {
    @Autowired
    private ForgotPasswordService forgotPasswordService;

    @GetMapping("/forgot-password")
    public String forgotPasswordPage() {
        return "forgotpass/forgot-password";
    }

    @GetMapping("/send-reset-link")
    public String sendResetLink(@RequestParam("email") String email,Model model) {
        boolean success = forgotPasswordService.sendResetPasswordEmail(email);
        if (success) {
            return "forgotpass/sendemailsuccess";
        }else {
            model.addAttribute("error", "không tìm thấy email");
        }
        return "forgotpass/forgot-password";
    }
    @GetMapping("/reset-password")
    public String resetPasswordPage(@RequestParam("token") String token, Model model) {
        model.addAttribute("token", token);
        return "forgotpass/reset-password";
    }

    @GetMapping("/submit-reset-password")
    public String submitResetPassword(@RequestParam("token") String token,Model model, @RequestParam("newPassword") String newPassword) {
        boolean success = forgotPasswordService.resetPassword(token, newPassword);
        if (success) {
            return "forgotpass/resetpasswordsuccess";
        }else {
            model.addAttribute("error", "phiên không hợp lệ hoặc đã hết hạn");

        }
        return "forgotpass/reset-password";
    }
}
