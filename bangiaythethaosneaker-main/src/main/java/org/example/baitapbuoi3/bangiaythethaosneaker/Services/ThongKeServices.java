package org.example.baitapbuoi3.bangiaythethaosneaker.Services;

import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class ThongKeServices {
    @Autowired
    private HoaDonRepository hoaDonRepository;

    public BigDecimal getTotalRevenueForWeek(LocalDate startDate, LocalDate endDate) {
        return hoaDonRepository.sumRevenueForWeek(startDate, endDate);
    }

    public BigDecimal getTotalRevenueForMonth(int month, int year) {
        return hoaDonRepository.sumRevenueForMonth(month, year);
    }

    public long getPaidInvoicesCount() {
        return hoaDonRepository.countPaidInvoices();
    }
}
