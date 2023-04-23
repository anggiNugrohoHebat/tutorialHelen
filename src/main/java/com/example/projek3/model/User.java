package com.example.projek3.model;

public class User {
    private int id;
    private Integer nama;
    private Integer saldo;

    public User() {
    }

    public User(int id, Integer nama, Integer saldo) {
        this.id = id;
        this.nama = nama;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNama() {
        return nama;
    }

    public void setNama(Integer nama) {
        this.nama = nama;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", nama=" + nama + ", saldo=" + saldo + "]";
    }

}
