/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.poly.model;

/**
 *
 * @author ADMIN
 */
public class Member {
    private String ID_Member, Name_Member, TotalWorkingTime, ID_Permission,PassWord;
    private int salary;

    public Member(String ID_Member, String Name_Member, String TotalWorkingTime, String ID_Permission, String PassWord, int salary) {
        this.ID_Member = ID_Member;
        this.Name_Member = Name_Member;
        this.TotalWorkingTime = TotalWorkingTime;
        this.ID_Permission = ID_Permission;
        this.PassWord = PassWord;
        this.salary = salary;
    }

    public Member() {
      //To change body of generated methods, choose Tools | Templates.
    }

    public String getID_Member() {
        return ID_Member;
    }

    public void setID_Member(String ID_Member) {
        this.ID_Member = ID_Member;
    }

    public String getName_Member() {
        return Name_Member;
    }

    public void setName_Member(String Name_Member) {
        this.Name_Member = Name_Member;
    }

    public String getTotalWorkingTime() {
        return TotalWorkingTime;
    }

    public void setTotalWorkingTime(String TotalWorkingTime) {
        this.TotalWorkingTime = TotalWorkingTime;
    }

    public String getID_Permission() {
        return ID_Permission;
    }

    public void setID_Permission(String ID_Permission) {
        this.ID_Permission = ID_Permission;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String PassWord) {
        this.PassWord = PassWord;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}