package org.example.baitapbuoi3.bangiaythethaosneaker.Entity;

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
public class DonHangChiTietDTO {
        @Id
        private Integer id;
        private Integer idDonHang;
        private Integer idSanPham;
        private Integer soLuong;
        private BigDecimal donGia;
        private int kichCo;
        private String maSanPham;
        private String tenSanPham;
        private String anhSanPham;

}
