<!DOCTYPE html>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>
    <h2>Add New Employee</h2>
    <form action="insert" method="post">
        <label for="employee_id">Employee ID:</label>
        <input type="text" name="employee_id" required><br>
        <label for="employee_name">Employee Name:</label>
        <input type="text" name="employee_name" required><br>
        <label for="birthday">Birthday:</label>
        <input type="date" name="birthday" required><br>
        <label for="phone_number">Phone Number:</label>
        <input type="text" name="phone_number" required><br>
        <label for="email">Email:</label>
        <input type="email" name="email" required><br>
        <button type="submit">Save</button>
    </form>
</body>
</html>
