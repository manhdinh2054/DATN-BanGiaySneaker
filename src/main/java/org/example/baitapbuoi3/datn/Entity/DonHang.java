package org.example.baitapbuoi3.datn.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idKhachHang")
    private KhacHhang idKhachHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idNhanVien")
    private NhanVien idNhanVien;

    @Column(name = "ngayTaoDon")
    private Instant ngayTaoDon;

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
    @JoinColumn(name = "idGiamGia")
    private GiamGia idGiamGia;

    @Column(name = "soTienSauKhiGiam", precision = 10, scale = 2)
    private BigDecimal soTienSauKhiGiam;

    @Column(name = "khachTra", precision = 10, scale = 2)
    private BigDecimal khachTra;

    @Column(name = "hinhThucThanhToan")
    private Boolean hinhThucThanhToan;

    @OneToMany(mappedBy = "idDonHang")
    private Set<DonHangChiTiet> donHangChiTiets = new LinkedHashSet<>();

}