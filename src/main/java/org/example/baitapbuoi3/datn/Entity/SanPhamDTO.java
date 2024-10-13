package org.example.baitapbuoi3.datn.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SanPhamDTO {
    @Id
    private Integer id;
    private String maSanPham;
    private String tenSanPham;
    private String mota;
    private String mauSac;
    private Integer kichCo;
    private Integer soLuowng;
    private String anhSanPham;
    private String tenThuongHieu;
    private BigDecimal gia;
    private Boolean trangthai;
    private String tenDanhMuc;
}
