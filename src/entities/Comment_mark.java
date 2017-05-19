/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Ксения
 */
public class Comment_mark implements IEntity{
    
    private int id_mark;
    private int id_user;
    private int id_comment;
    private boolean type;

    public Comment_mark() {
    }

    public Comment_mark(int id_m, int id_u, int id_c, boolean t) {
        this.id_mark = id_m;
        this.id_user = id_u;
        this.id_comment = id_c;
        this.type = t;
    }

    public int getId() {
        return id_mark;
    }

    public void setId(int id) {
        this.id_mark = id;
    }

    public int getIdUser() {
        return id_user;
    }

    public void setIdUser(int id) {
        this.id_user = id;
    }
    
    public int getIdComment() {
        return id_comment;
    }

    public void setIdComment(int id) {
        this.id_comment = id;
    }
    
    public boolean getType() {
        return type;
    }

    public void setType(boolean t) {
        this.type = t;
    }
    
    @Override
    public String toString() {
        return type + " ";
    }
    
    @Override
    public String[] getHeader(){
        return new String[] {"id_mark","id_user","id_comment","type"};
    }

    @Override
    public String[] getRow(){
        return new String[] {id_mark+"",  id_user+"",id_comment+"",type+""};
    }
}
