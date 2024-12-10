package org.example.studentjsp;

import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("welcome.jsp");
    }
}
