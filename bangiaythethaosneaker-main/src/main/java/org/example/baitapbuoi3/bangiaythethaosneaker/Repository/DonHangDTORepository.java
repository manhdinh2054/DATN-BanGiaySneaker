package org.example.baitapbuoi3.bangiaythethaosneaker.Repository;

import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.DonHangDTO;
import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.HoaDonDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonHangDTORepository extends JpaRepository<DonHangDTO,Integer> {
    @Query(value = "select dhct.id,spct.maSanPham,sp.anhSanPham,sp.tenSanPham,spct.kichCo,dhct.soLuong,dhct.donGia from DonHangChiTiet dhct \n" +
            "inner join SanPhamChiTiet spct on dhct.idSanPham = spct.id join SanPham sp on spct.idSanPham = sp.id where dhct.idDonHang = :idDonHang",nativeQuery = true)
    List<DonHangDTO> getAllDonHangChiTietByIdHoaDon(int idDonHang);
}
