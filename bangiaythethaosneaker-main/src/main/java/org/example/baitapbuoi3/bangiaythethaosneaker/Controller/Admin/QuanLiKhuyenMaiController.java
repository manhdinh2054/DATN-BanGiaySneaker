package org.example.baitapbuoi3.bangiaythethaosneaker.Controller.Admin;

import lombok.RequiredArgsConstructor;
import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.GiamGia;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.KhuyenMaiRepository;
import org.example.baitapbuoi3.bangiaythethaosneaker.Services.KhuyenMaiServices;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class QuanLiKhuyenMaiController {
    private final KhuyenMaiServices kmsv;
    private final KhuyenMaiRepository kmr;

    @GetMapping("/admin/quanlikhuyenmai")
    public String getQuanlikhuyenMai(@RequestParam(defaultValue = "0")int page,@RequestParam(defaultValue = "10")int size, Model model){
        Page<GiamGia> lst = kmsv.getKhuyenMaiPage(page, size);
        model.addAttribute("lstkhuyenmai",lst);
        return "admin/quanlikhuyenmai";
    }
    @PostMapping("/admin/quanlikhuyenmai/add")
    public String addKhuyenMai(@ModelAttribute GiamGia giamGia, Model model){
        giamGia.setTrangThai(true);
        kmr.save(giamGia);
        return "redirect:/admin/quanlikhuyenmai";
    }
}
