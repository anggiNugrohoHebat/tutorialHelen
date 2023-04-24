package com.example.projek3.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.projek3.model.Produk;

@Repository
public class ProdukDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ProdukDao produkDao;

    public String save(Produk produk) {
        try {
            int rows = jdbcTemplate.update(
                    "INSERT INTO projek3.tabel_produk (id, namaProduk, harga) VALUES (?, ?, ?)",
                    new Object[] { produk.getId(), produk.getNamaProduk(), produk.getHarga() });
            return "berhasil di simpan: " + rows;
        } catch (Exception e) {
            e.printStackTrace();
            return "gagal di simpan: " + e.getMessage();
        }
    }

    public Produk selectById(Integer id) {
        Produk produk = null;
        produk = jdbcTemplate.queryForObject("select * from projek3.tabel_produk where id = ?",
                BeanPropertyRowMapper.newInstance(Produk.class), id);
        return produk;
    }

    public String hapus(Integer id) {
        try {
            int rows = jdbcTemplate.update(
                    "DELETE * FROM projek3.tabel_produk WHERE id= ?");
            return "berhasil dihapus" + rows;
        } catch (Exception e) {
            e.printStackTrace();
            return "gagal dihapus: " + e.getMessage();
        }
    }
}
