package org.example.baitapbuoi3.bangiaythethaosneaker.Controller.Admin;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.baitapbuoi3.bangiaythethaosneaker.Services.ThongKeServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class ThongKeController {
    private final ThongKeServices thsv;

    @GetMapping("/thongke")
    public String showStatistics(Model model) {
        LocalDate now = LocalDate.now();
        LocalDate startOfWeek = now.minusDays(now.getDayOfWeek().getValue() - 1);
        LocalDate endOfWeek = startOfWeek.plusDays(6);
        BigDecimal totalRevenueForWeek = thsv.getTotalRevenueForWeek(startOfWeek, endOfWeek);

        BigDecimal totalRevenueForMonth = thsv.getTotalRevenueForMonth(now.getMonthValue(), now.getYear());

        long paidInvoicesCount = thsv.getPaidInvoicesCount();

        model.addAttribute("totalRevenueForWeek", totalRevenueForWeek);
        model.addAttribute("totalRevenueForMonth", totalRevenueForMonth);
        model.addAttribute("paidInvoicesCount", paidInvoicesCount);

        model.addAttribute("weeklyData", new BigDecimal[] {totalRevenueForWeek});
        model.addAttribute("monthlyData", new BigDecimal[] {totalRevenueForMonth});
        model.addAttribute("paidInvoicesData", new Long[] {paidInvoicesCount});

        return "admin/thongke";
    }

    @GetMapping("/exportExcel")
    @ResponseBody
    public ResponseEntity<byte[]> exportExcel() {
        LocalDate now = LocalDate.now();
        LocalDate startOfWeek = now.minusDays(now.getDayOfWeek().getValue() - 1);
        LocalDate endOfWeek = startOfWeek.plusDays(6);
        BigDecimal totalRevenueForWeek = thsv.getTotalRevenueForWeek(startOfWeek, endOfWeek);

        BigDecimal totalRevenueForMonth = thsv.getTotalRevenueForMonth(now.getMonthValue(), now.getYear());

        long paidInvoicesCount = thsv.getPaidInvoicesCount();
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Thong Ke");

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Mô Tả");
        headerRow.createCell(1).setCellValue("Doanh thu");


        Row weekRow = sheet.createRow(1);
        weekRow.createCell(0).setCellValue("Tổng Doanh Thu Trong Tuần");
        weekRow.createCell(1).setCellValue(totalRevenueForWeek.doubleValue());

        Row monthRow = sheet.createRow(2);
        monthRow.createCell(0).setCellValue("Tổng Doanh Thu Trong Tháng");
        monthRow.createCell(1).setCellValue(totalRevenueForMonth.doubleValue());

        Row paidInvoicesRow = sheet.createRow(3);
        paidInvoicesRow.createCell(0).setCellValue("Số Lượng Hóa Đơn Đã Thanh Toán");
        paidInvoicesRow.createCell(1).setCellValue(paidInvoicesCount);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            workbook.write(baos);
        } catch (Exception e) {
            e.printStackTrace();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=thongke.xlsx");
        headers.add("Content-Type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

        return ResponseEntity.ok()
                .headers(headers)
                .body(baos.toByteArray());
    }
}
