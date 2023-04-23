package com.java.miniproject.controller;

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

import com.java.miniproject.dao.ProductDao;
import com.java.miniproject.model.Product;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductDao productDao;

    @PostMapping("/save")
    public String save(@RequestBody Product product) {
        try {
            System.out.println("masuk controller save");
            int rows = productDao.save(product);
            return "anda telah menyimpan product sebesar: " +rows+" rpw+";
        } catch (Exception e) {
            return "telah terjadi error: "+ e.getMessage();
        }
    }

    @GetMapping("/selectbyid/{id}")
    public ResponseEntity<Product> selectByUserId(@PathVariable("id") Integer id) {
        try {
            Product product = productDao.selectById(id);
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        // ini adalah kodingan hellen
    }

    @GetMapping("/selectbyidv2/{id}")
    public ResponseEntity<Product> selectByUserIdV2(@PathVariable("id") Integer id) {
        try {
            Product product = productDao.selectById(id);
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        // ini adalah kodingan hellen
    }

}
