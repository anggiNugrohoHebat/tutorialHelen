package com.example.projek3.model;

public class Transaksi {
    private int id;
    private Integer userId;
    private Integer produkId;

    public Transaksi() {
    }

    public Transaksi(int id, Integer userId, Integer produkId) {
        this.id = id;
        this.userId = userId;
        this.produkId = produkId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProdukId() {
        return produkId;
    }

    public void setProdukId(Integer produkId) {
        this.produkId = produkId;
    }

    @Override
    public String toString() {
        return "Transaksi [id=" + id + ", userId=" + userId + ", produkId=" + produkId + "]";
    }

}
