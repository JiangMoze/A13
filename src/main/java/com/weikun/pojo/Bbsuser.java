package com.weikun.pojo;

/**
 * Created by Administrator on 2016/11/1.
 */
public class Bbsuser {
    private int id;
    private String username;
    private String pwd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bbsuser bbsuser = (Bbsuser) o;

        if (id != bbsuser.id) return false;
        if (username != null ? !username.equals(bbsuser.username) : bbsuser.username != null) return false;
        if (pwd != null ? !pwd.equals(bbsuser.pwd) : bbsuser.pwd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        return result;
    }
}
