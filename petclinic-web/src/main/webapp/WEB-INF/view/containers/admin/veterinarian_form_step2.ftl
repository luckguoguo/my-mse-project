<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<script>
$(document).ready(function() {
});
function goPrev() {
	$("#step").val("0");
	$("#veterinarianForm").submit();
}
</script>
<h2><a href="###">
<#if veterinarian.id??>
	<@spring.messageText "admin.veterinarian.form.update.title", "Update Veterinarian" />
<#else>
	<@spring.messageText "admin.veterinarian.form.register.title", "Register Veterinarian" />
</#if>
</a></h2>
<p style="color: red;"><@spring.messageText "admin.veterinarian.form.mgrPassword.attention", "Attention" /></p>
<form id="veterinarianForm" action="" method="POST">
<input type="hidden" id="step" name="step" value="2" />
<input type="hidden" name="id" value="${veterinarian.id!""}" />
<input type="hidden" name="password" value="${veterinarian.password!""}" />
<#if globalErrorMessage??>
<div class="error">
	${globalErrorMessage}
</div>
</#if>
<table width="80%">
	<tr>
		<td width="20%"><@spring.messageText "admin.veterinarian.form.label.clinic", "Veterinarian Clinic" /></td>
		<td width="80%">
			<@spring.bind "veterinarian.clinic.id" />
			${allClinics[spring.status.value?default("")]}
			<input type="hidden" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.veterinarian.form.label.username", "Veterinarian Username" /></td>
		<td>
			<@spring.bind "veterinarian.username" />
			${spring.status.value?default("")}
			<input type="hidden" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.veterinarian.form.label.title", "Veterinarian Title" /></td>
		<td>
			<@spring.bind "veterinarian.title" />
			${spring.status.value?default("")}
			<input type="hidden" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.veterinarian.form.label.name", "Veterinarian Name" /></td>
		<td>
			<@spring.bind "veterinarian.name" />
			${spring.status.value?default("")}
			<input type="hidden" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.veterinarian.form.label.gender", "Veterinarian Gender" /></td>
		<td>
			<@spring.bind "veterinarian.gender" />
			${allGenders[spring.status.value?default("")]}
			<input type="hidden" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.veterinarian.form.label.birthdate", "Veterinarian Birthdate" /></td>
		<td>
			<@spring.bind "veterinarian.birthdate" />
			${spring.status.value?default("")}
			<input type="hidden" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.veterinarian.form.label.workingdate", "Veterinarian Workingdate" /></td>
		<td>
			<@spring.bind "veterinarian.workingdate" />
			${spring.status.value?default("")}
			<input type="hidden" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.veterinarian.form.label.telephone", "Veterinarian Telephone" /></td>
		<td>
			<@spring.bind "veterinarian.telephone" />
			${spring.status.value?default("")}
			<input type="hidden" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.veterinarian.form.label.email", "Veterinarian Email" /></td>
		<td>
			<@spring.bind "veterinarian.email" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.veterinarian.form.label.introduction", "Veterinarian Introduction" /></td>
		<td>
			<@spring.bind "veterinarian.introduction" />
			${spring.status.value?default("")}
			<textarea cols="80" name="${spring.status.expression}" rows="10" style="display: none;">${spring.status.value?default("")}</textarea>
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.veterinarian.form.label.mgrPassword", "Veterinarian Clinic MgrPassword" /></td>
		<td>
			<@spring.bind "veterinarian.clinic.confirmMgrPassword" />
			<input type="password" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td></td>
		<td><input type="button" value="<@spring.messageText "admin.clinic.form.btn.previous", "Prev" />" onclick="javascript:goPrev();" /><input type="submit" value="<@spring.messageText "admin.clinic.form.btn.submit", "Submit" />" /></td>
	</tr>
</table>
</form>
