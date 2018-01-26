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

<div style="width: 700px;" class='container'>
<div class='row justify-content-md-center'>
<button class="col-sm-5 btn btn-primary" onclick="location.href='rent'">빌려드립니다</button>
<div class="col-sm-2"></div>
<button class="col-sm-5 btn btn-primary" onclick="location.href='lend'">빌려주세요</button>
</div>
<br><br>

<form action="add" method="post" enctype="multipart/form-data">
<input type="hidden" name='userType' value=1> <!-- userType 1은 빌려주세요 카테고리 -->
<input type="hidden" name='status' value=0> <!-- status 0은 그냥 등록상태 1은 대여상태 -->
<div class="form-group row">
<div class="col-sm-2"></div>
<div class="col-sm-10">
    <select class="btn btn-secondary" name="category"><option value="0">카테고리</option>
    <option value=1>전자제품</option>
    <option value=2>뷰티/악세</option>
    <option value=3>의류</option>
    <option value=4>공구</option>
    <option value=5>ETC</option>
    </select>
    </div>
    
</div>

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="title">물품정보</label>
<div class="col-sm-10">
<input id='title' class="form-control" type="text" placeholder="물품정보를 입력하세요" name='title'>
</div>
</div>

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="name">제목</label>
<div class="col-sm-10">
<input id='name' type='text' class="form-control" placeholder="제목을 입력하세요" name='name'>
</div>
</div>

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="content">내용</label>
<div class="col-sm-10">
<textarea id='content' class="form-control" placeholder="내용을 입력하세요"  name='content'>
</textarea>
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
    