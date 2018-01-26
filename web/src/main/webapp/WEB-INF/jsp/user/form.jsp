<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<title>회원가입</title>
<link rel="stylesheet" href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
</head>
<body>
<h1 align="center">회원가입</h1>
<br><br>

<div style="width: 700px;" class='container'>

<form action="add" method="post" enctype="multipart/form-data">

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="act_id">아이디</label>
<div class="col-sm-10">
<input id='act_id' class="form-control" type='text' placeholder="아이디를 입력하세요" name='accountName'>
</div>
</div>

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="email">이메일</label>
<div class="col-sm-10">
<input id='email' class="form-control" type="email" placeholder="이메일을 입력하세요" name='email'>
</div>
</div>

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="pwd">암호</label>
<div class="col-sm-10">
<input id='pwd' type='password' class="form-control" placeholder="패스워드를 입력하세요" name='password'>
</div>
</div>

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="name">이름</label>
<div class="col-sm-10">
<input id='name' type='text' class="form-control" placeholder="이름을 입력하세요"  name='name'>
</div>
</div>

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="acc_no">계좌번호</label>
<div class="col-sm-10">
<input id='acc_no' type='text' class="form-control" placeholder="계좌번호를 입력하세요" name='accountNo'>
</div>
</div>

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="bank">은행명</label>
<div class="col-sm-10">
<input id='bank' type='text' class="form-control" placeholder="은행명을 입력하세요" name='bank'>
</div>
</div>

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="cnt">한마디</label>
<div class="col-sm-10">
<input id='cnt' type='text' class="form-control" placeholder="한마디를 입력하세요" name='comment'>
</div>
</div>

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="phone">전화번호</label>
<div class="col-sm-10">
<input id='phone' type='text' class="form-control" placeholder="전화번호를 입력하세요" name='phone'>
</div>
</div>

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="sample6_postcode">우편번호</label>
<div class="col-sm-10">
<input type="text" id="sample6_postcode" class="form-control" placeholder="우편번호" name='postNo'>
<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
</div>
</div>

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="sample6_address">기본주소</label>
<div class="col-sm-10">
<input type="text" id="sample6_address" class="form-control" placeholder="주소"name='baseAddress'>
</div>
</div>

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="sample6_address2">상세주소</label>
<div class="col-sm-10">
<input  type="text" id="sample6_address2" class="form-control" placeholder="상세주소" name='detailAddress'>
</div>
</div>

<div class="form-group row">
<label class="col-sm-2 col-form-label" for="photo">사진첨부</label>
<div class="col-sm-10">
<input id='photo' type="file" name='photo'>
</div>
</div>

<div class='row justify-content-md-center'>
<button style='width:200px;'class="btn btn-primary">전송</button>
</div>

</form>

</div>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
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
    