<%@ include file="../includes/taglibs.jsp" %>
<jsp:include page="../includes/temp.jsp">
    <jsp:param name="title" value="Departments"/>
    <jsp:param name="mainMenu" value="Master Files"/>
    <jsp:param name="childMenu" value="Departments"/>
</jsp:include>

<%@ include file="../includes/main-menu.jsp" %>
<title>Add Rule</title>


<section class="main_content dashboard_part">

    <%@ include file="../includes/header.jsp" %>
    <div class="main_content_iner">
        <div class="container-fluid p-0">

            <form:form method="POST" modelAttribute="ruleDto"
                       action="${contextPath}/rule/saveOrUpdate">
                <div class="white_box mb_30">
                    <div class="box_header">
                        <div class="main-title">
                            <h3 class="mb-0">Add Rule</h3>
                        </div>
                    </div>
                    <div class="row justify-content-center">
                        <div class="col-md-6 col-lg-6 col-xl-6 col-sm-6">
                            <div class="mb-3">
                                <form:label path="ruleName">Title</form:label>
                                <form:input type="text" path="ruleName" class="form-control"
                                            required="true"
                                            autofocus="true"></form:input>
                                <form:errors path="ruleName"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-6 col-xl-6 col-sm-6">
                            <div class="mb-3">
                                <form:label path="description">Description</form:label>
                                <form:input type="text" path="description" class="form-control" required="true"
                                            autofocus="true"></form:input>
                                <form:errors path="description"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="leavePerMonth">Leave Per Month</form:label>
                                <form:input type="number" path="leavePerMonth" class="form-control" required="true"
                                            autofocus="true"></form:input>
                                <form:errors path="leavePerMonth"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="sickLeaves">Sick Leaves (Annual)</form:label>
                                <form:input type="number" path="sickLeaves" class="form-control" required="true"
                                            autofocus="true"></form:input>
                                <form:errors path="sickLeaves"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="paidHolidays">Paid Holidays (Annual)</form:label>
                                <form:input type="number" path="paidHolidays" class="form-control" required="true"
                                            autofocus="true"></form:input>
                                <form:errors path="paidHolidays"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-2 col-lg-2 col-xl-2 col-sm-2">
                            <div class="mb-3 form-group form-check">
                                <form:label class="form-check-label" path="monday">Monday</form:label>
                                <form:checkbox path="monday" class="form-check-input"
                                               autofocus="true"></form:checkbox>
                                <form:errors path="monday"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-2 col-lg-2 col-xl-2 col-sm-2">
                            <div class="mb-3 form-group form-check">
                                <form:label class="form-check-label" path="tuesday">Tuesday</form:label>
                                <form:checkbox path="tuesday" class="form-check-input"
                                               autofocus="true"></form:checkbox>
                                <form:errors path="tuesday"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-2 col-lg-2 col-xl-2 col-sm-2">
                            <div class="mb-3 form-group form-check">
                                <form:label class="form-check-label" path="wednesday">Wednesday</form:label>
                                <form:checkbox path="wednesday" class="form-check-input"
                                               autofocus="true"></form:checkbox>
                                <form:errors path="wednesday"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-2 col-lg-2 col-xl-2 col-sm-2">
                            <div class="mb-3 form-group form-check">
                                <form:label class="form-check-label" path="thursday">Thursday</form:label>
                                <form:checkbox path="thursday" class="form-check-input"
                                               autofocus="true"></form:checkbox>
                                <form:errors path="thursday"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-2 col-lg-2 col-xl-2 col-sm-2">
                            <div class="mb-3 form-group form-check">
                                <form:label class="form-check-label" path="friday">Friday</form:label>
                                <form:checkbox path="friday" class="form-check-input"
                                               autofocus="true"></form:checkbox>
                                <form:errors path="friday"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-2 col-lg-2 col-xl-2 col-sm-2">
                            <div class="mb-3 form-group form-check">
                                <form:label class="form-check-label" path="saturday">Saturday</form:label>
                                <form:checkbox path="saturday" class="form-check-input"
                                               autofocus="true"></form:checkbox>
                                <form:errors path="saturday"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-2 col-lg-2 col-xl-2 col-sm-2">
                            <div class="mb-3 form-group form-check">
                                <form:label class="form-check-label" path="sunday">Sunday</form:label>
                                <form:checkbox path="sunday" class="form-check-input"
                                               autofocus="true"></form:checkbox>
                                <form:errors path="sunday"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-2 col-lg-2 col-xl-2 col-sm-2">
                            <div class="mb-3 form-group form-check">
                                <form:label class="form-check-label" path="publicHoliday">Public Holiday</form:label>
                                <form:checkbox path="publicHoliday" class="form-check-input"
                                               autofocus="true"></form:checkbox>
                                <form:errors path="publicHoliday"></form:errors>
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



