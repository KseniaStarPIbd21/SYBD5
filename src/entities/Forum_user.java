/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author Ксения
 */
public class Forum_user implements IEntity{   
    private String name;
    private String email;
    private String password;
    private boolean gender;
    private Date birth_date;
    private Date regestration_date;
    private int id_user;
    

    public Forum_user() {
    }

    public Forum_user(String name,  boolean g,String email, String pw, Date bd, Date rd, int id) {
        this.name = name;
        this.email = email;
        this.password = pw;
        this.gender = g;
        this.birth_date = bd;
        this.regestration_date = rd;
        this.id_user = id;
    }

    public int getId() {
        return id_user;
    }

    public void setId(int id) {
        this.id_user = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String pw) {
        this.password = pw;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean g) {
        this.gender = g;
    }
    
    public Date getRegDate() {
        return regestration_date;
    }

    public void setRegDate(Date rd) {
        this.regestration_date = rd;
    }

    public Date getBirthDate() {
        return birth_date;
    }

    public void setBirthDate(Date bd) {
        this.birth_date = bd;
    }
    
    @Override
    public String toString() {
        return name + " " + gender + " "+ email;
    }
    
    public String getFullInfo() {
        return  name + " " + gender +  " " + email +  " " + password + " " + regestration_date +  " " + birth_date ;
    }
    
    @Override
    public String[] getHeader(){
        return new String[] {"name","email","password", "gender", "birth_date",
            "regestration_date","id_user"};
    }
    
    @Override
    public String[] getRow(){
        return new String[] { name, email, password, gender+"", birth_date.toString(),
            regestration_date.toString(),id_user+""};
    }


}
