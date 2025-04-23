package org.example.baitapbuoi3.bangiaythethaosneaker.Controller;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.DonHang;
import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.SanPham;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.DonHangRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.chrono.Chronology;
import java.time.temporal.ChronoUnit;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ReturnPaySuccessController {
    private final DonHangRepository dhrsp;
//        0 : giao hàng thành công
//        1 : đang giao hàng
//        2 : đã thanh toán(chờ xác nhận)
//        3 : chưa thanh toán
//        4 : đã hủy
//        hinh thuc thanh toan:
//                  true: tai quay;
//                  false: online;

    @GetMapping("/thongbaothanhtoan")
    public String getThongbaothanhtoan(@RequestParam Map<String, String> params,
                                       HttpServletResponse response) {
        String vnp_ResponseCode = params.get("vnp_ResponseCode");
        int vnp_idDonHang = Integer.parseInt(params.get("vnp_TxnRef"));
        BigDecimal vnp_Amount = new BigDecimal(params.get("vnp_Amount"));
        BigDecimal fixValue = vnp_Amount.divide(new BigDecimal("100"));
        vnp_Amount = fixValue.setScale(2,RoundingMode.HALF_UP);
        System.out.println(vnp_Amount);
        DonHang dh = dhrsp.findById(vnp_idDonHang).orElse(null);
        Cookie cookie = new Cookie("cart",null);

        if(dh != null){
            Instant now = Instant.now();
            Instant ngayTaoDonHang = dh.getNgayTaoDon();
            long thoiHan = ChronoUnit.HOURS.between(ngayTaoDonHang,now);
            if(thoiHan>24){
                dhrsp.delete(dh);
            }
        }
        if("00".equals(vnp_ResponseCode)){
            dh.setTrangThai(2);
            dh.setKhachTra(vnp_Amount);
            dhrsp.save(dh);
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
            return "VNPAY/orderSuccess";
        }else {

            return "VNPAY/orderFailed";
        }

    }
}
