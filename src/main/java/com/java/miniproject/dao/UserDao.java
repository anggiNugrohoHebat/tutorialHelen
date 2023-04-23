package com.java.miniproject.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// import com.java.miniproject.dao.UserDao;
import com.java.miniproject.model.User;

@Repository
public class UserDao {
    public Integer updateSaldoByUserId(Integer id, Integer saldoShopee) {
        try {
            int rows = jdbcTemplate.update(
                    "UPDATE public.tbl_user SET saldo=? WHERE id=?",
                    new Object[] { saldoShopee, id });
            return rows;
        } catch (Exception e) {
            return 0;
        }
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String saveUser(User user) {
        try {
            int rows = jdbcTemplate.update(
                "INSERT INTO projek1.tabel_user (id, userName, saldo, alamat) VALUES (?, ?, ?, ?)",
                new Object[] {user.getId(), user.getUserName(), user.getSaldo(), user.getAlamat()});
                return "berhasil di update: " + rows;
        }catch (Exception e) {
            e.printStackTrace();
            return "gagal di update: " + e.getMessage();
        }
    }

  

    public User getByUserId(Integer id) {
        User user = null;
        user = jdbcTemplate.queryForObject("select * from tbl_user where id = ?",
                BeanPropertyRowMapper.newInstance(User.class), id);
        return user;
    }

    public List<User> SemuaUser () {
        List<User> semuaUser;
        semuaUser = jdbcTemplate.query("SELECT * FROM tbl_user",
        BeanPropertyRowMapper.newInstance(User.class));
        return semuaUser;

    }

}
