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
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ThuongHieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "maThuongHieu", nullable = false, length = 50)
    private String maThuongHieu;

    @Size(max = 50)
    @Nationalized
    @Column(name = "tenThuongHieu", length = 50)
    private String tenThuongHieu;

    @Nationalized
    @Lob
    @Column(name = "logo")
    private String logo;

    @Size(max = 200)
    @Nationalized
    @Column(name = "trangWeb", length = 200)
    private String trangWeb;

    @Size(max = 200)
    @Nationalized
    @Column(name = "diaChi", length = 200)
    private String diaChi;

    @Size(max = 200)
    @Nationalized
    @Column(name = "email", length = 200)
    private String email;

    @Size(max = 50)
    @Nationalized
    @Column(name = "sdt", length = 50)
    private String sdt;

    @Column(name = "ngayThanhLap")
    private LocalDate ngayThanhLap;

    @Nationalized
    @Lob
    @Column(name = "mota")
    private String mota;

    @OneToMany(mappedBy = "idThuongHieu")
    private Set<SanPham> sanPhams = new LinkedHashSet<>();

}