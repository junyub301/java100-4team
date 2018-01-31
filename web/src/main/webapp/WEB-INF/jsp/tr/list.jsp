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

<div class='container' style="width:600px;">
<h1 align="center">대여 목록</h1>
<a class="btn btn-success" href='form'>추가</a>

<table style='margin-top: 10px;'class='table'>
<thead class="thead-dark">
<tr>
<th>번호</th><th>물품명</th><th>금액</th><th>신청날짜</th><th>상태</th>
</tr>
</thead>
<tbody>

<c:forEach items="${transaction}" var="transaction">
      <tr>
        <td>${transaction.no}</td>
        <td><a href='${transaction.no}'>${transaction.item.name}</a></td>
        <td>${transaction.item.pricePerDay}</td>
        <td>${transaction.requestDate}</td>
        <td>${transaction.item.status}</td>
      </tr> 
</c:forEach>

</tbody>
</table>
</div>
</body>
</html>
    