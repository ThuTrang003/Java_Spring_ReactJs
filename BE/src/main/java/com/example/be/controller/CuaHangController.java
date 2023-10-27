package com.example.be.controller;

import com.example.be.service.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cua-hang")
@CrossOrigin({"*"})
public class CuaHangController {
    @Autowired
    private CuaHangService cuaHangService;

    @GetMapping
    public ResponseEntity getAll() {
        return new ResponseEntity(cuaHangService.getAll(), HttpStatus.OK);
    }
}
