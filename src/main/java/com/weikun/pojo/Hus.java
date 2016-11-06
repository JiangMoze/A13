package com.weikun.pojo;

/**
 * Created by Administrator on 2016/11/6.
 */
public class Hus {
    private int id;
    private String hname;
    private Wife wife;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hus hus = (Hus) o;

        if (id != hus.id) return false;
        if (hname != null ? !hname.equals(hus.hname) : hus.hname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (hname != null ? hname.hashCode() : 0);
        return result;
    }

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }
}
