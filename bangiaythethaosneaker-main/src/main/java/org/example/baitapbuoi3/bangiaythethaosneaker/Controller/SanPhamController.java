package org.example.baitapbuoi3.bangiaythethaosneaker.Controller;

import lombok.RequiredArgsConstructor;
import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.*;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.*;
import org.example.baitapbuoi3.bangiaythethaosneaker.Services.Cookie.CookieServices;
import org.example.baitapbuoi3.bangiaythethaosneaker.Services.Cookie.ParamServices;
import org.example.baitapbuoi3.bangiaythethaosneaker.Services.Cookie.SessionServices;
import org.example.baitapbuoi3.bangiaythethaosneaker.Services.SanPhamServices;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequiredArgsConstructor
public class SanPhamController {
    private final SanPhamRepository spi;
    private final SanPhamServices spsv;
    private final DanhMucRepository dmi;
    private final DonHangRepository dhi;
    private final ThuongHieuRepository thi;
    private final SanPhamChiTietRepository spbti;

    private final CookieServices cookieServices;
    private final ParamServices paramServices;
    private final SessionServices sessionServices;

    @RequestMapping("/sanpham")
    public String sanPham(Authentication authentication, Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        if(authentication != null && authentication.isAuthenticated()){
            model.addAttribute("isLoggedIn", true);
            model.addAttribute("username", authentication.getName());
        }
        Page<SanPham> sanphamlst = spsv.fillanPhamByTen(page, size);
        List<DanhMuc> lstdanhmuc = dmi.findAll();
        List<ThuongHieu> lstthuonghieu = thi.findAll();
        model.addAttribute("lstthuonghieu", lstthuonghieu);
        model.addAttribute("lstdanhmuc", lstdanhmuc);
        model.addAttribute("lstsanpham", sanphamlst);
        return "sanpham";
    }

    @GetMapping("/sanpham/danhmuc/{id}")
    public String getSanPhamDanhMuc(@PathVariable("id") int id, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, Model model) {
        Page<SanPham> sanphamlstdanhmuc = spsv.findSanPhamByDanhMuc(page, size, id);
        List<DanhMuc> lstdanhmuc = dmi.findAll();
        List<ThuongHieu> lstthuonghieu = thi.findAll();
        model.addAttribute("lstthuonghieu", lstthuonghieu);
        model.addAttribute("lstdanhmuc", lstdanhmuc);
        model.addAttribute("sanphamlstdanhmuc", sanphamlstdanhmuc);
        model.addAttribute("iddanhmuc", id);
        return "sanphamdanhmuc";
    }

    @GetMapping("/sanpham/thuonghieu/{id}")
    public String getSanPhamThuongHieu(@PathVariable("id") int id, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, Model model) {
        Page<SanPham> sanphamlstthuonghieu = spsv.findSanPhamByThuongHieu(page, size, id);
        List<DanhMuc> lstdanhmuc = dmi.findAll();
        List<ThuongHieu> lstthuonghieu = thi.findAll();
        model.addAttribute("lstthuonghieu", lstthuonghieu);
        model.addAttribute("lstdanhmuc", lstdanhmuc);
        model.addAttribute("sanphamlstthuonghieu", sanphamlstthuonghieu);
        model.addAttribute("iddanhmuc", id);
        return "sanphamthuonghieu";
    }

    @GetMapping("/sanpham/sanphamchitiet/{id}/{tsp}")
    public String sanPhamChiTiet(Model model, @PathVariable("id") int id,@PathVariable("tsp")String tenSanPham) {
        Optional<SanPham> sanPhamlst = spi.findById(id);
        List<DanhMuc> lstdanhmuc = dmi.findAll();
        List<ThuongHieu> lstthuonghieu = thi.findAll();
        List<SanPhamChiTiet> lstsanphambienthe = spbti.getSanPhamBienTheByIdSanPham(id);
        model.addAttribute("lstthuonghieu", lstthuonghieu);
        model.addAttribute("lstdanhmuc", lstdanhmuc);
        model.addAttribute("lstsanphambt",lstsanphambienthe);
        if (sanPhamlst.isPresent()) {
            model.addAttribute("sanphamchitietlst", sanPhamlst.get());
        }
        return "sanphamchitiet";
    }

    @PostMapping("/sampham/sanphamchitiet/addtodh")
    public String addSanPhamToDonHang(@RequestParam("id") int id,
                                      @RequestParam("kichCo")int kichCo,
                                      @RequestParam("mauSac") int mauSac,
                                      @RequestParam("soLuong") int soLuong,
                                       DonHangChiTiet dhct,
                                      Model model) {
        SanPham sp = spi.findByIdSanPham(id);
        if(sp == null) {
            model.addAttribute("errors","không tìm thấy sản phẩm");
            return null;
        }
        return "sanphamchitiet";
    }

//    @PostMapping("/card/items")
//    public ResponseEntity<?> showCard(@CookieValue(value = "cart",defaultValue = "") String encodeData ) {
//        if(encodeData.isEmpty()){
//            return ResponseEntity.badRequest().body("no data found!");
//        }
//        byte[] data = Base64.getDecoder().decode(encodeData);
//        String jsonData  = new String(data);
//        Gson gson = new Gson();
//        List<Map<String,String>> cartItems = gson.fromJson(jsonData,new TypeToken<List<Map<String,String>>>(){}.getType());
//        List<CartDetail> cartDetails = new ArrayList<>();
//        for(Map<String,String> entry : cartItems){
//            int idSanPham = Integer.parseInt(entry.get("idSanPham"));
//            int kichCo = Integer.parseInt(entry.get("kichCo"));
//            int soLuong = Integer.parseInt(entry.get("soLuong"));
//
//            CartDetail sanPhamChiTiet = cdi.sanPhamGioHangGetData(idSanPham,kichCo);
//
//            if(sanPhamChiTiet != null){
//                sanPhamChiTiet.setSoLuong(soLuong);
//                cartDetails.add(sanPhamChiTiet);
//            }
//        }
//        return ResponseEntity.ok(cartDetails);
//    }
}
