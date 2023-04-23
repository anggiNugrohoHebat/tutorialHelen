package com.example.projek3.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.projek3.model.Produk;

@Repository
public class ProdukDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public String save(Produk produk) {
        try {
            int rows = jdbcTemplate.update(
                "INSERT INTO projek3.tabel_produk (id, namaProduk, harga) VALUES (?, ?, ?)",
                new Object[] {produk.getId(), produk.getNamaProduk(), produk.getHarga()});
                return "berhasil di simpan: ";  
        }catch (Exception e) {
            e.printStackTrace();
            return "gagal di simpan: " + e.getMessage();
        }
    }
    
}
