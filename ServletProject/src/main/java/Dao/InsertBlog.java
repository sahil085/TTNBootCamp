package Dao;

import java.sql.*;

public class InsertBlog {
    public static boolean insertblog(String blog, String uname) throws SQLException {

        PreparedStatement ps = Authentication.con.prepareStatement("insert into blogs (name,blog) values(?,?)");
        ps.setString(1, uname);
        ps.setString(2, blog);
        if (ps.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }


    }
}
