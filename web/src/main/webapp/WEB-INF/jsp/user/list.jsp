
<%@page import="java.util.List"%>
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

<button><a href='form'>추가</a></button>

<h1>회원 목록</h1>


<table>
<thead>
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
</body>
</html>
    