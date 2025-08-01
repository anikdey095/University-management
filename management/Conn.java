
package university.management;

import java.sql.*;

public class Conn {
    
    Connection con;
    Statement s;

  public  Conn () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///uniproject", "root", "unimanagement12345");
            s = con.createStatement();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Conn();
    }
}