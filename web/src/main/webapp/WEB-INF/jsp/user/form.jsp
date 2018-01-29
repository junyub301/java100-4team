<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<title>회원가입</title>
<script type="text/javascript">
    function tocheckpw2() {
        var pwd = document.getElementById("pwd").value;
        var pwck = document.getElementById("PwCheck").value;
 
        if (pwd != pwck) {
            document.getElementById('pwsame').innerHTML = '비밀번호가 틀렸습니다. 다시 입력해 주세요';
            return false;
        }
    }
</script>
<link rel="stylesheet" href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/test.css'>
</head>
<body style="background-image:url('../../img/portfolio/group.jpg'); 
background-repeat: no-repeat; background-position: center; 
background-size: cover; background-attachment: fixed;">
<!-- <h1 align="center">회원가입</h1>
<br><br> -->

<div style="width: 700px; margin-top: 50px" class='container'>

<form action="add" method="post" onsubmit="return tocheckpw2()" data-ajax="false" enctype="multipart/form-data">

<div class="form-group1">
<input id='act_id' class="form-control1" type='text' placeholder="아이디" name='accountName'>
</div>

<div class="form-group1">
<input id='email' class="form-control1" type="email" placeholder="이메일" name='email'>
</div>

<div class="form-group1">
<input id='pwd' type='password' class="form-control1" placeholder="비밀번호" name='password'>
</div>

<div class="form-group1">
<input id="PwCheck" type="password" class="form-control1" style="margin-bottom: 0.3rem;" placeholder="비밀번호 재입력">
<p align="center" id="pwsame" style="color:red;">
</div>

<div class="form-group1">
<input id='name' type='text' class="form-control1" placeholder="이름"  name='name'>
</div>

<div class="form-group1">
<input id='acc_no' type='text' class="form-control1" placeholder="계좌번호" name='accountNo'>
</div>

<div class="form-group1">
<input id='bank' type='text' class="form-control1" placeholder="은행" name='bank'>
</div>

<div class="form-group1">
<input id='cnt' type='text' class="form-control1" placeholder="한마디" name='comment'>
</div>

<div class="form-group1">
<input id='phone' type='text' class="form-control1"  style="margin-bottom: 0.3rem;" placeholder="전화번호" name='phone'>
</div>

<div class="form-group1">
<input style="margin-bottom: 0.5rem; background-color: #D8D8D8;" type="button" class="form-control1" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
<input type="text" id="sample6_postcode" class="form-control1" placeholder="우편번호" name='postNo'>
</div>

<div class="form-group1">
<input type="text" id="sample6_address" class="form-control1" placeholder="주소"name='baseAddress'>
</div>

<div class="form-group1">
<input  type="text" id="sample6_address2" class="form-control1" placeholder="상세주소" name='detailAddress'>
</div>

<div class="form-group1">
<input id='photo' class="form-control1" type="file" name='photo'>
</div>

<div class='row justify-content-md-center'>
<button style="width:469px; height: 45px; margin-bottom: 0.5rem;" class="btn btn-primary">회원가입</button>
</div>
</form>

<div align="center" class='form-group1'>
                    <button style="width:70%; height: 45px; margin-bottom: -0.7rem; background-color: " onclick="location='../auth/login.jsp'"
                        class='btn btn-info btn-sm'>로그인</button>
            </div>

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
    