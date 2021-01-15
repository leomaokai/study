package com.kai.bean;

import java.sql.Date;

public class Myusers {
    private int id;
    private String name;
    private String password;
    private String eamil;
    private Date birthday;

    public Myusers() {
    }

    public Myusers(int id, String name, String password, String eamil, Date birthday) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.eamil = eamil;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEamil() {
        return eamil;
    }

    public void setEamil(String eamil) {
        this.eamil = eamil;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Myusers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", eamil='" + eamil + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
