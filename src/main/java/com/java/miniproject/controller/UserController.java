package com.java.miniproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.miniproject.dao.UserDao;
import com.java.miniproject.model.User;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserDao userDao;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody User usr) {
        try {
            String rows = userDao.saveUser(usr);
            return new ResponseEntity<>("User baru telah ter simpan : " + rows, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/updatasaldo/{id}/{saldo}")
    public ResponseEntity<String> updateSaldoByUserId(@PathVariable("id") Integer id,
            @PathVariable("saldo") Integer saldo) {
        try {
            int rows = userDao.updateSaldoByUserId(id, saldo);
            return new ResponseEntity<>("saldo telah ter simpan : " + rows, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/selectbyid/{id}")
    public ResponseEntity<User> selectByUserId(@PathVariable("id") Integer id) {
        try {
            User user = userDao.getByUserId(id);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("semuaUser")
    public List<User> semuaUser (@RequestBody User user) {
        try {
            List<User> rows = userDao.SemuaUser();
            return rows;
        }catch ( Exception e) {
            e.printStackTrace();
            return 
            new ArrayList<>();
        }
    }
}
