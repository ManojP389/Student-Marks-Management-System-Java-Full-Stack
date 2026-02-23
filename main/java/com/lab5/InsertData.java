package com.lab5;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/InsertData")
public class InsertData extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {

            // 1. Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish Connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student",
                    "root",
                    "root123");   // change if your password is different

            // 3. Prepare Statement
            PreparedStatement st = con.prepareStatement(
                    "insert into mark values(?,?,?,?,?,?,?,?,?,?,?)");

            st.setInt(1, Integer.parseInt(request.getParameter("rollno")));
            st.setString(2, request.getParameter("name"));
            st.setString(3, request.getParameter("section"));
            st.setInt(4, Integer.parseInt(request.getParameter("sub1")));
            st.setInt(5, Integer.parseInt(request.getParameter("sub2")));
            st.setInt(6, Integer.parseInt(request.getParameter("sub3")));
            st.setInt(7, Integer.parseInt(request.getParameter("sub4")));
            st.setInt(8, Integer.parseInt(request.getParameter("sub5")));
            st.setInt(9, Integer.parseInt(request.getParameter("sub6")));
            st.setInt(10, Integer.parseInt(request.getParameter("lab1")));
            st.setInt(11, Integer.parseInt(request.getParameter("lab2")));

            st.executeUpdate();

            out.println("<h2>Successfully Inserted</h2>");

            st.close();
            con.close();

        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }

        out.close();
    }
}