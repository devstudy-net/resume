<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" 	uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="resume" 	tagdir="/WEB-INF/tags"%>

<resume:edit-tab-header selected="courses" />

<div class="panel panel-default">
	<div class="panel-body">
		<h4 class="data-header">Курсы повышения квалификации</h4>
		<h6 class="text-center help-block">(Упорядоченные по убыванию)</h6>
		<hr />
		<resume:form-display-error-if-invalid formName="courseForm" />
		<form:form action="/edit/courses" method="post" commandName="courseForm">
			<sec:csrfInput/>
			<div id="ui-block-container">
				<c:forEach var="course" items="${courseForm.items}" varStatus="status">
					<resume:edit-course-block index="${status.index}" course="${course }" />
				</c:forEach>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<a href="javascript:resume.ui.addBlock();">+ Добавить курс</a>
				</div>
			</div>
			<hr />
			<div class="row">
				<div class="col-xs-12 text-center">
					<input type="submit" class="btn btn-primary" value="Сохранить">
				</div>
			</div>
		</form:form>
	</div>
</div>
<script id="ui-block-template" type="text/x-handlebars-template">
	<resume:edit-course-block index="{{blockIndex}}" />
</script>