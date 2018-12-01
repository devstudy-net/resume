<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ attribute name="educations" required="true" type="java.util.List" %>
<%@ attribute name="showEdit"  required="false" type="java.lang.Boolean" %>

<div class="panel panel-primary">
	<div class="panel-heading">
		<h3 class="panel-title">
			<i class="fa fa-graduation-cap"></i> Education
			<c:if test="${showEdit }"><a href="/edit/education" class="edit-block">Edit</a></c:if>
		</h3>
	</div>
	<div class="panel-body">
		<ul class="timeline">
			<c:forEach var="education" items="${educations }">
			<li>
				<div class="timeline-badge warning">
					<i class="fa fa-graduation-cap"></i>
				</div>
				<div class="timeline-panel">
					<div class="timeline-heading">
						<h4 class="timeline-title">${education.summary }</h4>
						<p>
							<small class="dates"><i class="fa fa-calendar"></i> 
								${education.beginYear } - 
								<c:choose>
								<c:when test="${education.finish }">
								${education.finishYear }
								</c:when>
								<c:otherwise>
								<strong class="label label-danger">Current</strong>
								</c:otherwise>
								</c:choose>
							</small>
						</p>
					</div>
					<div class="timeline-body">
						<p>${education.faculty }, ${education.university }</p>
					</div>
				</div>
			</li>
			</c:forEach>
		</ul>
	</div>
</div>