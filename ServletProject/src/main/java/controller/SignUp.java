package controller;

import Dao.Registration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter=response.getWriter();
        try {
            if(Registration.addUser(request.getParameter("pass"),request.getParameter("uname"))){
            printWriter.write("Registration Done Successfully");
            }else {
                printWriter.write("Try Again");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}