package com.lab5;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/DeleteData")
public class DeleteData extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {

            int roll = Integer.parseInt(request.getParameter("rollno"));

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student",
                    "root",
                    "root123");

            PreparedStatement ps =
                    con.prepareStatement("delete from mark where rollno=?");

            ps.setInt(1, roll);

            int rows = ps.executeUpdate();

            if (rows > 0)
                out.println("<h2>Record Deleted Successfully</h2>");
            else
                out.println("<h3>No Record Found</h3>");

            con.close();

        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }

        out.close();
    }
}