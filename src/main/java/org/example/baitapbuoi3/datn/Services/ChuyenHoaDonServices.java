package org.example.baitapbuoi3.datn.Services;

import org.example.baitapbuoi3.datn.Entity.HoaDon;
import org.example.baitapbuoi3.datn.Repository.DonHangChiTietInterface;
import org.example.baitapbuoi3.datn.Repository.DonHangInterface;
import org.example.baitapbuoi3.datn.Repository.HoaDonChiTietInterface;
import org.example.baitapbuoi3.datn.Repository.HoaDonInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChuyenHoaDonServices {
    @Autowired
    HoaDonInterface hoaDonInterface;
    @Autowired
    HoaDonChiTietInterface hoaDonChiTietInterface;
    public void TransferToHoaDonService(int idhoadon){
        hoaDonInterface.insertHoaDon(idhoadon);
    }
    public void TransferToHoaDonChiTietService(int idhoadonchitiet){
        hoaDonChiTietInterface.insertHoaDonChiTiet(idhoadonchitiet);
    }
}
