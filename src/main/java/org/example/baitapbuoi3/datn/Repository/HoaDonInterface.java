package org.example.baitapbuoi3.datn.Repository;

import jakarta.transaction.Transactional;
import org.example.baitapbuoi3.datn.Entity.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonInterface extends JpaRepository<HoaDon,Integer> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO HoaDon(id,ngayLapHoaDon,idKhachHang,idNhanVien,tongTien,trangThai,sdtKhachHang,tenKhachhang,diaChi,giamGiaID,soTienSauKhiGiam,khachTra,hinhThucThanhToan)" +
            "select id,ngayTaoDon,idKhachHang,idNhanVien,tongTien,trangThai,sdtKhachHang,tenKhachhang,diaChi,idGiamGia,soTienSauKhiGiam,khachTra,hinhThucThanhToan from DonHang where id =:id", nativeQuery = true)
    void insertHoaDon(int id);
    @Query(value = "select * from HoaDon", nativeQuery = true)
    Page<HoaDon> findAllHoaDonPage(Pageable pageable);

    @Query(value = "SELECT * FROM HoaDon WHERE sdtKhachHang = :sdtKhachHang ", nativeQuery = true)
    Page<HoaDon> searchHoaDonByAll(String sdtKhachHang,Pageable pageable);
    @Query(value = "SELECT * FROM HoaDon WHERE trangThai = :trangthai ", nativeQuery = true)
    Page<HoaDon> searchHoaDonByAllTAndTrangThai(int trangthai,Pageable pageable);
}
