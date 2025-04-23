package org.example.baitapbuoi3.bangiaythethaosneaker.Api;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.RequiredArgsConstructor;
import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.HoaDon;
import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.HoaDonChiTietDTO;
import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.HoaDonDTO;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.HoaDonChiTietDTORepository;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.HoaDonChiTietRepository;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.HoaDonDTORepository;
import org.example.baitapbuoi3.bangiaythethaosneaker.Repository.HoaDonRepository;
import org.example.baitapbuoi3.bangiaythethaosneaker.Services.CreatePDF.CreatePdfHoaDonServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.Normalizer;
import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequiredArgsConstructor
public class HoaDonApi {

    private final HoaDonRepository hdi;
    private final HoaDonDTORepository hddtorsp;
    private final CreatePdfHoaDonServices cpdfhdsv;
    private final HoaDonChiTietDTORepository hdctdtoi;

    @GetMapping("/employee/muahangtaiquay/exportpdf/{id}")
    public ResponseEntity<byte[]> exportPdfFileEmployee(@PathVariable("id") int idHoaDon) throws DocumentException, IOException {
        HoaDon hoaDon = hdi.findOneByHoaDon(idHoaDon);
        List<HoaDonDTO> hoaDonChiTiet = hddtorsp.getAllHoaDonChiTietByIdHoaDon(idHoaDon);
        Document document = new Document();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, byteArrayOutputStream);
        document.open();
        document.add(new Paragraph("HOA DON BAN HANG", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK)));
        document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
        document.add(new Paragraph("THONG TIN", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLACK)));
        document.add(new Paragraph("Ma Hoa Don: " + cpdfhdsv.removeAccents(String.valueOf(hoaDon.getId()))));
        document.add(new Paragraph("Ten Khach Hang: " + cpdfhdsv.removeAccents(hoaDon.getTenKhachhang())));
        document.add(new Paragraph("SDT: " + cpdfhdsv.removeAccents(String.valueOf(hoaDon.getSdtKhachHang()))));
        document.add(new Paragraph("Nguoi Thanh Toan: " + cpdfhdsv.removeAccents(String.valueOf(hoaDon.getIdAccountNhanVien()))));
        document.add(new Paragraph("Ngay Lap Hoa Don: " + cpdfhdsv.removeAccents(String.valueOf(hoaDon.getNgayLapHoaDon()))));
        document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
        document.add(new Paragraph("SAN PHAM", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLACK)));
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);

        PdfPCell c1 = new PdfPCell(new Phrase("STT"));
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Ten San Pham"));
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Kich Co"));
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("So Luong"));
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Don Gia"));
        table.addCell(c1);

        int stt = 1;
        for (HoaDonDTO item : hoaDonChiTiet) {
            table.addCell(String.valueOf(stt++));
            table.addCell(formatText(item.getTenSanPham()));
            table.addCell(String.valueOf(item.getKichCo()));
            table.addCell(String.valueOf(item.getSoLuong()));
            table.addCell(String.valueOf(item.getDonGia()));
        }

        document.add(table);
        Paragraph totalAmount = new Paragraph("Tong Tien: " + cpdfhdsv.removeAccents(String.valueOf(hoaDon.getTongTien())));
        totalAmount.setAlignment(Element.ALIGN_RIGHT);
        document.add(totalAmount);
        document.close();
        return ResponseEntity.ok()
                .header("Content-Disposition", "inline; filename=invoice_" + idHoaDon + ".pdf")
                .contentType(org.springframework.http.MediaType.APPLICATION_PDF)
                .body(byteArrayOutputStream.toByteArray());
    }
    @GetMapping("/admin/muahangtaiquay/exportpdf/{id}")
    public ResponseEntity<byte[]> exportPdfFileAdmin(@PathVariable("id") int idHoaDon) throws DocumentException, IOException {
        HoaDon hoaDon = hdi.findOneByHoaDon(idHoaDon);
        List<HoaDonDTO> hoaDonChiTiet = hddtorsp.getAllHoaDonChiTietByIdHoaDon(idHoaDon);
        Document document = new Document();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, byteArrayOutputStream);
        document.open();
        document.add(new Paragraph("HOA DON BAN HANG", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK)));
        document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
        document.add(new Paragraph("THONG TIN", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLACK)));
        document.add(new Paragraph("Ma Hoa Don: " + cpdfhdsv.removeAccents(String.valueOf(hoaDon.getId()))));
        document.add(new Paragraph("Ten Khach Hang: " + cpdfhdsv.removeAccents(hoaDon.getTenKhachhang())));
        document.add(new Paragraph("SDT: " + cpdfhdsv.removeAccents(String.valueOf(hoaDon.getSdtKhachHang()))));
        document.add(new Paragraph("Nguoi Thanh Toan: " + cpdfhdsv.removeAccents(String.valueOf(hoaDon.getIdAccountNhanVien()))));
        document.add(new Paragraph("Ngay Lap Hoa Don: " + cpdfhdsv.removeAccents(String.valueOf(hoaDon.getNgayLapHoaDon()))));
        document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
        document.add(new Paragraph("SAN PHAM", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLACK)));
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);

        PdfPCell c1 = new PdfPCell(new Phrase("STT"));
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Ten San Pham"));
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Kich Co"));
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("So Luong"));
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Don Gia"));
        table.addCell(c1);

        int stt = 1;
        for (HoaDonDTO item : hoaDonChiTiet) {
            table.addCell(String.valueOf(stt++));
            table.addCell(formatText(item.getTenSanPham()));
            table.addCell(String.valueOf(item.getKichCo()));
            table.addCell(String.valueOf(item.getSoLuong()));
            table.addCell(String.valueOf(item.getDonGia()));
        }

        document.add(table);
        Paragraph totalAmount = new Paragraph("Tong Tien: " + cpdfhdsv.removeAccents(String.valueOf(hoaDon.getTongTien())));
        totalAmount.setAlignment(Element.ALIGN_RIGHT);
        document.add(totalAmount);
        document.close();
        return ResponseEntity.ok()
                .header("Content-Disposition", "inline; filename=invoice_" + idHoaDon + ".pdf")
                .contentType(org.springframework.http.MediaType.APPLICATION_PDF)
                .body(byteArrayOutputStream.toByteArray());
    }

    public String formatText(String text){
        if (text == null) {
            return null;
        }
        String normalized = Normalizer.normalize(text, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalized).replaceAll("").replaceAll("Đ", "D").replaceAll("đ", "d");
    }

}
