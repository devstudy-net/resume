<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="skills" required="true" type="java.util.List" %>
<%@ attribute name="showEdit"  required="false" type="java.lang.Boolean" %>

<div class="panel panel-primary">
	<div class="panel-heading">
		<h3 class="panel-title">
			<i class="fa fa-code"></i> Technical Skills
			<c:if test="${showEdit }"><a href="/edit/skills" class="edit-block">Edit</a></c:if>
		</h3>
	</div>
	<div class="panel-body">
		<table class="table table-striped table-bordered">
			<tr>
				<th style="width: 140px;">Category</th>
				<th>Frameworks and technologies</th>
			</tr>
			<c:forEach var="skill" items="${skills }">
			<tr>
				<td>${skill.category }</td>
				<td>${skill.value }</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</div>