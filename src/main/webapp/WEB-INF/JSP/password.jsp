<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="resume" 	tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %> 

<div class="panel panel-info small-center-block">
	<div class="panel-heading">
		<h3 class="panel-title">
			<i class="fa fa-unlock-alt"></i> Новый пароль для аккаунта
		</h3>
	</div>
	<div class="panel-body edit-password">
	    <resume:form-display-error-if-invalid formName="passwordForm" />
		<form:form action="/edit/password" commandName="passwordForm" method="post">
			<div class="help-block">Введите Ваш новый пароль и подтвердите его </div>
			<resume:form-has-error path="password"/>
			<div class="form-group ${hasError ? 'has-error has-feedback' : ''}">
				<label class="control-label" for="password">Новый пароль</label> 
				<form:password path="password" id="password" cssClass="form-control" required="required"/>
				<resume:form-error path="password" />
			</div>
			
			<resume:form-has-error path="confirmPassword"/>
			<div class="form-group ${hasError ? 'has-error has-feedback' : ''}">
				<label class="control-label" for="confirmPassword">Подтверждение пароля</label> 
				<form:password path="confirmPassword" id="confirmPassword" cssClass="form-control" required="required"/>
				<resume:form-error path="confirmPassword" />
			</div>
			<button type="submit" class="btn btn-primary">Обновить пароль</button>
		</form:form>
	</div>
</div>