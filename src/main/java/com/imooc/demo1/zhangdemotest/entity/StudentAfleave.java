package com.imooc.demo1.zhangdemotest.entity;

import java.util.Date;

public class StudentAfleave {
    private String studentAfleaveId;
    private String studentId;
    private String counsellorId;
    private String studentAname;
    private String studentClass;
    private String studentNumber;
    private Date studentAfleaveStartTime;
    private Date studentAfleaveEndTime;
    private int studentAfleaveDays;
    private String studentAfleavePlace;
    private String studentAfleaveReason;
    private String studentAfleaveState;

    public StudentAfleave(String studentAfleaveId, String studentId, String counsellorId, String studentAname, String studentClass, String studentNumber, Date studentAfleaveStartTime, Date studentAfleaveEndTime, int studentAfleaveDays, String studentAfleavePlace, String studentAfleaveReason, String studentAfleaveState) {
        this.studentAfleaveId = studentAfleaveId;
        this.studentId = studentId;
        this.counsellorId = counsellorId;
        this.studentAname = studentAname;
        this.studentClass = studentClass;
        this.studentNumber = studentNumber;
        this.studentAfleaveStartTime = studentAfleaveStartTime;
        this.studentAfleaveEndTime = studentAfleaveEndTime;
        this.studentAfleaveDays = studentAfleaveDays;
        this.studentAfleavePlace = studentAfleavePlace;
        this.studentAfleaveReason = studentAfleaveReason;
        this.studentAfleaveState = studentAfleaveState;
    }

    public String getStudentAfleaveId() {
        return studentAfleaveId;
    }

    public void setStudentAfleaveId(String studentAfleaveId) {
        this.studentAfleaveId = studentAfleaveId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCounsellorId() {
        return counsellorId;
    }

    public void setCounsellorId(String counsellorId) {
        this.counsellorId = counsellorId;
    }

    public String getStudentAname() {
        return studentAname;
    }

    public void setStudentAname(String studentAname) {
        this.studentAname = studentAname;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Date getStudentAfleaveStartTime() {
        return studentAfleaveStartTime;
    }

    public void setStudentAfleaveStartTime(Date studentAfleaveStartTime) {
        this.studentAfleaveStartTime = studentAfleaveStartTime;
    }

    public Date getStudentAfleaveEndTime() {
        return studentAfleaveEndTime;
    }

    public void setStudentAfleaveEndTime(Date studentAfleaveEndTime) {
        this.studentAfleaveEndTime = studentAfleaveEndTime;
    }

    public int getStudentAfleaveDays() {
        return studentAfleaveDays;
    }

    public void setStudentAfleaveDays(int studentAfleaveDays) {
        this.studentAfleaveDays = studentAfleaveDays;
    }

    public String getStudentAfleavePlace() {
        return studentAfleavePlace;
    }

    public void setStudentAfleavePlace(String studentAfleavePlace) {
        this.studentAfleavePlace = studentAfleavePlace;
    }

    public String getStudentAfleaveReason() {
        return studentAfleaveReason;
    }

    public void setStudentAfleaveReason(String studentAfleaveReason) {
        this.studentAfleaveReason = studentAfleaveReason;
    }

    public String getStudentAfleaveState() {
        return studentAfleaveState;
    }

    public void setStudentAfleaveState(String studentAfleaveState) {
        this.studentAfleaveState = studentAfleaveState;
    }

}
