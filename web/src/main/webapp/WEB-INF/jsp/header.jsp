<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    

  <!-- Header -->
    <header class="masthead bg-primary2 text-white text-center">
       <nav class="navbar navbar-expand-lg bg-secondary fixed-top text-uppercase" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="#page-top">Sharer & Sharee</a>
        
        <div class="navbar-nav ml-auto" id="navbarResponsive">
      <c:choose>
    <c:when test="${sessionScope.loginUser != null}">
        ${sessionScope.loginUser.name}
        <a href="${contextPath}/app/auth/logout" 
           class='btn btn-light btn-sm'>로그아웃</a>
    </c:when>

    <c:otherwise>
       <a href="${contextPath}/app/auth/login" 
           class='btn btn-primary btn-sm'>로그인</a>
    </c:otherwise>
    </c:choose>
        </div>
      </div>
    </nav>
    
    </header>









    