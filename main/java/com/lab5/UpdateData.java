package com.lab5;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/UpdateData")
public class UpdateData extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student",
                    "root",
                    "type_ur_dbpass");

            PreparedStatement ps = con.prepareStatement(
                    "update mark set name=?, section=?, s1=?, s2=?, s3=?, s4=?, s5=?, s6=?, l1=?, l2=? where rollno=?");

            ps.setString(1, request.getParameter("name"));
            ps.setString(2, request.getParameter("section"));
            ps.setInt(3, Integer.parseInt(request.getParameter("sub1")));
            ps.setInt(4, Integer.parseInt(request.getParameter("sub2")));
            ps.setInt(5, Integer.parseInt(request.getParameter("sub3")));
            ps.setInt(6, Integer.parseInt(request.getParameter("sub4")));
            ps.setInt(7, Integer.parseInt(request.getParameter("sub5")));
            ps.setInt(8, Integer.parseInt(request.getParameter("sub6")));
            ps.setInt(9, Integer.parseInt(request.getParameter("lab1")));
            ps.setInt(10, Integer.parseInt(request.getParameter("lab2")));
            ps.setInt(11, Integer.parseInt(request.getParameter("rollno")));

            int rows = ps.executeUpdate();

            if (rows > 0)
                out.println("<h2>Record Updated Successfully</h2>");
            else
                out.println("<h3>No Record Found</h3>");

            con.close();

        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }

        out.close();
    }

}
