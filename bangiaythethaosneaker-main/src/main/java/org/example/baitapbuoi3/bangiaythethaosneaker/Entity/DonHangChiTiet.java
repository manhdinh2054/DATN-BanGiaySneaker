package org.example.baitapbuoi3.bangiaythethaosneaker.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DonHangChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "idDonHang")
    private DonHang idDonHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSanPham")
    private SanPhamChiTiet idSanPham;

    @Column(name = "soLuong")
    private Integer soLuong;

    @Column(name = "donGia", precision = 10, scale = 2)
    private BigDecimal donGia;

    @Column(name = "thanhTien", precision = 10, scale = 2)
    private BigDecimal thanhTien;

}