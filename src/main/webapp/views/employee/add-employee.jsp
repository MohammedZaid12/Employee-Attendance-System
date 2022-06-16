<%@ include file="../includes/taglibs.jsp" %>
<jsp:include page="../includes/temp.jsp">
    <jsp:param name="title" value="Departments"/>
    <jsp:param name="mainMenu" value="Master Files"/>
    <jsp:param name="childMenu" value="Departments"/>
</jsp:include>

<%@ include file="../includes/main-menu.jsp" %>
<title>Add Employee</title>


<section class="main_content dashboard_part">

    <%@ include file="../includes/header.jsp" %>
    <div class="main_content_iner">
        <div class="container-fluid p-0">

            <form:form method="POST" modelAttribute="employeeDto"
                       action="${contextPath}/employee/saveOrUpdate">
                <div class="white_box mb_30">
                    <div class="box_header">
                        <div class="main-title">
                            <h3 class="mb-0">Add Employee</h3>
                        </div>
                    </div>
                    <div class="row justify-content-center">
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="user.firstName">First Name</form:label>
                                <form:input type="text" path="user.firstName" class="form-control"
                                            required="true"
                                            autofocus="true"></form:input>
                                <form:errors path="user.firstName"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="user.lastName">Last Name</form:label>
                                <form:input type="text" path="user.lastName" class="form-control" required="true"
                                            autofocus="true"></form:input>
                                <form:errors path="user.lastName"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="user.email">Email</form:label>
                                <form:input type="text" path="user.email" class="form-control" required="true"
                                            autofocus="true"></form:input>
                                <form:errors path="user.email"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="user.password">Password</form:label>
                                <form:input type="password" path="user.password" class="form-control" required="true"
                                            autofocus="true"></form:input>
                                <form:errors path="user.password"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="user.nationalIdNumber">NIC</form:label>
                                <form:input type="text" path="user.nationalIdNumber" class="form-control"
                                            required="true"
                                            autofocus="true"></form:input>
                                <form:errors path="user.nationalIdNumber"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="user.contact">Contact</form:label>
                                <form:input type="text" path="user.contact" class="form-control" required="true"
                                            autofocus="true"></form:input>
                                <form:errors path="user.contact"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="user.birthDate">Birth Date</form:label>
                                <form:input type="date" path="user.birthDate" class="form-control" required="true"
                                            autofocus="true"></form:input>
                                <form:errors path="user.birthDate"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="user.address">Address</form:label>
                                <form:input type="text" path="user.address" class="form-control" required="true"
                                            autofocus="true"></form:input>
                                <form:errors path="user.address"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="user.gender">Gender</form:label>
                                <form:select cssClass="form-select" path="user.gender" id="gender">
                                    <c:forEach items="${genders}" var="gender">
                                        <form:option value="${gender}">${gender}</form:option>
                                    </c:forEach>
                                </form:select>
                                <form:errors path="user.gender"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="religion">Religion</form:label>
                                <form:select cssClass="form-select" path="religion" id="religion">
                                    <c:forEach items="${religions}" var="religion">
                                        <form:option value="${religion}">${religion}</form:option>
                                    </c:forEach>
                                </form:select>
                                <form:errors path="user.gender"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="joinDate">Join Date</form:label>
                                <form:input type="date" path="joinDate" class="form-control" required="true"
                                            autofocus="true"></form:input>
                                <form:errors path="joinDate"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="initialSalary">Initial Salary</form:label>
                                <form:input type="number" path="initialSalary" class="form-control" required="true"
                                            autofocus="true"></form:input>
                                <form:errors path="initialSalary"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="designation">Designation</form:label>
                                <form:select cssClass="form-select" path="designation" id="designation">
                                    <c:forEach items="${designations}" var="designation">
                                        <form:option
                                                value="${designation.id}">${designation.designationName}</form:option>
                                    </c:forEach>
                                </form:select>
                                <form:errors path="designation"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="rule">Rule</form:label>
                                <form:select cssClass="form-select" path="rule" id="rule">
                                    <c:forEach items="${rules}" var="rule">
                                        <form:option
                                                value="${rule.id}">${rule.ruleName}</form:option>
                                    </c:forEach>
                                </form:select>
                                <form:errors path="rule"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="shift">Shift</form:label>
                                <form:select cssClass="form-select" path="shift" id="shift">
                                    <c:forEach items="${shifts}" var="shift">
                                        <form:option
                                                value="${shift.id}">${shift.shiftTitle}</form:option>
                                    </c:forEach>
                                </form:select>
                                <form:errors path="rule"></form:errors>
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



