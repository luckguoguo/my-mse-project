<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<h2><a href="###"><@spring.messageText "admin.password.form.title", "Update Password" /></a></h2>
<form id="passwordForm" action="" method="POST">
<#if globalErrorMessage??>
<div class="error">
	${globalErrorMessage}
</div>
</#if>
<table>
	<tr>
		<td><@spring.messageText "admin.password.form.label.origPassword", "Original Password" /></td>
		<td>
			<@spring.bind "passwordForm.origPassword" />
			<input type="password" name="${spring.status.expression}" value="" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.password.form.label.newPassword", "New Password" /></td>
		<td>
			<@spring.bind "passwordForm.newPassword" />
			<input type="password" name="${spring.status.expression}" value="" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.password.form.label.confirmNewPassword", "Confirm New Password" /></td>
		<td>
			<@spring.bind "passwordForm.confirmNewPassword" />
			<input type="password" name="${spring.status.expression}" value="" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td></td>
		<td><input type="reset" value="<@spring.messageText "admin.password.form.btn.reset", "Reset" />" /><input type="submit" value="<@spring.messageText "admin.password.form.btn.submit", "Submit" />" /></td>
	</tr>
</table>
</form>
