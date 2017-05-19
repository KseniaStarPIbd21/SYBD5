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
public class Theme implements IEntity{
  
    private String name;
    private int id_theme;

    public Theme() {
    }

    public Theme( String name, int id) {
        this.id_theme = id;
        this.name = name;
    }

    public int getId() {
        return id_theme;
    }

    public void setId(int id) {
        this.id_theme = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return name + " ";
    }
    
    @Override
    public String[] getHeader(){
        return new String[] {"id_theme","name"};
    }
    
    @Override
    public String[] getRow(){
        return new String[] {id_theme+"", name};
    }

    
}
