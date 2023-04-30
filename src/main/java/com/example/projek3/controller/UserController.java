package com.example.projek3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projek3.dao.UserDao;
import com.example.projek3.model.User;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping("updateUser/{id}/{saldo}")
    public String updateUser(@PathVariable("id") Integer id,
            @PathVariable("saldo") Integer saldo) {
        try {
            int rows = userDao.updateUser(saldo, id);
            return "berhasil Diupdate: " + rows;
        } catch (Exception e) {
            e.printStackTrace();
            return "gagal diupdate: " + e.getMessage();
        }
    }

    @PostMapping("saveUser")
    public String saveUser(@RequestBody User user) {
        try {
            String rows = userDao.save(user);
            return "berhasil di simpan: " + rows;
        } catch (Exception e) {
            e.printStackTrace();
            return "gagal disimpan: " + e.getMessage();
        }
    }

    @GetMapping("/getUserByID")
    public String getUserById(@PathVariable("id")Integer id) {
        try {
            User user = userDao.getByUserId(id);
            return user + "berhasil";
        }catch (Exception e) {
            e.printStackTrace();
            return "gagal: " + e.getMessage();
        }
    }

    @PostMapping("/semuaUser")
    public List<User> semuaUser() {
        try {
            List<User> rows = userDao.semuaUser();
            return rows;
        }catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
       
        }
     
    


}
