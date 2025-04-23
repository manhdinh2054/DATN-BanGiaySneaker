package org.example.baitapbuoi3.bangiaythethaosneaker.Repository;

import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.HoaDonDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonDTORepository extends JpaRepository<HoaDonDTO,Integer> {
    @Query(value = "select hdct.id,spct.maSanPham,sp.anhSanPham,sp.tenSanPham,spct.kichCo,hdct.soLuong,hdct.donGia from hoadonchitiet hdct inner join SanPhamChiTiet spct on hdct.idSanPham = spct.id join SanPham sp on spct.idSanPham = sp.id where hdct.idHoaDon = :idHoaDon",nativeQuery = true)
    List<HoaDonDTO> getAllHoaDonChiTietByIdHoaDon(int idHoaDon);
}
