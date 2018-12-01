<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>

<%@ attribute name="path" 		 required="true"  type="java.lang.String" %>
<%@ attribute name="displayIcon" required="false" type="java.lang.Boolean" %>

<c:if test="${displayIcon == null or displayIcon }">
<spring:bind path="${path }">
	<c:if test="${status.error}">
	<span class="glyphicon glyphicon-exclamation-sign form-control-feedback" aria-hidden="true"></span>
	</c:if>
</spring:bind>
</c:if>
<form:errors path="${path }" cssClass="alert alert-danger" element="div" />