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
<h1 align="center">메세지 목록</h1>
<a class="btn btn-success" href='form'>추가</a>

<table style='margin-top: 10px;'class='table'>
<thead class="thead-dark">
<tr>
<th>번호</th><th>받는사람</th><th>제목</th><th>날짜</th><th>수신확인</th>
</tr>
</thead>
<tbody>

<c:forEach items="${message}" var="message">
      <tr>
        <td>${message.messageNo}</td>
        <td><a href='${message.messageNo}'>${message.userId}</a></td>
        <td>${message.title}</td>
        <td>${message.dispatchDate}</td>
        <td>${message.state}</td>
      </tr> 
</c:forEach>

</tbody>
</table>
</div>
</body>
</html>
    