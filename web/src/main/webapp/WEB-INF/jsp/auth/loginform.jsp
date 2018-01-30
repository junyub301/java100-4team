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
             <img style="width: 20%; opacity: inherit;margin-top: 100px" src="../../img/portfolio/shareicon2.png">
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

			<div class='form-group1'>
					<button id="btn2"  hidden="0" class='form-control2 btn btn-info btn-sm'>로그인</button>
			</div>
			<div class='form-group1'>
			     <div id="btn1" class="button_base b07_3d_double_roll">
		              <div>로그인</div>
		              <div>로그인</div>
		              <div>로그인</div>
		              <div>로그인</div>
		          </div>    
			</div>
		</form>
            <div class='form-group1'>
                 <div onclick="location='../user/form'" class="button_base b07_3d_double_roll">
                      <div>회원가입</div>
                      <div>회원가입</div>
                      <div>회원가입</div>
                      <div>회원가입</div>
                  </div>    
            </div>
            
    </div>
<script>
var btn1 = document.querySelector('#btn1')
var btn2 = document.querySelector('#btn2')

btn1.addEventListener('click', function(event) {
  var me = new MouseEvent('click')

  btn2.dispatchEvent(me)
})

btn2.addEventListener('click', function(event) {
})


</script>


	<jsp:include page="../jslib.jsp" />

</body>
</html>
