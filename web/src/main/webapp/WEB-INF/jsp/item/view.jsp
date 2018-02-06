<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>

<title>회원관리</title>
<link rel="stylesheet" href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<link href="../../css/freelancer.min.css" rel="stylesheet">

</head>
<body>
<jsp:include page="../header.jsp"/>

<div class='view_container'>
<div class='form-group row'> 
       <a href="${contextPath}/download/${item.filename}">
        <img class="viewimg" src="${contextPath}/download/${item.filename}"></a>
    </div> 

<div class='form-group row'> 
<label for='name' class='col-sm-2 col-form-label' >물품명</label> 
<div class='col-sm-10'> 
<input class='form-control' style='width:510px;' readonly id='name' type='text' name='name' value='${item.name}'>
</div> 
</div> 


<div class='form-group row'> 
<label for='content' class='col-sm-2 col-form-label'>한마디</label> 
<div class='col-sm-10'> 
<input class='form-control' style='width:510px;' id='content' type='text' name='content' value='${item.content}'>
</div> 
</div> 



<div class='form-group row'> 
<label for='startDate' class='col-sm-2 col-form-label'>시작일</label> 
<div class='col-sm-10'> 
<input class='form-control' style='width:510px;' id='startDate' type='date' name='startDate' value='${item.startDate}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='endDate' class='col-sm-2 col-form-label'>끝?</label> 
<div class='col-sm-10'> 
<input class='form-control' style='width:510px;' id='endDate' type='date' name='endDate' value='${item.endDate}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='price'class='col-sm-2 col-form-label'>가격</label> 
<div class='col-sm-10'> 
<input class='form-control' style='width:510px;' id='price' type='text' name='price' value='${item.price}'>
</div> 
</div> 


<div class='form-group row'> 
<label for='pricePerDay' class='col-sm-2 col-form-label'>하루가격</label> 
<div class='col-sm-10'> 
<input class='form-control' style='width:510px;' id='pricePerDay' type='text' name='pricePerDay' value='${item.pricePerDay}'>
</div> 
</div> 

    
<h2>물품사진</h2>
<div class='form-group row'> 
       <div class='col-sm-10'> 
  <c:forEach items="${item.photos}" var="file">
       <a href="${contextPath}/download/${file.photoName}">
        <img width="30%" src="${contextPath}/download/${file.photoName}"></a>
    </c:forEach>
    </div> 
    </div> 

</div>




<jsp:include page="../jslib.jsp" />
</body>
</html>
