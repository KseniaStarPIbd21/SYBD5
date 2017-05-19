/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entlogic;

import java.sql.SQLException;
import java.util.List;
import main.Manager;

/**
 *
 * @author Ксения
 */
public abstract class Alogic<T> {
     protected Manager manager;

    public Alogic() {
    }

    public Alogic(Manager manager) {
        this.manager = manager;
    }
            
    public abstract void add(T entity) throws SQLException;
    public abstract List<T> all() throws SQLException;
    public abstract void delete(Integer i) throws SQLException;
    public abstract void update(T entity) throws SQLException;
    public abstract String getIdName();
    public void setManager(Manager manager){
        this.manager = manager;
    }
}
