package org.example.baitapbuoi3.bangiaythethaosneaker.Services;


import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.HoaDonChiTietRepository;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChuyenHoaDonServices {
    @Autowired
    HoaDonRepository hoaDonRepository;
    @Autowired
    HoaDonChiTietRepository hoaDonChiTietRepository;
    public void TransferToHoaDonService(int idhoadon){
        hoaDonRepository.insertHoaDon(idhoadon);
    }
    public void TransferToHoaDonChiTietService(int idhoadonchitiet){
        hoaDonChiTietRepository.insertHoaDonChiTiet(idhoadonchitiet);
    }
}
