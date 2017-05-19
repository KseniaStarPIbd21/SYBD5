/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entlogic;


import entities.Discussion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import main.Manager;

/**
 *
 * @author Ксения
 */
public class Discussionlogic extends Alogic<Discussion>{
     public Discussionlogic() {
    }

    public Discussionlogic(Manager manager) {
        super(manager);
    }
    
    @Override    
    public void add(Discussion entity) throws SQLException {
        try{
            String query = "insert into public.discussion(id_discussion, name, creation_date, id_user, id_theme) values ((nextval('discussion_id_discussion_seq')), '" 
                    + entity.getName() + "', '" + entity.getCreatDate() + "', " + entity.getIdUser() + ", " + entity.getIdTheme()+ ");";
            manager.executeQueryNS(query);
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public List<Discussion> all() throws SQLException {
        List<Discussion> entities = null;
        try {
            entities = new ArrayList<>();
            ResultSet rs = manager.executeQuery("select * from discussion");
            while(rs.next()){
                Discussion entity = new Discussion();
                entity.setId(rs.getInt("id_discussion"));
                entity.setIdTheme(rs.getInt("id_theme"));
                entity.setIdUser(rs.getInt("id_user"));
                entity.setName(rs.getString("name"));
                 entity.setCreatDate(rs.getDate("creation_date"));
                entities.add(entity);               
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return entities;
    }

    @Override
    public void delete(Integer i) throws SQLException {
            String query = "delete from discussion where id_discussion = " + i + ";";
            manager.executeQueryNS(query);
    }

    @Override
    public void update(Discussion entity) throws SQLException {
        try{
            String query = "update discussion set name = '" + entity.getName() + "',"
                    + "creation_date = '" + entity.getCreatDate() + "',"
                    + "id_user = " + entity.getIdUser() + ","
                    + "id_theme = " + entity.getIdTheme() + " "
                    + "where id_discussion = " + entity.getId()+"; ";
            manager.executeQueryNS(query);
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public String getIdName() {
      return "id_discussion"; //To change body of generated methods, choose Tools | Templates.
    }
    
}
