package org.example.baitapbuoi3.bangiaythethaosneaker.Repository;

import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.SanPhamDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamDTORepository extends JpaRepository<SanPhamDTO,Integer> {
    @Query(value = "select spct.id,spct.maSanPham,sp.tenSanPham,sp.anhSanPham,spct.kichCo,spct.soLuong,spct.donGia from SanPhamChiTiet spct inner join SanPham sp on spct.idSanPham = sp.id",nativeQuery = true)
    List<SanPhamDTO> findAllSanPham();
}
