<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="hobbies" required="true" type="java.util.List" %>
<%@ attribute name="showEdit"  required="false" type="java.lang.Boolean" %>

<div class="panel panel-primary">
	<div class="panel-heading">
		<h3 class="panel-title">
			<i class="fa fa-heart"></i> Hobbi
			<c:if test="${showEdit }"><a href="/edit/hobby" class="edit-block">Edit</a></c:if>
		</h3>
	</div>
	<div class="panel-body">
		<div class="hobbies">
			<table class="table table-bordered">
				<c:forEach var="hobby" items="${hobbies }">
				<tr>
					<td><i class="fa hobby hobby-${hobby.cssClassName }"></i></td>
					<td>${hobby.name }</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>