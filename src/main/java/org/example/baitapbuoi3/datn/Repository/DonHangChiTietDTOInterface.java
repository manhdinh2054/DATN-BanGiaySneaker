package org.example.baitapbuoi3.datn.Repository;

import jakarta.transaction.Transactional;
import org.example.baitapbuoi3.datn.Entity.DonHangChiTietDTO;
import org.example.baitapbuoi3.datn.Entity.DonHangChiTietDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonHangChiTietDTOInterface extends JpaRepository<DonHangChiTietDTO,Integer> {
    @Query(value = "select dhct.id as id,dhct.idDonHang as idDonHang, dhct.soLuong as soLuong,dhct.donGia as donGia,sp.maSanPham as maSanPham,sp.tenSanPham as tenSanPham,sp.anhSanPham as anhSanPham from DonHangChiTiet dhct join SanPham sp on dhct.idSanPham = sp.id where idDonhang = :id", nativeQuery = true)
    List<DonHangChiTietDTO> getAllDonHangChiTietWithSanPham(int id);

    @Modifying
    @Transactional
    @Query(value = "delete from DonHangChiTiet where id = :id",nativeQuery = true)
    void deleteById1111(int id);
}
