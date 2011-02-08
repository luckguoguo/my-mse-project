<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<h2><@spring.messageText "requestTempPassword.form.label.title", "Request Temp Password" /></h2>
<form id="tempPasswordForm" action="" method="POST">
<#if globalErrorMessage??>
<div class="error">
	${globalErrorMessage}
</div>
</#if>
<table>
	<tr>
		<td><@spring.messageText "requestTempPassword.form.label.username", "Username" /></td>
		<td>
			<@spring.bind "tempPasswordForm.username" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td></td>
		<td>
			<input type="submit" value="<@spring.messageText "requestTempPassword.form.label.submit", "Submit" />" />
			<a href="login"><@spring.messageText "requestTempPassword.form.return", "Return" /></a>
		</td>
	</tr>
</table>
</form>