<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
      <li>Edit</li>
    </ul>
  </div>
</section>

<section class="section main-section">
  <div class="card mb-6">
    <header class="card-header">
      <p class="card-header-title">
        <span class="icon"><i class="mdi mdi-ballot"></i></span>
        Edit Employee
      </p>
    </header>
    <div class="card-content">
      <form method="post" action="<%= request.getContextPath() %>/employee">
        <input type="hidden" name="action" value="edit">
        <input type="hidden" name="id" value="<%= ((Employee) request.getAttribute("employee")).getEmployeeId() %>">
        <div class="field">
          <label class="label">Employee Name</label>
          <div class="control">
            <input class="input" type="text" name="employeeName" value="<%= ((Employee) request.getAttribute("employee")).getEmployeeName() %>" required>
          </div>
        </div>
        <div class="field">
          <label class="label">Birthday</label>
          <div class="control">
            <input class="input" type="date" name="birthday" value="<%= ((Employee) request.getAttribute("employee")).getBirthday() %>" required>
          </div>
        </div>
        <div class="field">
          <label class="label">Phone Number</label>
          <div class="control">
            <input class="input" type="text" name="phoneNumber" value="<%= ((Employee) request.getAttribute("employee")).getPhoneNumber() %>" required>
          </div>
        </div>
        <div class="field">
          <label class="label">Email</label>
          <div class="control">
            <input class="input" type="email" name="email" value="<%= ((Employee) request.getAttribute("employee")).getEmail() %>" required>
          </div>
        </div>
        <div class="field">
          <div class="control">
            <button type="submit" class="button green">Update Employee</button>
          </div>
        </div>
      </form>
    </div>
  </div>
</section>
<%@ include file="/include/script.jsp" %>
</body>
</html>
