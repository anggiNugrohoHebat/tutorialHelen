package com.java.miniproject.model;

public class User {
    private Integer id;
    private String userName;
    private Integer saldo;
    private String alamat;

    public User() {
    }

    public User(Integer id, String userName, Integer saldo, String alamat) {
        this.id = id;
        this.userName = userName;
        this.saldo = saldo;
        this.alamat = alamat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", saldo=" + saldo + ", alamat=" + alamat + "]";
    }

}
