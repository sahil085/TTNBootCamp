package Dao;

import java.sql.*;

public class Authentication {
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

    public static boolean authenticate(String uname, String password) throws SQLException {
        String name = uname;
        String pass = password;
        PreparedStatement ps = con.prepareStatement("SELECT name,password from user where name=? && password=? ");
        ps.setString(1, name);
        ps.setString(2, pass);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

}
