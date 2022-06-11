<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ include file="styles.jsp" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<nav class="sidebar active_sidebar">
    <div class="logo d-flex justify-content-between">
        <a href="${contextPath}"><img src="${contextPath}/resources/img/logo.png" alt=""></a>
        <div class="sidebar_close_icon d-lg-none">
            <i class="ti-close"></i>
        </div>
    </div>
    <ul id="sidebar_menu" class="metismenu">
        <li class="side_menu_title">
            <span>Master Files</span>
        </li>
        <li class="">
            <a class="has-arrow" href="#" aria-expanded="false">

                <img src="${contextPath}/resources/img/menu-icon/1.svg" alt="">
                <span>Master Files</span>
            </a>
            <ul class="mm-collapse">
                <li><a class="${param.childMenu == 'Departments' ? 'active' : ''}" href="${contextPath}/department">Departments</a>
                </li>
                <li><a class="${param.childMenu == 'Designation' ? 'active' : ''}" href="${contextPath}/designation">Designation</a>
                </li>
            </ul>
        </li>
    </ul>
</nav>
