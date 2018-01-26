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

<div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Dropdown button
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <a class="dropdown-item" href="#">Action</a>
    <a class="dropdown-item" href="#">Another action</a>
    <a class="dropdown-item" href="#">Something else here</a>
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
<textarea id='name' class="form-control" placeholder="내용을 입력하세요"  name='name'>
</textarea>
</div>
</div>

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="photo">사진첨부</label>
<div class="col-sm-10">
<input id='photo' type="file" name='photo'>
</div>
</div>

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="bank">쉐어가능기간</label>
<div class="col-sm-10">
<input id='bank' type='date' class="form-control1" placeholder="시작일" name='bank'>

<input id='bank' type='date' class="form-control1" placeholder="시작일" name='bank'>
</div>
</div>

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="cnt">원가격</label>
<div class="col-sm-10">
<input id='cnt' type='number' class="form-control" placeholder="원가격" name='comment'>
</div>
</div>

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="phone">쉐어 비용</label>
<div class="col-sm-10">
<input id='phone' type='number' class="form-control" placeholder="쉐어비용" name='phone'>
</div>
</div>



<div class='row justify-content-md-center'>
<button style='width:200px;'class="btn btn-primary">등록</button>
</div>

</form>

</div>
</body>
</html>
    