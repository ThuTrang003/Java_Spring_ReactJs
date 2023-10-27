package com.example.be.service;

import com.example.be.entity.NhanVien;
import com.example.be.model.request.NhanVienRequest;
import com.example.be.model.request.SearchNhanVienRequest;
import com.example.be.model.response.NhanVienResponce;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.UUID;

public interface NhanVienService {
    List<NhanVien> getAll1();

    Page<NhanVienResponce> getCustom(Integer pageNo);

    NhanVien getOne(UUID id);

    Page<NhanVienResponce> search(SearchNhanVienRequest serchNhanVien);

    NhanVien add(@Valid NhanVienRequest nhanVien, BindingResult result);

    NhanVien update(@Valid NhanVienRequest nhanVien, UUID id);

    void remove(UUID id);
}
