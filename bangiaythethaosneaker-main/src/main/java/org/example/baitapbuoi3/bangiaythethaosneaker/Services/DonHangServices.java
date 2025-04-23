package org.example.baitapbuoi3.bangiaythethaosneaker.Services;

import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.DonHang;
import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.HoaDon;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.DonHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DonHangServices {
    @Autowired
    private DonHangRepository dhrsp;
    public Page<DonHang> searchHoaDonByAllHinhThucThanhToanPage(boolean hinhthucthanhtoan, int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        return dhrsp.searchHoaDonByAllHinhThucThanhToanPage(hinhthucthanhtoan,pageable);
    }
    public Page<DonHang> searchDonHangBySdt(String sdt, int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        return dhrsp.searchDonHangBySdt(sdt,pageable);
    }
    public Page<DonHang> searchDonHangByTrangThai(int trangThai, int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        return dhrsp.searchDonHangByTrangThai(trangThai,pageable);
    }
}
