<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<title>대여관리</title>
<link rel="stylesheet" href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
</head>
<body>

<div style="width: 700px;" class='container'>
<h1>거래상세정보</h1>
<c:if test="${not empty transaction}">
<form action='update' method='post'> 

<input id='no' type="hidden" name='no' value='${transaction.no}'>

<div class='form-group row'> 
<label for='name' class='col-sm-2 col-form-label'>물품명</label> 
<div class='col-sm-10'> 
<input class='form-control' readonly id='name' type='text' name='name' value='${transaction.item.name}'>
</div> 
</div>

<div class='form-group row'> 
<label for='requestDate'class='col-sm-2 col-form-label'>신청일</label> 
<div class='col-sm-10'> 
<input class='form-control' id='requestDate' type='date' name='requestDate' value='${transaction.requestDate}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='payMethod' class='col-sm-2 col-form-label'>결제유형</label> 
<div class='col-sm-10'> 
<input class='form-control' id='payMethod' min="1" max="3" type='number' name='payMethod' value='${transaction.payMethod}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='payDate' class='col-sm-2 col-form-label'>결제일</label> 
<div class='col-sm-10'> 
<input class='form-control' id='payDate' type='date' name='payDate' value='${transaction.payDate}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='deliveryPayType' class='col-sm-2 col-form-label'>배송비결제유형</label> 
<div class='col-sm-10'> 
<input class='form-control' id='deliveryPayType' min="0" max="1"  type='number' name='deliveryPayType' value='${transaction.deliveryPayType}'>
</div> 
</div>

<div class='form-group row'> 
<label for='deliveryNo' class='col-sm-2 col-form-label'>운송장번호</label> 
<div class='col-sm-10'> 
<input class='form-control' id='deliveryNo' type='number' name='deliveryNo' value='${transaction.deliveryNo}'>
</div> 
</div>

<div class='form-group row'> 
<label for='deliveryDate' class='col-sm-2 col-form-label'>배송일</label> 
<div class='col-sm-10'> 
<input class='form-control' id='deliveryDate' type='date' name='deliveryDate' value='${transaction.deliveryDate}'>
</div> 
</div>

<div class='form-group row'> 
<label for='startDate' class='col-sm-2 col-form-label'>시작일</label> 
<div class='col-sm-10'> 
<input class='form-control' readonly id='startDate' type='date' name='startDate' value='${transaction.item.startDate}'>
</div> 
</div>

<div class='form-group row'> 
<label for='endDate' class='col-sm-2 col-form-label'>종료일</label> 
<div class='col-sm-10'> 
<input class='form-control' readonly id='endDate' type='date' name='endDate' value='${transaction.item.endDate}'>
</div> 
</div>

<div class='form-group row'> 
<label for='pricePerDay' class='col-sm-2 col-form-label'>대여가격</label> 
<div class='col-sm-10'> 
<input class='form-control' readonly id='pricePerDay' type='number' name='pricePerDay' value='${transaction.item.pricePerDay}'>
</div> 
</div>

<div class='form-group row'> 
<label for='status' class='col-sm-2 col-form-label'>상태</label> 
<div class='col-sm-10'> 
<input class='form-control' readonly id='status' type='text' name='status' value='${transaction.item.status}'>
</div> 
</div>



     
<div class='form-group row'> 
<div class='col-sm-10'> 
<button  class= "btn btn-primary ">변경</button> 
<a href='delete?no=${transaction.no}' class= "btn btn-danger ">삭제</a>
<a href="../rv/form?no=${transaction.no}" class= "btn btn-warning ">리뷰등록</a>
</div> 
</div> 
</form>
</c:if>
</div>
<c:if test="${empty transaction }">
         '${no}'번의 메세지 정보가 없습니다.
</c:if>

</body>
</html>
