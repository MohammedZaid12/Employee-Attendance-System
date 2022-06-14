<%@ include file="../includes/taglibs.jsp" %>
<jsp:include page="../includes/temp.jsp">
    <jsp:param name="title" value="Holidays"/>
    <jsp:param name="mainMenu" value="Holidays"/>
    <jsp:param name="childMenu" value="Holidays"/>
</jsp:include>

<%@ include file="../includes/main-menu.jsp" %>
<title>Holidays</title>

<section class="main_content dashboard_part">

    <%@ include file="../includes/header.jsp" %>
    <div class="main_content_iner ">
        <div class="container-fluid p-0">
            <div class="row justify-content-center">
                <div class="col-12">
                    <div class="QA_section">
                        <div class="white_box_tittle list_header">
                            <h4>Holiday List</h4>
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
                                    <a href="${contextPath}/holiday/add" class="btn_1">Add New</a>
                                </div>
                            </div>
                        </div>
                        <div class="QA_table mb_30">
                            <table class="table lms_table_active">
                                <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Month</th>
                                    <th scope="col">Year</th>
                                    <th scope="col">Remarks</th>
                                    <th scope="col">Start Date</th>
                                    <th scope="col">End Date</th>
                                    <th scope="col">Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${holidays}" var="holiday" varStatus="seq">
                                    <tr>

                                        <td>${seq.index+ 1}</td>
                                        <td>${holiday.month}</td>
                                        <td>${holiday.year}</td>
                                        <td>${holiday.remarks}</td>
                                        <td>${holiday.startDate}</td>
                                        <td>${holiday.endDate}</td>
                                        <td><a href="${contextPath}/holiday/getById/${holiday.id}"
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



