<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<c:choose>
	<c:when test="${production }">
		<link rel="stylesheet" href="/static/css/resume-common.min.css?v=${cssCommonVersion }">
		<sec:authorize access="isAuthenticated()">
			<link rel="stylesheet" href="/static/css/resume-ex.min.css?v=${cssExVersion }">
		</sec:authorize>
	</c:when>
	<c:otherwise>
		<link rel="stylesheet" href="/static/css/bootstrap-3.3.6.css">
		<link rel="stylesheet" href="/static/css/font-awesome-4.5.0.css">
		<link rel="stylesheet" href="/static/css/bootstrap-theme-3.3.6.css">
		<link rel="stylesheet" href="/static/css/timeline.css">
		<link rel="stylesheet" href="/static/css/app.css" />
		<link rel="stylesheet" href="/static/css/bootstrap-slider-6.1.6.css">
		<link rel="stylesheet" href="/static/css/bootstrap-datepicker-1.6.0.css">
		<link rel="stylesheet" href="/static/css/fileinput-4.3.2.css">
	</c:otherwise>
</c:choose>