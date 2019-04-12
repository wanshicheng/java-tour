package com.skillip.jdbc.pojo;

import java.util.Date;

public class Employee {
    private Integer empId;
    private String fname;
    private String lname;
    private Date startDate;
    private Date endDate;
    private Integer superiorEmpId;
    private Integer deptId;
    private String title;
    private Integer assignedBranchId;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getSuperiorEmpId() {
        return superiorEmpId;
    }

    public void setSuperiorEmpId(Integer superiorEmpId) {
        this.superiorEmpId = superiorEmpId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAssignedBranchId() {
        return assignedBranchId;
    }

    public void setAssignedBranchId(Integer assignedBranchId) {
        this.assignedBranchId = assignedBranchId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", superiorEmpId=" + superiorEmpId +
                ", deptId=" + deptId +
                ", title='" + title + '\'' +
                ", assignedBranchId=" + assignedBranchId +
                '}';
    }
}
