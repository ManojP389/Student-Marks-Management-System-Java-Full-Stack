package com.lab5;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/DispData")
public class DispData extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
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
                    "type_ur_dbpass");

            PreparedStatement ps = con.prepareStatement(
                    "select * from mark where rollno=?");

            ps.setInt(1, roll);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                out.println("<h2>Student Result</h2>");
                out.println("Roll No: " + rs.getInt(1) + "<br>");
                out.println("Name: " + rs.getString(2) + "<br>");
                out.println("Section: " + rs.getString(3) + "<br>");

                int s1 = rs.getInt(4);
                int s2 = rs.getInt(5);
                int s3 = rs.getInt(6);
                int s4 = rs.getInt(7);
                int s5 = rs.getInt(8);
                int s6 = rs.getInt(9);
                int l1 = rs.getInt(10);
                int l2 = rs.getInt(11);

                out.println("Marks: " + s1 + ", " + s2 + ", " + s3 + ", " +
                        s4 + ", " + s5 + ", " + s6 + ", " + l1 + ", " + l2 + "<br>");

                if (s1>=40 && s2>=40 && s3>=40 && s4>=40 &&
                    s5>=40 && s6>=40 && l1>=40 && l2>=40)
                    out.println("<b>Status: PASS</b>");
                else
                    out.println("<b>Status: FAIL</b>");
            }
            else {
                out.println("<h3>No Record Found</h3>");
            }

            con.close();

        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }

        out.close();
    }

}
