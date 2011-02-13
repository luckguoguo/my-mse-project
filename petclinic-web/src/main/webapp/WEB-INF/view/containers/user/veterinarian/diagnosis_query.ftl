<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<script>
$(document).ready(function() {
	$("input[name='createdDateFrom'], input[name='createdDateTo']").datepicker({
		changeMonth: true,
		changeYear: true,
		dateFormat: 'yy-mm-dd',
		yearRange: 'c-70:c+70'
	});
});
</script>
<h2><a href="###"><@spring.messageText "veterinarian.diagnosis.query.title", "Diagnosis Query" /></a></h2>
<form id="diagnosisQueryForm" action="result" method="GET">
<#if globalErrorMessage??>
<div class="error">
	${globalErrorMessage}
</div>
</#if>
<table width="100%">
	<tr>
		<td><@spring.messageText "veterinarian.diagnosis.query.form.label.createdDate", "Diagnosis Created Date" /></td>
		<td colspan="3">
			<@spring.bind "query.createdDateFrom" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
			-
			<@spring.bind "query.createdDateTo" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td></td>
		<td colspan="3"><input type="reset" value="<@spring.messageText "veterinarian.diagnosis.query.form.btn.reset", "Reset" />" /><input type="submit" value="<@spring.messageText "veterinarian.diagnosis.query.form.btn.submit", "Submit" />" /></td>
	</tr>
</table>
</form>

<!-- Query Results -->
<#if page??>
<table width="100%">
	<tr>
		<td colspan="9" align="right">
			<#if page.hasPre>
			<a href="result?createdDateFrom=${(query.createdDateFrom?string("yyyy-MM-dd"))!""}&createdDateTo=${(query.createdDateTo?string("yyyy-MM-dd"))!""}&page.pageNo=${(page.prePage)!"1"}"><@spring.messageText "veterinarian.diagnosis.query.result.btn.prev", "Prev" /></a>
			<#else>
			<@spring.messageText "veterinarian.diagnosis.query.result.btn.prev", "Prev" />
			</#if>
			&nbsp;
			<#if page.hasNext>
			<a href="result?createdDateFrom=${(query.createdDateFrom?string("yyyy-MM-dd"))!""}&createdDateTo=${(query.createdDateTo?string("yyyy-MM-dd"))!""}&page.pageNo=${(page.nextPage)!"1"}"><@spring.messageText "veterinarian.diagnosis.query.result.btn.next", "Next" /></a>
			<#else>
			<@spring.messageText "veterinarian.diagnosis.query.result.btn.next", "Next" />
			</#if>
			&nbsp;
			<@spring.messageArgsText "veterinarian.diagnosis.query.result.pageInfo", ["${page.currentPageNo}", "${page.totalPages}", "${page.totalCount}"], "Page Info" />
		</td>
	</tr>
	<tr>
		<td align="center"><@spring.messageText "veterinarian.diagnosis.query.result.title.no", "No." /></td>
		<td align="center"><@spring.messageText "veterinarian.diagnosis.query.result.petowner.username", "Diagnosis Petowner Username" /></td>
		<td align="center"><@spring.messageText "veterinarian.diagnosis.query.result.petowner.name", "Diagnosis Petowner Name" /></td>
		<td align="center"><@spring.messageText "veterinarian.diagnosis.query.result.pet.name", "Diagnosis Pet" /></td>
		<td align="center"><@spring.messageText "veterinarian.diagnosis.query.result.interrogation.name", "Diagnosis name" /></td>
		<td align="center"><@spring.messageText "veterinarian.diagnosis.query.result.interrogation.createdDate", "Interrogation Created Date" /></td>
		<td align="center"><@spring.messageText "veterinarian.diagnosis.query.result.createdDate", "Diagnosis Created Date" /></td>
		<td align="center"><@spring.messageText "veterinarian.diagnosis.query.result.star", "Diagnosis Star" /></td>
		<td align="center"><@spring.messageText "veterinarian.diagnosis.query.result.operation", "Operation" /></td>
	</tr>
	<#list page.result as diagnosis>
	<tr>
		<td align="center">${page.first + diagnosis_index}</td>
		<td><a href="${contextPath}/veterinarian/petowner/${diagnosis.interrogation.petOwner.username}" target="_blank">${diagnosis.interrogation.petOwner.username}</a></td>
		<td>${diagnosis.interrogation.petOwner.name}</td>
		<td>${diagnosis.interrogation.pet.name}</td>
		<td>${diagnosis.interrogation.name}</td>
		<td align="center">${diagnosis.interrogation.createdTime?string("yyyy-MM-dd")}</td>
		<td align="center">${diagnosis.createdTime?string("yyyy-MM-dd")}</td>
		<td align="center">${(diagnosisStars["${diagnosis.star}"])!"-"}</td>
		<td align="center">
			<a href="${contextPath}/veterinarian/diagnosis/${diagnosis.id}" target="_blank"><@spring.messageText "veterinarian.diagnosis.query.result.oper.detail", "Detail" /></a>
		</td>
	</tr>
	</#list>
	<tr>
		<td colspan="9" align="right">
			<#if page.hasPre>
			<a href="result?createdDateFrom=${(query.createdDateFrom?string("yyyy-MM-dd"))!""}&createdDateTo=${(query.createdDateTo?string("yyyy-MM-dd"))!""}&page.pageNo=${(page.prePage)!"1"}"><@spring.messageText "veterinarian.diagnosis.query.result.btn.prev", "Prev" /></a>
			<#else>
			<@spring.messageText "veterinarian.diagnosis.query.result.btn.prev", "Prev" />
			</#if>
			&nbsp;
			<#if page.hasNext>
			<a href="result?createdDateFrom=${(query.createdDateFrom?string("yyyy-MM-dd"))!""}&createdDateTo=${(query.createdDateTo?string("yyyy-MM-dd"))!""}&page.pageNo=${(page.nextPage)!"1"}"><@spring.messageText "veterinarian.diagnosis.query.result.btn.next", "Next" /></a>
			<#else>
			<@spring.messageText "veterinarian.diagnosis.query.result.btn.next", "Next" />
			</#if>
			&nbsp;
			<@spring.messageArgsText "veterinarian.diagnosis.query.result.pageInfo", ["${page.currentPageNo}", "${page.totalPages}", "${page.totalCount}"], "Page Info" />
		</td>
	</tr>
</table>
</#if>
