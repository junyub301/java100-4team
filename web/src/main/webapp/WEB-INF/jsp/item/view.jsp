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
<jsp:include page="../header.jsp"/>
</head>
<body>
<br><br>
<%--드롭다운식으로 수정해야함 --%>
<div style='width: 600px;height:400px;display:inline-block;float:left;'>
<br><br>
<table style='width:400px;margin-left:70px;'class="table table-dark">
    <tr>
      <td>이용내역</td>
    </tr>
    <tr>
      <td>회원정보변경</td>
    </tr>
    <tr>
      <td>메시지</td>
    </tr>
</table>
</div>
<div style="width: 700px;display:inline-block;margin-right:500px;" >




<br>
<div style='display:inline-block;width:400px;'> 
<label for='name' class='col-form-label' style='width:120px;'>물품명</label> 
<input class='form-control' style='display:inline-block;width:250px;' readonly id='name' type='text' name='name' value='${item.name}'>
</div> 
<br><br>


<div class='form-group row'> 
<label for='content' class='col-sm-2 col-form-label'>한마디</label> 
<div class='col-sm-10'> 
<input class='form-control' style='width:510px;' id='content' type='text' name='content' value='${item.content}'>
</div> 
</div> 


<div class='form-group row'> 
<label for='startDate' class='col-sm-2 col-form-label'>시작일</label> 
<div class='col-sm-10'> 
<input class='form-control' style='width:510px;' id='startDate' type='text' name='startDate' value='${item.startDate}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='endDate' class='col-sm-2 col-form-label'>끝?</label> 
<div class='col-sm-10'> 
<input class='form-control' style='width:510px;' id='endDate' type='text' name='endDate' value='${item.endDate}'>
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

</div>






</body>
</html>
