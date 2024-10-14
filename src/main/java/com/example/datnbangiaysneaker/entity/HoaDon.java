package com.example.datnbangiaysneaker.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "HoaDon")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @Column(name = "maHoaDon", length = 100)
    private String maHoaDon;

    @Column(name = "ngayLapHoaDon")
    private LocalDate ngayLapHoaDon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idKhachHang")
    private KhachHang idKhachHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idNhanVien")
    private NhanVien idNhanVien;

    @Column(name = "tongTien", precision = 10, scale = 2)
    private BigDecimal tongTien;

    @Column(name = "trangThai")
    private Integer trangThai;

    @Size(max = 15)
    @Column(name = "sdtKhachHang", length = 15)
    private String sdtKhachHang;

    @Size(max = 100)
    @Nationalized
    @Column(name = "tenKhachHang", length = 100)
    private String tenKhachHang;

    @Nationalized
    @Lob
    @Column(name = "diaChi")
    private String diaChi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "giamGiaID")
    private GiamGia giamGiaID;

    @Column(name = "soTienSauKhiGiam", precision = 10, scale = 2)
    private BigDecimal soTienSauKhiGiam;

    @Column(name = "khachTra", precision = 10, scale = 2)
    private BigDecimal khachTra;

    @OneToMany(mappedBy = "idHoaDon")
    private Set<HoaDonChiTiet> hoaDonChiTiets = new LinkedHashSet<>();
}
