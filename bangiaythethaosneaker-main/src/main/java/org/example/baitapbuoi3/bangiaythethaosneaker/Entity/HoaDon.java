package org.example.baitapbuoi3.bangiaythethaosneaker.Entity;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HoaDon {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "ngayLapHoaDon")
    private LocalDate ngayLapHoaDon;

    @Column(name = "idAccountKhachHang")
    private Integer idAccountKhachHang;

    @Column(name = "idAccountNhanVien")
    private Integer idAccountNhanVien;

    @Column(name = "tongTien", precision = 10, scale = 2)
    private BigDecimal tongTien;

    @Column(name = "trangThai")
    private Integer trangThai;

    @Size(max = 15)
    @Column(name = "sdtKhachHang", length = 15)
    private String sdtKhachHang;

    @Size(max = 100)
    @Nationalized
    @Column(name = "tenKhachhang", length = 100)
    private String tenKhachhang;

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

    @Column(name = "hinhThucThanhToan")
    private Boolean hinhThucThanhToan;

    @OneToMany(mappedBy = "idHoaDon")
    private Set<HoaDonChiTiet> hoaDonChiTiets = new LinkedHashSet<>();

}