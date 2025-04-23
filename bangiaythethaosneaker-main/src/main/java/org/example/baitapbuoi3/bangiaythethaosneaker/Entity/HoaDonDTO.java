package org.example.baitapbuoi3.bangiaythethaosneaker.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HoaDonDTO {
    @Id
    private Integer id;
    private String maSanPham;
    private String anhSanPham;
    private String tenSanPham;
    private int kichCo;
    private Integer soLuong;
    private BigDecimal donGia;
}
