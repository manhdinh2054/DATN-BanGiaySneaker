package org.example.baitapbuoi3.bangiaythethaosneaker.Controller.Employee;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.*;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.*;
import org.example.baitapbuoi3.bangiaythethaosneaker.Services.ChuyenHoaDonServices;
import org.example.baitapbuoi3.bangiaythethaosneaker.Services.CreatePDF.CreatePdfHoaDonServices;
import org.example.baitapbuoi3.bangiaythethaosneaker.Services.SanPhamServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class NhanVienBanHangTaiQuayController {
    private final DonHangRepository dhi;
    private final DonHangChiTietRepository dhcti;
    private final DonHangChiTietDTORepository dhctdtoi;
    private final SanPhamDTORepository spdtoi;
    private final SanPhamChiTietRepository spcti;
    private final HoaDonDTORepository hddtorsp;
    private final HoaDonRepository hdi;
    private final ChuyenHoaDonServices chdsv;

    @RequestMapping("/employee/muahangtaiquay/add")
    public String addSanPham(DonHang dh, DonHangChiTiet dhct, RedirectAttributes redirectAttributes) {
        long demhoadon = dhi.count();
        if (demhoadon >= 5) {
            redirectAttributes.addFlashAttribute("errorthemhoadon", "Đã tạo 5 đơn hàng, bạn không thể tạo thêm nữa.");
        } else {
            dh.setHinhThucThanhToan(true);
            dhi.save(dh);
        }
        return "redirect:/employee/muahangtaiquay";
    }

    @GetMapping("/employee/muahangtaiquay/delete/{id}")
    public String deleteSanPham(@PathVariable("id") int id) {
        dhi.deleteById(id);
        return "redirect:/employee/muahangtaiquay";
    }

    @GetMapping("/employee/muahangtaiquay/{id}")
    public String editSanPham(@PathVariable("id") int id, Model model) {
        List<DonHang> lstdonhang = dhi.getDonHangTaiQuay(true);
        Optional<DonHang> dh = dhi.findById(id);
        List<DonHangChiTietDTO> lstdonhangchitiet = dhctdtoi.getAllDonHangChiTietWithSanPham(id);
        if (dh.isPresent()) {
            model.addAttribute("lstdonhang", lstdonhang);
            model.addAttribute("donhangtrongsp", dh.get());
            model.addAttribute("donhangchitietlst", lstdonhangchitiet);
            List<SanPhamDTO> lst = spdtoi.findAllSanPham();
            model.addAttribute("sanphamsss", lst);
        }
        return "employee/employeemuahangtaiquay1";
    }


    @PostMapping("/employee/muahangtaiquay/addsanpham")
    public String addSanPham(@RequestParam("idDonHang") int id,
                             @RequestParam("idSanPham") int idSanPham,
                             @RequestParam("soLuong") int soLuong,
                             @RequestParam("idSanPham") List<Integer> idSanPhamLst,
                             @ModelAttribute DonHangChiTiet dhct,Model model) {
        for (Integer idsp : idSanPhamLst) {
            SanPhamChiTiet spct = spcti.findById(idsp).orElseThrow(() -> new IllegalArgumentException("Không tìm thấy sản phẩm"));
            dhct.setIdSanPham(spct);
            dhct.setDonGia(spct.getDonGia());


            int soLuongHienTai = spct.getSoLuong();
            int soluongMoi = soLuongHienTai - soLuong;
            if(soluongMoi >=0 ){
                spct.setSoLuong(soluongMoi);
                spcti.save(spct);
            }else {
                model.addAttribute("message", "Số lượng sản phẩm không đủ.");
                return "redirect:/employee/muahangtaiquay/" + id;

            }

        }
        dhcti.save(dhct);


        return "redirect:/employee/muahangtaiquay/" + id;
    }


    @GetMapping("/employee/muahangtaiquay/deletespsss/{id}/{idDonHang}")
    public String deleteSanPham111(@PathVariable("id") int id1, @PathVariable("idDonHang") int idDonHang) {
        Optional<DonHangChiTiet> donHangChiTiet = dhcti.findById(id1);
        if (donHangChiTiet.isPresent()) {
            DonHangChiTiet dhct = donHangChiTiet.get();
            int idSanPham = dhct.getIdSanPham().getId();
            int soLuong = dhct.getSoLuong();

            Optional<SanPhamChiTiet> sanPhamChiTiet = spcti.findById(idSanPham);
            if (sanPhamChiTiet.isPresent()) {
                SanPhamChiTiet spct = sanPhamChiTiet.get();
                int soLuongHienTai = spct.getSoLuong();
                int soLuongMoi = soLuongHienTai + soLuong;
                spct.setSoLuong(soLuongMoi);
                spcti.save(spct);
            } else {
            }
        }
        dhctdtoi.deleteById1111(id1);
        return "redirect:/employee/muahangtaiquay/" + idDonHang;
    }

    @PostMapping("/employee/muahangtaiquay/addhoadon")
    public String addHoaDon(@RequestParam("idsss") int id, @Valid DonHang donHang, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("errorthemhoadon", "Vui lòng điền đầy đủ thông tin");
            return "redirect:/employee/muahangtaiquay/" + id;
        }
        donHang.setId(id);
        donHang.setNgayTaoDon(Instant.now());
        donHang.setTrangThai(1);
        donHang.setHinhThucThanhToan(true);
        dhi.save(donHang);
        chdsv.TransferToHoaDonService(id);
        chdsv.TransferToHoaDonChiTietService(id);
        dhi.deleteById(id);
        redirectAttributes.addFlashAttribute("messagesuccess","thanh toán thành công");
        return "redirect:/employee/muahangtaiquay/successbill/"+id;
    }
    @GetMapping("/employee/muahangtaiquay/successbill/{id}")
    public String viewThongBao(@PathVariable("id") int donHangId,Model model) {
        Optional<HoaDon> donHang = hdi.findById(donHangId);
        List<HoaDonDTO> donhangChiTiet = hddtorsp.getAllHoaDonChiTietByIdHoaDon(donHangId);
        if (donHang.isPresent()) {
            HoaDon hoaDon = donHang.get();
            model.addAttribute("hoadonlst", hoaDon);
            model.addAttribute("hoadonchitietlst", donhangChiTiet);
        }
         return "employee/employeethongbaothanhtoan";
    }
}
