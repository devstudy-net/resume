<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="resume" tagdir="/WEB-INF/tags"%>

<div class="row profiles">
	<div id="profileContainer" class="col-xs-12" data-profile-total="${page.totalPages }" data-profile-number="${page.number }">
		<jsp:include page="fragment/profile-items.jsp" />
	</div>
	<c:if test="${page.number < page.totalPages - 1}">
	<div id="loadMoreContainer" class="col-xs-12 text-center">
		<a href="javascript:resume.moreProfiles();" class="btn btn-primary">Load more</a>
	</div>
	<div id="loadMoreIndicator" class="col-xs-12 text-center" style="display:none;">
		<img src="/static/img/large-loading.gif" alt="loading..."/>
	</div>
	</c:if>
</div>