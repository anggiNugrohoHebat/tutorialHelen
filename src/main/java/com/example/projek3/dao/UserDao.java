package com.example.projek3.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.projek3.model.User;

@Repository
public class UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public String updateUser(Integer saldo, Integer id) {
        try {
            int rows = jdbcTemplate.update(
                    "UPDATE FROM projek3.tabel_user SET saldo=? WHERE id= ?",
                    new Object[] { saldo, id });
            return "berhasil diupdate: " + rows;
        } catch (Exception e) {
            e.printStackTrace();
            return "tidak berhasil diupdate: " + e.getMessage();
        }
    }

    public String save(User user) {
        try {
            int rows = jdbcTemplate.update(
                    "INSERT INTO projek3.tabel_user (id, nama, saldo) VALUES (?, ?, ?)",
                    new Object[] { user.getId(), user.getNama(), user.getSaldo() });
            return "berhasil disimpan: " + rows;
        } catch (Exception e) {
            e.printStackTrace();
            return "gagal disimpan: " + e.getMessage();
        }
    }

   

}
