<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<title>회원관리</title>

<link rel="stylesheet" href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>

</head>
<body>

<div class='container' style="width:600px;">
<h1 align="center">회원 목록</h1>
<a class="btn btn-success" href='form'>추가</a>

<table style='margin-top: 10px;'class='table'>
<thead class="thead-dark">
<tr>
<th>번호</th><th>아이디</th><th>이메일</th>
</tr>
</thead>
<tbody>

<c:forEach items="${account}" var="account">
      <tr>
        <td>${account.accountsNo}</td>
        <td><a href='${account.accountsNo}'>${account.accountName}</a></td>
        <td>${account.email}</td>
      </tr> 
</c:forEach>

</tbody>
</table>
</div>
</body>
</html>
    