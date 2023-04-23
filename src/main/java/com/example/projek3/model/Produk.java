package com.example.projek3.model;

public class Produk {
    private int id;
    private Integer namaProduk;
    private Integer harga;

    public Produk() {
    }

    public Produk(int id, Integer namaProduk, Integer harga) {
        this.id = id;
        this.namaProduk = namaProduk;
        this.harga = harga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(Integer namaProduk) {
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
        return "Produk [id=" + id + ", namaProduk=" + namaProduk + ", harga=" + harga + "]";
    }

}
