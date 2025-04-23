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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class QuanLiNhanVienController {
    private final AccountRepository acv;
    @GetMapping("/admin/quanlinhanvien/detail/{id}")
    public String quanLiNhanVien(@PathVariable("id") int id, Model model) {
        Optional<Account> account = acv.findById(id);
        if(account.isPresent()){
            model.addAttribute("detailnhanvien",account.get());
        }

        return "admin/quanlinhanviendetail";
    }
    @PostMapping("/admin/quanlinhanvien/detail/update/{id}")
    public String updateNhanVien(@PathVariable("id") int id, RedirectAttributes redirectAttributes,
                                 @RequestParam("anhDaiDien1")MultipartFile[] anhDaiDien1,
                                 @RequestParam("hoVaTen") String hovaTen,
                                 @RequestParam("ngaySinh")LocalDate ngaySinh,
                                 @RequestParam("diaChi") String diaChi,
                                 @RequestParam("sdt") String sdt,
                                 @RequestParam("trangThai") boolean trangThai,
                                 @ModelAttribute Account account
                                 ) {
        Optional<Account> optionalAccount = acv.findById(id);
        if (!optionalAccount.isPresent()) {
            redirectAttributes.addFlashAttribute("message", "Nhân viên không tồn tại");
            return "redirect:/admin/quanlinhanvien";
        }
        List<String> anhlst = new ArrayList<>();
        for (MultipartFile file : anhDaiDien1) {
            if (!file.isEmpty()) {
                try {
                    String fileName = file.getOriginalFilename();
                    Path uploadDir = Paths.get("../java6/images/usernv/" + fileName);

                    File imageDir = new File("../java6/images/usernv/");
                    if (!imageDir.exists()) {
                        imageDir.mkdirs();
                    }

                    Files.write(uploadDir, file.getBytes());
                    anhlst.add(fileName);

                } catch (IOException e) {
                    e.printStackTrace();
                    redirectAttributes.addFlashAttribute("message", "Lỗi tải ảnh lên");
                    return "redirect:/admin/quanlinhanvien";
                }
            }
        }
        Account sdw = null;
        if (optionalAccount.isPresent()) {
            sdw = optionalAccount.get();
        }
        account.setUserName(sdw.getUserName());
        account.setPassword(sdw.getPassword());
        account.setRoles(sdw.getRoles());
        String imagePathString = String.join(",", anhlst);
        account.setAnhDaiDien(imagePathString);
        account.setHoVaTen(hovaTen);
        account.setNgaySinh(ngaySinh);
        account.setDiaChi(diaChi);
        account.setSdt(sdt);
        account.setTrangThai(trangThai);
        acv.save(account);
        return "redirect:/admin/quanlinhanvien";
    }
    @PostMapping("/admin/quanlinhanvien/delete/{id}")
    public String deleteNhanVien(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("successdelete","Xóa thành công");
        acv.deleteById(id);
        return "redirect:/admin/quanlinhanvien";
    }
}
