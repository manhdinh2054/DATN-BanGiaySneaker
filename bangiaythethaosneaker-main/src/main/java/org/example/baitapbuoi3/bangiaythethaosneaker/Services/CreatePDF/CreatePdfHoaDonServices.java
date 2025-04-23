package org.example.baitapbuoi3.bangiaythethaosneaker.Services.CreatePDF;

import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.DonHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Normalizer;

@Service
public class CreatePdfHoaDonServices {
    @Autowired
    private DonHangRepository donHangRepository;

    public String removeAccents(String input) {
        if (input == null) return null;
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        return normalized.replaceAll("[^\\p{ASCII}]", "");
    }

}
