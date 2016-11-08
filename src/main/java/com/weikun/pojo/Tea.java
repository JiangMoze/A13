package com.weikun.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/11/8.
 */
public class Tea {
    private int tid;
    private String tname;
    private Set<Stu> stus=new HashSet<Stu>();

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tea tea = (Tea) o;

        if (tid != tea.tid) return false;
        if (tname != null ? !tname.equals(tea.tname) : tea.tname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tid;
        result = 31 * result + (tname != null ? tname.hashCode() : 0);
        return result;
    }

    public Set<Stu> getStus() {
        return stus;
    }

    public void setStus(Set<Stu> stus) {
        this.stus = stus;
    }
}
