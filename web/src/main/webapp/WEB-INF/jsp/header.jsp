<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/freelancer.min.css" rel="stylesheet">
    <link href="../../css/test.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/earlyaccess/nanumgothic.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
  <%-- Header --%>
  
<nav class="site-header sticky-top py-1">
      <div class="custom_container d-flex flex-column flex-md-row justify-content-between">
    
        <a class="pad_zero py-2 col-sm-1" href="#">
          <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="d-block mx-auto"><circle cx="12" cy="12" r="10"></circle><line x1="14.31" y1="8" x2="20.05" y2="17.94"></line><line x1="9.69" y1="8" x2="21.17" y2="8"></line><line x1="7.38" y1="12" x2="13.12" y2="2.06"></line><line x1="9.69" y1="16" x2="3.95" y2="6.06"></line><line x1="14.31" y1="16" x2="2.83" y2="16"></line><line x1="16.62" y1="12" x2="10.88" y2="21.94"></line></svg>
        </a>
        <a onclick="location.href='../main/main'" class="pad_zero col-sm-1 py-2 d-none d-md-inline-block" href="#">SharerSharee</a>
        <div class="col-sm-8"></div>
        
        <c:choose>
    <c:when test="${sessionScope.loginUser != null}">
        <a class="pad_zero py-2 col-sm-1 d-none d-md-inline-block">${sessionScope.loginUser.name}</a>
        <a href="${contextPath}/app/auth/logout" 
           class='pad_zero py-2 col-sm-1 d-none d-md-inline-block'>Logout</a>
    </c:when>

    <c:otherwise>
       <a href="${contextPath}/app/auth/login" 
           class='pad_zero py-2 col-sm-2 d-none d-md-inline-block'>Login</a>
    </c:otherwise>
    </c:choose>
      </div>
    </nav>









    