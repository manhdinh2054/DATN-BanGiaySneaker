package org.example.baitapbuoi3.bangiaythethaosneaker.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SanPhamChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "maSanPham", length = 50)
    private String maSanPham;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "idSanPham", nullable = false)
    private SanPham idSanPham;

    @NotNull
    @Column(name = "kichCo", nullable = false)
    private Integer kichCo;

    @NotNull
    @Column(name = "soLuong", nullable = false)
    private Integer soLuong;

    @NotNull
    @Column(name = "donGia", nullable = false, precision = 18, scale = 2)
    private BigDecimal donGia;

    @NotNull
    @Column(name = "trangThai", nullable = false)
    private Boolean trangThai = false;

    @OneToMany(mappedBy = "idSanPham")
    private Set<DonHangChiTiet> donHangChiTiets = new LinkedHashSet<>();

}