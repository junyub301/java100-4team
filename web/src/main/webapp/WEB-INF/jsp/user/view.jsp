<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<title>회원관리</title>
<link rel="stylesheet" href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
</head>
<body>

<div style="width: 700px;" class='container'>
<h1>회원상세정보</h1>
<c:if test="${not empty account}">
<form action='update' method='post' enctype="multipart/form-data"> 

<div class='form-group row'> 
<label for='no'class='col-sm-2 col-form-label'>번호</label> 
<div class='col-sm-10'> 
<input class='form-control' readonly id='no' type='number' name='accountsNo' value='${account.accountsNo}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='title' class='col-sm-2 col-form-label'>아이디</label> 
<div class='col-sm-10'> 
<input class='form-control' readonly id='accountName' type='text' name='accountName' value='${account.accountName}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='email' class='col-sm-2 col-form-label'>이메일</label> 
<div class='col-sm-10'> 
<input class='form-control' id='email' type='email' name='email' value='${account.email}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='regdate' class='col-sm-2 col-form-label'>패스워드</label> 
<div class='col-sm-10'> 
<input class='form-control' id='password' type='password' name='password'>
</div> 
</div>

<div class='form-group row'> 
<label for='name' class='col-sm-2 col-form-label'>이름</label> 
<div class='col-sm-10'> 
<input class='form-control' id='name' type='text' name='name' value='${account.name}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='accountNo'class='col-sm-2 col-form-label'>통장번호</label> 
<div class='col-sm-10'> 
<input class='form-control' id='accountNo' type='text' name='accountNo' value='${user.accountNo}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='bank' class='col-sm-2 col-form-label'>은행</label> 
<div class='col-sm-10'> 
<input class='form-control' id='bank' type='text' name='bank' value='${user.bank}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='comment' class='col-sm-2 col-form-label'>한마디</label> 
<div class='col-sm-10'> 
<input class='form-control' id='comment' type='text' name='comment' value='${user.comment}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='phone' class='col-sm-2 col-form-label'>전화번호</label> 
<div class='col-sm-10'> 
<input class='form-control' id='phone' type='text' name='phone' value='${user.phone}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='sample6_postcode' class='col-sm-2 col-form-label'>우편번호</label> 
<div class='col-sm-10'> 
<input class='form-control' id='sample6_postcode' type='text' name='postNo' value='${user.postNo}'>
</div> 
</div> 

<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>

<div class='form-group row'> 
<label for='sample6_address' class='col-sm-2 col-form-label'>기본주소</label> 
<div class='col-sm-10'> 
<input class='form-control' id='sample6_address' type='text' name='baseAddress' value='${user.baseAddress}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='sample6_address2' class='col-sm-2 col-form-label'>상세주소</label> 
<div class='col-sm-10'> 
<input class='form-control' id='sample6_address2' type='text' name='detailAddress' value='${user.detailAddress}'>
</div> 
</div> 

<div class='form-group row'> 
<label class='col-sm-2 col-form-label'>사진</label> 
<div class='col-sm-10'> 
       <c:forEach items="${user.photos}" var="file">
       <img src="${contextPath}/download/${file.photoName}"/><br>
<a href="${contextPath}/download/${file.photoName}">${file.photoName}</a><br>
</c:forEach>
</div> 
</div> 
      
<div class="form-group row">
<label for="file1" class='col-sm-2 col-form-label'>사진첨부</label>
<div class='col-sm-10'>
<input type="file" class="form-control-file" id="file1" name="photo">
</div>
</div>
     
<div class='form-group row'> 
<div class='col-sm-10'> 
<button  class= "btn btn-primary ">변경</button> 
<a href='delete?no=${account.accountsNo}' class= "btn btn-danger ">삭제</a>
</div> 
</div> 
</form>
</c:if>
</div>
<c:if test="${empty account }">
         '${no}'번의 성적 정보가 없습니다.
</c:if>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample6_address').value = fullAddr;

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('sample6_address2').focus();
            }
        }).open();
    }
</script>
</body>
</html>
