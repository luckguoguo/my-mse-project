<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<h2><@spring.messageText "login.label.title", "Please Login" /></h2>
<form id="loginForm" action="" method="POST">
<#if globalErrorMessage??>
<div class="error">
	${globalErrorMessage}
</div>
</#if>
<table>
	<tr>
		<td><@spring.messageText "login.label.username", "Login Name" /></td>
		<td>
			<@spring.bind "loginForm.username" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "login.label.password", "Password" /></td>
		<td>
			<@spring.bind "loginForm.password" />
			<input type="password" name="${spring.status.expression}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td></td>
		<td>
			<input type="submit" value="<@spring.messageText "login.label.submit", "Login" />" />
			<a href="adminRequestTempPassword"><@spring.messageText "login.label.requestTempPassword", "RequestTempPassword" />
		</a></td>
	</tr>
</table>
</form>