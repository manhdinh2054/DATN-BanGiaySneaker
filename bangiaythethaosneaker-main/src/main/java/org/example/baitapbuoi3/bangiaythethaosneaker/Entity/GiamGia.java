package org.example.baitapbuoi3.bangiaythethaosneaker.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "trangThai")
    private Boolean trangThai;

    @OneToMany(mappedBy = "idGiamGia")
    private Set<DonHang> donHangs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "giamGiaID")
    private Set<HoaDon> hoaDons = new LinkedHashSet<>();

}