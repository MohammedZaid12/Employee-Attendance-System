<%@ include file="./includes/taglibs.jsp" %>
<jsp:include page="./includes/temp.jsp">
    <jsp:param name="title" value="Dashboard"/>
    <jsp:param name="mainMenu" value="Master Files"/>
</jsp:include>
<title>Dashboard</title>
<%@ include file="./includes/main-menu.jsp" %>
<section class="main_content dashboard_part">
    <%@ include file="./includes/header.jsp" %>
    <div class="main_content_iner ">
        <div class="container-fluid p-0">
            <div class="row justify-content-center">
                <div class="col-lg-12">
                    <div class="single_element">
                        <div class="quick_activity">
                            <div class="row">
                                <div class="col-12">
                                    <div class="quick_activity_wrap">
                                        <div class="single_quick_activity d-flex">
                                            <div class="icon">
                                                <img src="${comntextPath}/resources/img/icon/man.svg" alt="">
                                            </div>
                                            <div class="count_content">
                                                <h3><span class="counter">520</span></h3>
                                                <p>Doctors</p>
                                            </div>
                                        </div>
                                        <div class="single_quick_activity d-flex">
                                            <div class="icon">
                                                <img src="${comntextPath}/resources/img/icon/cap.svg" alt="">
                                            </div>
                                            <div class="count_content">
                                                <h3><span class="counter">6969</span></h3>
                                                <p>Nurses</p>
                                            </div>
                                        </div>
                                        <div class="single_quick_activity d-flex">
                                            <div class="icon">
                                                <img src="${comntextPath}/resources/img/icon/wheel.svg" alt="">
                                            </div>
                                            <div class="count_content">
                                                <h3><span class="counter">7510</span></h3>
                                                <p>Patients</p>
                                            </div>
                                        </div>
                                        <div class="single_quick_activity d-flex">
                                            <div class="icon">
                                                <img src="${comntextPath}/resources/img/icon/pharma.svg" alt="">
                                            </div>
                                            <div class="count_content">
                                                <h3><span class="counter">2110</span></h3>
                                                <p>Pharmacusts</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-12 col-xl-12">
                    <div class="white_box mb_30 ">
                        <div class="box_header border_bottom_1px  ">
                            <div class="main-title">
                                <h3 class="mb_25">Hospital Survey</h3>
                            </div>
                        </div>
                        <div class="income_servay">
                            <div class="row">
                                <div class="col-md-3">
                                    <div class="count_content">
                                        <h3>$ <span class="counter">305</span></h3>
                                        <p>Today's Income</p>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="count_content">
                                        <h3>$ <span class="counter">1005</span></h3>
                                        <p>This Week's Income</p>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="count_content">
                                        <h3>$ <span class="counter">5505</span></h3>
                                        <p>This Month's Income</p>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="count_content">
                                        <h3>$ <span class="counter">155615</span></h3>
                                        <p>This Year's Income</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div id="bar_wev"></div>
                    </div>
                </div>
                <div class="col-xl-12">
                    <div class="white_box QA_section card_height_100">
                        <div class="white_box_tittle list_header m-0 align-items-center">
                            <div class="main-title mb-sm-15">
                                <h3 class="m-0 nowrap">Patients</h3>
                            </div>
                            <div class="box_right d-flex lms_block">
                                <div class="serach_field-area2">
                                    <div class="search_inner">
                                        <form Active="#">
                                            <div class="search_field">
                                                <input type="text" placeholder="Search here...">
                                            </div>
                                            <button type="submit"><i class="ti-search"></i></button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="QA_table ">

                            <table class="table lms_table_active2">
                                <thead>
                                <tr>
                                    <th scope="col">Patients Name</th>
                                    <th scope="col">department</th>
                                    <th scope="col">Appointment Date</th>
                                    <th scope="col">Serial Number</th>
                                    <th scope="col">Amount</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <th scope="row">
                                        <div class="patient_thumb d-flex align-items-center">
                                            <div class="student_list_img mr_20">
                                                <img src="${comntextPath}/resources/img/patient/pataint.png" alt="" srcset="">
                                            </div>
                                            <p>Jhon Kural</p>
                                        </div>
                                    </th>
                                    <td>Monte Carlo</td>
                                    <td>11/03/2020</td>
                                    <td>MDC65454</td>
                                    <td>
                                        <div class="amoutn_action d-flex align-items-center">
                                            $29,192
                                            <div class="dropdown ms-4">
                                                <a class=" dropdown-toggle hide_pils" href="#" role="button"
                                                   id="dropdownMenuLink" data-bs-toggle="dropdown"
                                                   aria-haspopup="true" aria-expanded="false">
                                                    <i class="fas fa-ellipsis-v"></i>
                                                </a>
                                                <div class="dropdown-menu dropdown-menu-right"
                                                     aria-labelledby="dropdownMenuLink">
                                                    <a class="dropdown-item" href="#">View</a>
                                                    <a class="dropdown-item" href="#">Edit</a>
                                                    <a class="dropdown-item" href="#">Delete</a>
                                                </div>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <div class="patient_thumb d-flex align-items-center">
                                            <div class="student_list_img mr_20">
                                                <img src="${comntextPath}/resources/img/patient/2.png" alt="" srcset="">
                                            </div>
                                            <p>Jhon Kural</p>
                                        </div>
                                    </th>
                                    <td>Monte Carlo</td>
                                    <td>11/03/2020</td>
                                    <td>MDC65454</td>
                                    <td>
                                        <div class="amoutn_action d-flex align-items-center">
                                            $29,192
                                            <div class="dropdown ms-4">
                                                <a class=" dropdown-toggle hide_pils" href="#" role="button"
                                                   id="dropdownMenuLink" data-bs-toggle="dropdown"
                                                   aria-haspopup="true" aria-expanded="false">
                                                    <i class="fas fa-ellipsis-v"></i>
                                                </a>
                                                <div class="dropdown-menu dropdown-menu-right"
                                                     aria-labelledby="dropdownMenuLink">
                                                    <a class="dropdown-item" href="#">View</a>
                                                    <a class="dropdown-item" href="#">Edit</a>
                                                    <a class="dropdown-item" href="#">Delete</a>
                                                </div>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <div class="patient_thumb d-flex align-items-center">
                                            <div class="student_list_img mr_20">
                                                <img src="${comntextPath}/resources/img/patient/3.png" alt="" srcset="">
                                            </div>
                                            <p>Jhon Kural</p>
                                        </div>
                                    </th>
                                    <td>Monte Carlo</td>
                                    <td>11/03/2020</td>
                                    <td>MDC65454</td>
                                    <td>
                                        <div class="amoutn_action d-flex align-items-center">
                                            $29,192
                                            <div class="dropdown ms-4">
                                                <a class=" dropdown-toggle hide_pils" href="#" role="button"
                                                   id="dropdownMenuLink" data-bs-toggle="dropdown"
                                                   aria-haspopup="true" aria-expanded="false">
                                                    <i class="fas fa-ellipsis-v"></i>
                                                </a>
                                                <div class="dropdown-menu dropdown-menu-right"
                                                     aria-labelledby="dropdownMenuLink">
                                                    <a class="dropdown-item" href="#">View</a>
                                                    <a class="dropdown-item" href="#">Edit</a>
                                                    <a class="dropdown-item" href="#">Delete</a>
                                                </div>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <div class="patient_thumb d-flex align-items-center">
                                            <div class="student_list_img mr_20">
                                                <img src="${comntextPath}/resources/img/patient/4.png" alt="" srcset="">
                                            </div>
                                            <p>Jhon Kural</p>
                                        </div>
                                    </th>
                                    <td>Monte Carlo</td>
                                    <td>11/03/2020</td>
                                    <td>MDC65454</td>
                                    <td>
                                        <div class="amoutn_action d-flex align-items-center">
                                            $29,192
                                            <div class="dropdown ms-4">
                                                <a class=" dropdown-toggle hide_pils" href="#" role="button"
                                                   id="dropdownMenuLink" data-bs-toggle="dropdown"
                                                   aria-haspopup="true" aria-expanded="false">
                                                    <i class="fas fa-ellipsis-v"></i>
                                                </a>
                                                <div class="dropdown-menu dropdown-menu-right"
                                                     aria-labelledby="dropdownMenuLink">
                                                    <a class="dropdown-item" href="#">View</a>
                                                    <a class="dropdown-item" href="#">Edit</a>
                                                    <a class="dropdown-item" href="#">Delete</a>
                                                </div>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <div class="patient_thumb d-flex align-items-center">
                                            <div class="student_list_img mr_20">
                                                <img src="${comntextPath}/resources/img/patient/5.png" alt="" srcset="">
                                            </div>
                                            <p>Jhon Kural</p>
                                        </div>
                                    </th>
                                    <td>Monte Carlo</td>
                                    <td>11/03/2020</td>
                                    <td>MDC65454</td>
                                    <td>
                                        <div class="amoutn_action d-flex align-items-center">
                                            $29,192
                                            <div class="dropdown ms-4">
                                                <a class=" dropdown-toggle hide_pils" href="#" role="button"
                                                   id="dropdownMenuLink" data-bs-toggle="dropdown"
                                                   aria-haspopup="true" aria-expanded="false">
                                                    <i class="fas fa-ellipsis-v"></i>
                                                </a>
                                                <div class="dropdown-menu dropdown-menu-right"
                                                     aria-labelledby="dropdownMenuLink">
                                                    <a class="dropdown-item" href="#">View</a>
                                                    <a class="dropdown-item" href="#">Edit</a>
                                                    <a class="dropdown-item" href="#">Delete</a>
                                                </div>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <div class="patient_thumb d-flex align-items-center">
                                            <div class="student_list_img mr_20">
                                                <img src="${comntextPath}/resources/img/patient/6.png" alt="" srcset="">
                                            </div>
                                            <p>Jhon Kural</p>
                                        </div>
                                    </th>
                                    <td>Monte Carlo</td>
                                    <td>11/03/2020</td>
                                    <td>MDC65454</td>
                                    <td>
                                        <div class="amoutn_action d-flex align-items-center">
                                            $29,192
                                            <div class="dropdown ms-4">
                                                <a class=" dropdown-toggle hide_pils" href="#" role="button"
                                                   id="dropdownMenuLink" data-bs-toggle="dropdown"
                                                   aria-haspopup="true" aria-expanded="false">
                                                    <i class="fas fa-ellipsis-v"></i>
                                                </a>
                                                <div class="dropdown-menu dropdown-menu-right"
                                                     aria-labelledby="dropdownMenuLink">
                                                    <a class="dropdown-item" href="#">View</a>
                                                    <a class="dropdown-item" href="#">Edit</a>
                                                    <a class="dropdown-item" href="#">Delete</a>
                                                </div>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <div class="patient_thumb d-flex align-items-center">
                                            <div class="student_list_img mr_20">
                                                <img src="${comntextPath}/resources/img/patient/6.png" alt="" srcset="">
                                            </div>
                                            <p>Jhon Kural</p>
                                        </div>
                                    </th>
                                    <td>Monte Carlo</td>
                                    <td>11/03/2020</td>
                                    <td>MDC65454</td>
                                    <td>
                                        <div class="amoutn_action d-flex align-items-center">
                                            $29,192
                                            <div class="dropdown ms-4">
                                                <a class=" dropdown-toggle hide_pils" href="#" role="button"
                                                   id="dropdownMenuLink" data-bs-toggle="dropdown"
                                                   aria-haspopup="true" aria-expanded="false">
                                                    <i class="fas fa-ellipsis-v"></i>
                                                </a>
                                                <div class="dropdown-menu dropdown-menu-right"
                                                     aria-labelledby="dropdownMenuLink">
                                                    <a class="dropdown-item" href="#">View</a>
                                                    <a class="dropdown-item" href="#">Edit</a>
                                                    <a class="dropdown-item" href="#">Delete</a>
                                                </div>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="./includes/footer.jsp" %>
</section>






