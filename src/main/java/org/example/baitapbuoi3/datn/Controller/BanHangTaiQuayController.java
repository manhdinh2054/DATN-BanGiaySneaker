package org.example.baitapbuoi3.datn.Controller;

import lombok.RequiredArgsConstructor;
import org.example.baitapbuoi3.datn.Entity.*;
import org.example.baitapbuoi3.datn.Repository.*;
import org.example.baitapbuoi3.datn.Services.SanPhamServices;
import org.example.baitapbuoi3.datn.Repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BanHangTaiQuayController {
    private final DonHangInterface dhi;
    private final SanPhamInterface spi;
    private final DonHangChiTietInterface dhcti;
    private final DonHangChiTietDTOInterface dhctdtoi;
    private final SanPhamDTOInterface spdtoi;
    private final SanPhamServices spsv;

    @RequestMapping("/admin/muahangtaiquay/add")
    public String addSanPham(DonHang dh, DonHangChiTiet dhct, RedirectAttributes redirectAttributes) {
        long demhoadon = dhi.count();
        if (demhoadon >= 5) {
            redirectAttributes.addFlashAttribute("errorthemhoadon", "Đã tạo 5 đơn hàng, bạn không thể tạo thêm nữa.");
        } else {
            dhi.save(dh);
        }
        return "redirect:/admin/muahangtaiquay";
    }

    @GetMapping("/admin/muahangtaiquay/delete/{id}")
    public String deleteSanPham(@PathVariable("id") int id) {
        dhi.deleteById(id);
        return "redirect:/admin/muahangtaiquay";
    }

    @GetMapping("/admin/muahangtaiquay/{id}")
    public String editSanPham(@PathVariable("id") int id, Model model) {
        List<DonHang> lstdonhang = dhi.findAll();
        Optional<DonHang> dh = dhi.findById(id);
        List<DonHangChiTietDTO> lstdonhangchitiet = dhctdtoi.getAllDonHangChiTietWithSanPham(id);
        if (dh.isPresent()) {
            model.addAttribute("lstdonhang", lstdonhang);
            model.addAttribute("donhangtrongsp", dh.get());
            model.addAttribute("donhangchitietlst", lstdonhangchitiet);
            List<SanPhamDTO> lst = spdtoi.findAllSanPham();
            model.addAttribute("sanphamsss", lst);
        }
        return "admin/muahangtaiquay1";
    }


    @PostMapping("/admin/muahangtaiquay/addsanpham")
    public String addSanPham(@RequestParam("soLuong")List<SanPham> soLuong,@RequestParam("idSanPham") List<SanPham> donhangselected, @RequestParam("idsss") int id, DonHangChiTiet dhct, Model model) {
        if (donhangselected != null && !donhangselected.isEmpty()) {
            for (SanPham productsss : donhangselected) {
                dhct.setIdDonHang(dhct.getIdDonHang());
                dhct.setIdSanPham(dhct.getIdSanPham());
                dhct.setSoLuong(dhct.getSoLuong());
                dhct.setDonGia(dhct.getDonGia());
                BigDecimal giasanpham = dhct.getDonGia();
                int soluongsanpham = dhct.getSoLuong();
                BigDecimal thanhTien = giasanpham.multiply(BigDecimal.valueOf(soluongsanpham));
                dhct.setThanhTien(thanhTien);
                dhcti.save(dhct);
            }
        } else {
            model.addAttribute("message", "Vui lòng chọn ít nhất một sản phẩm.");
        }
        return "redirect:/admin/muahangtaiquay/" + id;
    }

    @GetMapping("/admin/muahangtaiquay/deletespsss/{id}/{idDonHang}")
    public String deleteSanPham111(@PathVariable("id") int id1, @PathVariable("idDonHang") int idDonHang) {
        dhctdtoi.deleteById1111(id1);
        return "redirect:/admin/muahangtaiquay/" + idDonHang;
    }
    @PostMapping("/admin/muahangtaiquay/addhoadon")
    public String addHoaDon(@RequestParam("idsss") int id,DonHang donHang) {
        donHang.setId(id);
        donHang.setNgayTaoDon(Instant.now());
        dhi.save(donHang);
        return "redirect:/admin/muahangtaiquay/";
    }
}
