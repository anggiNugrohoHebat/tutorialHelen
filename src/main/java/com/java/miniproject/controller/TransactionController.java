package com.java.miniproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.miniproject.dao.ProductDao;
import com.java.miniproject.dao.TransactionDao;
import com.java.miniproject.dao.UserDao;
import com.java.miniproject.model.Product;
import com.java.miniproject.model.Transaction;
import com.java.miniproject.model.User;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionDao transactionDao;

    @Autowired
    ProductDao productDao;

    @Autowired
    UserDao userDao;
 
    @PostMapping("/beli")
    public ResponseEntity<String> save(@RequestBody Transaction transaction) {
        try {
            int rows = transactionDao.save(transaction);
            if (rows >= 1) {
                User user = userDao.getByUserId(transaction.getUserId());
                Product product = productDao.selectById(transaction.getProductId());
                int rowterupdate = userDao.updateSaldoByUserId(user.getId(), user.getSaldo() - product.getHarga());

                return new ResponseEntity<>("Transaction baru telah ter simpan : " + rows, HttpStatus.CREATED);
            }

            return new ResponseEntity<>("Gagal Update id harus uniq", HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
