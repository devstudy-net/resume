<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 	   	uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" 	uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="resume" 	tagdir="/WEB-INF/tags"%>

<spring:eval expression="@properties.getProperty('profile.hobbies.max')" var="maxHobbies"/>
<resume:edit-tab-header selected="hobbies" />

<div id="hobbyContainer" class="panel panel-default" data-csrf-value="${_csrf.token}">
	<div class="panel-body">
		<h4 class="data-header">Некоторые работодатели уделяют внимание на хобби кандидата</h4>
		<h6 class="text-center help-block">Выберите не более ${maxHobbies} пунктов!</h6>
		<hr />
		<div id="ui-block-container" class="row" data-max-hobbies="${maxHobbies}">
			<c:forEach var="hobby" items="${hobbies }">
				<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
					<button type="button" class="btn btn-block btn-default hobby-btn ${hobby.selected ? 'active' : '' }" 
						data-hobby="${hobby.name }" data-toggle="button" aria-pressed="false">
						<i class="fa hobby hobby-${hobby.cssClassName }"></i>${hobby.name }
					</button>
				</div>
			</c:forEach>
		</div>
		<hr />
		<div id="errorAlert" class="alert alert-danger" role="alert" style="display:none;">
			<button type="button" class="close" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			<strong>Ошибка сохранения!</strong> Выберите не более ${maxHobbies} пунктов!
		</div>
		<div class="row">
			<div class="col-xs-12 text-center">
				<a href="javascript:resume.hobbies.save();" class="btn btn-primary">Сохранить</a>
			</div>
		</div>
	</div>
</div>