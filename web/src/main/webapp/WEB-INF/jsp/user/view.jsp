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
<link href="../../css/freelancer.min.css" rel="stylesheet">
<jsp:include page="../header.jsp"/>
</head>
<body>
<br><br>

<div style='width: 800px;height:400px;display:inline-block;float:left;'>
<br>
<table style='margin-left:420px;width:300px;'class="table table-striped table-dark">
    <tr onclick="folding1()">
      <td><a style='text-decoration:none;color:white;' href='#'>이용내역</a></td>
    </tr>
    <tr id="f1" style="display: none;">
      <td>&nbsp;&nbsp;&nbsp;<a style='text-decoration:none;color:white;' href='#'>등록/대여/반납현황</a></td>
    </tr>
    <tr onclick="folding2()">
      <td><a style='text-decoration:none;color:white;' href='#'>회원정보변경</a></td>
    </tr>
    <tr id="f2" style="display: none;">
      <td>&nbsp;&nbsp;&nbsp;<a style='text-decoration:none;color:white;' href='#'>회원정보변경</a></td>
    </tr>
    <tr onclick="folding3()">
      <td><a style='text-decoration:none;color:white;' href='../msg/list'>메시지</a></td>
    </tr>
    <tr id="f3" style="display: none;">
      <td>&nbsp;&nbsp;&nbsp;<a style='text-decoration:none;color:white;' href='../msg/list'>메시지</a></td>
    </tr>
</table>
</div>
<div style="width: 700px;display:inline-block;margin-right:500px;position:fixed;">

<c:if test="${not empty account}">
<form action='update' method='post' onsubmit="return tocheckpw1()" enctype="multipart/form-data"> 

<%--계정번호 히든처리 --%>
<input id='no' type="hidden" name='accountsNo' value='${account.accountsNo}'>


<div style='display:inline-block;width:250px;height:200px;float:left'>
       <c:forEach items="${user.photos}" var="file">
       <a href="${contextPath}/download/${file.photoName}">
        <img width="200px" src="${contextPath}/download/${file.photoName}"></a>
        
<%-- 파일이름 출력 숨김
${file.photoName} --%>
</c:forEach>
</div> 
<br>
<div style='display:inline-block;width:400px;'> 
<label for='accountName' class='col-form-label' style='width:120px;'>아이디</label> 
<input class='form-control' style='display:inline-block;width:250px;' readonly id='accountName' type='text' name='accountName' value='${account.accountName}'>
</div> 
<br><br>

<div style='display:inline-block;width:400px;'> 
<label for='password' class='col-form-label' style='width:120px;'>패스워드</label> 
<input class='form-control' style='display:inline-block;width:250px;' id='password' type='password' name='password'>
</div>
<br><br>
<div style='display:inline-block;width:400px;'> 
<label for='checkpwd' class='col-form-label' style='width:120px;'>패스워드 확인</label> 
<input class='form-control' style='display:inline-block;width:250px;' id='checkpwd' type='password'>
</div>
<br><br>
<!--버튼모양수정해야함  -->
<div class="form-group row">
<div class='col-sm-10'>
<span id="fileInputForm" class="btn btn-secondary" style="font-size:0.8em; padding-top:0px;  position:relative; float:left;margin-left:50px;width:100px;height:20px; overflow:hidden; cursor:pointer;">
사진변경
</span>
<input type="file" class="form-control-file"  id="file1" name="photo" style='position:absolute; margin-left:50px;width:100px;height:20px;opacity: 0;'>
</div>
</div>


<div class='form-group row'> 
<label for='email' class='col-sm-2 col-form-label'>이메일</label> 
<div class='col-sm-10'> 
<input class='form-control' style='width:510px;' id='email' type='email' name='email' value='${account.email}'>
</div> 
</div> 


<div class='form-group row'> 
<label for='name' class='col-sm-2 col-form-label'>이름</label> 
<div class='col-sm-10'> 
<input class='form-control' style='width:510px;' id='name' type='text' name='name' value='${account.name}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='bank' class='col-sm-2 col-form-label'>은행</label> 
<div class='col-sm-10'> 
<input class='form-control' style='width:510px;' id='bank' type='text' name='bank' value='${user.bank}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='accountNo'class='col-sm-2 col-form-label'>통장번호</label> 
<div class='col-sm-10'> 
<input class='form-control' style='width:510px;' id='accountNo' type='text' name='accountNo' value='${user.accountNo}'>
</div> 
</div> 


<div class='form-group row'> 
<label for='comment' class='col-sm-2 col-form-label'>한마디</label> 
<div class='col-sm-10'> 
<input class='form-control' style='width:510px;' id='comment' type='text' name='comment' value='${user.comment}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='phone' class='col-sm-2 col-form-label'>전화번호</label> 
<div class='col-sm-10'> 
<input class='form-control' style='width:510px;' id='phone' type='text' name='phone' value='${user.phone}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='sample6_postcode' class='col-sm-2 col-form-label'>우편번호</label> 
<div class='col-sm-5'> 
<input class='form-control' style='display:inline-block;width:300px;' id='sample6_postcode' type='text' name='postNo' value='${user.postNo}'>
</div>
<div style='width:50px;'></div>
<input type="button" style='display:inline-block;width:185px;' onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
</div> 


<div class='form-group row'> 
<label for='sample6_address' class='col-sm-2 col-form-label'>기본주소</label> 
<div class='col-sm-10'> 
<input class='form-control' style='width:510px;' id='sample6_address' type='text' name='baseAddress' value='${user.baseAddress}'>
</div> 
</div> 

<div class='form-group row'> 
<label for='sample6_address2' class='col-sm-2 col-form-label'>상세주소</label> 
<div class='col-sm-10'> 
<input class='form-control' style='width:510px;' id='sample6_address2' type='text' name='detailAddress' value='${user.detailAddress}'>
</div> 
</div> 


<div class='col-sm-10'>
<div style='width:280px;height:40px;display:inline-block;'></div> 
<button class="btn btn-primary">수정</button> 
<%-- 삭제버튼숨김
<a href='delete?no=${account.accountsNo}' class= "btn btn-danger ">삭제</a>
--%>
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

<%-- 비밀번호 확인 스크립트--%>
<script type="text/javascript">
    function tocheckpw1() {
        var pw = document.getElementById("password").value;
        var pwck = document.getElementById("checkpwd").value;
 
        if (pw != pwck) {
            alert('비밀번호가 틀렸습니다. 다시 입력해 주세요');
            return false;
        }
    }
</script>

<script type="text/javascript">
function folding1() {
    if (f1.style.display == 'none') {
        f1.style.display = '';
        f2.style.display = 'none';
        f3.style.display = 'none';
    } else {
        f1.style.display = 'none';
        
    }
}
function folding2() {
    if (f2.style.display == 'none') {
        f2.style.display = '';
        f1.style.display = 'none';
        f3.style.display = 'none';
    } else {
        f2.style.display = 'none';
    }
}
function folding3() {
    if (f3.style.display == 'none') {
        f3.style.display = '';
        f1.style.display = 'none';
        f2.style.display = 'none';
    } else {
        f3.style.display = 'none';
    }
}
</script>
<jsp:include page="../jslib.jsp" />
</body>
</html>
