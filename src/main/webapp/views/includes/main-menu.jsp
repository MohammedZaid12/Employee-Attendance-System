<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ include file="styles.jsp" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<nav class="sidebar active_sidebar">
    <div class="logo d-flex justify-content-between">
        <a href="${contextPath}"><img src="${contextPath}/resources/img/logo.jpeg" alt=""></a>
        <div class="sidebar_close_icon d-lg-none">
            <i class="ti-close"></i>
        </div>
    </div>
    <ul id="sidebar_menu" class="metismenu">
        <li class="side_menu_title">
            <a href="${contextPath}/"> <span>Dashboard</span> </a>
        </li>
        <li class="">
            <a class="has-arrow" href="#" aria-expanded="false">

                <img src="${contextPath}/resources/img/menu-icon/1.svg" alt="">
                <span>Master Files</span>
            </a>
            <ul class="mm-collapse">
                <li><a class="${param.childMenu == 'Departments' ? 'mm-active' : ''}" href="${contextPath}/department">Departments</a>
                </li>
                <li><a class="${param.childMenu == 'Designation' ? 'mm-active' : ''}" href="${contextPath}/designation">Designation</a>
                </li>
                <li><a class="${param.childMenu == 'Shifts' ? 'mm-active' : ''}" href="${contextPath}/shift">Shift</a>
                </li>
                <li><a class="${param.childMenu == 'Rule' ? 'mm-active' : ''}" href="${contextPath}/rule">Rule</a>
                </li>
                <li><a class="${param.childMenu == 'Holidays' ? 'mm-active' : ''}"
                       href="${contextPath}/holiday">Holiday</a>
                </li>
            </ul>
        </li>
        <li class="">
            <a class="has-arrow" href="#" aria-expanded="false">

                <img src="${contextPath}/resources/img/icon/pharma.svg" alt="" style="height: 20px;width: 20px">
                <span>Employee</span>
            </a>
            <ul class="mm-collapse">
                <li><a class="${param.childMenu == 'Employee' ? 'mm-active' : ''}" href="${contextPath}/employee">Employees</a>
                </li>
            </ul>
        </li>
    </ul>
</nav>
