<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel='stylesheet'
	href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/test.css'>
</head>
<body style="background-image:url('../../img/portfolio/group.jpg'); 
background-repeat: no-repeat; background-position: center; 
background-size: cover; background-attachment: fixed;">

<div class='container1'>

		<form action="login" method='post'>
            
            <div align="center" class='form-group1'>        
             <img style="width: 70%; opacity: inherit;" src="../../img/portfolio/rg.jpg">
            </div>
            
			<div class='form-group1'>
					<input placeholder="아이디" class='form-control1' id='accountName' type='text'
						name='accountName' value='${cookie.accountName.value}'>
			</div>

			<div class='form-group1'>
					<input placeholder="비밀번호" class='form-control1' id='password' type='password'
						name='password'>
			</div>

			<!-- <div class='form-group row'>
					<div class="form-check">
						<input type="checkbox" class="form-check-input"
							id="saveaccountName" name="saveaccountName"> <label
							class="form-check-label" for="saveaccountName">아이디 저장</label>
				</div>
			</div> -->

			<div align="center" class='form-group1'>
					<button style="width:70%; height: 45px; margin-bottom: -0.7rem;" onclick="location='../main/main.jsp'"
						class='btn btn-info btn-sm'>로그인</button>
			</div>
			<div align="center" class='form-group1'>
					<button style="width:70%; height: 45px; margin-bottom: -0.7rem; opacity: 20px;" onclick="location='../user/form'"
						class='btn btn-info btn-sm'>회원가입</button>
			</div>

		</form>
	</div>

	<jsp:include page="../jslib.jsp" />

</body>
</html>
