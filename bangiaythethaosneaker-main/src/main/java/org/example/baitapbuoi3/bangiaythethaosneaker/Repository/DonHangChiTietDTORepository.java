package org.example.baitapbuoi3.bangiaythethaosneaker.Repository;

import jakarta.transaction.Transactional;
import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.DonHangChiTietDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonHangChiTietDTORepository extends JpaRepository<DonHangChiTietDTO, Integer> {
    @Query(value = "SELECT dhct.id AS id,spct.maSanPham,spct.idSanPham AS idSanPham,dhct.idDonHang AS idDonHang,dhct.soLuong AS soLuong,dhct.donGia AS donGia" +
            ",sp.anhSanPham AS anhSanPham,sp.tenSanPham AS tenSanPham,spct.kichCo FROM DonHangChiTiet dhct JOIN SanPhamChiTiet " +
            "spct ON dhct.idSanPham = spct.id JOIN SanPham sp ON spct.idSanPham = sp.id WHERE dhct.idDonHang = :id ", nativeQuery = true)
    List<DonHangChiTietDTO> getAllDonHangChiTietWithSanPham(int id);

    @Modifying
    @Transactional
    @Query(value = "delete from DonHangChiTiet where id = :id", nativeQuery = true)
    void deleteById1111(int id);
}
