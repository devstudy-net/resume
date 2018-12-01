<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<c:choose>
	<c:when test="${production }">
		<script src="/static/js/resume-common.min.js?v=${jsCommonVersion }"></script>
		<sec:authorize access="isAuthenticated()">
			<script src="/static/js/resume-ex.min.js?v=${jsExVersion }"></script>
		</sec:authorize>
	</c:when>
	<c:otherwise>
		<script src="/static/js/jquery-2.2.2.js"></script>
		<script src="/static/js/bootstrap-3.3.6.js"></script>
		<script src="/static/js/bootstrap-slider-6.1.6.js"></script>
		<script src="/static/js/handlebars-4.0.5.js"></script>
		<script src="/static/js/bootstrap-datepicker-1.6.0.js"></script>
		<script src="/static/js/fileinput-4.3.2.js"></script>
		<script src="/static/js/app.js"></script>
	</c:otherwise>
</c:choose>
<script src="/static/js/messages.jsp?v=${jsMessagesVersion }"></script>