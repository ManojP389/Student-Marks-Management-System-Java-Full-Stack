package com.lab5;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ListData")
public class ListData extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student",
                    "root",
                    "root123");

            PreparedStatement ps =
                    con.prepareStatement("select * from mark");

            ResultSet rs = ps.executeQuery();

            out.println("<h2>All Students</h2>");
            out.println("<table border='1'>");

            out.println("<tr><th>Roll</th><th>Name</th><th>Section</th>" +
                    "<th>S1</th><th>S2</th><th>S3</th><th>S4</th>" +
                    "<th>S5</th><th>S6</th><th>L1</th><th>L2</th><th>Status</th></tr>");

            while (rs.next()) {

                int s1 = rs.getInt(4);
                int s2 = rs.getInt(5);
                int s3 = rs.getInt(6);
                int s4 = rs.getInt(7);
                int s5 = rs.getInt(8);
                int s6 = rs.getInt(9);
                int l1 = rs.getInt(10);
                int l2 = rs.getInt(11);

                out.println("<tr>");
                out.println("<td>" + rs.getInt(1) + "</td>");
                out.println("<td>" + rs.getString(2) + "</td>");
                out.println("<td>" + rs.getString(3) + "</td>");
                out.println("<td>" + s1 + "</td>");
                out.println("<td>" + s2 + "</td>");
                out.println("<td>" + s3 + "</td>");
                out.println("<td>" + s4 + "</td>");
                out.println("<td>" + s5 + "</td>");
                out.println("<td>" + s6 + "</td>");
                out.println("<td>" + l1 + "</td>");
                out.println("<td>" + l2 + "</td>");

                if (s1>=40 && s2>=40 && s3>=40 && s4>=40 &&
                    s5>=40 && s6>=40 && l1>=40 && l2>=40)
                    out.println("<td>PASS</td>");
                else
                    out.println("<td>FAIL</td>");

                out.println("</tr>");
            }

            out.println("</table>");

            con.close();

        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }

        out.close();
    }
}