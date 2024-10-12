package org.example.baitapbuoi3.datn.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "maNhanVien", nullable = false, length = 50)
    private String maNhanVien;

    @Size(max = 50)
    @Nationalized
    @Column(name = "tenNhanVien", length = 50)
    private String tenNhanVien;

    @Nationalized
    @Lob
    @Column(name = "diachi")
    private String diachi;

    @Size(max = 50)
    @Nationalized
    @Column(name = "sdt", length = 50)
    private String sdt;

    @Nationalized
    @Lob
    @Column(name = "anhDaiDien")
    private String anhDaiDien;

    @Column(name = "ngayDangKi")
    private LocalDate ngayDangKi;

    @Column(name = "trangThai")
    private Boolean trangThai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountNhanVien")
    private Account accountNhanVien;

    @Column(name = "gioitinh")
    private Boolean gioitinh;

    @Column(name = "ngaySinh")
    private LocalDate ngaySinh;

    @Size(max = 50)
    @Nationalized
    @Column(name = "viTri", length = 50)
    private String viTri;

    @OneToMany(mappedBy = "idNhanVien")
    private Set<HoaDon> hoaDons = new LinkedHashSet<>();

}