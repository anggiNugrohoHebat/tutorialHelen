package com.example.projek3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired 
    JdbcTemplate jdbcTemplate;

    @PostMapping("save")
    public String saveProduk(@RequestBody Produk produk) {
        try {
            String rows = produkDao.save(produk);
            return "berhasil di simpan: " + rows;
        } catch (Exception e) {
            e.printStackTrace();
            return "gagal disimpan: " + e.getMessage();
        }
    }

    @GetMapping("selecProdukBy/ {id}")
    public String selectById(@PathVariable("id") Integer id) {
        try {
            Produk produk = produkDao.selectById(id);
            return produk + "berhasil di ubah: ";
        }catch (Exception e) {
            e.printStackTrace();
            return "gagal di ubah: " + e.getMessage();
        }
     

    @GetMapping("hapus")
    public String hapusByid(@PathVariable("id") Integer id) {
        try {
            String rows = produkDao.hapus(id);
            return "berhasil dihapus: " + rows;
        } catch (Exception e) {
            e.printStackTrace();
            return "gagal di hapus: " + e.getMessage();
        }
    }
}
