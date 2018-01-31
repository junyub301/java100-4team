<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<title>리뷰관리</title>
<link rel="stylesheet" href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
</head>
<body>
<h1 align="center">리뷰 쓰기</h1>
<br><br>

<div style="width: 700px;" class='container'>

<form action="add" method="post">

<input id='no' type="hidden" name='rentNo' value="${no}">

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="contents">내용</label>
<div class="col-sm-10">
<input id='contents' class="form-control" type='text' placeholder="내용 입력" name='contents'>
</div>
</div>

<div class='row justify-content-md-center'>
<button style='width:200px;'class="btn btn-primary">전송</button>
</div>

</form>

</div>
<jsp:include page="../jslib.jsp" />
</body>
</html>
    