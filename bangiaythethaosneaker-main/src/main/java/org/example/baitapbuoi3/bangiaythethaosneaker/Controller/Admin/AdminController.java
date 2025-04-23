package org.example.baitapbuoi3.bangiaythethaosneaker.Controller.Admin;

import lombok.RequiredArgsConstructor;
import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.*;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.*;
import org.example.baitapbuoi3.bangiaythethaosneaker.Services.AccountServices;
import org.example.baitapbuoi3.bangiaythethaosneaker.Services.DonHangServices;
import org.example.baitapbuoi3.bangiaythethaosneaker.Services.HoaDonServices;
import org.example.baitapbuoi3.bangiaythethaosneaker.Services.SanPhamServices;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final DonHangServices dhsv;
    private final AccountServices asv;
    private final DonHangRepository dhi;
    private final SanPhamServices spsv;
    private final HoaDonServices hdsv;
    private final ThuongHieuRepository thi;
    private final DanhMucRepository dmi;
    private final AccountServices acsv;
    @RequestMapping("/muahangtaiquay")
    public String muahangTaiQuay(Model model) {
        List<DonHang> lstdonhang = dhi.getDonHangTaiQuay(true);
        model.addAttribute("lstdonhang", lstdonhang);
        return "admin/muahangtaiquay";
    }
    @RequestMapping("/quanlisanpham")
    public String quanLiSanPham(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5")int size) {
        Page<SanPham> sanPhamList = spsv.getSanPhamPage(page,size);
        List<ThuongHieu> lstthuonghieu = thi.findAll();
        List<DanhMuc> lstdanhmuc = dmi.findAll();

        model.addAttribute("lstsanpham", sanPhamList);
        model.addAttribute("danhmuclst",lstdanhmuc);
        model.addAttribute("thuonghieulst",lstthuonghieu);
        return "admin/quanlisanpham";
    }

    @RequestMapping("/quanlihoadon/quanli")
    public String quanLiHoaDonQuanLi(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10")int size, Model model) {
        Page<DonHang> lsthoadonedit = dhsv.searchHoaDonByAllHinhThucThanhToanPage(false, page, size);
        model.addAttribute("lsthoadonedit", lsthoadonedit);
        return "admin/quanlihoadon";
    }
    @RequestMapping("/quanlihoadon/lichsu")
    public String quanLiHoaDonLichSu(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10")int size, Model model) {
        Page<HoaDon> hdlst = hdsv.findAllHoaDonPage(page,size);
        model.addAttribute("hdlst", hdlst);
        return "admin/lichsuhoadon";
    }
    @RequestMapping("/quanlivoucher")
    public String quanLiVoucher() {
        return "admin/quanlivoucher";
    }
    @RequestMapping("/quanlinhanvien")
    public String quanLiNhanVien(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10")int size, Model model) {
        Page<Account> lst = asv.findAllAccountsByRole("EMPLOYEE",page,size);
        model.addAttribute("lstnhanvien", lst);
        return "admin/quanlinhanvien";
    }
    @RequestMapping("/quanlikhachhang")
    public String quanLiDonHang(@RequestParam(defaultValue = "0")int page,@RequestParam(defaultValue = "10")int size,Model model) {
        Page<Account> lst = asv.findAllAccountsByRole("CUSTOMER",page,size);
        model.addAttribute("lstnhanvien",lst);
        return "admin/quanlikhachhang";
    }
    @RequestMapping("/quanlikhuyenmai")
    public String quanLiKhuyenMai() {
        return "admin/quanlikhuyenmai";
    }
    @RequestMapping("/thongke")
    public String thongKe() {
        return "admin/thongke";
    }

}
