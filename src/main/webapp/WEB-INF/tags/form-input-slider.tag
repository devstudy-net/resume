<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="index" 		required="true"  type="java.lang.Object" %>
<%@ attribute name="value" 		required="true"  type="java.lang.Object" %>

<%-- Using cache for slider data --%>
<c:if test="${languageLevelKeys == null or languageLevelValues == null}">
	<c:set var="languageLevelKeys" value="[" scope="request" />
	<c:set var="languageLevelValues" value="[" scope="request" />
	<c:forEach var="level" items="${languageLevels }" varStatus="status">
		<c:set var="languageLevelKeys"   value='${languageLevelKeys}${level.sliderIntValue }${status.last ? "]" : "," }' scope="request" />
		<c:set var="languageLevelValues" value='${languageLevelValues }"${level.caption }"${status.last ? "]" : "," }' scope="request" />
	</c:forEach>
</c:if>

<input name="items[${index }].level" id="items${index }level" style="width: 100%;" class="level-slider"  
	data-slider-ticks="${languageLevelKeys }" data-slider-value="${value}" data-provide="slider" data-slider-handle="square" 
	data-slider-ticks-labels='${languageLevelValues }' data-slider-min="1" data-slider-max="7" data-slider-step="1" data-slider-tooltip="hide">