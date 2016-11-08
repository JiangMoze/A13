package com.weikun.pojo;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/11/8.
 */
@Entity
@Table(name = "pro", catalog = "test")
public class Pro {
    private int pid;
    private String pname;
    private Cou cou;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "pid", nullable = false)
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "pname", nullable = false, length = 10)
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pro pro = (Pro) o;

        if (pid != pro.pid) return false;
        if (pname != null ? !pname.equals(pro.pname) : pro.pname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pid;
        result = 31 * result + (pname != null ? pname.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    public Cou getCou() {
        return cou;
    }

    public void setCou(Cou cou) {
        this.cou = cou;
    }
}
