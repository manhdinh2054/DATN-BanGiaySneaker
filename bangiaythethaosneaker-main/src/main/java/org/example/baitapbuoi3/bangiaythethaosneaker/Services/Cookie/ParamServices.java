package org.example.baitapbuoi3.bangiaythethaosneaker.Services.Cookie;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ParamServices {

    @Autowired
    HttpServletRequest request;

    //Đọc chuỗi giá trị của tham số
    //* @param name tên tham số
    //* @param defaultvalue giá trị mặc định
    //* @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
    public String getString(String name, String defaultValue) {
        String value = request.getParameter(name);
        return value != null ? value : defaultValue;
    }

    //* Đọc số nguyên giá trị của tham số
    //* @param name tên tham số
    //* @param defaultValue giá trị mặc định
    //* @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
    public int getInt(String name, int defaultValue) {
        String value = getString(name,String.valueOf(defaultValue));
        return Integer.parseInt(value);
    }

    //*Đọc số thực giá trị của tham số
    //* @param name tên tham số
    //* @param defaultValue giá trị mặc định
    //* @return giá trị tham số hoặc giá trị mặc định nêu không tồn tại
    public double getDouble(String name, double defaultValue) {
        String value = getString(name, String.valueOf(defaultValue));
        return Double.parseDouble(value);
    }

    public boolean getBoolean(String name,boolean defaultValue){
        String value = getString(name, String.valueOf(defaultValue));
        return Boolean.parseBoolean(value);
    }

    public Date getDate(String name, String pattern){
        String value = getString(name, "");
        try {
            return new SimpleDateFormat(pattern).parse(value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
