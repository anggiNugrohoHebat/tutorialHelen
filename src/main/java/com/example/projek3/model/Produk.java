package com.example.projek3.model;

public class Produk {
    private int id;
    private Integer namaProduk;
    private Integer harga;
    private Integer hapus;

    public Produk() {
    }

    public Produk(int id, Integer namaProduk, Integer harga, Integer hapus) {
        this.id = id;
        this.namaProduk = namaProduk;
        this.harga = harga;
        this.hapus = hapus;
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

    public Integer getHapus() {
        return hapus;
    }

    public void setHapus(Integer hapus) {
        this.hapus = hapus;
    }

    @Override
    public String toString() {
        return "Produk [id=" + id + ", namaProduk=" + namaProduk + ", harga=" + harga + ", hapus=" + hapus + "]";
    }

}
