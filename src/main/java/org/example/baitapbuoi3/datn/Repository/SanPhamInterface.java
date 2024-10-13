package org.example.baitapbuoi3.datn.Repository;

import org.example.baitapbuoi3.datn.Entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamInterface extends JpaRepository<SanPham,Integer> {
    @Query(value = "WITH ranked_products AS ( " +
            "   SELECT *, ROW_NUMBER() OVER (PARTITION BY maSanPham ORDER BY gia DESC) AS rn " +
            "   FROM SanPham) " +
            "SELECT * FROM ranked_products WHERE rn = 1", nativeQuery = true)
    Page<SanPham> getSanPhamPage1(Pageable pageable);
    @Query(value = "WITH ranked_products AS ( " +
            "   SELECT *, ROW_NUMBER() OVER (PARTITION BY maSanPham ORDER BY gia DESC) AS rn " +
            "   FROM SanPham " +
            "   WHERE idDanhMuc = :idDanhMuc) " +
            "SELECT * FROM ranked_products WHERE rn = 1", nativeQuery = true)
    Page<SanPham> findSanPhamByDanhMuc(Pageable pageable, int idDanhMuc);
    @Query(value = "WITH ranked_products AS ( " +
            "   SELECT *, ROW_NUMBER() OVER (PARTITION BY maSanPham ORDER BY gia DESC) AS rn " +
            "   FROM SanPham " +
            "   WHERE idThuongHieu = :idDanhMuc) " +
            "SELECT * FROM ranked_products WHERE rn = 1", nativeQuery = true)
    Page<SanPham> findSanPhamByThuongHieu(Pageable pageable,int idDanhMuc);
    @Query(value = "select * from sanPham where maSanPham = :id",nativeQuery = true)
    List<SanPham> findSanPhamById1(String id);
    @Query(value = "select * from sanPham where maSanPham= :masanpham",nativeQuery = true)
    Page<SanPham> findDetailSanPham(Pageable pageable,String masanpham);

}
