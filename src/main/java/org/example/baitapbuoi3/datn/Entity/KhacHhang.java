package org.example.baitapbuoi3.datn.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class KhacHhang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "maKhachhang", nullable = false, length = 50)
    private String maKhachhang;

    @Size(max = 50)
    @Nationalized
    @Column(name = "tenKhachHang", length = 50)
    private String tenKhachHang;

    @Size(max = 50)
    @Nationalized
    @Column(name = "diaChi", length = 50)
    private String diaChi;

    @Size(max = 100)
    @Column(name = "Email", length = 100)
    private String email;

    @Size(max = 50)
    @Nationalized
    @Column(name = "sdt", length = 50)
    private String sdt;

    @Column(name = "ngayDangKi")
    private LocalDate ngayDangKi;

    @Column(name = "trangThai")
    private Boolean trangThai;

    @Nationalized
    @Lob
    @Column(name = "anhDaiDien")
    private String anhDaiDien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountKhachHang")
    private Account accountKhachHang;

    @Column(name = "gioitinh")
    private Boolean gioitinh;

    @Column(name = "ngaysinh")
    private LocalDate ngaysinh;

    @OneToMany(mappedBy = "idKhachHang")
    private Set<DonHang> donHangs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idKhachHang")
    private Set<HoaDon> hoaDons = new LinkedHashSet<>();

}