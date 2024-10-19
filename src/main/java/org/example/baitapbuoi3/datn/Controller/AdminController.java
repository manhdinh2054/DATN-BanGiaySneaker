package org.example.baitapbuoi3.datn.Controller;

import lombok.RequiredArgsConstructor;
import org.example.baitapbuoi3.datn.Entity.*;
import org.example.baitapbuoi3.datn.Repository.DonHangInterface;
import org.example.baitapbuoi3.datn.Repository.SanPhamInterface;
import org.example.baitapbuoi3.datn.Services.HoaDonServices;
import org.example.baitapbuoi3.datn.Services.SanPhamServices;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final SanPhamInterface spi;
//    private final NhanVienInterface nvi;
    private final DonHangInterface dhi;
    private final SanPhamServices spsv;
    private final HoaDonServices hdsv;
//    private final KhachHangServices khsv;
    @RequestMapping("/muahangtaiquay")
    public String muahangTaiQuay(Model model) {
        List<DonHang> lstdonhang = dhi.findAll();
        model.addAttribute("lstdonhang", lstdonhang);
        return "admin/muahangtaiquay";
    }
//    @RequestMapping("/quanlisanpham")
//    public String quanLiSanPham(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5")int size) {
//        Page<SanPham> sanPhamList = spsv.getSanPhamPage(page,size);
//        model.addAttribute("lstsanpham", sanPhamList);
//        return "admin/quanlisanpham";
//    }


    @RequestMapping("/quanlihoadon")
    public String quanLiHoaDonH(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10")int size, Model model) {
        Page<HoaDon> hdlst = hdsv.findAllHoaDonPage(page,size);
        model.addAttribute("hdlst", hdlst);
        return "admin/quanlihoadon";
    }

//    @RequestMapping("/quanlinhanvien")
//    public String quanLiNhanVien(Model model) {
//        List<NhanVien> lst = nvi.findAll();
//        model.addAttribute("lstnhanvien", lst);
//        return "admin/quanlinhanvien";
//    }
//    @RequestMapping("/quanlikhachhang")
//    public String quanLiDonHang(@RequestParam(defaultValue = "0")int page,@RequestParam(defaultValue = "10")int size,Model model) {
//        Page<KhacHhang> lst = khsv.getKhachhangpage(page,size);
//        model.addAttribute("lstnhanvien",lst);
//        return "admin/quanlikhachhang";
//    }
//    @RequestMapping("/quanlikhuyenmai")
//    public String quanLiKhuyenMai() {
//        return "admin/quanlikhuyenmai";
//    }
//    @RequestMapping("/thongke")
//    public String thongKe() {
//        return "admin/thongke";
//    }


}
