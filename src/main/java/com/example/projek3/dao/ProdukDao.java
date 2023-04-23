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

    public String getByProdukId(Integer id) {
        try {
            String rows = jdbcTemplate.getByProdukId(
                "SELECT + FROM projek3.tabel_produk WHERE id= ?",
                new Object[] {id});
                return "berhasil: " + rows;
        }catch (Exception e) {
            e.printStackTrace();
            return "gagal: " + e.getMessage();
        }
    }

    public Produk selectById(Integer id) {
        Produk produk = null;
        produk = jdbcTemplate.queryForObject("select * from tabel_produk where id = ?",
                BeanPropertyRowMapper.newInstance(Produk.class), id);
        return produk;
    }

}
