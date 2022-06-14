<%@ include file="../includes/taglibs.jsp" %>
<jsp:include page="../includes/temp.jsp">
    <jsp:param name="title" value="Departments"/>
    <jsp:param name="mainMenu" value="Master Files"/>
    <jsp:param name="childMenu" value="Departments"/>
</jsp:include>

<%@ include file="../includes/main-menu.jsp" %>
<title>Edit holiday</title>


<section class="main_content dashboard_part">

    <%@ include file="../includes/header.jsp" %>
    <div class="main_content_iner">
        <div class="container-fluid p-0">

            <form:form method="POST" modelAttribute="holidayDto"
                       action="${contextPath}/holiday/saveOrUpdate">
                <div class="white_box mb_30">
                    <div class="box_header">
                        <div class="main-title">
                            <h3 class="mb-0">Edit holiday</h3>
                        </div>
                    </div>
                    <div class="row justify-content-center">
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="month">Month</form:label>
                                <form:input path="id" type="number" hidden="true"></form:input>
                                <form:select cssClass="form-select" path="month" id="month">
                                    <c:forEach items="${months}" var="month">
                                        <form:option value="${month}">${month}</form:option>
                                    </c:forEach>
                                </form:select>
                                <form:errors path="month"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="year">Year</form:label>
                                <form:select cssClass="form-select" path="year" id="year">
                                    <c:forEach items="${years}" var="year">
                                        <form:option value="${year}">${year}</form:option>
                                    </c:forEach>
                                </form:select>
                            </div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="startDate">Start Date</form:label>
                                <form:input type="date" path="startDate" id="startDate" class="form-control"
                                            required="true"
                                            autofocus="true"></form:input>
                                <form:errors path="startDate"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="endDate">End Date</form:label>
                                <form:input type="date" path="endDate" id="endDate" class="form-control" required="true"
                                            autofocus="true"></form:input>
                                <form:errors path="endDate"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="remarks">Remarks</form:label>
                                <form:textarea path="remarks" class="form-control" required="true"
                                               autofocus="true"></form:textarea>
                                <form:errors path="remarks"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-12 col-lg-12 col-xl-12 col-sm-12" style="text-align: right">
                            <div class="mb-3">
                                <button class="btn btn-lg btn-primary btn-block" type="submit" id="btn">Submit</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
    <%@ include file="../includes/footer.jsp" %>
</section>


<script>

    $('#month').on('change', function () {
        limitingFormDateAndToDateColumns();
    })
    $('#year').on('change', function () {
        limitingFormDateAndToDateColumns();
    })

    function limitingFormDateAndToDateColumns() {
        let startDateSelected = $('#startDate').val();
        let endDateSelected = $('#endDate').val();
        console.log("fromDate : ", startDateSelected)
        console.log("toDate : ", endDateSelected)
        let year = parseInt($('#year').val());
        let month = $('#month').val();
        console.log("year", year);
        console.log("month", month);
        if (!isNaN(year) && month !== undefined && month !== '') {
            let monthStartDate = getStartDateOfMonthAndYear(month, year);
            let monthEndDate = getEndDateOfMonthAndYear(month, year);
            if (monthStartDate !== '' && monthStartDate !== undefined && monthEndDate !== '' && monthEndDate !== undefined) {
                let fromDateInput = $('#startDate');
                let toDateInput = $('#endDate');
                fromDateInput.attr("min", monthStartDate);
                fromDateInput.attr('max', monthEndDate);
                fromDateInput.attr('value', monthStartDate);
                $('#startDate').val(monthStartDate)
                toDateInput.attr('min', monthStartDate);
                toDateInput.attr('max', monthEndDate);
                toDateInput.attr('value', monthEndDate);
            }
            console.log("monthStartDate", monthStartDate);
            console.log("monthEndDate", monthEndDate);
        }

    }

    $('#form').submit(function () {
        let startDate = $('#startDate').val()
        let endDate = $('#endDate').val()
        console.log("startDate", startDate)
        console.log("endDate", endDate)
        console.log("startDate > endDate", startDate > endDate)
        if (startDate > endDate) {
            Swal.fire({
                icon: "error",
                title: "Oops...",
                text: "Start date cannot be greater than end date!",
            });
            return false;
        }
    })
</script>