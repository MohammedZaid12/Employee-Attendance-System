<%@ include file="../includes/taglibs.jsp" %>
<jsp:include page="../includes/temp.jsp">
    <jsp:param name="title" value="Departments"/>
    <jsp:param name="mainMenu" value="Master Files"/>
    <jsp:param name="childMenu" value="Departments"/>
</jsp:include>

<%@ include file="../includes/main-menu.jsp" %>
<title>Edit Designation</title>


<section class="main_content dashboard_part">

    <%@ include file="../includes/header.jsp" %>
    <div class="main_content_iner">
        <div class="container-fluid p-0">

            <form:form method="POST" modelAttribute="designationDto"
                       action="${contextPath}/designation/saveOrUpdate">
                <div class="white_box mb_30">
                    <div class="box_header">
                        <div class="main-title">
                            <h3 class="mb-0">Edit designation</h3>
                        </div>
                    </div>
                    <div class="row justify-content-center">
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="designationName">Designation Name</form:label>
                                <form:input type="number" path="id" hidden="true"></form:input>
                                <form:input type="text" path="designationName" class="form-control" placeholder="Name"
                                            autofocus="true"></form:input>
                                <form:errors path="designationName"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="department">Department</form:label>
                                <form:select cssClass="form-select" path="department">
                                    <c:forEach items="${departments}" var="dep">
                                        <form:option value="${dep.id}">${dep.name}</form:option>
                                    </c:forEach>
                                </form:select>
                                <form:errors path="department"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="employeeCapacity">Employee Capacity</form:label>
                                <form:input type="number" path="employeeCapacity" class="form-control"
                                            placeholder="capacity" autofocus="true"></form:input>
                                <form:errors path="employeeCapacity"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-12 col-lg-12 col-xl-12 col-sm-12" style="text-align: right">
                            <div class="mb-3">
                                <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
    <%@ include file="../includes/footer.jsp" %>
</section>



