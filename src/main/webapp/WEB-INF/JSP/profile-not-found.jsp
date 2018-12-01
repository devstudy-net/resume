<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="resume" tagdir="/WEB-INF/tags"%>
<div id="profile-not-found" class="row profile">
	<div class="col-xs-12 col-sm-6 col-md-4">
		<div class="panel panel-primary">
			<img alt="photo" src="/static/img/profile-not-found.png" class="img-responsive photo">
		</div>
	</div>
	<div class="col-xs-12 col-sm-6 col-md-8">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="fa fa-exclamation-circle"></i> Oops
				</h3>
			</div>
			<div class="panel-body">
				<h4>Profile not found</h4>
			</div>
		</div>
	</div>
</div>