package com.weikun.pojo;

/**
 * Created by Administrator on 2016/11/8.
 */
public class Teastu {
    private int tid;
    private int sid;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teastu teastu = (Teastu) o;

        if (tid != teastu.tid) return false;
        if (sid != teastu.sid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tid;
        result = 31 * result + sid;
        return result;
    }
}
