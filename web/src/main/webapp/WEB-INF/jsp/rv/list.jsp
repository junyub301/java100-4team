<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<title>리뷰관리</title>

<link rel="stylesheet" href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>

</head>
<body>

<div class='container' style="width:600px;">
<h1 align="center">리뷰 목록</h1>

<table style='margin-top: 10px;'class='table'>
<thead class="thead-dark">
<tr>
<th>번호</th><th>내용</th><th>날짜</th>
</tr>
</thead>
<tbody>

<c:forEach items="${review}" var="review">
      <tr>
        <td>${review.rentNo}</td>
        <td><a href='${review.rentNo}'><span class="d-inline-block text-truncate" 
              style="max-width: 150px;">${review.contents}</span></a></td>
        <td>${review.createdDate}</td>
      </tr> 
</c:forEach>

</tbody>
</table>
</div>
<jsp:include page="../jslib.jsp" />
</body>
</html>
    