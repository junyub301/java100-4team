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

<div class="form-group row">
<div class="col-sm-2"></div>
<div class="col-sm-10">
    <select class="btn btn-secondary" name=""><option value="">카테고리</option>
    <option value="">전자제품</option>
    <option value="">뷰티/악세</option>
    <option value="">의류</option>
    <option value="">공구</option>
    <option value="">ETC</option>
    </select>
    </div>
</div>

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="email">물품정보</label>
<div class="col-sm-10">
<input id='email' class="form-control" type="email" placeholder="물품정보를 입력하세요" name='email'>
</div>
</div>

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="pwd">제목</label>
<div class="col-sm-10">
<input id='pwd' type='password' class="form-control" placeholder="제목을 입력하세요" name='password'>
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
<input style="width:200px; display: inline-block" id='bank' type='date' class="form-control" placeholder="시작일" name='bank'>
 
<input style="width:200px; display: inline-block" id='bank' type='date' class="form-control" placeholder="시작일" name='bank'>
</div>
</div>

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="cnt">원가격</label>
<div class="col-sm-10">
<input id='cnt' type='number' class="form-control" placeholder="원가격을 입력하세요" name='comment'>
</div>
</div>

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="phone">쉐어 비용</label>
<div class="col-sm-10">
<input id='phone' type='number' class="form-control" placeholder="쉐어비용을 입력하세요" name='phone'>
</div>
</div>



<div class='row justify-content-md-center'>
<button style='width:200px;'class="btn btn-primary">등록</button>
</div>

</form>

</div>
<jsp:include page="../jslib.jsp"/>
</body>
</html>
    