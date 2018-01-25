<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
</head>
<body>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>

<form action="add" method="post" enctype="multipart/form-data">
아이디<input id='act_id' type='text' name='accountName'><br>
이메일<input id='email' type="email" name='email'><br>
패스워드<input id='pwd' type='password' name='password'><br>
이름<input id='name' type='text' name='name'><br>
통장번호<input id='acc_no' type='text' name='accountNo'><br>
은행명<input id='bank' type='text' name='bank'><br>
한마디<input id='cnt' type='text' name='comment'><br>
전화번호<input id='phone' type='text' name='phone'><br>
우편번호<input type="text" id="sample6_postcode" placeholder="우편번호" name='postNo'>
<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
기본주소<input type="text" id="sample6_address" placeholder="주소"name='baseAddress'><br>
상세주소<input  type="text" id="sample6_address2" placeholder="상세주소" name='detailAddress'><br>
사진<input  type="file" name='photo'><br>
<button>전송</button>
</form>

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
    