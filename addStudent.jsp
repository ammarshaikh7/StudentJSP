<jsp:include page="header.jsp" />
<h2>Add New Student</h2>
<form class="container mt-4" action="AddStudentServlet" method="post">
    <label class="form-label" for="name">Name:</label>
    <input class="form-control" type="text" id="name" name="name" required><br>
    <label class="form-label" for="age">Age:</label>
    <input class="form-control" type="number" id="age" name="age" required><br>
    <label class="form-label" for="grade">Grade:</label>
    <input class="form-control" type="text" id="grade" name="grade" required><br>
    <button type="submit" class="btn-outline-primary">Add Student</button>
</form>
<jsp:include page="footer.jsp" />
