package org.example.baitapbuoi3.bangiaythethaosneaker.Api;

import com.google.gson.Gson;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.DonHang;
import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.DonHangChiTiet;
import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.SanPhamChiTiet;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.DonHangChiTietRepository;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.DonHangRepository;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.SanPhamChiTietRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequiredArgsConstructor
public class GioHangApi {

    private final DonHangRepository dhrsp;
    private final DonHangChiTietRepository dhctrsp;
    private final SanPhamChiTietRepository spctrsp;

    @PostMapping("/cart/addonhangtocartcheckout")
    public ResponseEntity<?> purchaseCart(@RequestParam("hoVaTen") String hoVaTen,
                                          @RequestParam("sdtKhachHang") String sdtKhachHang,
                                          @RequestParam("diaChi") String diaChi,
                                          @RequestParam("tongtienthanhtoan12") BigDecimal tongtienthanhtoan,
                                          HttpServletRequest request) {
        Cookie[] cookie = request.getCookies();
        List<Map<String, String>> cartItems = new ArrayList<>();

        if (cookie != null) {
            for (Cookie c : cookie) {
                if ("cart".equals(c.getName())) {
                    String decodeCookie = new String(Base64.getDecoder().decode(c.getValue()));
                    Gson gson = new Gson();
                    cartItems = gson.fromJson(decodeCookie, List.class);
                    break;
                }
            }
        }

//        0 : giao hàng thành công
//        1 : đang giao hàng
//        2 : đã thanh toán(chờ xác nhận)
//        3 : chưa thanh toán
//        4 : đã hủy
//        hinh thuc thanh toan:
//                  true: tai quay;
//                  false: online;

        DonHang dh1 = new DonHang();
        dh1.setTenKhachhang(hoVaTen);
        dh1.setSdtKhachHang(sdtKhachHang);
        dh1.setDiaChi(diaChi);
        dh1.setNgayTaoDon(Instant.now());
        dh1.setTongTien(tongtienthanhtoan);
        dh1.setTrangThai(3);
        dh1.setHinhThucThanhToan(false);
        dhrsp.save(dh1);

        List<DonHangChiTiet> chiTietList = new ArrayList<>();
        for (Map<String, String> item : cartItems) {
            DonHangChiTiet dhct1 = new DonHangChiTiet();
            dhct1.setIdDonHang(dh1);
            SanPhamChiTiet sanPhamChiTiet = spctrsp.findById(Integer.parseInt(item.get("idSanPham"))).orElse(null);
            dhct1.setIdSanPham(sanPhamChiTiet);
            dhct1.setSoLuong(Integer.parseInt(item.get("soLuong")));
            dhct1.setDonGia(new BigDecimal(item.get("gia")));
            chiTietList.add(dhct1);
        }
        dhctrsp.saveAll(chiTietList);
        Map<String, Object> response = new HashMap<>();
        response.put("idDonHang", dh1.getId());

        return ResponseEntity.ok(response);
    }

}
