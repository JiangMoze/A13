package com.weikun.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/11/8.
 */
public class Stu {
    private int sid;
    private String sname;
    private Set<Tea> teas=new HashSet<Tea>();

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stu stu = (Stu) o;

        if (sid != stu.sid) return false;
        if (sname != null ? !sname.equals(stu.sname) : stu.sname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid;
        result = 31 * result + (sname != null ? sname.hashCode() : 0);
        return result;
    }

    public Set<Tea> getTeas() {
        return teas;
    }

    public void setTeas(Set<Tea> teas) {
        this.teas = teas;
    }
}
