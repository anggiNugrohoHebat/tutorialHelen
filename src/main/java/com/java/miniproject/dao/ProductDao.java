package com.java.miniproject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.java.miniproject.model.Product;

@Repository
public class ProductDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(Product pro) {
        // TODO Auto-generated method stub
        int rows = jdbcTemplate.update(
                "INSERT INTO public.tbl_product (id, nama_produk, harga) VALUES(?, ?, ?);",
                new Object[] { pro.getId(), pro.getNamaProduk(), pro.getHarga() });
        return rows;

    }

    public Product selectById(Integer id) {
        Product product = null;
        product = jdbcTemplate.queryForObject("select * from tbl_product where id = ?",
                BeanPropertyRowMapper.newInstance(Product.class), id);
        return product;
    }

}
