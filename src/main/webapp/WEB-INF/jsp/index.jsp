<%@ include file="common/header.jsp" %>

	<div class="link">
		<security:authorize access="isAnonymous()">
			Not logged in yet, Click to <a href="<c:url value='/login' />" id="show">Login</a>
		</security:authorize>

		<security:authorize access="isAuthenticated()">
			Logged in as user <b><security:authentication property="principal.username" /></b>, 
			Click to <a href="<c:url value='/j_spring_security_logout' />" class="sign_ic">Logout</a>
		</security:authorize>

		<p><a href="<c:url value='/protected' />">Access Protected Resource</a></p>
	</div>

<%@ include file="common/footer.jsp" %>
