/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entlogic;

import entities.Comment;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import main.Manager;

/**
 *
 * @author Ксения
 */
public class Commentlogic extends Alogic<Comment>{
    public Commentlogic() {
    }

    public Commentlogic(Manager manager) {
        super(manager);
    }
    
    @Override    
    public void add(Comment entity) throws SQLException {
        try{
            String query = "insert into public.comment(id_comment, id_user, id_discussion, text, creation_date)values ((nextval('comment_id_comments_seq'))," 
                    + entity.getIdUser()+ ", " + entity.getIdDiscussion() + ", '" + entity.getText() + "', '" +entity.getCreatDate()+ "');";
            manager.executeQueryNS(query);
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public List<Comment> all() throws SQLException {
        List<Comment> entities = null;
        try {
            entities = new ArrayList<>();
            ResultSet rs = manager.executeQuery("select * from comment");
            while(rs.next()){
                Comment entity = new Comment();
                entity.setId(rs.getInt("id_comment"));
                entity.setIdDiscussion(rs.getInt("id_discussion"));
                entity.setIdUser(rs.getInt("id_user"));
                entity.setText(rs.getString("text"));
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
        try{
            String query = "delete from comment where id_comment = " + i + ";";
            manager.executeQueryNS(query);
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public void update(Comment entity) throws SQLException {
        try{
            String query = "update comment set id_user = " + entity.getIdUser() + ","
                    + "id_discussion = " + entity.getIdDiscussion() + ","
                    + "text = '" + entity.getText() + "',"
                    + "creation_date = '" + entity.getCreatDate() + "' "                    
                    + "where id_comment = " + entity.getId()+";";
            manager.executeQueryNS(query);
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public String getIdName() {
       return "id_comment"; //To change body of generated methods, choose Tools | Templates.
    }
}
