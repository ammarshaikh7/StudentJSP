package org.example.studentjsp;

import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect("welcome.jsp");
    }
}
