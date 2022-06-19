<%@ include file="../includes/taglibs.jsp" %>
<jsp:include page="../includes/temp.jsp">
    <jsp:param name="title" value="Departments"/>
    <jsp:param name="mainMenu" value="Master Files"/>
    <jsp:param name="childMenu" value="Departments"/>
</jsp:include>

<%@ include file="../includes/main-menu.jsp" %>
<title>Mark Attendance</title>

<section class="main_content dashboard_part">

    <%@ include file="../includes/header.jsp" %>
    <div class="main_content_iner ">
        <div class="container-fluid p-0">
            <div class="row justify-content-center">
                <div class="col-12">
                    <div class="QA_section">
                        <form method="post" action="${contextPath}/attendance/mark-attendance">

                            <div class="white_box_tittle list_header">
                                <div class="col-md-2">
                                    <label>Department</label>
                                    <select name="deptId" class="form-select">
                                        <c:forEach items="${departments}" var="department">
                                            <option value="${department.id}" ${selectedDept == department.id ? 'selected' : ''}>
                                                    ${department.name}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    <label>Month</label>
                                    <select name="month" id="month" class="form-select">
                                        <c:forEach items="${months}" var="month">
                                            <option value="${month}" ${selectedMonth == month ? 'selected' : ''}>
                                                    ${month}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    <label>Year</label>
                                    <select name="year" id="year" class="form-select">
                                        <c:forEach items="${years}" var="year">
                                            <option value="${year}" ${selectedYear == year ? 'selected' : ''}>
                                                    ${year}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    <label>Date</label>
                                    <input type="date" class="form-control" name="date" id="date"
                                           value="${selectedDate}">
                                </div>
                                <div class="col-md-2">
                                    <input type="submit" style="margin-top: 15px" value="Submit" class="btn btn-info">
                                </div>
                            </div>
                        </form>

                        <div class="QA_table mb_30">
                            <form:form method="post" action="${contextPath}/attendance/save-attendance"
                                       modelAttribute="masterList">
                                <table class="table lms_table_active">
                                    <thead>
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Emp Id</th>
                                        <th scope="col">Emp Name</th>
                                        <th scope="col">Status</th>
                                        <th scope="col" colspan="2">CheckIn & CheckOut</th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    <c:forEach items="${masterList.attendanceList}" var="attendance" varStatus="seq">
                                        <tr>
                                            <td>${seq.index+ 1}</td>
                                            <td>
                                                <form:input type="hidden"
                                                            path="attendanceList[${seq.index}].employeeId"
                                                            class="form-control"
                                                            value="${attendance.employee.id}"></form:input>
                                                <form:input type="hidden"
                                                            path="attendanceList[${seq.index}].attendanceDate"
                                                            class="form-control"
                                                            value="${attendance.attendanceDate}"></form:input>
                                                    ${attendance.employee.id}
                                            </td>
                                            <td>

                                                    ${attendance.employee.user.fullName}
                                            </td>
                                            <td>
                                                <form:select cssClass="form-select"
                                                             path="attendanceList[${seq.index}].attendanceStatus"
                                                             id="attendanceStatus"
                                                             onchange="checkAttendanceStatus(this)">
                                                    <c:forEach items="${attendanceStatus}" var="status">
                                                        <form:option value="${status}">${status}</form:option>
                                                    </c:forEach>
                                                </form:select>
                                            </td>
                                            <td>
                                                <form:input type="time" id="checkIn"
                                                            path="attendanceList[${seq.index}].checkIn"
                                                            class="form-control"></form:input>

                                            </td>
                                            <td>
                                                <form:input type="time" id="checkOut"
                                                            path="attendanceList[${seq.index}].checkOut"
                                                            class="form-control"></form:input>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <input type="submit" value="Submit" class="btn btn-success"
                                       style="margin-left: 95%; margin-top: 20px">
                            </form:form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="../includes/footer.jsp" %>
</section>
<script>
    $(document).ready(function () {
        limitingFormDateAndToDateColumns();
    });
    $('#month').on('change', function () {
        limitingFormDateAndToDateColumns();
    })
    $('#year').on('change', function () {
        limitingFormDateAndToDateColumns();
    })

    function limitingFormDateAndToDateColumns() {
        let year = parseInt($('#year').val());
        let month = $('#month').val();
        console.log("year", year);
        console.log("month", month);
        if (!isNaN(year) && month !== undefined && month !== '') {
            let monthStartDate = getStartDateOfMonthAndYear(month, year);
            let monthEndDate = getEndDateOfMonthAndYear(month, year);
            if (monthStartDate !== '' && monthStartDate !== undefined && monthEndDate !== '' && monthEndDate !== undefined) {
                let dateInput = $('#date');
                dateInput.attr("min", monthStartDate);
                dateInput.attr('max', monthEndDate);
                dateInput.attr('value', monthStartDate);
                $('#date').val(monthStartDate)
            }
        }
    }

    function checkAttendanceStatus(element) {
        if ($(element).val() == 'ABSENT' || $(element).val() == 'EXEMPTED') {
            $(element).parents('tr').find('#checkIn').hide();
            $(element).parents('tr').find('#checkOut').hide();
        } else {
            $(element).parents('tr').find('#checkIn').show();
            $(element).parents('tr').find('#checkOut').show();
        }
    }
</script>



