package org.example.baitapbuoi3.bangiaythethaosneaker.Services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.Account;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class ForgotPasswordService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Transactional
    public boolean sendResetPasswordEmail(String email) {
        Account account = accountRepository.findByEmail(email).orElse(null);

        if (account != null) {
            String token = UUID.randomUUID().toString();
            account.setPasswordResetToken(token);
            accountRepository.save(account);
            try {
                sendEmail(account.getEmail(), token);
                return true;
            } catch (MessagingException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    private void sendEmail(String to, String token) throws MessagingException {
        String resetPasswordLink = "http://localhost:8080/auth/reset-password?token=" + token;

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject("Yêu cầu đổi mật khẩu");
        helper.setText("Nhấp vào đường link này để thay đổi mật khẩu: " + resetPasswordLink);

        mailSender.send(message);
    }

    @Transactional
    public boolean resetPassword(String token, String newPassword) {
        Account account = accountRepository.findByPasswordResetToken(token);

        if (account != null) {
            account.setPassword(new BCryptPasswordEncoder().encode(newPassword));
            account.setPasswordResetToken(null);
            accountRepository.save(account);
            return true;
        }
        return false;
    }
}
