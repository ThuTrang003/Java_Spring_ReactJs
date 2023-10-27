package com.example.be.model.response;

import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

public interface NhanVienSearchResponce {
    @Value("#{target.idNhanVien}")
    UUID getId();

    @Value("#{target.tenNhanVien}")
    String getTenNhanVien();

    @Value("#{target.tenCuaHang}")
    String getTenCuaHang();
}
