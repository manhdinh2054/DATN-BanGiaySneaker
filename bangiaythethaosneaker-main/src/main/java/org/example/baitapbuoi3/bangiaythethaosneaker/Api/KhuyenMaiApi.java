package org.example.baitapbuoi3.bangiaythethaosneaker.Api;

import lombok.RequiredArgsConstructor;
import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.GiamGia;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.KhuyenMaiRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class KhuyenMaiApi {
    private final KhuyenMaiRepository kmr;
    @PostMapping("/admin/quanlikhuyenmai/stopkhuyenmai/{id}")
    public ResponseEntity<?> stopKhuyenmai(@PathVariable("id") int id){
        Optional<GiamGia> giamGia = kmr.findById(id);
        if(giamGia.isPresent()){
            GiamGia gg = giamGia.get();
            gg.setTrangThai(false);
            kmr.save(gg);
        }
        return ResponseEntity.ok().build();
    }
}
