package org.example.baitapbuoi3.bangiaythethaosneaker.Services;

import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.HoaDon;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HoaDonServices {
    @Autowired
    HoaDonRepository hdi;
    public Page<HoaDon> findAllHoaDonPage(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        return hdi.findAllHoaDonPage(pageable);
    }
    public Page<HoaDon> searchAllHoaDonPage(String sdtKhachHang,int page,int size){
        Pageable pageable = PageRequest.of(page,size);
        return hdi.searchHoaDonByAll(sdtKhachHang,pageable);
    }
    public Page<HoaDon> searchHoaDonPageAndTrangThai(int trangthai,int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        return hdi.searchHoaDonByAllTAndTrangThai(trangthai,pageable);
    }

}
