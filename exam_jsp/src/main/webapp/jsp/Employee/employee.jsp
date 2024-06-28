<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.exam_jsp.entity.Employee" %>
<html>
<head>
    <%@ include file="/include/head.jsp" %>
</head>
<body>
<%@ include file="/include/navbar.jsp" %>
<section class="is-title-bar">
    <div class="flex flex-col md:flex-row items-center justify-between space-y-6 md:space-y-0">
        <ul>

            <li>Employee</li>
        </ul>
    </div>
</section>

<section class="is-hero-bar">
    <div class="flex flex-col md:flex-row items-center justify-start">
        <div class="col-sm-2" style="margin-right: 5px;">
            <a class="btn btn-add" href="addEmployee" title="Add Employee">
                <i class="fas fa-plus"></i>
                Add Employee
            </a>
        </div>
    </div>
</section>

<section class="section main-section">
    <div class="card has-table">
        <header class="card-header">
            <p class="card-header-title">
                <span class="icon"><i class="mdi mdi-account-multiple"></i></span>
                Employees
            </p>

        </header>
        <div class="card-content">
            <table>
                <thead>
                <tr>
                    <th scope="col">Employee ID</th>
                    <th scope="col">Employee Name</th>
                    <th scope="col">Birthday</th>
                    <th scope="col">Phone Number</th>
                    <th scope="col">Email</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<Employee> employees = (List<Employee>) request.getAttribute("employees");
                    if (employees != null) {
                        for (Employee employee : employees) {
                %>
                <tr>
                    <td><%= employee.getEmployeeId() %></td>
                    <td><%= employee.getEmployeeName() %></td>
                    <td><%= new java.text.SimpleDateFormat("dd/MM/yyyy").format(employee.getBirthday()) %></td>
                    <td><%= employee.getPhoneNumber() %></td>
                    <td><%= employee.getEmail() %></td>
                    <td>
                        <a class="btn btn-primary" href="<%= request.getContextPath() %>/employee?action=edit&id=<%= employee.getEmployeeId() %>">Edit</a>
                        <form action="employee" method="post" style="display:inline;" onsubmit="return confirmDelete()">
                            <input type="hidden" name="id" value="<%= employee.getEmployeeId() %>">
                            <input type="hidden" name="action" value="delete">
                            <button type="submit" class="btn btn-danger">Delete</button>
                        </form>
                    </td>
                </tr>
                <% }
                }
                %>
                </tbody>
            </table>
            <div class="table-pagination">
                <div class="flex items-center justify-between">
                    <div class="buttons">
                        <%
                            int currentPage = (int) request.getAttribute("currentPage");
                            int totalPages = (int) request.getAttribute("totalPages");
                            for (int i = 1; i <= totalPages; i++) {
                        %>
                        <a href="<%= request.getContextPath() %>/employee?page=<%= i %>" class="button <%= (i == currentPage) ? "active" : "" %>"><%= i %></a>
                        <%
                            }
                        %>
                    </div>
                    <small>Page <%= currentPage %> of <%= totalPages %></small>
                </div>
            </div>
        </div>
    </div>
</section>
<%@ include file="/include/script.jsp" %>
<script>
    function confirmDelete() {
        return confirm("Are you sure you want to delete this employee?");
    }
</script>
<style>
    .btn-primary {
        color: rgb(245 157 57);
        background-color: rgb(251 226 197);
        border: none;
        border-radius: .357rem;
        font-weight: 600;
        padding: 5px 20px;
    }

    .btn-add {
        color: white;
        background-color: black;
        border: none;
        border-radius: .357rem;
        font-weight: 600;
        padding: 10px 20px;
    }

    .btn-danger {
        color: rgb(244 63 94);
        background-color: rgb(254 205 211);
        border: none;
        border-radius: .357rem;
        font-weight: 600;
        padding: 5px 20px;
    }
</style>
</body>
</html>
