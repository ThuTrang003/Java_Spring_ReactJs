package com.example.be.service.impl;

import com.example.be.entity.CuaHang;
import com.example.be.repository.CuaHangRepository;
import com.example.be.service.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuaHangServiceImpl implements CuaHangService {
    @Autowired
    private CuaHangRepository repository;

    @Override
    public List<CuaHang> getAll() {
        return repository.findAll();
    }
}
