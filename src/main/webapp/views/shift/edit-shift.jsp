<%@ include file="../includes/taglibs.jsp" %>
<jsp:include page="../includes/temp.jsp">
    <jsp:param name="title" value="Departments"/>
    <jsp:param name="mainMenu" value="Master Files"/>
    <jsp:param name="childMenu" value="Departments"/>
</jsp:include>

<%@ include file="../includes/main-menu.jsp" %>
<title>Edit Shift</title>


<section class="main_content dashboard_part">

    <%@ include file="../includes/header.jsp" %>
    <div class="main_content_iner">
        <div class="container-fluid p-0">

            <form:form method="POST" modelAttribute="shiftDto"
                       action="${contextPath}/shift/saveOrUpdate">
                <div class="white_box mb_30">
                    <div class="box_header">
                        <div class="main-title">
                            <h3 class="mb-0">Edit shift</h3>
                        </div>
                    </div>
                    <div class="row justify-content-center">
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="shiftTitle">Title</form:label>
                                <form:input type="number" path="id" hidden="true"></form:input>
                                <form:input type="text" path="shiftTitle" class="form-control" placeholder="Title"
                                            required="true"
                                            autofocus="true"></form:input>
                                <form:errors path="shiftTitle"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="timeStart">Start Time</form:label>
                                <form:input type="time" path="timeStart" class="form-control" required="true"
                                            autofocus="true"></form:input>
                                <form:errors path="timeStart"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="timeEnd">End Time</form:label>
                                <form:input type="time" path="timeEnd" class="form-control" required="true"
                                            autofocus="true"></form:input>
                                <form:errors path="timeEnd"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="lateTime">Late Time</form:label>
                                <form:input type="time" path="lateTime" class="form-control" required="true"
                                            autofocus="true"></form:input>
                                <form:errors path="lateTime"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="halfDayTime">Half Day Time</form:label>
                                <form:input type="time" path="halfDayTime" class="form-control" required="true"
                                            autofocus="true"></form:input>
                                <form:errors path="halfDayTime"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="lastTimeAllowed">Last Time Allowed</form:label>
                                <form:input type="time" path="lastTimeAllowed" class="form-control" required="true"
                                            autofocus="true"></form:input>
                                <form:errors path="lastTimeAllowed"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="defaultCheckIn">Default CheckIn</form:label>
                                <form:input type="time" path="defaultCheckIn" class="form-control" required="true"
                                            autofocus="true"></form:input>
                                <form:errors path="defaultCheckIn"></form:errors>
                            </div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4 col-sm-4">
                            <div class="mb-3">
                                <form:label path="defaultCheckout">Default CheckOut</form:label>
                                <form:input type="time" path="defaultCheckout" class="form-control" required="true"
                                            autofocus="true"></form:input>
                                <form:errors path="defaultCheckout"></form:errors>
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



