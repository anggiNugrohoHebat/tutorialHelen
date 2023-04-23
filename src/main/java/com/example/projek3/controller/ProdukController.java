package com.example.projek3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projek3.dao.ProdukDao;
import com.example.projek3.model.Produk;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/produk")
public class ProdukController {

    @Autowired
    ProdukDao produkDao;

    @PostMapping("save")
    public String saveProduk(@RequestBody Produk produk) {
        try {
            String rows = produkDao.save(produk);
            return "berhasil di simpan: " + rows;
        }catch (Exception e) {
            e.printStackTrace();
            return "gagal disimpan: " + e.getMessage();
        }
    }

    
}
