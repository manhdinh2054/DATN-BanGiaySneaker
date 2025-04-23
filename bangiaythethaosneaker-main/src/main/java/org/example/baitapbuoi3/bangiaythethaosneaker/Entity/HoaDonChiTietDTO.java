package org.example.baitapbuoi3.bangiaythethaosneaker.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
public class HoaDonChiTietDTO {
    @Id
    private Integer id;
    private Integer idHoaDon;
    private Integer idSanPham;
    private String maSanPham;
    private Integer soLuong;
    private BigDecimal donGia;
    private BigDecimal thanhTien;
}
