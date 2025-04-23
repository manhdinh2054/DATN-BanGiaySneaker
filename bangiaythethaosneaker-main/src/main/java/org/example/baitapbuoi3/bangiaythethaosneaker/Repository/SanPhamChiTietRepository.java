package org.example.baitapbuoi3.bangiaythethaosneaker.Repository;

import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.SanPham;
import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.SanPhamChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SanPhamChiTietRepository extends JpaRepository<SanPhamChiTiet,Integer> {
    @Query(value = "select * from sanPhamChiTiet where idSanPham=:idSanPham",nativeQuery = true)
    List<SanPhamChiTiet> getSanPhamBienTheByIdSanPham(int idSanPham);
    @Query(value = "SELECT * FROM SanPhamChiTiet where idSanPham=:idSanPham",nativeQuery = true)
    Page<SanPhamChiTiet> findDetailSanPham(Pageable pageable, int idSanPham);
    //api
    @Query(value = "SELECT soLuong FROM SanPhamChiTiet WHERE idSanPham = :idSanPham AND kichCo = :kichCo", nativeQuery = true)
    Optional<Integer> findByIdSanPhamApi(int idSanPham, int kichCo);
//    @Query(value = "SELECT * FROM SanPhamChiTiet spct WHERE spct.maSanPham LIKE %:maSanPham%",nativeQuery = true)
//    Page<SanPhamChiTiet> findSanPhamByMa(Pageable pageable, String maSanPham);

    @Query(value = "select * from SanPhamChiTiet where id = :id",nativeQuery = true)
    SanPhamChiTiet findSanPhamByMa(int id);

    @Query("SELECT s FROM SanPhamChiTiet s WHERE s.idSanPham = :idSanPham AND s.maSanPham = :maSanPham AND s.kichCo = :kichCo")
    Optional<SanPhamChiTiet> findByIdSanPhamAndKichCoSanPham11(SanPham idSanPham, String maSanPham, int kichCo);
}
