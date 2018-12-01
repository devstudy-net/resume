<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="resume" tagdir="/WEB-INF/tags"%>

<%@ attribute name="certificates" required="true" type="java.util.List" %>
<%@ attribute name="showEdit"  required="false" type="java.lang.Boolean" %>

<div class="panel panel-primary certificates">
	<div class="panel-heading">
		<h3 class="panel-title">
			<i class="fa fa-certificate"></i> Certificates
			<c:if test="${showEdit }"><a href="/edit/certificates" class="edit-block">Edit</a></c:if>
		</h3>
	</div>
	<div class="panel-body">
		<c:forEach var="certificate" items="${certificates }">
		<a class="thumbnail certificate-link" href="#" data-title="${certificate.name }" data-url="${certificate.largeUrl }"> 
			<img class="img-responsive" src="${certificate.smallUrl }" alt="${certificate.name }">
			<span>${certificate.name }</span>
		</a>
		</c:forEach>
	</div>
</div>

<resume:certificate-viewer />