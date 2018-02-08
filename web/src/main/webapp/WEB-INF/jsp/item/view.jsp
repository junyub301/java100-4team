<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>

<title>회원관리</title>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>

</head>
<body>
<jsp:include page="../header.jsp"/>

<div class="container">
<div class="row">
<div class="col-sm-4"></div>
<div class="col-md-4 col-sm-6 col-xs-12">
<div class="card-body">
<div class="col-sm-9">
    <div class="card-text">
    <a href="/download/1518049263844_0.jpg">
    <img src="/download/1518049263844_0.jpg" class="img-responsive img-circle proimg" alt="사진이 없습니다"></a>
      <h4 class="py-3 text_center" style="color:#3680C1">gm1</h4>
      <p class="text_center text-muted">Team Leader</p>
      <!-- <ul class="list-inline social-buttons">
        <li><a href="http://www.free-css.com/free-css-templates"><i class="fa fa-twitter"></i></a></li>
        <li><a href="http://www.free-css.com/free-css-templates"><i class="fa fa-facebook"></i></a></li>
        <li><a href="http://www.free-css.com/free-css-templates"><i class="fa fa-linkedin"></i></a></li>
      </ul> -->
  </div>
</div>
</div>
</div>
</div>

<div class="row">
<div class="col-md-2"></div>
<div class="card-body" style="display: inline-block;">
<h3 class="mb-0">
<p class="card-text text_center">${item.title}</p></h3>
<p class="card-text text_center">${item.name}</p>
</div>


<div class="card-body" style="display: inline-block;">
<p class="card-text text_right text-muted">${item.startDate}-${item.endDate}</p>
<p class="card-text text_right text-muted">${item.price}  원</p>
<p class="card-text text_right text-muted">${item.pricePerDay}  원</p></div>
<div class="col-md-3"></div>
</div>

<div class="row py-5">
<div class="col-sm-2"></div>
  <c:forEach items="${item.photos}" var="file">
       <a href="${contextPath}/download/${file.photoName}">
        <img style="height: 225px; width: 250px; display: block; margin: 10px;"
         src="${contextPath}/download/${file.photoName}"></a>
    </c:forEach>
    <div class="col-sm-1"></div>
</div>
</div>

<jsp:include page="../jslib.jsp" />
</body>
</html>
