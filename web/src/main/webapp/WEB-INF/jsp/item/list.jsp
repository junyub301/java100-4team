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
<!-- <link rel='stylesheet' href='../..css/common.css'> -->
</head>
<body>
<jsp:include page="../header.jsp"/>

		<div style="width: 700px; margin: auto"
			class='row justify-content-md-center'>
			<button class="col-sm-5 btn btn-primary"
				onclick="location.href='list'">빌려드립니다</button>
			<div class="col-sm-2"></div>
			<button class="col-sm-5 btn btn-primary"
				onclick="location.href='lendlist'">빌려주세요</button>
		</div>
	<div class='itembox_container'>
		
		<c:forEach items="${list}" var="item">
			<c:set var="userType" value="${item.userType}"/>
			  <c:if test="${userType eq 0}">
				<div style="display: inline; cursor: pointer;" onclick="location.href='${item.itemNo}'">
					<div class="itembox">
						<div class="">
							<%-- <strong class="d-inline-block mb-2 text-primary">${item.itemNo}</strong> --%>
						    <img
							class="itemimg"
							data-src="holder.js/300x200?theme=thumb"
							alt="Thumbnail [300x200]"
							<c:forEach items="${item.photos}" var="photo">
								src="${contextPath}/download/${photo.photoName}"
                            </c:forEach>
							data-holder-rendered="true">
							<h3 class="mb-0">
								<a class="box_text" href="#">${item.title}</a>
							</h3>
							<div class="mb-1 text-muted">${item.startDate}-${item.endDate}</div>
							<p class="box_text">${item.content}</p>
							<a href="#">${item.name}</a>
						</div>
					</div>
				</div>
			 </c:if>
		</c:forEach>
		
		<c:set var="prevPageDisabled" value="${(pageNo > 1) ? '':'disabled'}" />
		<c:set var="prevPageTabIndex" value="${(pageNo > 1) ? 0 : -1}" />
		<c:set var="nextPageDisabled"
			value="${(pageNo < lastPageNo) ? '':'disabled'}" />
		<c:set var="nextPageTabIndex"
			value="${(pageNo < lastPageNo) ? 0 : -1}" />

	</div>
		<nav style="position: fixed; left:0px; right:0px;" aria-label="Page navigation">
			<ul class="pagination justify-content-center">
				<li class="page-item ${prevPageDisabled}"><a class="page-link"
					href="list?pn=${pageNo - 1}" tabindex="${prevPageTabIndex}">이전</a></li>

				<li class="page-item"><a class="page-link" href="#">${pageNo}</a></li>

				<li class="page-item ${nextPageDisabled}"><a class="page-link"
					href="list?pn=${pageNo + 1}" tabindex="${nextPageTabIndex}">다음</a></li>
			</ul>
		</nav>
</body>
</html>
