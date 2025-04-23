package org.example.baitapbuoi3.bangiaythethaosneaker.Controller;

import com.google.gson.Gson;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.baitapbuoi3.bangiaythethaosneaker.Services.Cookie.CookieServices;
import org.example.baitapbuoi3.bangiaythethaosneaker.Services.Encode.Base64Services;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class GiohangController {
    private final CookieServices cksv;
    private final Base64Services base64Services;


    @PostMapping("/addtodh")
    public ResponseEntity<Map<String, Object>> addGioHang(@RequestBody Map<String, Object> cartData) {
        Map<String, Object> res = new HashMap<>();

        try {
            String idSp = cartData.get("idSanPham").toString();
            String soLuong = cartData.get("soLuong").toString();
            String kichCo = cartData.get("kichCo").toString();
            String tenSanPham = cartData.get("tenSanPham").toString();
            String anhSanPham = cartData.get("anhSanPham").toString();
            String gia = cartData.get("gia").toString();

            String cartJson = cksv.getValue("cart");
            if (cartJson != null && !cartJson.isEmpty()) {
                cartJson = base64Services.decodeBase64(cartJson);
            }

            List<Map<String, String>> cart;
            if (cartJson != null && !cartJson.isEmpty()) {
                cart = new Gson().fromJson(cartJson, ArrayList.class);
            } else {
                cart = new ArrayList<>();
            }
            boolean exists = false;
            for (Map<String, String> item : cart) {
                if (item.get("idSanPham").equals(idSp) && item.get("kichCo").equals(kichCo)) {
                    int currentQuantity = Integer.parseInt(item.get("soLuong"));
                    item.put("soLuong", String.valueOf(currentQuantity + Integer.parseInt(soLuong)));
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                Map<String, String> newSanPham = new HashMap<>();
                newSanPham.put("idSanPham", idSp);
                newSanPham.put("soLuong", soLuong);
                newSanPham.put("kichCo", kichCo);
                newSanPham.put("tenSanPham", tenSanPham);
                newSanPham.put("anhSanPham", anhSanPham);
                newSanPham.put("gia",gia);
                cart.add(newSanPham);
            }
            String updatedCartJson = new Gson().toJson(cart);
            String encodeCartJson = base64Services.encodeBase64(updatedCartJson);
            cksv.add("cart", encodeCartJson, 24);

            res.put("success", true);
            res.put("message", "Sản phẩm đã được thêm vào giỏ hàng!");
        } catch (Exception e) {
            e.printStackTrace();
            res.put("success", false);
            res.put("message", "Đã xảy ra lỗi khi thêm sản phẩm vào giỏ hàng.");
        }

        return ResponseEntity.ok(res);
    }
    @GetMapping("/view")
    public String getViewCart(Model model, HttpServletRequest request) {
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
        List<Integer> sanPhamId = new ArrayList<>();
        for (Map<String, String> item : cartItems) {
            sanPhamId.add(Integer.parseInt(item.get("idSanPham")));
        }
        model.addAttribute("cartItems", cartItems);
        return "giohang";
    }

}
