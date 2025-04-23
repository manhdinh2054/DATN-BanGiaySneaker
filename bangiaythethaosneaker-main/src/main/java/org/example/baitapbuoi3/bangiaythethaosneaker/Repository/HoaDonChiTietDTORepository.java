package org.example.baitapbuoi3.bangiaythethaosneaker.Repository;

import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.HoaDonChiTietDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonChiTietDTORepository extends JpaRepository<HoaDonChiTietDTO,Integer>{
    @Query(value = "select hdct.id,hdct.idHoaDon,sp.idSanPham,sp.maSanPham,hdct.soLuong,hdct.donGia,hdct.thanhTien from HoaDonChiTiet hdct inner join SanPhamChiTiet sp on hdct.idSanPham = sp.id where hdct.idHoaDon =:idHoaDon",nativeQuery = true)
    List<HoaDonChiTietDTO> getAllHoaDonByIdHoaDon(int idHoaDon);
}
