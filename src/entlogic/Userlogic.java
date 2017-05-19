/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entlogic;

import entities.Forum_user;
import entities.Theme;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import main.Manager;

/**
 *
 * @author Ксения
 */
public class Userlogic extends Alogic<Forum_user>{
     public Userlogic() {
    }

    public Userlogic(Manager manager) {
        super(manager);
    }
    
    @Override    
    public void add(Forum_user entity) throws SQLException {
        try{
            String query = "insert into public.forum_user( name, email, password, gender, birth_date, regestration_date, id_user) values ('" 
                    + entity.getName() +"', '"+ entity.getEmail()+"', '" + entity.getPassword()+"',"+
                    entity.getGender() + ", '" + entity.getBirthDate() + "', '" + entity.getRegDate() +
                    "', (nextval('user_id_users_seq'))"  + ");";
            manager.executeQueryNS(query);
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public List<Forum_user> all() throws SQLException {
        List<Forum_user> entities = null;
        try {
            entities = new ArrayList<>();
            ResultSet rs = manager.executeQuery("select * from forum_user");
            while(rs.next()){
                Forum_user entity = new Forum_user();
                entity.setId(rs.getInt("id_user"));
                entity.setName(rs.getString("name"));
                entity.setEmail(rs.getString("email"));
                entity.setPassword(rs.getString("password"));
                entity.setGender(rs.getBoolean("gender"));
                entity.setBirthDate(rs.getDate("birth_date"));
                entity.setRegDate(rs.getDate("regestration_date"));
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
            String query = "delete from forum_user where id_user = " + i+";";
            manager.executeQueryNS(query);
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public void update(Forum_user entity) throws SQLException {
        try{
            String query = "update public.forum_user set name = '" + entity.getName() + "',"
                    + "email = '" + entity.getEmail() + "',"
                    + "gender = " + entity.getGender() + ","
                    + "birth_date = '" + entity.getBirthDate() + "', "
                    + "regestration_date = '" + entity.getRegDate() + "', "
                    + "password = '" + entity.getPassword() + "' " 
                    + "where id_user = " + entity.getId()+";";
            manager.executeQueryNS(query);
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public String getIdName() {
        return "id_user"; //To change body of generated methods, choose Tools | Templates.
    }

}
