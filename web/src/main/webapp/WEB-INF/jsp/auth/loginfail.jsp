<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Refresh" content="2;login">
<title>로그인</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body style="background-image:url('../../img/portfolio/group.jpg'); 
background-repeat: no-repeat; background-position: center; 
background-size: cover; background-attachment: fixed;">
<div class='container'>

<%-- <jsp:include page="../header.jsp"/> --%>
<div align="center" style="margin-top:400px">
<font color="white">
<h1>로그인 실패!</h1>
<p>이메일 또는 암호가 맞지 않습니다!</p>
</font>
</div>
<%-- <jsp:include page="../footer.jsp"/> --%>

</div>

<jsp:include page="../jslib.jsp"/>

</body>
</html>
    