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
public class Comment implements IEntity{
    private int id_comment; 
    private int id_user;
    private int id_discussion;      
    private String text;
    private Date creation_date;

    public Comment() {
    }

    public Comment(int id_c, int id_u,int id_d, String t, Date cd) {
        this.id_comment = id_c;
        this.id_user = id_u;
        this.id_discussion = id_d;
        this.text = t;
        this.creation_date = cd;
    }

    public int getId() {
        return id_comment;
    }

    public void setId(int id) {
        this.id_comment = id;
    }

    public int getIdUser() {
        return id_user;
    }

    public void setIdUser(int id) {
        this.id_user = id;
    }
    
    public int getIdDiscussion() {
        return id_discussion;
    }

    public void setIdDiscussion(int id) {
        this.id_discussion = id;
    }
    
    public String getText() {
        return text;
    }

    public void setText(String t) {
        this.text = t;
    }
    
    public Date getCreatDate() {
        return creation_date;
    }

    public void setCreatDate(Date cd) {
        this.creation_date = cd;
    }
    
    @Override
    public String toString() {
        return text + " ";
    }
    
    public String getFullInfo() {
        return text + " " + creation_date;
    }
    
    @Override
    public String[] getHeader(){
        return new String[] {"id_comment","id_user", "id_discussion", "text",
            "creation_date"};
    }
    
    @Override
    public String[] getRow(){
        return new String[] {id_comment+"",id_user+"",id_discussion+"", text, 
            creation_date.toString()};
    }
}
