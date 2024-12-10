package org.example.studentjsp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.studentjsp.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String ageParam = request.getParameter("age");
        String grade = request.getParameter("grade");

        if (name != null && !name.isEmpty() && ageParam != null && !ageParam.isEmpty() && grade != null && !grade.isEmpty()) {
            try {
                int age = Integer.parseInt(ageParam);

                HttpSession session = request.getSession();
                List<Student> students = (List<Student>) session.getAttribute("students");

                if (students == null) {
                    students = new ArrayList<>();
                }

                int nextId = students.size() + 1; // Generate ID
                Student student = new Student(nextId, name, age, grade);
                students.add(student);

                session.setAttribute("students", students);
                response.sendRedirect("ViewStudentsServlet");

            } catch (NumberFormatException e) {
                response.sendRedirect("error.jsp");
            }
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
