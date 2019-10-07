package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

	static String DBNAME = "achadosperdidos";
	static String DRIVER = "com.mysql.jdbc.Driver";
	static String URL = "jdbc:mysql://localhost:3306/" + DBNAME;
	static String USER = "root";
	static String PASS = "";
	
    public static Connection getConnection(){

        try {   
          Class.forName(DRIVER);
          return DriverManager.getConnection(URL, USER, PASS);
          
          
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException(" Erro na conexao", ex);
        }

    }
    
    public static void closeConnection(Connection con){
                     
        if(con!=null){
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     
    
    }
    
       
         public static void closeConnection(Connection con, PreparedStatement stmt){
               
             closeConnection(con);
             
            try {
                
                if(stmt != null){
                    stmt.close();
                }                
                
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
                 
       
         public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
               
             closeConnection(con, stmt);
             
            try {
                
                if(rs != null){
                    rs.close();
                }                
                
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
}