package com.example.projek3.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.projek3.model.Transaksi;

@Repository
public class TransaksiDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Integer save(Transaksi transaksi) {
        try {
            int rows = jdbcTemplate.update(
                "UPDATE * FROM projek3.tabel_transaksi (id, userId, produkId) VALUES (?,?,?)",
                new Object[] {transaksi.getId(), transaksi.getUserId(), transaksi.getProdukId()});
                return rows;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
