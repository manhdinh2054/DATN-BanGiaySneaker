package org.example.baitapbuoi3.bangiaythethaosneaker.Controller.Employee;

import lombok.RequiredArgsConstructor;
import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.DonHang;
import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.HoaDon;
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
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController1 {
    private final DonHangServices dhsv;
    private final AccountServices asv;
    private final DonHangRepository dhi;
    private final SanPhamServices spsv;
    private final HoaDonServices hdsv;
    private final ThuongHieuRepository thi;
    private final DanhMucRepository dmi;
    private final AccountServices acsv;
    @RequestMapping("/muahangtaiquay")
    public String muahangTaiQuay11(Model model) {
        List<DonHang> lstdonhang = dhi.getDonHangTaiQuay(true);
        model.addAttribute("lstdonhang", lstdonhang);
        return "employee/employeemuahangtaiquay";
    }
    @RequestMapping("/quanlihoadon/quanli")
    public String quanLiHoaDonQuanLi11(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10")int size, Model model) {
        Page<DonHang> lsthoadonedit = dhsv.searchHoaDonByAllHinhThucThanhToanPage(false, page, size);
        model.addAttribute("lsthoadonedit", lsthoadonedit);
        return "employee/employeequanlihoadon";
    }
    @RequestMapping("/quanlihoadon/lichsu")
    public String quanLiHoaDonLichSu11(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10")int size, Model model) {
        Page<HoaDon> hdlst = hdsv.findAllHoaDonPage(page,size);
        model.addAttribute("hdlst", hdlst);
        return "employee/employeelichsuhoadon";
    }


}
