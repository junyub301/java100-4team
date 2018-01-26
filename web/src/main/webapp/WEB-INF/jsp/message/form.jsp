<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<title>메세지관리</title>
<link rel="stylesheet" href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
</head>
<body>
<h1 align="center">메세지 보내기</h1>
<br><br>

<div style="width: 700px;" class='container'>

<form action="add" method="post">

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="title">제목</label>
<div class="col-sm-10">
<input id='title' class="form-control" type='text' placeholder="메세지 제목 입력" name='title'>
</div>
</div>

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="content">내용</label>
<div class="col-sm-10">
<input id='content' class="form-control" type="text" placeholder="내용 입력" name='content'>
</div>
</div>

<div class='row justify-content-md-center'>
<button style='width:200px;'class="btn btn-primary">전송</button>
</div>

</form>

</div>

</body>
</html>
    