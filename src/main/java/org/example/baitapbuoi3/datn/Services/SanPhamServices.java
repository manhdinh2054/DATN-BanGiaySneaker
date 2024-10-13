package org.example.baitapbuoi3.datn.Services;

import org.example.baitapbuoi3.datn.Entity.SanPham;
import org.example.baitapbuoi3.datn.Repository.SanPhamInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SanPhamServices {
    @Autowired
    SanPhamInterface sanPhamInterface;

    public Page<SanPham> getSanPhamPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return sanPhamInterface.getSanPhamPage1(pageable);
    }
    public Page<SanPham> findSanPhamByDanhMuc(int page,int size,int idDanhMuc) {
        Pageable pageable = PageRequest.of(page,size);
        return sanPhamInterface.findSanPhamByDanhMuc(pageable,idDanhMuc);
    }
    public Page<SanPham> findSanPhamByThuongHieu(int page,int size,int id) {
        Pageable pageable = PageRequest.of(page,size);
        return sanPhamInterface.findSanPhamByThuongHieu(pageable,id);
    }
    public Page<SanPham> findSanPhamDetail(int page,int size,String masanpham){
        Pageable pageable = PageRequest.of(page,size);
        return sanPhamInterface.findDetailSanPham(pageable,masanpham);
    }
}
