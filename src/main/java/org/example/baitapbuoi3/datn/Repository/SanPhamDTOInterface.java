package org.example.baitapbuoi3.datn.Repository;

import org.example.baitapbuoi3.datn.Entity.SanPhamDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamDTOInterface extends JpaRepository<SanPhamDTO,Integer> {
    @Query(value = "SELECT sp.id,sp.maSanPham,sp.tenSanPham,sp.mota,sp.mauSac,sp.kichCo,sp.soLuowng,sp.anhSanPham,th.tenThuongHieu,sp.gia,sp.trangthai,dm.tenDanhMuc FROM SanPham sp JOIN ThuongHieu th ON sp.idThuongHieu = th.id JOIN DanhMuc dm ON sp.idDanhMuc = dm.id",nativeQuery = true)
    List<SanPhamDTO> findAllSanPham();
}
