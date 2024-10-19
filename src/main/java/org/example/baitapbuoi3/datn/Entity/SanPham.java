package org.example.baitapbuoi3.datn.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "maSanPham", nullable = false, length = 50)
    private String maSanPham;

    @Size(max = 100)
    @Nationalized
    @Column(name = "tenSanPham", length = 100)
    private String tenSanPham;

    @Nationalized
    @Lob
    @Column(name = "mota")
    private String mota;

    @Size(max = 50)
    @Nationalized
    @Column(name = "mauSac", length = 50)
    private String mauSac;

    @Column(name = "kichCo")
    private Integer kichCo;

    @Column(name = "soLuong")
    private Integer soLuong;

    @Nationalized
    @Lob
    @Column(name = "anhSanPham")
    private String anhSanPham;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idThuongHieu")
    private ThuongHieu idThuongHieu;

    @Column(name = "gia", precision = 18, scale = 2)
    private BigDecimal gia;

    @Column(name = "trangthai")
    private Boolean trangthai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDanhMuc")
    private DanhMuc idDanhMuc;

    @OneToMany(mappedBy = "idSanPham")
    private Set<DonHangChiTiet> donHangChiTiets = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idSanPham")
    private Set<HoaDonChiTiet> hoaDonChiTiets = new LinkedHashSet<>();

}