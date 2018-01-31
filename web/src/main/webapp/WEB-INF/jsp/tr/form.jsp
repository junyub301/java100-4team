<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<title>거래현황</title>
<link rel="stylesheet" href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
</head>
<body>
<h1 align="center">거래현황 임시등록 </h1>
<br><br>

<div style="width: 700px;" class='container'>

<form action="add" method="post">

<%--대여자번호(로그인사용자)--%>
<input id='lenderNo' class="form-control" type="hidden" name='lenderNo' value='${sessionScope.loginUser.accountsNo}'>

<%--아직 미구현 
<input id='itemNo' class="form-control" type="hidden" placeholder="아이템번호" name='itemNo'>--%>
 
<div class="form-group row">
<label class="col-sm-2 col-form-label" for="requestDate">신청일</label>
<div class="col-sm-10">
<input id='requestDate' class="form-control" type="date" placeholder="신청일" name='requestDate'>
</div>
</div>

<%--임시로 결제방법 1~3 번호선택 --%>
<div class="form-group row">
<label class="col-sm-2 col-form-label" for="payMethod">결제유형</label>
<div class="col-sm-10">
<input id='payMethod' class="form-control" type="number" min="1" max="3" placeholder="결제유형" name='payMethod'>
</div>
</div>
 
<div class="form-group row">
<label class="col-sm-2 col-form-label" for="payDate">결제일</label>
<div class="col-sm-10">
<input id='payDate' class="form-control" type="date" placeholder="결제일" name='payDate'>
</div>
</div>

<%--배송비 결제유형 2가지방법 선택 --%>
<div class="form-group row">
<label class="col-sm-2 col-form-label" for="deliveryPayType">배송비결제유형</label>
<div class="col-sm-10">
<input id='deliveryPayType' class="form-control" type="number" min="0" max="1" placeholder="배송비결제유형" name='deliveryPayType'>
</div>
</div>
 
<div class="form-group row">
<label class="col-sm-2 col-form-label" for="deliveryNo">운송장번호</label>
<div class="col-sm-10">
<input id='deliveryNo' class="form-control" type="number" min="1" placeholder="운송장번호" name='deliveryNo'>
</div>
</div>
 
<div class="form-group row">
<label class="col-sm-2 col-form-label" for="deliveryDate">배송일</label>
<div class="col-sm-10">
<input id='deliveryDate' class="form-control" type="date" placeholder="배송일" name='deliveryDate'>
</div>
</div>
 
<div class='row justify-content-md-center'>
<button style='width:200px;'class="btn btn-primary">전송</button>
</div>

</form>

</div>

</body>
</html>
    