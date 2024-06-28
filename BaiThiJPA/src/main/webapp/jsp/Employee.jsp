<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Employee" %>
<html>
<head>
    <%@ include file="/include/head.jsp" %>
</head>
<body>
<%@ include file="/include/navbar.jsp" %>
<h1>Employee</h1>
<a href="AddEmployee" class="btn btn-primary mb-3">Add New Employee</a>
<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Employee Name</th>
        <th scope="col">Birthday</th>
        <th scope="col">PhoneNumber</th>
        <th scope="col">Email</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Employee> employeeList = (List<Employee>) request.getAttribute("employeeList");  // Retrieve the correct attribute
        if (employeeList != null) {
            for (Employee employee : employeeList) {
    %>
    <tr>
        <td><%= employee.getEmployeeId() %></td>
        <td><%= employee.getEmployeeName() %></td>
        <td><%= employee.getBirthday() %></td>
        <td><%= employee.getPhoneNumber() %></td>
        <td><%= employee.getEmail() %></td>
        <td>
            <a href="EditEmployee?employeeId=<%= employee.getEmployeeId() %>" class="btn btn-primary">Edit</a>
            <form action="Employee" method="post" style="display:inline;" onsubmit="return confirmDelete()">
                <input type="hidden" name="id" value="<%= employee.getEmployeeId() %>">
                <input type="hidden" name="action" value="delete">
                <button type="submit" class="btn btn-danger">Delete</button>
            </form>
        </td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>

<%--<%--%>
<%--    String message = (String) session.getAttribute("message");--%>
<%--    if (message != null) {--%>
<%--%>--%>
<%--<script type="text/javascript">--%>
<%--    alert('<%= message %>');--%>
<%--</script>--%>
<%--<%--%>
<%--        session.removeAttribute("message");--%>
<%--    }--%>
<%--%>--%>
<script type="text/javascript">
    function confirmDelete() {
        return confirm('Bạn có chắc chắn muốn xóa lớp học này không?');
    }
</script>
<%@ include file="/include/footer.jsp" %>
</body>
</html>
