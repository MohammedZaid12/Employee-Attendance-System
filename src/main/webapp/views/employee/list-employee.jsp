<%@ include file="../includes/taglibs.jsp" %>
<jsp:include page="../includes/temp.jsp">
    <jsp:param name="title" value="Shifts"/>
    <jsp:param name="mainMenu" value="Master Files"/>
    <jsp:param name="childMenu" value="Shifts"/>
</jsp:include>

<%@ include file="../includes/main-menu.jsp" %>
<title>Employees</title>

<section class="main_content dashboard_part">

    <%@ include file="../includes/header.jsp" %>
    <div class="main_content_iner ">
        <div class="container-fluid p-0">
            <div class="row justify-content-center">
                <div class="col-12">
                    <div class="QA_section">
                        <div class="white_box_tittle list_header">
                            <h4>Employee List</h4>
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
                                    <a href="${contextPath}/employee/add" class="btn_1">Add New</a>
                                </div>
                            </div>
                        </div>
                        <div class="QA_table mb_30">
                            <table class="table lms_table_active">
                                <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Full Name</th>
                                    <th scope="col">Join Date</th>
                                    <th scope="col">Nic</th>
                                    <th scope="col">Contact</th>
                                    <th scope="col">Religion</th>
                                    <th scope="col">Salary</th>
                                    <th scope="col">Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${employees}" var="employee" varStatus="seq">
                                    <tr>

                                        <td>${seq.index+1 }</td>
                                        <td>${employee.user.fullName}</td>
                                        <td>${employee.joinDate}</td>
                                        <td>${employee.user.nationalIdNumber}</td>
                                        <td>${employee.user.contact}</td>
                                        <td>${employee.religion}</td>
                                        <td>${employee.currentSalary}</td>
                                        <td><a href="${contextPath}/employee/getById/${employee.id}"
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



