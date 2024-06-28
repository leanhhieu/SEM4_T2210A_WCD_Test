<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entity.Employee" %>
<html>
<head>
    <%@ include file="/include/head.jsp" %>
</head>
<body>
<%@ include file="/include/navbar.jsp" %>
<h1>Edit Employee</h1>

<form action="EditEmployee" method="POST">
    <input type="hidden" name="employeeId" value="${employee.employeeId}"> <!-- Add employeeId field -->
    <div class="mb-3">
        <label for="exampleInputEmployeeId" class="form-label">Employee ID</label>
        <input type="text" class="form-control" id="exampleInputEmployeeId" value="${employee.employeeId}" readonly>
    </div>
    <div class="mb-3">
        <label for="exampleInputEmployeeName" class="form-label">Employee Name</label>
        <input type="text" name="employeeName" class="form-control" id="exampleInputEmployeeName" value="${employee.employeeName}" required>
    </div>
    <div class="mb-3">
        <label for="exampleInputBirthday" class="form-label">Birthday</label>
        <input type="date" name="birthday" class="form-control" id="exampleInputBirthday" value="${employee.birthday}" required>
    </div>
    <div class="mb-3">
        <label for="exampleInputPhoneNumber" class="form-label">Phone Number</label>
        <input type="text" name="phoneNumber" class="form-control" id="exampleInputPhoneNumber" value="${employee.phoneNumber}" required>
    </div>
    <div class="mb-3">
        <label for="exampleInputEmail" class="form-label">Email</label>
        <input type="email" name="email" class="form-control" id="exampleInputEmail" value="${employee.email}" required>
    </div>
    <button type="submit" class="btn btn-primary">Save Changes</button>
</form>

<%@ include file="/include/footer.jsp" %>
</body>
</html>
