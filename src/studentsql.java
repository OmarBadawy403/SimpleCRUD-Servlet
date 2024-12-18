import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class studentsql {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  
            String url = "jdbc:mysql://127.0.0.1/servletdb";  
            con = DriverManager.getConnection(url, "omar", "omar");  
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
        return con;
    }

    public static int save(student s) {
        int st = 0;
        
        try {String sql = "INSERT INTO `studentinf`(`name`, `password`, `email`, `country`) VALUES (?,?,?,?)";
        	Connection con = studentsql.getConnection(); 
             PreparedStatement preparedStatement = con.prepareStatement(sql);

       

            preparedStatement.setString(1, s.getName());
            preparedStatement.setString(2, s.getPassword());
            preparedStatement.setString(3, s.getEmail());
            preparedStatement.setString(4, s.getCountry());

            st = preparedStatement.executeUpdate();  
            con.close();
        } catch (SQLException e) {
          
            e.printStackTrace();
        }
        return st;
    }

    public static int update(student s) {
        int st = 0;
        
        try {String sql = "UPDATE `studentinf` SET `name`=?, `password`=?, `email`=?, `country`=? WHERE id=?";
        		Connection con = studentsql.getConnection(); 
             PreparedStatement preparedStatement = con.prepareStatement(sql);

        

            preparedStatement.setString(1, s.getName());
            preparedStatement.setString(2, s.getPassword());
            preparedStatement.setString(3, s.getEmail());
            preparedStatement.setString(4, s.getCountry());
            preparedStatement.setInt(5, s.getId());

            st = preparedStatement.executeUpdate(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }

    
    
    
    
    
    public static int delete(int id) {
        int st = 0;
        
        try {
        	String sql = "DELETE FROM `studentinf` WHERE id=?";
        		Connection con = studentsql.getConnection(); 
             PreparedStatement preparedStatement = con.prepareStatement(sql);


            preparedStatement.setInt(1, id);
            st = preparedStatement.executeUpdate();  
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }

    
    
    
    
    
    
    
    public static student getid(int id) {
        student s = new student();
      
        try {  String sql = "SELECT * FROM `studentinf` WHERE id=?";
        		Connection con = studentsql.getConnection(); 
             PreparedStatement preparedStatement = con.prepareStatement(sql) ;

    
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery() ;
                if (resultSet.next()) { 
                    s.setId(resultSet.getInt(1));
                    s.setName(resultSet.getString(2));
                    s.setPassword(resultSet.getString(3));
                    s.setEmail(resultSet.getString(4));
                    s.setCountry(resultSet.getString(5));
                }
            
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        return s;
    }

    
    
    public static List<student> getstudent() {
        List<student> list = new ArrayList<student>();
        
        
        
        try {String sql = "SELECT * FROM `studentinf`";
        		
        		Connection con = studentsql.getConnection(); 
        		PreparedStatement preparedStatement=con.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery(); 
           
        	 
            while (resultSet.next()) {  
            	  
                student s = new student();
                s.setId(resultSet.getInt(1));
                s.setName(resultSet.getString(2));
                s.setPassword(resultSet.getString(3));
                s.setEmail(resultSet.getString(4));
                s.setCountry(resultSet.getString(5));
                list.add(s);      
            }
        } catch (SQLException e) {
            System.out.println("Error executing the SQL query for fetching all students.");
            e.printStackTrace();
        }
        
        return list;
    }

    
    
    
   
    
    
}
