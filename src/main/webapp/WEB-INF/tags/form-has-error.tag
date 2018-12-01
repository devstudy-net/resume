<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 

<%@ attribute name="path" 		required="true"  type="java.lang.String" %>

<spring:bind path="${path }">
	<c:set var="hasError" value="${status.error}" scope="request"/>
</spring:bind>