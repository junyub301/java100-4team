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
    <header>  
       <div class="header1 bg-secondary text-uppercase">
        <div style="margin-top: 17px; margin-left: 20px; margin-right: 20px;">
        <a style="color: white; text-decoration: none;" href="../main/main">
        <h4 class="fontsetting">SharerSharee</h4></a>
        <nav class="nav1">
        <ul class="ul1">
        
        <li style="float: right; padding: 0; list-style: none;">
      <c:choose>
    <c:when test="${sessionScope.loginUser != null}">
        <a style="color: white;">${sessionScope.loginUser.name}</a>
        <a href="${contextPath}/app/auth/logout" 
           style="color: white; text-decoration: none;" class='login1'>Logout</a>
    </c:when>

    <c:otherwise>
       <a href="${contextPath}/app/auth/login" 
           style="color: white; text-decoration: none;" class='login1'>Login</a>
    </c:otherwise>
    </c:choose>
        </li>
        </ul>
        </nav>
        </div>
        </div>
    </header>









    