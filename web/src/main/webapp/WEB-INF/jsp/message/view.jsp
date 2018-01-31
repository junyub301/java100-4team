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
<c:if test="${not empty message}">
<form action='update' method='post'> 

<div class='form-group row'> 
<label for='no'class='col-sm-2 col-form-label'>번호</label> 
<div class='col-sm-10'> 
<input class='form-control' readonly id='no' type='number' name='messageNo' value='${message.messageNo}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='userId' class='col-sm-2 col-form-label'>아이디</label> 
<div class='col-sm-10'> 
<input class='form-control' readonly id='userId' type='text' value='${message.userId}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='title' class='col-sm-2 col-form-label'>제목</label> 
<div class='col-sm-10'> 
<input class='form-control' id='title' type='text' name='title' value='${message.title}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='content' class='col-sm-2 col-form-label'>내용</label> 
<div class='col-sm-10'> 
<input class='form-control' id='content' type='text' name='content' value='${message.content}'>
</div> 
</div>

<div class='form-group row'> 
<label for='dispatchDate' class='col-sm-2 col-form-label'>보낸날짜</label> 
<div class='col-sm-10'> 
<input class='form-control' readonly id='dispatchDate' type='text' value='${message.dispatchDate}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='state' class='col-sm-2 col-form-label'>수신확인</label> 
<div class='col-sm-10'> 
<input class='form-control' readonly id='state' type='text' value='${message.state}'>
</div> 
</div> 
     
<div class='form-group row'> 
<div class='col-sm-10'> 
<button  class= "btn btn-primary ">변경</button> 
<a href='delete?no=${message.messageNo}' class= "btn btn-danger ">삭제</a>
</div> 
</div> 
</form>
</c:if>
</div>
<c:if test="${empty message }">
         '${no}'번의 메세지 정보가 없습니다.
</c:if>
<jsp:include page="../jslib.jsp" />
</body>
</html>
