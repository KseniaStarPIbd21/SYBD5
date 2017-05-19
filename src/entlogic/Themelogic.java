/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entlogic;
import entities.Theme;
import main.Manager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Ксения
 */
public class Themelogic extends Alogic<Theme>{
    public Themelogic() {
    }

    public Themelogic(Manager manager) {
        super(manager);
    }
    
    @Override
    public void add(Theme entity) throws SQLException {
        try{
            String query = "insert into public.theme(name, id_theme) values ('" + entity.getName()
                    + "', (nextval('theme_id_theme_seq')));";
            manager.executeQueryNS(query);
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public List<Theme> all() throws SQLException {
        List<Theme> entities = null;
        try {
            entities = new ArrayList<>();
            ResultSet rs = manager.executeQuery("select * from theme");
            while(rs.next()){
                Theme entity = new Theme();
                entity.setId(rs.getInt("id_theme"));
                entity.setName(rs.getString("name"));
                entities.add(entity);               
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return entities;
    }

    @Override
    public void delete(Integer i) throws SQLException {
        try{
            String query = "delete from theme where id_theme = " + i + ";";
            manager.executeQueryNS(query);
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public void update(Theme entity) throws SQLException {
        try{
            String query = "update theme set name = '" + entity.getName() + "' "           
                    + "where id_theme = " + entity.getId();
            manager.executeQueryNS(query);
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public String getIdName() {
        return "id_theme"; //To change body of generated methods, choose Tools | Templates.
    }

}
