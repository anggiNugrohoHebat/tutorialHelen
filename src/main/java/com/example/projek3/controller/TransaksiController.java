package com.example.projek3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projek3.dao.ProdukDao;
import com.example.projek3.dao.TransaksiDao;
import com.example.projek3.dao.UserDao;
import com.example.projek3.model.Produk;
import com.example.projek3.model.Transaksi;
import com.example.projek3.model.User;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/beli")
public class TransaksiController {

    @Autowired
    TransaksiDao transaksiDao;

    @Autowired
    ProdukDao produkDao;

    @Autowired
    UserDao userDao;

    @PostMapping("beli")
    public String save (@RequestBody Transaksi transaksi) {
        try {
            int rows = transaksiDao.save(transaksi);
            if (rows >= 1) {
                User user = userDao.getByUserId(transaksi.getUserId());
                Produk produk = produkDao.get
            }
        }
    }
    
}
