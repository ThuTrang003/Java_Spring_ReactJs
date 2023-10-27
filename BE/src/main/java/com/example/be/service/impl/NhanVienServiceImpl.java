package com.example.be.service.impl;

import com.example.be.entity.NhanVien;
import com.example.be.model.request.NhanVienRequest;
import com.example.be.model.request.SearchNhanVienRequest;
import com.example.be.model.response.NhanVienResponce;
import com.example.be.repository.CuaHangRepository;
import com.example.be.repository.NhanVienRepository;
import com.example.be.service.NhanVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.UUID;

@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    private NhanVienRepository repository;

    @Autowired
    private CuaHangRepository cuaHangRepository;

    @Override
    public List<NhanVien> getAll1() {
        return repository.findAll();
    }

    @Override
    public Page<NhanVienResponce> search(SearchNhanVienRequest serchNhanVien) {
        Pageable pageable = PageRequest.of(serchNhanVien.getPageNo(), 5);
        return repository.search(serchNhanVien, pageable);
    }

    @Override
    public Page<NhanVienResponce> getCustom(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 10);
        return repository.customProveti(pageable);
    }

    @Override
    public NhanVien getOne(UUID id) {
        return repository.findById(id).get();
    }


    @Override
    public NhanVien add(@Valid NhanVienRequest nhanVien, BindingResult result) {
        if (result.hasErrors()) {
            return null;
        }
        NhanVien x = NhanVien.builder()
                .ma(nhanVien.getMa())
                .ten(nhanVien.getTen())
                .gioiTinh(nhanVien.getGioiTinh())
                .sdt(nhanVien.getSdt())
                .diaChi(nhanVien.getDiaChi())
                .cuaHang(cuaHangRepository.findById(nhanVien.getIdCH()).get())
                .build();
        return repository.save(x);
    }

    @Override
    public NhanVien update(NhanVienRequest nhanVien, UUID id) {
        NhanVien edit = repository.findById(id).get();
        edit = NhanVien.builder()
                .id(id)
                .ma(nhanVien.getMa())
                .ten(nhanVien.getTen())
                .gioiTinh(nhanVien.getGioiTinh())
                .sdt(nhanVien.getSdt())
                .diaChi(nhanVien.getDiaChi())
                .cuaHang(cuaHangRepository.findById(nhanVien.getIdCH()).get())
                .build();
        return repository.save(edit);
    }

    @Override
    public void remove(UUID id) {
        repository.delete(repository.findById(id).get());
    }
}
