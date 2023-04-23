package com.java.miniproject.model;

public class Product {
    private Integer id;
    private String namaProduk;
    private Integer harga;

    public Product() {
    }

    public Product(Integer id, String namaProduk, Integer harga, String alamat) {
        this.id = id;
        this.namaProduk = namaProduk;
        this.harga = harga;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", namaProduk=" + namaProduk + ", harga=" + harga + "]";
    }

}