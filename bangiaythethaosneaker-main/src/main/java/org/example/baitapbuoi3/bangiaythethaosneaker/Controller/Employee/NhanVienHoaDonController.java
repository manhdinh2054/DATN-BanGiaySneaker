package org.example.baitapbuoi3.bangiaythethaosneaker.Controller.Employee;

import lombok.RequiredArgsConstructor;
import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.DonHang;
import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.DonHangDTO;
import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.HoaDon;
import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.HoaDonDTO;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.DonHangDTORepository;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.HoaDonChiTietRepository;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.HoaDonDTORepository;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.HoaDonRepository;
import org.example.baitapbuoi3.bangiaythethaosneaker.Services.DonHangServices;
import org.example.baitapbuoi3.bangiaythethaosneaker.Services.HoaDonServices;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NhanVienHoaDonController {
    private final HoaDonServices hdsv;
    private final DonHangServices dhsv;
    private final HoaDonDTORepository hddtoi;
    private final HoaDonChiTietRepository hdctrsp;
    private final DonHangDTORepository dhstorsp;

    @GetMapping("/employee/quanlihoadon/quanli/search")
    public String searchHoaDon11(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
                               @RequestParam(value = "sdtKhachHang", required = false) String sdt,
                               @RequestParam(value = "trangThai", required = false) int trangThai,
                               Model model) {
//        0 : giao hàng thành công
//        1 : đang giao hàng
//        2 : đã thanh toán(chờ xác nhận)
//        3 : chưa thanh toán
//        4 : đã hủy
//        hinh thuc thanh toan:
//                  true: tai quay;
//                  false:
        if (trangThai == 00) {
            Page<DonHang> hdlst = dhsv.searchHoaDonByAllHinhThucThanhToanPage(false, page, size);
            model.addAttribute("hdlst", hdlst);
        }
        if (trangThai == 0) {
            Page<DonHang> lsthoadonedit = dhsv.searchDonHangByTrangThai(0, page, size);
            model.addAttribute("lsthoadonedit", lsthoadonedit);
        } else if (trangThai == 1) {
            Page<DonHang> lsthoadonedit = dhsv.searchDonHangByTrangThai(1, page, size);
            model.addAttribute("lsthoadonedit", lsthoadonedit);
        } else if (trangThai == 2) {
            Page<DonHang> lsthoadonedit = dhsv.searchDonHangByTrangThai(2, page, size);
            model.addAttribute("lsthoadonedit", lsthoadonedit);
        } else if (trangThai == 3) {
            Page<DonHang> lsthoadonedit = dhsv.searchDonHangByTrangThai(3, page, size);
            model.addAttribute("lsthoadonedit", lsthoadonedit);
        } else {
            Page<DonHang> lsthoadonedit = dhsv.searchDonHangByTrangThai(4, page, size);
            model.addAttribute("lsthoadonedit", lsthoadonedit);
        }
        if (!sdt.trim().isEmpty()) {
            Page<DonHang> lsthoadonedit = dhsv.searchHoaDonByAllHinhThucThanhToanPage(false, page, size);
            model.addAttribute("lsthoadonedit", lsthoadonedit);
        }

        return "employee/employeequanlihoadon";
    }
    @GetMapping("/employee/quanlihoadon/quanli/detail/{id}")
    public String showAndEditDetailHoaDon11(@PathVariable("id") int id, Model model) {
        List<DonHangDTO> hdct = dhstorsp.getAllDonHangChiTietByIdHoaDon(id);
        model.addAttribute("hoadonchitietlst", hdct);
        return "employee/employeequanlihoadonchitiet";
    }
    @GetMapping("/employee/quanlihoadon/lichsu/search")
    public String searchHoaDonLichSu111(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
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

        return "employee/employeelichsuhoadon";
    }
    @GetMapping("/employee/quanlihoadon/lichsu/detail/{id}")
    public String showDetailHoaDon11(@PathVariable("id") int id, Model model) {
        List<HoaDonDTO> lst = hddtoi.getAllHoaDonChiTietByIdHoaDon(id);
        model.addAttribute("hoadondetail", lst);
        return "employee/employeelichsuhoadonchitiet";
    }
}
