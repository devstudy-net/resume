<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ attribute name="index"    required="true"  type="java.lang.Object"%>
<%@ attribute name="id"       required="false" type="java.lang.Object"%>
<%@ attribute name="smallUrl" required="false" type="java.lang.String"%>
<%@ attribute name="largeUrl" required="false" type="java.lang.String"%>
<%@ attribute name="name"     required="false" type="java.lang.String"%>

<div id="ui-item-${index }" class="thumbnail ui-item">
	<input type="hidden" name="items[${index }].id" 		value="${id }" />
	<input type="hidden" name="items[${index }].smallUrl" 	value="${smallUrl }" />
	<input type="hidden" name="items[${index }].largeUrl" 	value="${largeUrl }" />
	<input type="hidden" name="items[${index }].name" 		value="${name }" />
	
	<button type="button" class="close" onclick="$('#ui-item-${index }').remove();">
		<span aria-hidden="true">&times;</span>
	</button>
	<a class="certificate-link" href="#" data-title="${name }" data-url="${largeUrl }"> 
		<img class="img-responsive" src="${largeUrl }" alt="${name }">
		<span>${name }</span>
	</a>
</div>