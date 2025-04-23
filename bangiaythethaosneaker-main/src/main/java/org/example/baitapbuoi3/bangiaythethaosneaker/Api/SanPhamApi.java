package org.example.baitapbuoi3.bangiaythethaosneaker.Api;

import lombok.RequiredArgsConstructor;
import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.SanPham;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.SanPhamChiTietRepository;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.SanPhamRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SanPhamApi {
    private final SanPhamChiTietRepository spcti;
    private final SanPhamRepository spi;

    @GetMapping("/sanphamkichco")
    public ResponseEntity<Integer> getSoLuong(@RequestParam int idSanPham, @RequestParam int kichCo) {
        Optional<Integer> splst = spcti.findByIdSanPhamApi(idSanPham, kichCo);
        return splst
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/deletesanphamanh/{id}")
    public ResponseEntity<?> deleteSanPhamAnh(@PathVariable("id") int anhSanPham) {
        Optional<SanPham> spAnh = spi.findById(anhSanPham);
        if(spAnh.isPresent()){
            SanPham spa = spAnh.get();
            String anhSanPhamUrl = spa.getAnhSanPham();
            File file = new File("/images/product/"+anhSanPhamUrl);
            if(file.exists()){
                file.delete();
            }
            spa.setAnhSanPham(null);
            spi.save(spa);
        }
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/deletesanphamchitiet/{id}")
    public ResponseEntity<?> deleteSanPhamChiTiet(@PathVariable("id") int idSanPham) {
        spcti.deleteById(idSanPham);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deletesanpham/{id}")
    public ResponseEntity<?> deleteSanPham(@PathVariable("id") int idSanPham) {
        spi.deleteById(idSanPham);
        return ResponseEntity.ok().build();
    }
}

