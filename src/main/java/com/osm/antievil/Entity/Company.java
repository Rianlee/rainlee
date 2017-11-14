package com.osm.antievil.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author wellCh4n
 * @DESCRIPTION
 * @create 2017 - 11 - 13 13:23
 */
@Entity
public class Company implements Comparable<Company> {

    @Id
    @GeneratedValue
    private Integer Id;

    private String name;
    private String pinyinname;
    private String address;
    private Integer pid;
    private Integer cid;
    private String comment;
    private Double n;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyinname() {
        return pinyinname;
    }

    public void setPinyinname(String pinyinname) {
        this.pinyinname = pinyinname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getN() {
        return n;
    }

    public void setN(Double n) {
        this.n = n;
    }

    @Override
    public int compareTo(Company o) {
        if (this.getN() > o.getN()){
            return -1;
        }else{
            return 1;
        }
    }
}
