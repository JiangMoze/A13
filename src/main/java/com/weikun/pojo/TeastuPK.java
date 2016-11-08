package com.weikun.pojo;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/11/8.
 */
public class TeastuPK implements Serializable {
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

        TeastuPK teastuPK = (TeastuPK) o;

        if (tid != teastuPK.tid) return false;
        if (sid != teastuPK.sid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tid;
        result = 31 * result + sid;
        return result;
    }
}
