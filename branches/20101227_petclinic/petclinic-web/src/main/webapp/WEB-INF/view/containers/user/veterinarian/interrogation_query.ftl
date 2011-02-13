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
<h2><a href="###"><@spring.messageText "veterinarian.interrogation.query.title", "Interrogation Query" /></a></h2>
<form id="interrogationQueryForm" action="result" method="GET">
<#if globalErrorMessage??>
<div class="error">
	${globalErrorMessage}
</div>
</#if>
<table width="100%">
	<tr>
		<td><@spring.messageText "veterinarian.interrogation.query.form.label.createdDate", "Interrogation Created Date" /></td>
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
		<td colspan="3"><input type="reset" value="<@spring.messageText "veterinarian.interrogation.query.form.btn.reset", "Reset" />" /><input type="submit" value="<@spring.messageText "veterinarian.interrogation.query.form.btn.submit", "Submit" />" /></td>
	</tr>
</table>
</form>

<!-- Query Results -->
<#if page??>
<table width="100%">
	<tr>
		<td colspan="8" align="right">
			<#if page.hasPre>
			<a href="result?createdDateFrom=${(query.createdDateFrom?string("yyyy-MM-dd"))!""}&createdDateTo=${(query.createdDateTo?string("yyyy-MM-dd"))!""}&page.pageNo=${(page.prePage)!"1"}"><@spring.messageText "veterinarian.interrogation.query.result.btn.prev", "Prev" /></a>
			<#else>
			<@spring.messageText "veterinarian.interrogation.query.result.btn.prev", "Prev" />
			</#if>
			&nbsp;
			<#if page.hasNext>
			<a href="result?createdDateFrom=${(query.createdDateFrom?string("yyyy-MM-dd"))!""}&createdDateTo=${(query.createdDateTo?string("yyyy-MM-dd"))!""}&page.pageNo=${(page.nextPage)!"1"}"><@spring.messageText "veterinarian.interrogation.query.result.btn.next", "Next" /></a>
			<#else>
			<@spring.messageText "veterinarian.interrogation.query.result.btn.next", "Next" />
			</#if>
			&nbsp;
			<@spring.messageArgsText "veterinarian.interrogation.query.result.pageInfo", ["${page.currentPageNo}", "${page.totalPages}", "${page.totalCount}"], "Page Info" />
		</td>
	</tr>
	<tr>
		<td align="center"><@spring.messageText "veterinarian.interrogation.query.result.title.no", "No." /></td>
		<td align="center"><@spring.messageText "veterinarian.interrogation.query.result.petowner.username", "Interrogation Petowner Username" /></td>
		<td align="center"><@spring.messageText "veterinarian.interrogation.query.result.petowner.name", "Interrogation Petowner Name" /></td>
		<td align="center"><@spring.messageText "veterinarian.interrogation.query.result.pet.name", "Interrogation Pet" /></td>
		<td align="center"><@spring.messageText "veterinarian.interrogation.query.result.name", "Interrogation name" /></td>
		<td align="center"><@spring.messageText "veterinarian.interrogation.query.result.createdDate", "Interrogation Created Date" /></td>
		<td align="center"><@spring.messageText "veterinarian.interrogation.query.result.status", "Interrogation Status" /></td>
		<td align="center"><@spring.messageText "veterinarian.interrogation.query.result.operation", "Operation" /></td>
	</tr>
	<#list page.result as interrogation>
	<tr>
		<td align="center">${page.first + interrogation_index}</td>
		<td><a href="${contextPath}/veterinarian/petowner/${interrogation.petOwner.username}" target="_blank">${interrogation.petOwner.username}</a></td>
		<td>${interrogation.petOwner.name}</td>
		<td>${interrogation.pet.name}</td>
		<td>${interrogation.name}</td>
		<td align="center">${interrogation.createdTime?string("yyyy-MM-dd")}</td>
		<td align="center">${interrogationStatuses["${interrogation.status}"]}</td>
		<td align="center">
			<a href="${contextPath}/veterinarian/interrogation/${interrogation.id}" target="_blank"><@spring.messageText "veterinarian.interrogation.query.result.oper.detail", "Detail" /></a>
		</td>
	</tr>
	</#list>
	<tr>
		<td colspan="8" align="right">
			<#if page.hasPre>
			<a href="result?createdDateFrom=${(query.createdDateFrom?string("yyyy-MM-dd"))!""}&createdDateTo=${(query.createdDateTo?string("yyyy-MM-dd"))!""}&page.pageNo=${(page.prePage)!"1"}"><@spring.messageText "veterinarian.interrogation.query.result.btn.prev", "Prev" /></a>
			<#else>
			<@spring.messageText "veterinarian.interrogation.query.result.btn.prev", "Prev" />
			</#if>
			&nbsp;
			<#if page.hasNext>
			<a href="result?createdDateFrom=${(query.createdDateFrom?string("yyyy-MM-dd"))!""}&createdDateTo=${(query.createdDateTo?string("yyyy-MM-dd"))!""}&page.pageNo=${(page.nextPage)!"1"}"><@spring.messageText "veterinarian.interrogation.query.result.btn.next", "Next" /></a>
			<#else>
			<@spring.messageText "veterinarian.interrogation.query.result.btn.next", "Next" />
			</#if>
			&nbsp;
			<@spring.messageArgsText "veterinarian.interrogation.query.result.pageInfo", ["${page.currentPageNo}", "${page.totalPages}", "${page.totalCount}"], "Page Info" />
		</td>
	</tr>
</table>
</#if>
