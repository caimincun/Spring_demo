package cn.springmvc.model;

import java.io.Serializable;

/**
 * Created by cmc on 14-12-9.
 */
public class User implements Serializable {
    private int id;
    private String name;
    private String password;
    private int deptid;

    // 用户和部门一对一 关联
    private Dept dept;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", deptid=" + deptid +
                ", dept=" + dept +
                '}';
    }
}
