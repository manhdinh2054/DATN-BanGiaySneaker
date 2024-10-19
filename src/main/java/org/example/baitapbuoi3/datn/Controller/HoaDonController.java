package org.example.baitapbuoi3.datn.Controller;

import lombok.RequiredArgsConstructor;
import org.example.baitapbuoi3.datn.Entity.HoaDon;
import org.example.baitapbuoi3.datn.Repository.HoaDonInterface;
import org.example.baitapbuoi3.datn.Services.HoaDonServices;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class HoaDonController {
    private final HoaDonServices hdsv;
    private final HoaDonInterface hdi;

    @GetMapping("/admin/quanlihoadon/search")
    public String searchHoaDon(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
                               @RequestParam(value = "sdtKhachHang", required = false) String sdt,
                               @RequestParam(value = "trangThai", required = false) int trangThai,
                               Model model) {
        if (trangThai == 00) {
            Page<HoaDon> hdlst = hdsv.findAllHoaDonPage(page, size);
            model.addAttribute("hdlst", hdlst);
        } else {
            Page<HoaDon> hdlst = hdsv.searchHoaDonPageAndTrangThai(trangThai, page, size);
            model.addAttribute("hdlst", hdlst);
        }
        if (!sdt.trim().isEmpty()) {
            Page<HoaDon> lsthoadon = hdsv.searchAllHoaDonPage(sdt, page, size);
            model.addAttribute("hdlst", lsthoadon);
        }

        return "admin/quanlihoadon";
    }
}
