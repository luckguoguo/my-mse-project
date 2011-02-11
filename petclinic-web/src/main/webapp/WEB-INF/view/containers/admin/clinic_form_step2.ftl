<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<script>
$(document).ready(function() {
	$("#clinicStarWidget").raty({
		path: "${contextPath}/image/raty",
		start: ${clinic.star!"0"},
		readOnly: true
	});
});
function goPrev() {
	$("#step").val("0");
	$("#clinicForm").submit();
}
</script>
<h2><a href="###">
<#if clinic.id??>
	<@spring.messageText "admin.clinic.form.update.title", "Update Clinic" />
<#else>
	<@spring.messageText "admin.clinic.form.register.title", "Register Clinic" />
</#if>
</a></h2>
<p style="color: red;"><@spring.messageText "admin.clinic.form.mgrPassword.attention", "Attention" /></p>
<form id="clinicForm" action="" method="POST">
<input type="hidden" id="step" name="step" value="2" />
<input type="hidden" name="id" value="${clinic.id!""}" />
<#if clinic.id??>
	<input type="hidden" name="mgrPassword" value="${clinic.mgrPassword!""}" />
</#if>
<#if globalErrorMessage??>
<div class="error">
	${globalErrorMessage}
</div>
</#if>
<table width="80%">
	<tr>
		<td width="22%"><@spring.messageText "admin.clinic.form.label.name", "Clinic Name" /></td>
		<td width="78%">
			<@spring.bind "clinic.name" />
			${spring.status.value?default("")}
			<input type="hidden" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.clinic.form.label.grade", "Clinic Grade" /></td>
		<td>
			<@spring.bind "clinic.grade" />
			${clinicGrades[spring.status.value?default("")]}
			<input type="hidden" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.clinic.form.label.address", "Clinic Address" /></td>
		<td>
			<@spring.bind "clinic.address" />
			${spring.status.value?default("")}
			<input type="hidden" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.clinic.form.label.telephone", "Clinic Telephone" /></td>
		<td>
			<@spring.bind "clinic.telephone" />
			${spring.status.value?default("")}
			<input type="hidden" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.clinic.form.label.email", "Clinic Email" /></td>
		<td>
			<@spring.bind "clinic.email" />
			${spring.status.value?default("")}
			<input type="hidden" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.clinic.form.label.introduction", "Clinic Introduction" /></td>
		<td>
			<@spring.bind "clinic.introduction" />
			${spring.status.value?default("")}
			<textarea cols="80" name="${spring.status.expression}" rows="10" style="display: none;">${spring.status.value?default("")}</textarea>
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.clinic.form.label.star", "Clinic Star" /></td>
		<td>
			<@spring.bind "clinic.star" />
			<div id="clinicStarWidget"></div>
			<input type="hidden" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<#if clinic.id??>
	<#else>
	<tr>
		<td><span class="required">*</span> <@spring.messageText "admin.clinic.form.label.mgrPassword", "Clinic MgrPassword" /></td>
		<td>
			<@spring.bind "clinic.mgrPassword" />
			<input type="password" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	</#if>
	<tr>
		<td>
		<span class="required">*</span> 
		<#if clinic.id??>
		<@spring.messageText "admin.clinic.form.label.mgrPassword", "Clinic ConfirmMgrPassword" />
		<#else>
		<@spring.messageText "admin.clinic.form.label.confirmMgrPassword", "Clinic ConfirmMgrPassword" />
		</#if>
		</td>
		<td>
			<@spring.bind "clinic.confirmMgrPassword" />
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
