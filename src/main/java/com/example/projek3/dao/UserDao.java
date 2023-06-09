package com.example.projek3.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.projek3.model.User;

@Repository
public class UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Integer updateUser(Integer saldo, Integer id) {
        try {
            int rows = jdbcTemplate.update(
                    "UPDATE FROM projek3.tabel_user SET saldo=? WHERE id= ?",
                    new Object[] { saldo, id });
            return null;
        }catch (Exception e) {
            e.printStackTrace();
            return 0;
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

    public User getByUserId(Integer id) {
        User user;
        user = jdbcTemplate.queryForObject("SELECT * FROM projek3.tabel_user Where id=?",
                BeanPropertyRowMapper.newInstance(User.class), id);
        return user;
    }

    public List<User> semuaUser() {
        List<User> semuaUser;
        semuaUser = jdbcTemplate.query("SELECT * FROM projek3.tabel_user",
                BeanPropertyRowMapper.newInstance(User.class));
        return semuaUser;
    }
}
