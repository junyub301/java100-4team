<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    

  <%-- Header --%>
  
    <header class="masthead bg-primary2 text-white text-center">
       <div style="opacity: 0.5; z-index: 2;" class="navbar navbar-expand-lg bg-secondary fixed-top text-uppercase" id="mainNav">
      <div style="margin-left:50px; z-index:1; display: inline-block;">
        <a class="navbar-brand" href="../main/main">Sharer & Sharee</a>
        
      </div>
        <div style="margin-right:50px;" class="navbar-nav ml-auto" id="navbarResponsive">
      <c:choose>
    <c:when test="${sessionScope.loginUser != null}">
        <div class="col-sm-1">${sessionScope.loginUser.name}</div>
        <a href="${contextPath}/app/auth/logout" 
           class='btn btn-light btn-sm'>Logout</a>
    </c:when>

    <c:otherwise>
       <a href="${contextPath}/app/auth/login" 
           class='btn btn-primary btn-sm'>Login</a>
    </c:otherwise>
    </c:choose>
        </div>
    </div>
    
    
    </header>









    