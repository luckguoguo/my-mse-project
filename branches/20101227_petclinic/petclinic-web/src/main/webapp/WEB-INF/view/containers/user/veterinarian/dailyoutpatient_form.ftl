<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<script>
$(document).ready(function() {
	$("input[name='day']").datepicker({
		changeMonth: true,
		changeYear: true,
		dateFormat: 'yy-mm-dd',
		yearRange: 'c-70:c+70',
		minDate: +1,
		maxDate: "+3M"
	});
});
</script>
<h2><a href="###"><@spring.messageText "veterinarian.dailyoutpatient.form.register.title", "Register Outpatient" /></a></h2>
<form id="dailyOutpatientForm" action="" method="POST">
<input type="hidden" name="id" value="${(dailyOutpatient.id)!""}" />
<#if globalErrorMessage??>
<div class="error">
	${globalErrorMessage}
</div>
</#if>
<table width="80%">
	<tr>
		<td width="20%"><span class="required">*</span> <@spring.messageText "veterinarian.dailyoutpatient.form.label.day", "Outpatient Day" /></td>
		<td width="80%">
			<@spring.bind "dailyOutpatient.day" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><span class="required">*</span> <@spring.messageText "veterinarian.dailyoutpatient.form.label.countLimit", "Outpatient Count Limit" /></td>
		<td>
			<@spring.bind "dailyOutpatient.countLimit" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td></td>
		<td><input type="reset" value="<@spring.messageText "veterinarian.dailyoutpatient.form.btn.reset", "Reset" />" /><input type="submit" value="<@spring.messageText "veterinarian.dailyoutpatient.form.btn.submit", "Submit" />" /></td>
	</tr>
</table>
</form>
