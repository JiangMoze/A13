package com.weikun.pojo;

/**
 * Created by Administrator on 2016/11/6.
 */
public class Son {
    private int sid;
    private String sname;
    private Integer fid;
    private Father father;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Son son = (Son) o;

        if (sid != son.sid) return false;
        if (sname != null ? !sname.equals(son.sname) : son.sname != null) return false;
        if (fid != null ? !fid.equals(son.fid) : son.fid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid;
        result = 31 * result + (sname != null ? sname.hashCode() : 0);
        result = 31 * result + (fid != null ? fid.hashCode() : 0);
        return result;
    }

    public Father getFather() {
        return father;
    }

    public void setFather(Father father) {
        this.father = father;
    }
}
