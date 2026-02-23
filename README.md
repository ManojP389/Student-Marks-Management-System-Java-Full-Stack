# 🎓 Student Marks Management System - Java Full Stack

A Dynamic Web Application built using Java Servlets, JDBC, MySQL, and Apache Tomcat to perform complete CRUD operations on student marks.

---

## 📌 Project Overview

This project demonstrates how to build a full-stack Java web application using:

- Java Servlets (Backend)
- MySQL Database
- JDBC Connectivity
- Apache Tomcat Server
- HTML & CSS (Frontend)

The application allows users to manage student academic records through a web interface.

## 🚀 Features Implemented (CRUD Operations)

### ➕ Insert Student Marks
Stores student details and marks into the database.

### 🔍 Search Student
Retrieves student details using roll number.

### 📋 List All Students
Displays all student records in a structured table format.

### ✏ Update Student Record
Modifies existing student data.

### ❌ Delete Student Record
Removes student record from database.


## 🛠 Technologies Used

- Java
- Servlet API
- JDBC
- MySQL
- Apache Tomcat 9
- HTML5
- CSS3
- Eclipse IDE

## 🗄 Database Configuration

**Database Name:** student  
**Table Name:** mark

### Table Schema

sql
CREATE TABLE mark(
rollno INT PRIMARY KEY,
name VARCHAR(50),
section VARCHAR(1),
s1 INT,
s2 INT,
s3 INT,
s4 INT,
s5 INT,
s6 INT,
l1 INT,
l2 INT
);

### Application Architecture

Browser
⬇
Apache Tomcat Server
⬇
Java Servlet
⬇
JDBC
⬇
MySQL Database

### Steps to run the project

Install MySQL.
Create database student.
Create table mark using the given schema.
Download MySQL Connector/J.
Place the connector JAR inside: WEB-INF/lib
Configure Apache Tomcat v9 in Eclipse.
Run the project on server.


👨‍💻 Author
P.Manoj Kumar
Presidency university SOCSE



