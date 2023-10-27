package com.example.be.repository;

import com.example.be.entity.NhanVien;
import com.example.be.model.request.SearchNhanVienRequest;
import com.example.be.model.response.NhanVienResponce;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {
    @Query(value = " select a.id as idNhanVien , a.ten as tenNhanVien, b.ten as tenCuaHang  " +
            " from NhanVien a JOIN CuaHang b on b.id = a.idCH ", nativeQuery = true)
    Page<NhanVienResponce> customProveti(Pageable pageable);

    @Query(value = """
            select a.id as idNhanVien, a.ma as ma,  a.ten as ten, a.gioiTinh as gioiTinh,
             a.sdt as sdt, a.diaChi as diaChi, b.ten as tenCuaHang, b.id as idCuaHang FROM 
            NhanVien a LEFT Join CuaHang b ON a.idCH = b.id
            where  (a.ma LIKE %:#{#x.maSearch}% OR :#{#x.maSearch} IS NULL OR :#{#x.maSearch} LIKE '')
            and (a.sdt LIKE %:#{#x.sdtSearch}% OR :#{#x.sdtSearch} IS NULL OR :#{#x.sdtSearch} like '')
            and (a.diaChi LIKE %:#{#x.diaChiSearch}% OR :#{#x.diaChiSearch} IS NULL OR :#{#x.diaChiSearch} like '')
            """, nativeQuery = true)
    Page<NhanVienResponce> search(@Param("x") SearchNhanVienRequest x, Pageable pageable);
}
