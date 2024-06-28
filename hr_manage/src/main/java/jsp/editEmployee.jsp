<!DOCTYPE html>
<html>
<head>
    <title>Edit Employee</title>
</head>
<body>
    <h2>Edit Employee</h2>
    <form action="update" method="post">
        <input type="hidden" name="employee_id" value="${employee.employee_id}">
        <label for="employee_name">Employee Name:</label>
        <input type="text" name="employee_name" value="${employee.employee_name}" required><br>
        <label for="birthday">Birthday:</label>
        <input type="date" name="birthday" value="${employee.birthday}" required><br>
        <label for="phone_number">Phone Number:</label>
        <input type="text" name="phone_number" value="${employee.phone_number}" required><br>
        <label for="email">Email:</label>
        <input type="email" name="email" value="${employee.email}" required><br>
        <button type="submit">Save</button>
    </form>
</body>
</html>
