<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
</style>
<title>리스트</title>
<link rel="stylesheet"
	href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../..css/common.css'>
</head>
<body>
	<div class='container'>
		<div style="width: 700px; margin: auto"
			class='row justify-content-md-center'>
			<button class="col-sm-5 btn btn-primary"
				onclick="location.href='rentlist'">빌려드립니다</button>
			<div class="col-sm-2"></div>
			<button class="col-sm-5 btn btn-primary"
				onclick="location.href='lendlist'">빌려주세요</button>
		</div>
		<c:forEach items="${list}" var="item">
			<c:set var="userType" value="${item.userType}" />
				<c:if test="${userType eq 0}">
					<div style="display: inline-block" class="col-md-6">
						<div class="card flex-md-row mb-4 box-shadow h-md-250">
							<div class="card-body d-flex flex-column align-items-start">
								<strong class="d-inline-block mb-2 text-primary">${item.itemNo}</strong>
								<h3 class="mb-0">
									<a class="text-dark" href="#">${item.name}</a>
								</h3>
								<div class="mb-1 text-muted">${item.startDate}-${item.endDate}</div>
								<p class="card-text mb-auto">${item.content}</p>
								<a href="#">Continue reading</a>
							</div>
							<a href=""></a> <img
								class="card-img-right flex-auto d-none d-md-block"
								data-src="holder.js/200x250?theme=thumb"
								alt="Thumbnail [200x250]" style="width: 200px; height: 250px;"
								src="${contextPath}/download/${item.photos.photoName}"
								data-holder-rendered="true">
						</div>
					</div>
				</c:if>
		</c:forEach>
		<jsp:include page="../paging.jsp" />
	</div>
</body>
</html>
