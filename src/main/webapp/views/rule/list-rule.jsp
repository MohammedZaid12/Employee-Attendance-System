<%@ include file="../includes/taglibs.jsp" %>
<jsp:include page="../includes/temp.jsp">
    <jsp:param name="title" value="Shifts"/>
    <jsp:param name="mainMenu" value="Master Files"/>
    <jsp:param name="childMenu" value="Shifts"/>
</jsp:include>

<%@ include file="../includes/main-menu.jsp" %>
<title>Rule</title>
<style>
    .fa-toggle-on {
        color: green;
    }

    .fa-toggle-off {
        color: red;
    }
</style>
<section class="main_content dashboard_part">

    <%@ include file="../includes/header.jsp" %>
    <div class="main_content_iner ">
        <div class="container-fluid p-0">
            <div class="row justify-content-center">
                <div class="col-12">
                    <div class="QA_section">
                        <div class="white_box_tittle list_header">
                            <h4>Rule List</h4>
                            <div class="box_right d-flex lms_block">
                                <div class="serach_field_2">
                                    <div class="search_inner">
                                        <form Active="#">
                                            <div class="search_field">
                                                <input type="text" placeholder="Search content here...">
                                            </div>
                                            <button type="submit"><i class="ti-search"></i></button>
                                        </form>
                                    </div>
                                </div>
                                <div class="add_button ms-2">
                                    <a href="${contextPath}/rule/add" class="btn_1">Add New</a>
                                </div>
                            </div>
                        </div>
                        <div class="QA_table mb_30">
                            <table class="table lms_table_active" id="table">
                                <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Title</th>
                                    <th scope="col">Leave per month</th>
                                    <th scope="col">Sick leaves</th>
                                    <th scope="col">Paid holidays</th>
                                    <c:forEach items="${daysOfWeek}" var="day">
                                        <th>${day}</th>
                                    </c:forEach>
                                    <th scope="col">Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${rules}" var="rule" varStatus="seq">
                                    <tr>

                                        <td>${seq.index+1 }</td>
                                        <td>${rule.ruleName}</td>
                                        <td>${rule.leavePerMonth}</td>
                                        <td>${rule.sickLeaves}</td>
                                        <td>${rule.paidHolidays}</td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${rule.sunday}">
                                                    <i class="fa fa-toggle-on"></i>
                                                </c:when>
                                                <c:otherwise>
                                                    <i class="fa fa-toggle-off"></i>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${rule.monday}">
                                                    <i class="fa fa-toggle-on"></i>
                                                </c:when>
                                                <c:otherwise>
                                                    <i class="fa fa-toggle-off"></i>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${rule.tuesday}">
                                                    <i class="fa fa-toggle-on"></i>
                                                </c:when>
                                                <c:otherwise>
                                                    <i class="fa fa-toggle-off"></i>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${rule.wednesday}">
                                                    <i class="fa fa-toggle-on"></i>
                                                </c:when>
                                                <c:otherwise>
                                                    <i class="fa fa-toggle-off"></i>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${rule.thursday}">
                                                    <i class="fa fa-toggle-on"></i>
                                                </c:when>
                                                <c:otherwise>
                                                    <i class="fa fa-toggle-off"></i>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${rule.friday}">
                                                    <i class="fa fa-toggle-on"></i>
                                                </c:when>
                                                <c:otherwise>
                                                    <i class="fa fa-toggle-off"></i>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${rule.saturday}">
                                                    <i class="fa fa-toggle-on"></i>
                                                </c:when>
                                                <c:otherwise>
                                                    <i class="fa fa-toggle-off"></i>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td><a href="${contextPath}/rule/getById/${rule.id}"
                                               class="fa fa-edit"></a></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="../includes/footer.jsp" %>
</section>
<script>
    $('#table').dataTable();
</script>



