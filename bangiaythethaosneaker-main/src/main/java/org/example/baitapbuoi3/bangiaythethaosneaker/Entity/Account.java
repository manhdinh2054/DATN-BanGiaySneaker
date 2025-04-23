package org.example.baitapbuoi3.bangiaythethaosneaker.Entity;

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
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "UserName", nullable = false, length = 50)
    private String userName;

    @Size(max = 255)
    @NotNull
    @Column(name = "Password", nullable = false)
    private String password;

    @Size(max = 10)
    @NotNull
    @Column(name = "roles", nullable = false, length = 10)
    private String roles;

    @Size(max = 50)
    @Nationalized
    @Column(name = "hoVaTen", length = 50)
    private String hoVaTen;

    @Size(max = 50)
    @Nationalized
    @Column(name = "diaChi", length = 50)
    private String diaChi;

    @Size(max = 200)
    @Column(name = "email", length = 200)
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

    @Column(name = "gioiTinh")
    private Boolean gioiTinh;

    @Column(name = "ngaySinh")
    private LocalDate ngaySinh;

    @Column(name = "passwordResetToken")
    private String passwordResetToken;

    @OneToMany(mappedBy = "idAccountKhachHang")
    private Set<DonHang> donHangKhachHangs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idAccountNhanVien")
    private Set<DonHang> donHangNhanViens = new LinkedHashSet<>();

}