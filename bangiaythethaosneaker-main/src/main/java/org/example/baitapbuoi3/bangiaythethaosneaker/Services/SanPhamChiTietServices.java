package org.example.baitapbuoi3.bangiaythethaosneaker.Services;

import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.SanPhamChiTiet;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.SanPhamChiTietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SanPhamChiTietServices {
    @Autowired
    private SanPhamChiTietRepository spctrsp;


}
