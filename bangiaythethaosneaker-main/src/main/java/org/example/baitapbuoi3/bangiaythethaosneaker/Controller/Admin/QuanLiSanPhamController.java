package org.example.baitapbuoi3.bangiaythethaosneaker.Controller.Admin;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.*;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.DanhMucRepository;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.SanPhamChiTietRepository;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.SanPhamRepository;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.ThuongHieuRepository;
import org.example.baitapbuoi3.bangiaythethaosneaker.Services.AccountServices;
import org.example.baitapbuoi3.bangiaythethaosneaker.Services.SanPhamChiTietServices;
import org.example.baitapbuoi3.bangiaythethaosneaker.Services.SanPhamServices;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class QuanLiSanPhamController {
    private final SanPhamServices spsv;
    private final SanPhamRepository spi;
    private final SanPhamChiTietRepository spcti;
    private final ThuongHieuRepository thi;
    private final DanhMucRepository dmi;
    private final SanPhamChiTietServices spctsv;
    private final SanPhamChiTietRepository spctrsp;

    @GetMapping("/admin/quanlisanpham/detail/{idsp}")
    public String quanLiSanPham(@PathVariable("idsp") int idSanPham, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, Model model) {
        Page<SanPhamChiTiet> lst = spsv.findSanPhamDetail(page, size, idSanPham);
        Optional<SanPham> sanPham = spi.findById(idSanPham);
        if (sanPham.isPresent()) {
            model.addAttribute("sanphamsss", sanPham.get());
        }
        model.addAttribute("sanphamdetail", lst);
        model.addAttribute("idsp", idSanPham);
        return "admin/quanlisanphamdetail";
    }

    @PostMapping("/admin/quanlisanpham/addsanpham")
    public String addSanPham(
            @RequestParam("tenSanPham") String tenSanPham,
            @RequestParam("mausac") String mausac,
            @RequestParam("idDanhMuc") DanhMuc idDanhMuc,
            @RequestParam("idThuongHieu") ThuongHieu idThuongHieu,
            @RequestParam("gia") BigDecimal gia,
            @RequestParam("moTa") String moTa,
            @RequestParam("anhSanPham11") MultipartFile[] anhSanPham,
            @Valid SanPham sanPham, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("message", bindingResult);
            return "redirect:/admin/quanlisanpham";
        }

        List<String> sanphamlst = new ArrayList<>();

        for (MultipartFile file : anhSanPham) {
            if (!file.isEmpty()) {
                try {
                    String fileName = file.getOriginalFilename();
                    Path uploadDir = Paths.get("../java6/images/product/" + fileName);

                    File imageDir = new File("../java6/images/product/");
                    if (!imageDir.exists()) {
                        imageDir.mkdirs();
                    }

                    Files.write(uploadDir, file.getBytes());
                    sanphamlst.add(fileName);

                } catch (IOException e) {
                    e.printStackTrace();
                    redirectAttributes.addFlashAttribute("message", "Lỗi tải ảnh lên");
                    return "redirect:/admin/quanlisanpham";
                }
            }
        }

        String imagesPathString = String.join(",", sanphamlst);
        sanPham.setAnhSanPham(imagesPathString);
        sanPham.setTenSanPham(tenSanPham);
        sanPham.setIdDanhMuc(idDanhMuc);
        sanPham.setIdThuongHieu(idThuongHieu);
        sanPham.setGia(gia);
        sanPham.setMoTa(moTa);
        sanPham.setTrangThai(false);
        spi.save(sanPham);

        redirectAttributes.addFlashAttribute("message", "Thêm sản phẩm thành công!");
        return "redirect:/admin/quanlisanpham";
    }

    @PostMapping("/admin/quanlisanpham/addsanphamdetail")
    public String addSanPhamDetail(@RequestParam("idSanPham") int idSanPham,
                                   @RequestParam("idSanPham") SanPham idSanPham1,
                                   @RequestParam("maSanPham") String maSanPham,
                                   @RequestParam("kichCo") int kichCo,
                                   @RequestParam("soLuong") int soLuong,
                                   @RequestParam("donGia") BigDecimal donGia,
                                   SanPhamChiTiet sanPhamChiTiet) {
        Optional<SanPhamChiTiet> spct = spctrsp.findByIdSanPhamAndKichCoSanPham11(idSanPham1,maSanPham,kichCo);
        if (spct.isPresent()){
            SanPhamChiTiet spctUpdate = spct.get();
            spctUpdate.setSoLuong(spctUpdate.getSoLuong() + soLuong);
            spctrsp.save(spctUpdate);
        }else {
            sanPhamChiTiet.setTrangThai(true);
            spctrsp.save(sanPhamChiTiet);
        }
        return "redirect:/admin/quanlisanpham/detail/" + idSanPham;
    }

    @GetMapping("/admin/quanlisanpham/timkiem")
    public String timKiemSanPham(@RequestParam("timKiemSanPham") String tenSanPham, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, Model model) {
        if (tenSanPham.trim().isEmpty() || tenSanPham == "") {
            Page<SanPham> sanPhamList = spsv.getSanPhamPage(page, size);
            model.addAttribute("lstsanpham", sanPhamList);
            return "admin/quanlisanpham";
        } else {
            Page<SanPham> sanPhams = spsv.getSanPhamTimKiem(page, size, tenSanPham);
            model.addAttribute("lstsanpham", sanPhams);
        }
        return "admin/quanlisanpham";
    }

    @GetMapping("/admin/quanlisanpham/detail/search")
    public String searchSanPhamDetail(@RequestParam("timkiemSanPhamChiTiet") String maSanPham, @RequestParam("idSanPhamss") int id, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, Model model) {
        if (maSanPham.trim().isEmpty() || maSanPham == "") {
            Page<SanPhamChiTiet> lst = spsv.findSanPhamDetail(page, size, id);
            model.addAttribute("sanphamdetail", lst);
        } else {
//            Page<SanPhamChiTiet> sanPhams = spsv.getSanPhamTimKiemMa(page, size, maSanPham);
//            model.addAttribute("lstsanpham", sanPhams);
        }

        return "redirect:/admin/quanlisanpham/detail/" + id;
    }
    @GetMapping("/admin/quanlisanpham/chinhsuasanpham/{id}")
    public String chinhSuaSanPham(@PathVariable("id") int id, Model model) {
        Optional<SanPham> sanPhamlst = spi.findById(id);
        List<ThuongHieu> lstthuonghieu = thi.findAll();
        List<DanhMuc> lstdanhmuc = dmi.findAll();

        if (sanPhamlst.isPresent()) {
            model.addAttribute("sanphamlst", sanPhamlst.get());
            model.addAttribute("danhmuclst",lstdanhmuc);
            model.addAttribute("thuonghieulst",lstthuonghieu);
        }
        return "admin/chinhsuasanpham";
    }
    @GetMapping("/admin/quanlisanpham/chinhsuasanphamchitiet/{id}")
    public String chinhSuaSanPhamChiTiet(@PathVariable("id") int id, Model model) {
        Optional<SanPhamChiTiet> sanPhamChiTiet = spcti.findById(id);
        if (sanPhamChiTiet.isPresent()) {
            model.addAttribute("sanphamchitiet", sanPhamChiTiet.get());
        }
        return "admin/chinhsuasanphamchitiet";
    }
    @PostMapping("/admin/quanlisanpham/chinhsuasanphamchitiet/change/{id}")
    public String chinhSuaSanPhamChiTietChange(@PathVariable("id") int id,
                                            @RequestParam("idSanPham") int idSanPham,
                                            @RequestParam("maSanPham")String maSanPham,
                                            @RequestParam("kichCo") int kichCo,
                                            @RequestParam("soLuong") int soLuong,
                                            @RequestParam("donGia") BigDecimal donGia,
                                            @RequestParam("trangThai") boolean trangThai,
                                            @ModelAttribute SanPhamChiTiet sanPhamChiTiet, RedirectAttributes redirectAttributes){
        Optional<SanPhamChiTiet> optionalSanPhamChiTiet = spcti.findById(id);
        if (!optionalSanPhamChiTiet.isPresent()) {
            redirectAttributes.addFlashAttribute("message", "Sản phẩm chi tiết sản phẩm không tồn tại");
            return "redirect:/admin/quanlisanpham";
        }
        sanPhamChiTiet.setKichCo(kichCo);
        sanPhamChiTiet.setSoLuong(soLuong);
        sanPhamChiTiet.setDonGia(donGia);
        sanPhamChiTiet.setTrangThai(trangThai);
        spcti.save(sanPhamChiTiet);
        return "redirect:/admin/quanlisanpham/detail/"+idSanPham;
    }

    @PostMapping("/admin/quanlisanpham/chinhsuasanpham/change/{id}")
    public String chinhSuaSanPhamChange(@PathVariable("id") int id,
                                        @RequestParam("anhSanPham11") MultipartFile[] anhSanPham,
                                        @RequestParam("tenSanPham")String tenSanPham,
                                        @RequestParam("mauSac")String mauSac,
                                        @RequestParam("idDanhMuc")DanhMuc idDanhMuc,
                                        @RequestParam("idThuongHieu")ThuongHieu idThuongHieu,
                                        @RequestParam("gia")BigDecimal gia,
                                        @RequestParam("moTa")String moTa,
                                        @RequestParam("trangThai") boolean trangThai,
                                        @ModelAttribute SanPham sanPham,RedirectAttributes redirectAttributes){

        Optional<SanPham> optionalSanPham = spi.findById(id);
        if (!optionalSanPham.isPresent()) {
            redirectAttributes.addFlashAttribute("message", "Sản phẩm không tồn tại");
            return "redirect:/admin/quanlisanpham";
        }

        List<String> sanphamlst = new ArrayList<>();
        for (MultipartFile file : anhSanPham) {
            if (!file.isEmpty()) {
                try {
                    String fileName = file.getOriginalFilename();
                    Path uploadDir = Paths.get("../images/product/" + fileName);

                    File imageDir = new File("../images/product/");
                    if (!imageDir.exists()) {
                        imageDir.mkdirs();
                    }

                    Files.write(uploadDir, file.getBytes());
                    sanphamlst.add(fileName);

                } catch (IOException e) {
                    e.printStackTrace();
                    redirectAttributes.addFlashAttribute("message", "Lỗi tải ảnh lên");
                    return "redirect:/admin/quanlisanpham";
                }
            }
        }

        String imagesPathString = String.join(",", sanphamlst);
        sanPham.setAnhSanPham(imagesPathString);
        sanPham.setTenSanPham(tenSanPham);
        sanPham.setMausac(mauSac);
        sanPham.setIdDanhMuc(idDanhMuc);
        sanPham.setIdThuongHieu(idThuongHieu);
        sanPham.setGia(gia);
        sanPham.setMoTa(moTa);
        sanPham.setTrangThai(trangThai);
        spi.save(sanPham);
        return "redirect:/admin/quanlisanpham";
    }


}
