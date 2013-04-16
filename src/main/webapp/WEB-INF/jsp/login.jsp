<%@ include file="common/header.jsp" %>

<div class="login">
	<h2>Log In</h2>
	<c:if test="${param.login_error == 1}">
		<div class="error">Login Failed: Invalid username or password</div>
	</c:if>
	<form id="signin" action="<c:url value='/j_spring_security_check'/>" method="POST">
		<label>UserName</label>
		<input type="text" name="j_username" />
		<label>Password</label>
		<input type="password" name="j_password"  />
		<div><input type="checkbox" name="_spring_security_remember_me" />Remember Me</div>
		<button type="submit">Login</button>
	</form>
</div>

<%@ include file="common/footer.jsp" %>
