package org.example.baitapbuoi3.bangiaythethaosneaker.Repository;

import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham,Integer> {
    @Query(value = "select * from SanPham", nativeQuery = true)
    Page<SanPham> getSanPhamPage1(Pageable pageable);
    @Query(value = "select * from sanPham where idDanhMuc = :idDanhMuc", nativeQuery = true)
    Page<SanPham> findSanPhamByDanhMuc(Pageable pageable, int idDanhMuc);
    @Query(value = "select * from sanPham where idThuongHieu = :idThuongHieu", nativeQuery = true)
    Page<SanPham> findSanPhamByThuongHieu(Pageable pageable,int idThuongHieu);

    @Query(value = "SELECT * FROM SanPham", nativeQuery = true)
    Page<SanPham> findAllSanPham(Pageable pageable);

    @Query(value = "select * from sanPham where id =:id", nativeQuery = true)
    SanPham findByIdSanPham(int id);
    @Query(value = "SELECT * FROM SanPham sp WHERE sp.tenSanPham LIKE %:tenSanPham%",nativeQuery = true)
    Page<SanPham> findSanPhamByName(Pageable pageable, String tenSanPham);


}
