package com.weikun.pojo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/11/8.
 */
@Entity()
@Table(name = "cou", catalog = "test")
public class Cou {
    private int cid;
    private String cname;
    private Set<Pro> pros=new HashSet<Pro>();

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "cid", nullable = false)
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Basic
    @Column(name = "cname", nullable = false, length = 10)
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cou cou = (Cou) o;

        if (cid != cou.cid) return false;
        if (cname != null ? !cname.equals(cou.cname) : cou.cname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cid;
        result = 31 * result + (cname != null ? cname.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "cou",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public Set<Pro> getPros() {
        return pros;
    }

    public void setPros(Set<Pro> pros) {
        this.pros = pros;
    }
}
