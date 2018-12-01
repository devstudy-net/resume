<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" 	uri="http://www.springframework.org/security/tags" %>

<div class="panel panel-info small-center-block">
	<div class="panel-heading">
		<h3 class="panel-title">
			<i class="fa fa-unlock"></i> Восстановление доступа
		</h3>
	</div>
	<div class="panel-body">
		<form action="/restore" method="post">
			<sec:csrfInput/>
			<div class="form-group">
				<label for="uid">Введите Ваш UID или Email или Phone</label> 
				<input id="uid" name="uid" class="form-control" required="required" placeholder="UID или Email или Phone">
			</div>
			<button type="submit" class="btn btn-primary">Восстановить</button>
		</form>
	</div>
</div>