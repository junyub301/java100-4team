<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>

    
<div class='container1'>

<%-- <jsp:include page="../header.jsp"/> --%>


<form action="login" method='post'> 

<div class='form-group row'>
    <label for='accountName' class='col-sm-2 col-form-label'>아이디</label>
    <div class='col-sm-10'>
    <input class='form-control' id='accountName' type='text' 
           name='accountName' value='${cookie.accountName.value}'>
    </div>
</div>

<div class='form-group row'>
    <label for='password' class='col-sm-2 col-form-label'>암호</label>
    <div class='col-sm-10'>
    <input class='form-control' id='password' type='password' name='password'>
    </div>
</div>

<div class='form-group row'>
    <div class="col-sm-2"></div>
    <div class="col-sm-10">
      <div class="form-check">
        <input type="checkbox" class="form-check-input"
               id="saveaccountName" name="saveaccountName">
        <label class="form-check-label" for="saveaccountName">아이디 저장</label>
      </div>
    </div>
</div> 

<div class='form-group row'>
    <div class='col-sm-10'>
    <button onclick="location='list.jsp'" class='btn btn-primary btn-sm'>로그인</button>
    </div>
</div>
<div class='form-group row'>
    <div class='col-sm-10'>
    <button onclick="location='form.jsp'" class='btn btn-primary btn-sm'>회원가입</button>
    </div>
</div>

</form>
<%-- 
<jsp:include page="../footer.jsp"/> --%>

</div>

<jsp:include page="../jslib.jsp"/>

</body>
</html>
    