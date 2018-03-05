package controller;

import Dao.Authentication;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession ss = request.getSession();
        if (ss.getAttribute("uname") == null) {
            Authentication a = new Authentication();
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            try {

                if (a.authenticate(request.getParameter("name"), request.getParameter("pass"))) {

                    ss.setAttribute("uname", request.getParameter("name"));

                    response.sendRedirect("http://localhost:8090/blogs.jsp");
                } else {

                    out.write("INVALID PASSWORD OR USERNAME");
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.include(request, response);

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            response.sendRedirect("http://localhost:8090/blogs.jsp");
        }
    }

}
