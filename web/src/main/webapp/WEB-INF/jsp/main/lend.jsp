<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>물품 등록</title>
<link rel="stylesheet" href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
</head>
<body>
<div class='row justify-content-md-center'>
<button style='width:200px;'class="btn btn-primary" onclick="location.href='rent'">빌려드립니다</button>
<button style='width:200px;'class="btn btn-primary" onclick="location.href='lend'">빌려주세요</button>
</div>
<br><br>

<div style="width: 700px;" class='container'>

<form action="add" method="post" enctype="multipart/form-data">

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="act_id">카테고리</label>
<div class="col-sm-10">
<input id='act_id' class="form-control" type='text' placeholder="아이디를 입력하세요" name='accountName'>
</div>
</div>

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="email">물품정보</label>
<div class="col-sm-10">
<input id='email' class="form-control" type="email" placeholder="이메일을 입력하세요" name='email'>
</div>
</div>

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="pwd">제목</label>
<div class="col-sm-10">
<input id='pwd' type='password' class="form-control" placeholder="패스워드를 입력하세요" name='password'>
</div>
</div>

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="name">내용</label>
<div class="col-sm-10">
<input id='name' type='text' class="form-control" placeholder="내용을 입력하세요"  name='name'>
</div>
</div>

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="photo">사진첨부</label>
<div class="col-sm-10">
<input id='photo' type="file" name='photo'>
</div>
</div>




<div class='row justify-content-md-center'>
<button style='width:200px;'class="btn btn-primary">등록</button>
</div>

</form>

</div>
</body>
</html>
    