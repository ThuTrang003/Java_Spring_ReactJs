package com.example.be.model.response;


import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

public interface NhanVienResponce {
    @Value("#{target.idNhanVien}")
    UUID getId();

    @Value("#{target.ma}")
    String getMa();

    @Value("#{target.ten}")
    String getTen();

    @Value("#{target.gioiTinh}")
    String getGioiTinh();

    @Value("#{target.sdt}")
    String getSdt();

    @Value("#{target.diaChi}")
    String getDiaChi();

    @Value("#{target.idCuaHang}")
    String getIdCuaHang();

    @Value("#{target.tenCuaHang}")
    String getTenCuaHang();
}
