<%@ include file="../includes/taglibs.jsp" %>
<jsp:include page="../includes/temp.jsp">
    <jsp:param name="title" value="Shifts"/>
    <jsp:param name="mainMenu" value="Master Files"/>
    <jsp:param name="childMenu" value="Shifts"/>
</jsp:include>

<%@ include file="../includes/main-menu.jsp" %>
<title>Shift</title>

<section class="main_content dashboard_part">

    <%@ include file="../includes/header.jsp" %>
    <div class="main_content_iner ">
        <div class="container-fluid p-0">
            <div class="row justify-content-center">
                <div class="col-12">
                    <div class="QA_section">
                        <div class="white_box_tittle list_header">
                            <h4>Shift List</h4>
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
                                    <a href="${contextPath}/shift/add" class="btn_1">Add New</a>
                                </div>
                            </div>
                        </div>
                        <div class="QA_table mb_30">
                            <table class="table lms_table_active">
                                <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Title</th>
                                    <th scope="col">Time Start</th>
                                    <th scope="col">Time End</th>
                                    <th scope="col">Late Time</th>
                                    <th scope="col">Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${shifts}" var="shift" varStatus="seq">
                                    <tr>

                                        <td>${seq.index+1 }</td>
                                        <td>${shift.shiftTitle}</td>
                                        <td>${shift.timeStart}</td>
                                        <td>${shift.timeEnd}</td>
                                        <td>${shift.lateTime}</td>
                                        <td><a href="${contextPath}/shift/getById/${shift.id}"
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



