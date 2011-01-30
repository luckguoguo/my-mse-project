<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<h2><a href="###">
<#if clinic.id??>
	<@spring.messageText "admin.clinic.form.update.title", "Update Clinic" />
<#else>
	<@spring.messageText "admin.clinic.form.register.title", "Register Clinic" />
</#if>
</a></h2>
<form id="clinicForm" action="" method="POST">
<input type="hidden" name="step" value="1" />
<input type="hidden" name="id" value="${clinic.id!""}" />
<input type="hidden" name="mgrPassword" value="${clinic.mgrPassword!"default"}" />
<input type="hidden" name="confirmMgrPassword" value="${clinic.confirmMgrPassword!"default"}" />
<#if globalErrorMessage??>
<div class="error">
	${globalErrorMessage}
</div>
</#if>
<table>
	<tr>
		<td><@spring.messageText "admin.clinic.form.label.name", "Clinic Name" /></td>
		<td>
			<@spring.bind "clinic.name" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.clinic.form.label.grade", "Clinic Grade" /></td>
		<td>
			<@spring.bind "clinic.grade" />
			<@spring.formSingleSelect path="clinic.grade" options=clinicGrades />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.clinic.form.label.address", "Clinic Address" /></td>
		<td>
			<@spring.bind "clinic.address" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.clinic.form.label.telephone", "Clinic Telephone" /></td>
		<td>
			<@spring.bind "clinic.telephone" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.clinic.form.label.email", "Clinic Email" /></td>
		<td>
			<@spring.bind "clinic.email" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.clinic.form.label.introduction", "Clinic Introduction" /></td>
		<td>
			<@spring.bind "clinic.introduction" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.clinic.form.label.star", "Clinic Star" /></td>
		<td>
			<@spring.bind "clinic.star" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td></td>
		<td><input type="reset" value="<@spring.messageText "admin.clinic.form.btn.reset", "Reset" />" /><input type="submit" value="<@spring.messageText "admin.clinic.form.btn.next", "Next" />" /></td>
	</tr>
</table>
</form>
