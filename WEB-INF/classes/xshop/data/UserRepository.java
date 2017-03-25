package xshop.data;

import xshop.entity.UserInfo;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserRepository {


    public UserRepository() {
    }

    public boolean add(UserInfo userinfo) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");

            PreparedStatement stmt = con.prepareStatement("INSERT INTO user(userid,password,name,usertype) VALUES(?,?,?,?)");
            stmt.setString(1, userinfo.getUserId());
            stmt.setString(2, userinfo.getPassword());
            stmt.setString(3, userinfo.getName());
            stmt.setString(4, userinfo.getUserType());

            int result = stmt.executeUpdate();

            con.close();
            
            if (result != 0) {
                return true;
            }
            return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }





    public List<UserInfo> getAll() {
        List<UserInfo> userlist = new ArrayList<UserInfo>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/login", "root", "");
            

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM user");
            
            ResultSet rs = stmt.executeQuery();
            

            while (rs.next()) {
                

                int id = rs.getInt("id");
              //  System.out.println("test1");

                String uid = rs.getString("userid");
               // System.out.println("test2");

                String pass = rs.getString("password");
               // System.out.println("test3");

                String name =  rs.getString("name");
               // System.out.println("test4");
                String type = rs.getString("usertype");

              //  System.out.println("test5 var");

                UserInfo userinfo = new UserInfo(id, uid ,pass,name,type);
               // System.out.println("test5");
                userlist.add(userinfo);
               // System.out.println("testlist");
            }
          //  System.out.println("test6");
            con.close();



        } catch (Exception e) {
            System.out.println("exception found at UserRepository.java");
        }
        return userlist;
    }



    public boolean edit(UserInfo userinfo) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");

            PreparedStatement stmt = con.prepareStatement("UPDATE user SET userid=? , name=? , password=?, usertype=? WHERE Id=?");
            stmt.setString(1, userinfo.getUserId());
            stmt.setString(2, userinfo.getName());
            stmt.setString(3, userinfo.getPassword());
            stmt.setString(4, userinfo.getUserType());
            stmt.setInt(5, userinfo.getId());

            int result = stmt.executeUpdate();
            con.close();

            if (result != 0) {
                return true;
            }
            return false;

        } catch (Exception e) {
            return false;
        }
    }


       public UserInfo getByUserId(String userId) {
        UserInfo UserInfo = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/login", "root", "");

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM user WHERE userid ='"+userId+"'");
            ResultSet rs = stmt.executeQuery();
            UserInfo userinfo;

            
            if (rs.next()) {
                int id = rs.getInt("id");
                String uid = rs.getString("userid");

                String pass = rs.getString("password");

                String name =  rs.getString("name");

                String type = rs.getString("usertype");

                userinfo = new UserInfo(id, uid ,pass,name,type);
                return userinfo;

            }
            con.close();

        } catch (Exception e) {

        }
        return null;
        
    }


     public UserInfo getById(int userId) {
        UserInfo UserInfo = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/login", "root", "");

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM user WHERE id ="+userId);
            ResultSet rs = stmt.executeQuery();
            UserInfo userinfo;

            
            if (rs.next()) {
                int id = rs.getInt("id");
                String uid = rs.getString("userid");

                String pass = rs.getString("password");

                String name =  rs.getString("name");

                String type = rs.getString("usertype");

                userinfo = new UserInfo(id, uid ,pass,name,type);
                return userinfo;

            }
            con.close();

        } catch (Exception e) {

        }
        return null;
        
    }

}