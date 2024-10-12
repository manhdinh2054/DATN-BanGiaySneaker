package org.example.baitapbuoi3.datn.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class GiamGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "giamGiaPhamTram", precision = 5, scale = 2)
    private BigDecimal giamGiaPhamTram;

    @Column(name = "giamGiaSoTien", precision = 10, scale = 2)
    private BigDecimal giamGiaSoTien;

    @Column(name = "dieuKienApDung", precision = 10, scale = 2)
    private BigDecimal dieuKienApDung;

    @Column(name = "ngayBatDau")
    private LocalDate ngayBatDau;

    @Column(name = "ngayKetThuc")
    private LocalDate ngayKetThuc;

    @OneToMany(mappedBy = "idGiamGia")
    private Set<DonHang> donHangs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "giamGiaID")
    private Set<HoaDon> hoaDons = new LinkedHashSet<>();

}