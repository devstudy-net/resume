<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="profile" required="true" type="net.devstudy.resume.domain.Profile" %>
<%@ attribute name="showEdit"  required="false" type="java.lang.Boolean" %>

<div class="panel panel-primary">
	<div class="panel-heading">
		<h3 class="panel-title">
			<i class="fa fa-info-circle"></i> Additional info
			<c:if test="${showEdit }"><a href="/edit/info" class="edit-block">Edit</a></c:if>
		</h3>
	</div>
	<div class="panel-body text-justify">
		${profile.info }
	</div>
</div>