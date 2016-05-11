<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="resume" tagdir="/WEB-INF/tags" %>

<div class="container">
	<div class="row">
		<div class="col-md-4 col-sm-6">
			<resume:profile-main />
			<div class="hidden-xs">
				<resume:profile-languages />
				<resume:profile-hobbies />
				<resume:profile-info />
			</div>
		</div>
		<div class="col-md-8 col-sm-6">
			<resume:profile-objective/>
			<resume:profile-skills />
			<resume:profile-practics />
			<resume:profile-certificates/>
			<resume:profile-cources/>
			<resume:profile-education />
		</div>
		<div class="col-xs-12 visible-xs-block">
			<resume:profile-languages />
			<resume:profile-hobbies />
			<resume:profile-info />
		</div>
	</div>
</div>