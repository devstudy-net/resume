<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"      	uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume" 	tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags" %> 

<%@ attribute name="index"   required="true" type="java.lang.Object"%>
<%@ attribute name="course" required="false" type="net.devstudy.resume.domain.Course"%>

<div id="ui-item-${index }" class="panel panel-default">
	<div class="panel-body ui-item">
		<div class="row">
			<div class="col-xs-12">
				<button type="button" class="close" onclick="$('#ui-item-${index }').remove();">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</div>
		<div class="row">
			<c:if test="${course != null }"><resume:form-has-error path="items[${index }].name"/></c:if>
			<div class="col-xs-6 col-md-4 form-group ${hasError ? 'has-error has-feedback' : ''}">
				<label class="control-label" for="items${index }name">Название курса*</label> 
				<input class="form-control" name="items[${index }].name" id="items${index }name" 
										placeholder="Example: Java Advanced" value="${course.name }" required="required">
				<c:if test="${course != null }">
				<resume:form-error path="items[${index }].name" />
				</c:if>
			</div>
			<c:if test="${course != null }"><resume:form-has-error path="items[${index }].school"/></c:if>
			<div class="col-xs-6 col-md-4 form-group ${hasError ? 'has-error has-feedback' : ''}">
				<label class="control-label" for="items${index }school">Название школы / площадки*</label> 
				<input class="form-control" name="items[${index }].school" id="items${index }.school" 
										placeholder="Example: SourceIt" value="${course.school }" required="required">
				<c:if test="${course != null }">
				<resume:form-error path="items[${index }].school" />
				</c:if>
			</div>
			<div class="col-xs-12 col-md-4 form-group">
				<label for="items${index }finishDate">Дата окончания</label> 
				<div class="row">
					<div class="col-xs-6">
						<select id="items${index }finishDateMonth" name="items[${index }].finishDateMonth" class="form-control" onchange="resume.ui.updateSelect($(this))" data-ref-select="items${index }finishDateYear">
						<option value="">Not finished yet</option>
						<c:forEach var="month" items="${months }">
						<option value="${month.key }" ${month.key == course.finishDateMonth ? 'selected="selected"' : '' }>${month.value }</option>
						</c:forEach>
						</select>
					</div>
					<div class="col-xs-6">
						<select id="items${index }finishDateYear" name="items[${index }].finishDateYear" class="form-control" onchange="resume.ui.updateSelect($(this))" data-ref-select="items${index }finishDateMonth">
						<option value="">Not finished yet</option>
						<c:forEach var="year" items="${years }">
						<option value="${year }" ${year == course.finishDateYear ? 'selected="selected"' : '' }>${year }</option>
						</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>