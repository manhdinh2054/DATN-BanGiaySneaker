package org.example.baitapbuoi3.bangiaythethaosneaker.Repository;

import jakarta.transaction.Transactional;
import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.HoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, Integer> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO HoaDonChiTiet(idHoaDon,idSanPham,soluong,donGia,thanhTien)" +
            "select idDonHang,idSanPham,soLuong,donGia,thanhTien from DonhangChiTiet where idDonHang =:id", nativeQuery = true)
    void insertHoaDonChiTiet(int id);


}
