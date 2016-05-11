<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="profile" items="${profiles }">
	<div class="panel panel-default profile-item">
		<div class="media panel-body">
			<div class="media-left media-top">
				<a href="/${profile.uid }"><img alt="${profile.fullName }" src="${profile.smallPhoto }" class="photo"></a>
			</div>
			<div class="media-body search-result-item">
				<a href="/${profile.uid }" class="btn btn-primary pull-right">Детали</a>
				<h4 class="media-heading">
					<a href="/${profile.uid }">${profile.id}) ${profile.fullName }, ${profile.age }</a>
				</h4>
				<strong>${profile.objective }</strong>
				<p>${profile.city },${profile.country }</p>
				<blockquote>
					<small>${profile.summary }</small>
				</blockquote>
			</div>
		</div>
	</div>
</c:forEach>