package org.example.baitapbuoi3.bangiaythethaosneaker.Controller.Admin;

import lombok.RequiredArgsConstructor;
import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.Account;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.AccountRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class QuanLiKhachHangController {
    private final AccountRepository aci;
    @GetMapping("/admin/quanlikhachhang/detail/{id}")
    public String quanLiKhachHang(@PathVariable("id") int id, Model model) {
        Optional<Account> account = aci.findById(id);
        if(account.isPresent()) {
            model.addAttribute("detailnhanvien",account.get());
        }

        return "admin/quanlikhachhangdetail";
    }
    @PostMapping("/admin/quanlikhachhang/detail/update/{id}")
    public String updateNhanVien(@PathVariable("id") int id, RedirectAttributes redirectAttributes,
                                 @RequestParam("anhDaiDien1") MultipartFile[] anhDaiDien1,
                                 @ModelAttribute Account account) {
        Optional<Account> optionalAccount = aci.findById(id);
        if (!optionalAccount.isPresent()) {
            redirectAttributes.addFlashAttribute("message", "Nhân viên không tồn tại");
            return "redirect:/admin/quanlikhachhang";
        }

        List<String> anhlst = new ArrayList<>();
        for (MultipartFile file : anhDaiDien1) {
            if (!file.isEmpty()) {
                try {
                    String fileName = file.getOriginalFilename();
                    Path uploadDir = Paths.get("../java6/images/userkh/" + fileName);

                    File imageDir = new File("../java6/images/userkh/");
                    if (!imageDir.exists()) {
                        imageDir.mkdirs();
                    }

                    Files.write(uploadDir, file.getBytes());
                    anhlst.add(fileName);

                } catch (IOException e) {
                    e.printStackTrace();
                    redirectAttributes.addFlashAttribute("message", "Lỗi tải ảnh lên");
                    return "redirect:/admin/quanlikhachhang";
                }
            }
        }
        Account sdw = null;
        if (optionalAccount.isPresent()) {
            sdw = optionalAccount.get();
        }
        String imagePathString = String.join(",", anhlst);
        account.setAnhDaiDien(imagePathString);
        account.setUserName(sdw.getUserName());
        account.setPassword(sdw.getPassword());
        account.setRoles(sdw.getRoles());
        aci.save(account);
        return "redirect:/admin/quanlikhachhang";
    }
    @PostMapping("/admin/quanlikhachhang/delete/{id}")
    public String deleteNhanVien(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("successdelete","Xóa thành công");
        aci.deleteById(id);
        return "redirect:/admin/quanlikhachhang";
    }

}
