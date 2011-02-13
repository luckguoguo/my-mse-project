<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<script>
$(document).ready(function() {
	$("input[name='dayFrom'], input[name='dayTo']").datepicker({
		changeMonth: true,
		changeYear: true,
		dateFormat: 'yy-mm-dd',
		yearRange: 'c-70:c+70'
	});
});
</script>
<h2><a href="###"><@spring.messageText "petowner.appointment.query.title", "Appointment Query" /></a></h2>
<form id="appointmentQueryForm" action="result" method="GET">
<#if globalErrorMessage??>
<div class="error">
	${globalErrorMessage}
</div>
</#if>
<table width="100%">
	<tr>
		<td><@spring.messageText "petowner.appointment.query.form.label.day", "Appointment Day" /></td>
		<td colspan="3">
			<@spring.bind "query.dayFrom" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
			-
			<@spring.bind "query.dayTo" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td></td>
		<td colspan="3"><input type="reset" value="<@spring.messageText "petowner.appointment.query.form.btn.reset", "Reset" />" /><input type="submit" value="<@spring.messageText "petowner.appointment.query.form.btn.submit", "Submit" />" /></td>
	</tr>
</table>
</form>

<!-- Query Results -->
<#if page??>
<table width="100%">
	<tr>
		<td colspan="8" align="right">
			<#if page.hasPre>
			<a href="result?dayFrom=${(query.dayFrom?string("yyyy-MM-dd"))!""}&dayTo=${(query.dayTo?string("yyyy-MM-dd"))!""}&page.pageNo=${(page.prePage)!"1"}"><@spring.messageText "petowner.appointment.query.result.btn.prev", "Prev" /></a>
			<#else>
			<@spring.messageText "petowner.appointment.query.result.btn.prev", "Prev" />
			</#if>
			&nbsp;
			<#if page.hasNext>
			<a href="result?dayFrom=${(query.dayFrom?string("yyyy-MM-dd"))!""}&dayTo=${(query.dayTo?string("yyyy-MM-dd"))!""}&page.pageNo=${(page.nextPage)!"1"}"><@spring.messageText "petowner.appointment.query.result.btn.next", "Next" /></a>
			<#else>
			<@spring.messageText "petowner.appointment.query.result.btn.next", "Next" />
			</#if>
			&nbsp;
			<@spring.messageArgsText "petowner.appointment.query.result.pageInfo", ["${page.currentPageNo}", "${page.totalPages}", "${page.totalCount}"], "Page Info" />
		</td>
	</tr>
	<tr>
		<td align="center"><@spring.messageText "petowner.appointment.query.result.no", "No." /></td>
		<td align="center"><@spring.messageText "petowner.appointment.query.result.veterinarian.name", "Appointment Vet Name" /></td>
		<td align="center"><@spring.messageText "petowner.appointment.query.result.veterinarian.clinic.name", "Appointment Clinic Name" /></td>
		<td align="center"><@spring.messageText "petowner.appointment.query.result.veterinarian.clinic.address", "Appointment Clinic Address" /></td>
		<td align="center"><@spring.messageText "petowner.appointment.query.result.veterinarian.speciality", "Appointment Speciality" /></td>
		<td align="center"><@spring.messageText "petowner.appointment.query.result.day", "Appointment Day" /></td>
		<td align="center"><@spring.messageText "petowner.appointment.query.result.serialNo", "Appointment SerialNo" /></td>
		<td align="center"><@spring.messageText "petowner.appointment.query.result.operation", "Operation" /></td>
	</tr>
	<#list page.result as appointment>
	<tr>
		<td align="center">${page.first + appointment_index}</td>
		<td>${appointment.dailyOutpatient.veterinarian.name}</td>
		<td>${appointment.dailyOutpatient.veterinarian.clinic.name}</td>
		<td>${appointment.dailyOutpatient.veterinarian.clinic.address}</td>
		<td align="center">${appointment.dailyOutpatient.veterinarian.specialityPetCategory.name}</td>
		<td align="center">${appointment.dailyOutpatient.day?string("yyyy-MM-dd")}</td>
		<td align="center">${appointment.serialNo}</td>
		<td align="center">
			<a href="${contextPath}/petowner/vet/${appointment.dailyOutpatient.veterinarian.id}" target="_blank"><@spring.messageText "petowner.appointment.query.result.oper.detail", "Detail" /></a>
		</td>
	</tr>
	</#list>
	<tr>
		<td colspan="8" align="right">
			<#if page.hasPre>
			<a href="result?dayFrom=${(query.dayFrom?string("yyyy-MM-dd"))!""}&dayTo=${(query.dayTo?string("yyyy-MM-dd"))!""}&page.pageNo=${(page.prePage)!"1"}"><@spring.messageText "petowner.appointment.query.result.btn.prev", "Prev" /></a>
			<#else>
			<@spring.messageText "petowner.appointment.query.result.btn.prev", "Prev" />
			</#if>
			&nbsp;
			<#if page.hasNext>
			<a href="result?dayFrom=${(query.dayFrom?string("yyyy-MM-dd"))!""}&dayTo=${(query.dayTo?string("yyyy-MM-dd"))!""}&page.pageNo=${(page.nextPage)!"1"}"><@spring.messageText "petowner.appointment.query.result.btn.next", "Next" /></a>
			<#else>
			<@spring.messageText "petowner.appointment.query.result.btn.next", "Next" />
			</#if>
			&nbsp;
			<@spring.messageArgsText "petowner.appointment.query.result.pageInfo", ["${page.currentPageNo}", "${page.totalPages}", "${page.totalCount}"], "Page Info" />
		</td>
	</tr>
</table>
</#if>
