<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<title>메세지관리</title>
<link rel="stylesheet" href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
</head>
<body>

<div style="width: 700px;" class='container'>
<h1>메세지상세정보</h1>
<c:if test="${not empty review}">
<form action='update' method='post'> 

<div class='form-group row'> 
<label for='rentNo'class='col-sm-2 col-form-label'>번호</label> 
<div class='col-sm-10'> 
<input class='form-control' readonly id='rentNo' type='number' name='rentNo' value='${review.rentNo}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='contents' class='col-sm-2 col-form-label'>내용</label> 
<div class='col-sm-10'> 
<input class='form-control' id='contents' type='text' name='contents' value='${review.contents}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='createdDate' class='col-sm-2 col-form-label'>등록날짜</label> 
<div class='col-sm-10'> 
<input class='form-control' readonly id='createdDate' type='date' name='createdDate' value='${review.createdDate}'>
</div> 
</div> 

     
<div class='form-group row'> 
<div class='col-sm-10'> 
<button  class= "btn btn-primary ">변경</button> 
<a href='delete?no=${review.rentNo}' class= "btn btn-danger ">삭제</a>
</div> 
</div> 
</form>
</c:if>
</div>
<c:if test="${empty review }">
         '${no}'번의 리뷰 정보가 없습니다.
</c:if>
<jsp:include page="../jslib.jsp" />
</body>
</html>
