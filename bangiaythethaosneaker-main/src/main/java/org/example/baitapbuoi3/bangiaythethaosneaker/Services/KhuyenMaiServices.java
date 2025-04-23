package org.example.baitapbuoi3.bangiaythethaosneaker.Services;

import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.GiamGia;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.KhuyenMaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class KhuyenMaiServices {
    @Autowired
    private KhuyenMaiRepository kmi;

    public Page<GiamGia> getKhuyenMaiPage(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        return kmi.getKhuyenMaiPage(pageable);
    }
}
