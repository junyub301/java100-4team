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
<jsp:include page="../header.jsp"/>

<div style="width: 700px; margin: auto;" class='row justify-content-md-center'>
<button class="col-sm-5 btn btn-primary" onclick="location.href='rent'">빌려드립니다</button>
<div class="col-sm-2"></div>
<button class="col-sm-5 btn btn-primary" onclick="location.href='lend'">빌려주세요</button>
</div>

<div class="rl_container">
<form action="add" method="post" enctype="multipart/form-data">
<input type="hidden" name='userType' value=0> <!-- userType 0은 빌려드립니다 카테고리 -->
<input type="hidden" name='status' value=0> <!-- status 0은 그냥 등록상태 1은 대여상태 -->
<input type="hidden" name='userNo' value='${sessionScope.loginUser.accountsNo}'> <!-- userNo등록 사용자번호 받아오기 로그인 정보에서 받아옴-->
<div class="form-group row">
<div class="col-sm-2"></div>
<div class="col-sm-10">
    <select class="btn btn-secondary" name="category"><option value=0>카테고리</option>
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
<input id='name' class="form-control" type="text" placeholder="물품정보를 입력하세요" name='name'>
</div>
</div>

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="name">제목</label>
<div class="col-sm-10">
<input id='title' type='text' class="form-control" placeholder="제목을 입력하세요" name='title'>
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
<div class="form-group row">
<label class="col-sm-2 col-form-label" for="photo">사진첨부</label>
<div class="col-sm-10">
<input id='photo' type="file" name='photo'>
</div>
</div>
<div class="form-group row">
<label class="col-sm-2 col-form-label" for="photo">사진첨부</label>
<div class="col-sm-10">
<input id='photo' type="file" name='photo'>
</div>
</div>

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="startDate">쉐어가능기간</label>
<div class="col-sm-10">
<input style="width:200px; display: inline-block;" readonly id='startDate' type='date' 
        class="form-control" placeholder="시작일" name='startDate'>
 
<input style="width:200px; display: inline-block" id='endDate' type='date' 
        class="form-control" placeholder="종료일" name='endDate'>
</div>
</div>

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="price">원가격</label>
<div class="col-sm-10">
<input id='price' type='number' class="form-control" placeholder="원가격을 입력하세요" name='price'>
</div>
</div>

<div class="form-group row">
<label class="col-sm-2 col-form-label" for=pricePerDay>쉐어 비용</label>
<div class="col-sm-10">
<input id='pricePerDay' type='number' class="form-control" placeholder="쉐어비용을 입력하세요" name='pricePerDay'>
</div>
</div>

<div class='row justify-content-md-center'>
<button style='width:200px;'class="btn btn-primary">등록</button>
</div>

<script type="text/javascript">
document.getElementById('startDate').valueAsDate = new Date();
</script>

</form>
</div>
<jsp:include page="../jslib.jsp"/>
</body>
</html>
    