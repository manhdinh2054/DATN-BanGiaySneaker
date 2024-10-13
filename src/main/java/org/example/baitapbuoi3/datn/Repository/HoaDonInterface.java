package org.example.baitapbuoi3.datn.Repository;

import org.example.baitapbuoi3.datn.Entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonInterface extends JpaRepository<HoaDon,Integer> {
}
