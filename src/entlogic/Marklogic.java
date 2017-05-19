/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entlogic;

import entities.Comment_mark;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import main.Manager;

/**
 *
 * @author Ксения
 */
public class Marklogic extends Alogic<Comment_mark>{
     public Marklogic() {
    }

    public Marklogic(Manager manager) {
        super(manager);
    }
    
    @Override    
    public void add(Comment_mark entity) throws SQLException {
        try{
            String query = "insert into public.comment_mark(id_mark, id_user, id_comment, type) values ((nextval('Comment_mark_id_mark_seq')), " 
                    + entity.getIdUser() + ", " + entity.getIdComment()
                    + ", " + entity.getType() + ");";
            manager.executeQueryNS(query);
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public List<Comment_mark> all() throws SQLException {
        List<Comment_mark> entities = null;
        try {
            entities = new ArrayList<>();
            ResultSet rs = manager.executeQuery("select * from comment_mark");
            while(rs.next()){
                Comment_mark entity = new Comment_mark();
                entity.setId(rs.getInt("id_mark"));
                entity.setIdComment(rs.getInt("id_comment"));
                entity.setIdUser(rs.getInt("id_user"));
                entity.setType(rs.getBoolean("type"));
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
            String query = "delete from comment_mark where id_mark = " + i + ";";
            manager.executeQueryNS(query);
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public void update(Comment_mark entity) throws SQLException {
        try{
            String query = "update comment_mark set id_user = " + entity.getIdUser() + ","
                    + "id_comment = " + entity.getIdComment() + ","
                    + "type = " + entity.getType() + " "
                    + "where id_mark = " + entity.getId();
            manager.executeQueryNS(query);
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public String getIdName() {
        return "id_mark"; //To change body of generated methods, choose Tools | Templates.
    }
}
