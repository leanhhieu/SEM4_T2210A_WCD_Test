<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/include/head.jsp"%>
</head>
<body>
<%@ include file="/include/navbar.jsp"%>

<section class="is-title-bar">
    <div class="flex flex-col md:flex-row items-center justify-between space-y-6 md:space-y-0">
        <ul>
            <li>List of Employees</li>
            <li>Add Employee</li>
        </ul>
    </div>
</section>
<section class="section main-section">
    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <div class="tile-body">
                    <form action="addEmployee" method="post" class="edit-event-form">
                        <div class="form-group col-md-3">
                            <label class="control-label">Employee ID</label>
                            <input type="text" class="form-control" name="employeeId" placeholder="Employee ID" required>
                        </div>
                        <div class="form-group col-md-3">
                            <label class="control-label">Employee Name</label>
                            <input type="text" class="form-control" name="employeeName" placeholder="Employee Name" required>
                        </div>
                        <div class="form-group col-md-3">
                            <label class="control-label">Birthday</label>
                            <input type="date" class="form-control" name="birthday" required>
                        </div>
                        <div class="form-group col-md-3">
                            <label class="control-label">Phone Number</label>
                            <input type="text" class="form-control" name="phoneNumber" placeholder="Phone Number" required>
                        </div>
                        <div class="form-group col-md-3">
                            <label class="control-label">Email</label>
                            <input type="email" class="form-control" name="email" placeholder="Email" required>
                        </div>
                        <button type="submit" class="btn btn-save">Save</button>
                        <a href="<%= request.getContextPath() %>/employee" class="btn btn-cancel">Cancel</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
<style>
    .row {
        display: -webkit-box;
        display: -ms-flexbox;
        display: flex;
        -ms-flex-wrap: wrap;
        flex-wrap: wrap;
        margin-right: -15px;
        margin-left: -15px;
    }

    .col-md-12 {
        -webkit-box-flex: 0;
        -ms-flex: 0 0 100%;
        flex: 0 0 100%;
        max-width: 100%;
    }

    .form-control {
        display: block;
        width: 100%;
        padding: 0.375rem 0.75rem;
        font-size: 15px;
        line-height: 1.5;
        color: black;
        background-color: #f1f1f1;
        background-clip: padding-box;
        height: 45px;
        border: 1px solid #dadada;
        border-radius: .357rem;
        -webkit-transition: border-color 0.15s ease-in-out, -webkit-box-shadow 0.15s ease-in-out;
        transition: border-color 0.15s ease-in-out, -webkit-box-shadow 0.15s ease-in-out;
        -o-transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
        transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
        transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out, -webkit-box-shadow 0.15s ease-in-out;
    }

    .control-label {
        font-weight: 600;
        color: black;
    }

    .btn-save {
        background-color: rgb(166 236 171);
        color: rgb(1 123 10);
        font-weight: 600;
        letter-spacing: 1px;
        border: none;
        border-radius: .357rem;
        border: none;
        padding: 5px 20px;
        margin-top: 10px;
    }

    .btn-cancel {
        background-color: rgb(255 197 197);
        color: rgb(190, 40, 40);
        font-weight: 600;
        letter-spacing: 1px;
        border: none;
        border-radius: .357rem;
        border: none;
        padding: 8px 20px;
        margin-top: 10px;
    }

    .main-section {
        margin-left: 15px;
    }

    .error-message {
        color: red;
        font-size: 15px;
    }
</style>
<%@ include file="/include/script.jsp"%>
</body>
</html>
