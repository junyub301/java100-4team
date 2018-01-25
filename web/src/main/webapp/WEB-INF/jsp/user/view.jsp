<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<title>회원관리</title>
</head>
<body>


<h1>회원상세정보</h1>

<c:if test="${not empty account}">
<form action='update' method='post' enctype="multipart/form-data"> 

<div class='form-group row'> 
<label for='no'class='col-sm-2 col-form-label'>번호</label> 
<div class='col-sm-10'> 
<input class='form-control' readonly id='no' type='number' name='accountsNo' value='${account.accountsNo}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='title'class='col-sm-2 col-form-label'>아이디</label> 
<div class='col-sm-10'> 
<input class='form-control' readonly id='accountName' type='text' name='accountName' value='${account.accountName}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='content'class='col-sm-2 col-form-label'>이메일</label> 
<div class='col-sm-10'> 
<input class='form-control' id='email' type='email' name='email' value='${account.email}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='regdate'class='col-sm-2 col-form-label'>패스워드</label> 
<div class='col-sm-10'> 
<input class='form-control' id='password' type='password' name='password'>
</div> 
</div>

<div class='form-group row'> 
<label for='viewcount'class='col-sm-2 col-form-label'>이름</label> 
<div class='col-sm-10'> 
<input class='form-control' id='name' type='text' name='name' value='${account.name}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='viewcount'class='col-sm-2 col-form-label'>통장번호</label> 
<div class='col-sm-10'> 
<input class='form-control' id='accountNo' type='text' name='accountNo' value='${user.accountNo}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='viewcount'class='col-sm-2 col-form-label'>은행</label> 
<div class='col-sm-10'> 
<input class='form-control' id='bank' type='text' name='bank' value='${user.bank}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='viewcount'class='col-sm-2 col-form-label'>한마디</label> 
<div class='col-sm-10'> 
<input class='form-control' id='comment' type='text' name='comment' value='${user.comment}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='viewcount'class='col-sm-2 col-form-label'>전화번호</label> 
<div class='col-sm-10'> 
<input class='form-control' id='phone' type='text' name='phone' value='${user.phone}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='viewcount'class='col-sm-2 col-form-label'>우편번호</label> 
<div class='col-sm-10'> 
<input class='form-control' id='postNo' type='text' name='postNo' value='${user.postNo}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='viewcount'class='col-sm-2 col-form-label'>기본주소</label> 
<div class='col-sm-10'> 
<input class='form-control' id='baseAddress' type='text' name='baseAddress' value='${user.baseAddress}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='viewcount'class='col-sm-2 col-form-label'>상세주소</label> 
<div class='col-sm-10'> 
<input class='form-control' id='detailAddress' type='text' name='detailAddress' value='${user.detailAddress}'>
</div> 
</div> 

<div class='form-group row'> 
<label class='col-sm-2 col-form-label'>사진</label> 
<div class='col-sm-10'> 
       <c:forEach items="${user.photos}" var="file">
       <img src="${contextPath}/download/${file.photoName}"/><br>
<a href="${contextPath}/download/${file.photoName}">${file.photoName}</a><br>
</c:forEach>
             
</div> 
</div> 
      
      
<div class="form-group row">
<label for="file1" class='col-sm-2 col-form-label'>사진첨부</label>
<div class='col-sm-10'>
 <input type="file" class="form-control-file" id="file1" name="photo">
</div>
</div>
      
      
     
<div class='form-group row'> 
<div class='col-sm-10'> 
<button  class= "btn btn-primary ">변경</button> 
<a href='delete?no=${account.accountsNo}' class= "btn btn-danger ">삭제</a>
</div> 
</div> 
</form> 
</c:if>
<c:if test="${empty account }">
         '${no}'번의 성적 정보가 없습니다.
</c:if>

</body>
</html>
    
