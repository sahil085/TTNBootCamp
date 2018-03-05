package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registration {

    public static Connection con;

    static {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/servlet", "root", "root");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

        public static boolean addUser(String password, String uname) throws SQLException {

            PreparedStatement ps = con.prepareStatement("insert into user (name,password) values(?,?)");
            ps.setString(1, uname);
            ps.setString(2, password);
            if (ps.executeUpdate() > 0) {
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }


        }


}
