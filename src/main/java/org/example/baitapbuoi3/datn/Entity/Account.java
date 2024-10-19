package org.example.baitapbuoi3.datn.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
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

    @Size(max = 50)
    @NotNull
    @Column(name = "Password", nullable = false, length = 50)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rolesID")
    private Role rolesID;

    @OneToMany(mappedBy = "accountKhachHang")
    private Set<KhacHhang> khacHhangs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "accountNhanVien")
    private Set<NhanVien> nhanViens = new LinkedHashSet<>();

}