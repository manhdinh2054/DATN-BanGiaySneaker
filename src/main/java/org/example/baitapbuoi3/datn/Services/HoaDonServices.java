package org.example.baitapbuoi3.datn.Services;

import org.example.baitapbuoi3.datn.Entity.HoaDon;
import org.example.baitapbuoi3.datn.Entity.SanPham;
import org.example.baitapbuoi3.datn.Repository.HoaDonInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HoaDonServices {
    @Autowired
    HoaDonInterface  hdi;
    public Page<HoaDon> findAllHoaDonPage(int page,int size){
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
