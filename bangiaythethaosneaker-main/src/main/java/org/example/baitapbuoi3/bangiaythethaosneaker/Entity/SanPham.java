package org.example.baitapbuoi3.bangiaythethaosneaker.Entity;

import jakarta.persistence.*;
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
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "maSanPham")
    private String maSanPham;

    @Size(max = 100)
    @Nationalized
    @Column(name = "tenSanPham", length = 100)
    private String tenSanPham;

    @Nationalized
    @Lob
    @Column(name = "moTa")
    private String moTa;

    @Nationalized
    @Lob
    @Column(name = "anhSanPham")
    private String anhSanPham;

    @Size(max = 50)
    @Nationalized
    @Column(name = "mausac", length = 50)
    private String mausac;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idThuongHieu")
    private ThuongHieu idThuongHieu;

    @Column(name = "gia", precision = 18, scale = 2)
    private BigDecimal gia;

    @Column(name = "trangThai")
    private Boolean trangThai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDanhMuc")
    private DanhMuc idDanhMuc;

    @OneToMany(mappedBy = "idSanPham")
    private Set<SanPhamChiTiet> sanPhamChiTiets = new LinkedHashSet<>();

}