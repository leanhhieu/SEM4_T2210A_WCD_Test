<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h2>ABC Company's Employee List</h2>
    <a href="addEmployee.jsp">Add New</a>
    <form action="search" method="post">
        <input type="text" name="keyword" placeholder="Search here">
        <button type="submit">Search</button>
    </form>
    <table>
        <thead>
            <tr>
                <th>No</th>
                <th>Employee Id</th>
                <th>Employee Name</th>
                <th>Birthday</th>
                <th>Phone Number</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="employee" items="${listEmployee}">
                <tr>
                    <td>${employee.index}</td>
                    <td>${employee.employee_id}</td>
                    <td>${employee.employee_name}</td>
                    <td>${employee.birthday}</td>
                    <td>${employee.phone_number}</td>
                    <td>${employee.email}</td>
                    <td>
                        <a href="edit?employee_id=${employee.employee_id}">Edit</a>
                        <a href="delete?employee_id=${employee.employee_id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
