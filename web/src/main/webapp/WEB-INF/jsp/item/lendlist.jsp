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
<jsp:include page="../header.jsp"/>
        <div class='container'>
        <div class='row justify-content-md-center'>
            <button class="col-sm-5 btn btn-primary"
                onclick="location.href='list'">빌려드립니다</button>
            <div class="col-sm-2"></div>
            <button class="col-sm-5 btn btn-primary"
                onclick="location.href='lendlist'">빌려주세요</button>
        </div>
        </div>
    
<div class="album py-5">
    <div class='container'>
        <div class='row'>
         <c:forEach items="${list}" var="item">
            <c:set var="userType" value="${item.userType}"/>
              <c:if test="${userType eq 1}">
              
            <div class="col-md-4 m_pointer" onclick="location.href='${item.itemNo}'">
              <div class="card mb-4 box-shadow">

              <img class="card-img-top"
                            data-src="holder.js/300x200?theme=thumb"
                            alt="Thumbnail [300x200]"
                            style="height: 225px; width: 100%; display: block;"
                            <c:forEach items="${item.photos}" var="photo">
                                src="${contextPath}/download/${photo.photoName}"
                            </c:forEach>
                            data-holder-rendered="true">
                
                <div class="card-body">
                <h3 class="mb-0">
                  <p class="card-text text-truncate">${item.title}</p></h3>
                  <p class="card-text text-truncate">${item.content}</p>
                  <p class="card-text text-truncate">${item.name}</p>
                  <div class="d-flex justify-content-between align-items-center">
                    <!-- <div class="btn-group">
                      <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                      <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
                    </div>
                    <small class="text-muted">9 mins</small> -->
                  </div>
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
        </div>
            <nav aria-label="Page navigation">
            <ul class="pagination justify-content-center">
                <li class="page-item ${prevPageDisabled}"><a class="page-link"
                    href="lendlist?pn=${pageNo - 1}" tabindex="${prevPageTabIndex}">이전</a></li>

                <li class="page-item"><a class="page-link" href="#">${pageNo}</a></li>

                <li class="page-item ${nextPageDisabled}"><a class="page-link"
                    href="lendlist?pn=${pageNo + 1}" tabindex="${nextPageTabIndex}">다음</a></li>
            </ul>
        </nav>
    <style>
      .m_pointer{
        cursor: pointer;
      }
    </style>
      
</body>
</html>
