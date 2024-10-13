package org.example.baitapbuoi3.datn.Repository;

import org.example.baitapbuoi3.datn.Entity.DonHangChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonHangChiTietInterface extends JpaRepository<DonHangChiTiet, Integer> {

}
