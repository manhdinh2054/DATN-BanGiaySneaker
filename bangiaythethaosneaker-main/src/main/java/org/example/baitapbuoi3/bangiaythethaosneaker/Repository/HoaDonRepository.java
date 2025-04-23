package org.example.baitapbuoi3.bangiaythethaosneaker.Repository;

import jakarta.transaction.Transactional;
import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon,Integer> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO HoaDon(id,ngayLapHoaDon,idAccountKhachHang,idAccountNhanVien,tongTien,trangThai,sdtKhachHang,tenKhachhang,diaChi,giamGiaID,soTienSauKhiGiam,khachTra,hinhThucThanhToan)" +
            "select id,ngayTaoDon,idAccountKhachHang,idAccountNhanVien,tongTien,trangThai,sdtKhachHang,tenKhachhang,diaChi,idGiamGia,soTienSauKhiGiam,khachTra,hinhThucThanhToan from DonHang where id =:id", nativeQuery = true)
    void insertHoaDon(int id);

    @Query(value = "select * from HoaDon", nativeQuery = true)
    Page<HoaDon> findAllHoaDonPage(Pageable pageable);
    @Query(value = "select * from HoaDon where id = :id", nativeQuery = true)
    HoaDon findOneByHoaDon(int id);
    @Query(value = "SELECT * FROM HoaDon WHERE sdtKhachHang = :sdtKhachHang ", nativeQuery = true)
    Page<HoaDon> searchHoaDonByAll(String sdtKhachHang,Pageable pageable);
    @Query(value = "SELECT * FROM HoaDon WHERE trangThai = :trangthai ", nativeQuery = true)
    Page<HoaDon> searchHoaDonByAllTAndTrangThai(int trangthai,Pageable pageable);






    @Query("SELECT SUM(hd.tongTien) FROM HoaDon hd WHERE hd.ngayLapHoaDon BETWEEN :startDate AND :endDate")
    BigDecimal sumRevenueForWeek(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    // Tổng doanh thu trong tháng
    @Query("SELECT SUM(hd.tongTien) FROM HoaDon hd WHERE MONTH(hd.ngayLapHoaDon) = :month AND YEAR(hd.ngayLapHoaDon) = :year")
    BigDecimal sumRevenueForMonth(@Param("month") int month, @Param("year") int year);

    // Số lượng hóa đơn đã thanh toán
    @Query("SELECT COUNT(hd) FROM HoaDon hd WHERE hd.hinhThucThanhToan = true")
    long countPaidInvoices();
}
