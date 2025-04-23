package org.example.baitapbuoi3.bangiaythethaosneaker.Repository;

import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.DonHang;
import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonHangRepository extends JpaRepository<DonHang,Integer> {

    @Query(value = "select * from DonHang where hinhThucThanhToan = :hinhThucThanhToan ", nativeQuery = true)
    Page<DonHang> searchHoaDonByAllHinhThucThanhToanPage(boolean hinhThucThanhToan, Pageable pageable);

    @Query(value = "select * from DonHang where hinhThucThanhToan = :hinhThucThanhToan",nativeQuery = true)
    List<DonHang> getDonHangTaiQuay(Boolean hinhThucThanhToan);

    @Query(value = "select * from DonHang  where sdtKhachHang = :sdtKhachHang",nativeQuery = true)
    Page<DonHang> searchDonHangBySdt(String sdtKhachHang,Pageable pageable);

    @Query(value = "select * from DonHang where trangThai = :trangThai",nativeQuery = true)
    Page<DonHang> searchDonHangByTrangThai(int trangThai,Pageable pageable);
}
