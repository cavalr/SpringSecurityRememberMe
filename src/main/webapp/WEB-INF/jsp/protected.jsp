<%@ include file="common/header.jsp" %>

	<div class="link">
		<h3>This is resource is protected.</h3>
		<security:authorize access="isAuthenticated()">
			Logged in as user <b><security:authentication property="principal.username" /></b>,
			Click to <a href="<c:url value='/j_spring_security_logout' />" class="sign_ic">Logout</a>
		</security:authorize>
	</div>

<%@ include file="common/footer.jsp" %>
