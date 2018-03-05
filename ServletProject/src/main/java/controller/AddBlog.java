package controller;


import Dao.InsertBlog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/AddBlog")
public class AddBlog extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        if (session.getAttribute("uname") == null) {
            out.write("Session Expired");
        } else {
            try {

                if (InsertBlog.insertblog(request.getParameter("val"), (String) session.getAttribute("uname"))) {

                    out.write("blog added successfully");
                } else {
                    out.write("blog not added <br> please try after sometime");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


    }
}
