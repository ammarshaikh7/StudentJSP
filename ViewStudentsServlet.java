package org.example.studentjsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import java.util.*;

@WebServlet("/ViewStudentsServlet")
public class ViewStudentsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the student list from the session
        List<Student> students = (List<Student>) request.getSession().getAttribute("students");

        // If no students exist in session, initialize an empty list
        if (students == null) {
            students = new ArrayList<>();
        }

        // Set the student list as a request attribute
        request.setAttribute("students", students);

        // Forward to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/viewStudents.jsp");
        dispatcher.forward(request, response);
    }
}
