<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ attribute name="practics" required="true" type="java.util.List" %>
<%@ attribute name="showEdit"  required="false" type="java.lang.Boolean" %>

<div class="panel panel-primary">
	<div class="panel-heading">
		<h3 class="panel-title">
			<i class="fa fa-briefcase"></i> Practic Experience
			<c:if test="${showEdit }"><a href="/edit/practics" class="edit-block">Edit</a></c:if>
		</h3>
	</div>
	<div class="panel-body">
		<ul class="timeline">
			<c:forEach var="practic" items="${practics }">
			<li>
				<div class="timeline-badge danger">
					<i class="fa fa-briefcase"></i>
				</div>
				<div class="timeline-panel">
					<div class="timeline-heading">
						<h4 class="timeline-title">${practic.position } at ${practic.company }</h4>
						<p>
							<small class="dates"><i class="fa fa-calendar"></i> 
								<fmt:formatDate value="${practic.beginDate }" pattern="MMM yyyy"/> - 
								<c:choose>
								<c:when test="${practic.finish }">
								<fmt:formatDate value="${practic.finishDate }" pattern="MMM yyyy"/>
								</c:when>
								<c:otherwise>
								<strong class="label label-danger">Current</strong>
								</c:otherwise>
								</c:choose>
							</small>
						</p>
					</div>
					<div class="timeline-body">
						<p>
							<strong>Responsibilities included:</strong> ${practic.responsibilities }
						</p>
						<c:if test="${practic.demo != null }">
						<p>
							<strong>Demo: </strong><a href="${practic.demo}">${practic.demo}</a>
						</p>
						</c:if>
						<c:if test="${practic.src != null }">
						<p>
							<strong>Source code: </strong><a href="${practic.src}">${practic.src}</a>
						</p>
						</c:if>
					</div>
				</div>
			</li>
			</c:forEach>
		</ul>
	</div>
</div>
