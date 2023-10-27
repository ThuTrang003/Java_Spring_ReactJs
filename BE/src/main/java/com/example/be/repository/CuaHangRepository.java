package com.example.be.repository;

import com.example.be.entity.CuaHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CuaHangRepository extends JpaRepository<CuaHang, UUID> {
}
