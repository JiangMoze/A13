package com.weikun.pojo;

/**
 * Created by Administrator on 2016/11/8.
 */
public class Report {
    private int fid;
    private String fname;
    public Report(){}
    public Report(int fid, String fname) {
        this.fid = fid;
        this.fname = fname;
    }

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
}
