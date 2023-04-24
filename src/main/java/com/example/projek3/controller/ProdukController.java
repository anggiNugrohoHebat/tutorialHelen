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

    @GetMapping("getById")
    public String getProdukById(Integer id) {
        try {
            int rows = produkDao.getByProdukId(
                "SELECT * FROM projek3.tabel_produk WHERE id= ?",
                new Object[] {id});
                return "produk adalah: " + rows;
        }catch (Exception e) {
            e.printStackTrace();
            return "produk tidak diketahui: " + e.getMessage();
        }
    }

    
}
