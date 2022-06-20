<%@ include file="../includes/taglibs.jsp" %>
<jsp:include page="../includes/temp.jsp">
    <jsp:param name="title" value="Departments"/>
    <jsp:param name="mainMenu" value="Master Files"/>
    <jsp:param name="childMenu" value="Departments"/>
</jsp:include>

<%@ include file="../includes/main-menu.jsp" %>
<title>Attendance Report</title>
<style>
    .sticky-table > thead > tr > th {
        border: 1px solid #555 !important;
        vertical-align: middle !important;
        position: sticky !important;
        background-color: #2e2c34;
        color: #ffffff;
    }

    .sticky-table > tbody > tr > td {
        border: 1px solid #555 !important;
        vertical-align: middle !important;
    }

    .card {
        padding: 10px;
        border-radius: 10px;
    }
</style>

<section class="main_content dashboard_part">

    <%@ include file="../includes/header.jsp" %>
    <div class="main_content_iner ">
        <div class="container-fluid p-0">
            <div class="row justify-content-center">
                <div class="col-12">
                    <div class="QA_section">
                        <div class="card">
                            <div class="card-body">
                                <form method="post" action="${contextPath}/attendance/department-wise-report">

                                    <div class="white_box_tittle list_header">
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
                                        <div class="col-md-1">
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
                                            <label>Start Date</label>
                                            <input type="date" class="form-control" name="startDate" id="startDate"
                                                   value="${selectedStartDate}">
                                        </div>
                                        <div class="col-md-2">
                                            <label>End Date</label>
                                            <input type="date" class="form-control" name="endDate" id="endDate"
                                                   value="${selectedEndDate}">
                                        </div>
                                        <div class="col-md-2">
                                            <label>Department</label>
                                            <select name="deptId" id="deptId" class="form-select">
                                                <c:forEach items="${departments}" var="department">
                                                    <option value="${department.id}" ${selectedDept == department.id ? 'selected' : ''}>
                                                            ${department.name}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="col-md-2">
                                            <label>Employee</label>
                                            <input type="number" value="${currentEmployee}" id="currentEmployee" hidden>
                                            <select name="employeeId" id="employee" class="form-select">
                                            </select>
                                        </div>
                                        <div class="col-md-1">
                                            <input type="submit" style="margin-top: 15px" value="Submit"
                                                   class="btn btn-info">
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <br>
                        <c:if test="${reportTable}">
                            <div class="card">
                                <div class="card-body">
                                    <div class="data-tables datatable-dark table-responsive">

                                        <table class="table text-center sticky-table" border="1px solid lightgray">
                                            <thead>
                                            <tr>
                                                <th scope="col" rowspan="3">#</th>
                                                <th scope="col" rowspan="3">Emp Id</th>
                                                <th scope="col" rowspan="3">Emp Name</th>
                                                <th scope="col" rowspan="3">Designation</th>
                                                <th scope="col" colspan="62">Attendance ${selectedMonth}
                                                    - ${selectedYear} </th>
                                            </tr>
                                            <tr>
                                                <c:forEach var="monthDate" items="${monthDates}">
                                                    <th colspan="2" class="text-nowrap">
                                                        <fmt:parseDate value="${monthDate}" type="date"
                                                                       pattern="yyyy-MM-dd"
                                                                       var="parsedDate"/>
                                                        <fmt:formatDate value="${parsedDate}" type="date" pattern="dd"/>
                                                        <br>${monthDate.dayOfWeek.name()}
                                                    </th>
                                                </c:forEach>
                                            </tr>
                                            <tr>
                                                <c:forEach var="monthDate" items="${monthDates}">
                                                    <th>In</th>
                                                    <th>Out</th>
                                                </c:forEach>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${attendanceReportModelList}" var="attendanceReportModel"
                                                       varStatus="seq">
                                                <tr>
                                                    <td>${seq.index + 1}</td>
                                                    <td>${attendanceReportModel.employee.id}</td>
                                                    <td>${attendanceReportModel.employee.user.fullName}</td>
                                                    <td>${attendanceReportModel.designation.designationName}</td>
                                                    <c:forEach items="${attendanceReportModel.attendanceDtoList}"
                                                               var="attendance">
                                                        <td colspan="2">
                                                            <table style="margin: auto">
                                                                <tr>
                                                                    <td>${attendance.checkIn}</td>
                                                                    <td>${attendance.checkOut}</td>
                                                                </tr>
                                                                <tr>
                                                                    <td style="text-align: center"
                                                                        colspan="2">${attendance.attendanceStatus}</td>
                                                                </tr>
                                                            </table>
                                                        </td>

                                                    </c:forEach>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>

                        </c:if>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <br>
    <%@ include file="../includes/footer.jsp" %>
</section>
<script>
    $(document).ready(function () {
        limitingFormDateAndToDateColumns();
        setTimeout(function () {
            setEmployeeDropdown();
        }, 100)
    });
    $('#month').on('change', function () {
        limitingFormDateAndToDateColumns();
        setTimeout(function () {
            setEmployeeDropdown();
        }, 100)
    })
    $('#year').on('change', function () {
        limitingFormDateAndToDateColumns();
        setTimeout(function () {
            setEmployeeDropdown();
        }, 100)
    })
    $('#deptId').on('change', function () {
        setTimeout(function () {
            setEmployeeDropdown();
        }, 100)
    })

    function limitingFormDateAndToDateColumns() {
        let year = parseInt($('#year').val());
        let month = $('#month').val();
        if (!isNaN(year) && month !== undefined && month !== '') {
            let monthStartDate = getStartDateOfMonthAndYear(month, year);
            let monthEndDate = getEndDateOfMonthAndYear(month, year);
            if (monthStartDate !== '' && monthStartDate !== undefined && monthEndDate !== '' && monthEndDate !== undefined) {
                let startDateInput = $('#startDate');
                let ednDateInput = $('#endDate');
                startDateInput.attr("min", monthStartDate);
                startDateInput.attr('max', monthEndDate);
                startDateInput.attr('value', monthStartDate);
                $('#startDate').val(monthStartDate)
                ednDateInput.attr("min", monthStartDate);
                ednDateInput.attr('max', monthEndDate);
                ednDateInput.attr('value', monthStartDate);
                $('#endDate').val(monthEndDate)
            }
        }
    }

    function setEmployeeDropdown() {
        let year = parseInt($('#year').val());
        let month = $('#month').val();
        let monthStartDate = getStartDateOfMonthAndYear(month, year);
        let monthEndDate = getEndDateOfMonthAndYear(month, year);
        let deptId = parseInt($('#deptId').val());
        $.ajax({
            url: '/employee/generate-list-for-dropdown',
            method: "GET",
            data: {
                deptId: deptId,
                month: month,
                year: year,
                startDate: monthStartDate,
                endDate: monthEndDate
            },
            success: function (response) {
                let data = response;
                let option = "";
                option += "<option value=" + 0 + ">All</option>";
                if (data) {
                    $.each(data, function (key, item) {
                        if (key === $("#currentEmployee").val()) {
                            option += "<option value=" + key + " selected>" + item + "</option>";
                        } else {
                            option += "<option value=" + key + ">" + item + "</option>";
                        }
                    });
                }
                $("#employee").html(option);
            },
            error: function (error) {
                console.log(error)
                Swal.fire({
                    icon: "error",
                    title: "Oops...",
                    text: "No employee found!",
                });
            }
        })
    }
</script>



