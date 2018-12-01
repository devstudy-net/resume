<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"      	uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume" 	tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags" %> 

<%@ attribute name="index" 		required="true"  type="java.lang.Object" %>
<%@ attribute name="language" 	required="false" type="net.devstudy.resume.domain.Language" %>

<div id="ui-item-${index }" class="panel panel-default">
	<div class="panel-body ui-item">
		<div class="row">
			<div class="col-xs-12">
				<button type="button" class="close" onclick="$('#ui-item-${index }').remove();"><span aria-hidden="true">&times;</span></button>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12 col-md-3 form-group">
				<div class="row">
					<div class="col-xs-6 form-group" style="padding-right:0px;">
						<label for="items${index }type">Тип</label> 
						<select name="items[${index }].type" class="form-control" >
						<c:forEach var="languageType" items="${languageTypes }">
						<option value="${languageType.dbValue }" ${languageType == language.type ? 'selected="selected"' : '' }>
							<spring:message code="LanguageType.${languageType}" />
						</option>
						</c:forEach>
						</select>
					</div>
					<c:if test="${language != null }"><resume:form-has-error path="items[${index }].name"/></c:if>
					<div class="col-xs-6 form-group ${hasError ? 'has-error has-feedback' : ''}" style="padding-right:8px;">
						<label class="control-label" for="items${index }name">Язык</label> 
						<input class="form-control" name="items[${index }].name" id="items${index }name" placeholder="Example: English" value="${language.name }" required="required">
						<c:if test="${language != null }">
						<resume:form-error path="items[${index }].name"/>
						</c:if>
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-md-9">
				<label for="items${index }level">Уровень</label> 
				<div style="padding: 0 30px;">
					<resume:form-input-slider index="${index }" value="${language != null ? language.level.sliderIntValue : 4}" />
				</div>
			</div>
		</div>
	</div>
</div>