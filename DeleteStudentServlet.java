package org.example.studentjsp;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the studentId from the request
        String studentIdParam = request.getParameter("studentId");

        if (studentIdParam != null) {
            try {
                int studentId = Integer.parseInt(studentIdParam);

                // Get the student list from the session
                HttpSession session = request.getSession();
                List<Student> students = (List<Student>) session.getAttribute("students");

                // Remove the student with the matching ID
                if (students != null) {
                    students.removeIf(student -> student.getId() == studentId);
                    session.setAttribute("students", students); // Update the session attribute
                }

            } catch (NumberFormatException e) {
                e.printStackTrace(); // Log error if studentId is invalid
            }
        }

        // Redirect back to the student list
        response.sendRedirect("ViewStudentsServlet");
    }
}
