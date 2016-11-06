package com.weikun.pojo;

import java.util.Set;

/**
 * Created by Administrator on 2016/11/6.
 */
public class Father {
    private int fid;
    private String fname;
    private Set<Son> son;

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Father father = (Father) o;

        if (fid != father.fid) return false;
        if (fname != null ? !fname.equals(father.fname) : father.fname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fid;
        result = 31 * result + (fname != null ? fname.hashCode() : 0);
        return result;
    }

    public Set<Son> getSon() {
        return son;
    }

    public void setSon(Set<Son> son) {
        this.son = son;
    }
}
