package com.kai.pojo;


//实体类
public class Myuser {
    private int id;
    private String name;
    private String password;

    public Myuser() {
    }

    public Myuser(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.password = pwd;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.password = pwd;
    }

    @Override
    public String toString() {
        return "Myuser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
