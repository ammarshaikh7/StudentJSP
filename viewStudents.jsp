<%@ page import="java.util.List" %>
<%@ page import="org.example.studentjsp.Student" %>
<jsp:include page="header.jsp" />
<html>
<head>
  <title>View Students</title>
</head>
<body>
<h1>Student List</h1>

<%
  List<Student> students = (List<Student>) request.getAttribute("students");

  if (students != null && !students.isEmpty()) {
%>
<table class="table table-striped table-bordered table-hover ">
<thead class="table-light">
  <tr>
    <th>Student Name</th>
    <th>Age</th>
    <th>Grade</th>
    <th>Action</th>
  </tr>
  <% for (Student student : students) { %>
  <tr>
    <td><%= student.getName() %></td>
    <td><%= student.getAge() %></td>
    <td><%= student.getGrade() %></td>
    <td>
      <!-- Delete button sends the studentId to DeleteStudentServlet -->
      <form action="DeleteStudentServlet" method="post" style="display:inline;">
        <input type="hidden" name="studentId" value="<%= student.getId() %>">
        <button type="submit">Delete</button>
      </form>
    </td>
  </tr>
  <% } %>
</table>
<%
} else {
%>
<p>No students found.</p>
<%
  }
%>

<!-- Back Button -->
<button onclick="window.location.href='welcome.jsp'">Back</button>
</body>
</html>
<jsp:include page="footer.jsp" />
