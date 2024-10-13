package org.example.baitapbuoi3.datn.Repository;

import org.example.baitapbuoi3.datn.Entity.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DonHangInterface extends JpaRepository<DonHang,Integer> {
    @Query(value = "INSERT INTO DonHang (idKhachHang, ngayTaoDon, tongTien, trangThai, sdtKhachHang, tenKhachHang) VALUES (:idKhachHang, :ngayTaoDon, :tongTien, :trangThai, :sdtKhachHang, :tenKhachHang)", nativeQuery = true)
    void insertDonHang(int idKhachHang, String ngayTaoDon, double tongTien, String trangThai, String sdtKhachHang, String tenKhachHang);

}
