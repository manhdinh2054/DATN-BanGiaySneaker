package org.example.baitapbuoi3.bangiaythethaosneaker.Services;

import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.SanPham;
import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.SanPhamChiTiet;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.SanPhamChiTietRepository;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SanPhamServices {
    @Autowired
    SanPhamRepository sanPhamRepository;
    @Autowired
    SanPhamChiTietRepository sanPhamChiTietRepository;

    public Page<SanPham> getSanPhamPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return sanPhamRepository.getSanPhamPage1(pageable);
    }
    public  Page<SanPham> getSanPhamTimKiem(int page, int size,String tenSanPham) {
        Pageable pageable = PageRequest.of(page, size);
        return sanPhamRepository.findSanPhamByName(pageable,tenSanPham);
    }
//    public Page<SanPhamChiTiet> getSanPhamTimKiemMa(int page, int size, String maSaPham){
//        Pageable pageable = PageRequest.of(page, size);
//        return sanPhamChiTietRepository.findSanPhamByMa(pageable,maSaPham);
//    }

    public Page<SanPham> findSanPhamByDanhMuc(int page,int size,int idDanhMuc) {
        Pageable pageable = PageRequest.of(page,size);
        return sanPhamRepository.findSanPhamByDanhMuc(pageable,idDanhMuc);
    }
    public Page<SanPham> findSanPhamByThuongHieu(int page, int size, int id) {
        Pageable pageable = PageRequest.of(page,size);
        return sanPhamRepository.findSanPhamByThuongHieu(pageable,id);
    }
    public Page<SanPhamChiTiet> findSanPhamDetail(int page, int size, int idSanPham){
        Pageable pageable = PageRequest.of(page,size);
        return sanPhamChiTietRepository.findDetailSanPham(pageable,idSanPham);
    }
    public Page<SanPham> fillanPhamByTen(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return sanPhamRepository.findAllSanPham(pageable);
    }


}
