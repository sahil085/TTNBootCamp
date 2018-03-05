package controller;

import Dao.Authentication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/recentblogs")
public class recentblogs extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.write("<table border='1' style='border:2px solid black;border-radius:2px;margin-left:5%;text-allign:centre;'>");
        out.write("<thead><th>Sno.</th><th>blog</th><th>blogger</th></thead>");
        out.write("<tbody>");
        try {
            PreparedStatement ps = Authentication.con.prepareStatement("select * from blogs;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                out.write("<tr><td>" + rs.getInt(1) + "</td><td>" + rs.getString(3) + "</td><td>" + rs.getString(2) + "</td></tr>");

            }
            out.write("<tbody>");
            out.write("</table>");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
