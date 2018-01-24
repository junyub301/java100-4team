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
<form action="add">
아이디<input id='act_id' type='text' name='accountName'><br>
이메일<input id='email' type="email" name='email'><br>
패스워드<input id='pwd' type='password' name='password'><br>
이름<input id='name' type='text' name='name'><br>
통장번호<input id='acc_no' type='text' name='accountNo'><br>
은행명<input id='bank' type='text' name='bank'><br>
한마디<input id='cnt' type='text' name='comment'><br>
전화번호<input id='phone' type='text' name='phone'><br>
우편번호<input id='pst_no' type='text' name='postNo'><br>
기본주소<input id='bas_addr' type='text' name='baseAddress'><br>
상제주소<input id='det_addr' type='text' name='detailAddress'><br>
<button>전송</button>
</form>
</body>
</html>
    