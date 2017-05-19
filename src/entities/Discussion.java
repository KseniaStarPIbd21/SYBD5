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
public class Discussion implements IEntity{
    private int id_discussion;   
    private String name;
    private Date creation_date;
    private int id_user;
    private int id_theme;        
    

    public Discussion() {
    }

    public Discussion(int id_d, String n,Date cd,  int id_u, int id_t) {
        this.id_discussion = id_d;
        this.name = n;
        this.creation_date = cd;       
        this.id_user = id_u;
        this.id_theme = id_t;      
    }

    public int getId() {
        return id_discussion;
    }

    public void setId(int id) {
        this.id_discussion = id;
    }

    public int getIdUser() {
        return id_user;
    }

    public void setIdUser(int id) {
        this.id_user = id;
    }
    
    public int getIdTheme() {
        return id_theme;
    }

    public void setIdTheme(int id) {
        this.id_theme = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name = n;
    }
    
    public Date getCreatDate() {
        return creation_date;
    }

    public void setCreatDate(Date cd) {
        this.creation_date = cd;
    }
    
    @Override
    public String toString() {
        return name + " ";
    }
    
    public String getFullInfo() {
        return name + " " + creation_date;
    }
    
    @Override
    public String[] getHeader(){
        return new String[] {"id_discussion","name","creation_date","id_user",
            "id_theme"};
    }
    
    @Override
    public String[] getRow(){
        return new String[] {id_discussion+"", name, creation_date.toString(),
                    id_user+"",id_theme+""};
    }
}
