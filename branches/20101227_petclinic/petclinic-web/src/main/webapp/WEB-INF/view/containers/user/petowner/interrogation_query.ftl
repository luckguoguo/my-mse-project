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
<h2><a href="###"><@spring.messageText "petowner.interrogation.query.title", "Interrogation Query" /></a></h2>
<form id="interrogationQueryForm" action="result" method="GET">
<#if globalErrorMessage??>
<div class="error">
	${globalErrorMessage}
</div>
</#if>
<table width="100%">
	<tr>
		<td width="10%"><@spring.messageText "petowner.interrogation.query.form.label.pet", "Interrogation Pet" /></td>
		<td width="30%">
			<@spring.bind "query.petId" />
			<@spring.formSingleSelect path="query.petId" options=ownerPets />
			<@spring.showErrors ", ", "error"/>
		</td>
		<td width="20%"><@spring.messageText "petowner.interrogation.query.form.label.status", "Interrogation Status" /></td>
		<td width="40%">
			<@spring.bind "query.status" />
			<@spring.formSingleSelect path="query.status" options=interrogationStatuses />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "petowner.interrogation.query.form.label.name", "Interrogation Name" /></td>
		<td>
			<@spring.bind "query.name" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td><@spring.messageText "petowner.interrogation.query.form.label.createdDate", "Interrogation Created Date" /></td>
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
		<td colspan="3"><input type="reset" value="<@spring.messageText "petowner.interrogation.query.form.btn.reset", "Reset" />" /><input type="submit" value="<@spring.messageText "petowner.interrogation.query.form.btn.submit", "Submit" />" /></td>
	</tr>
</table>
</form>

<!-- Query Results -->
<#if page??>
<table width="100%">
	<tr>
		<td colspan="6" align="right">
			<#if page.hasPre>
			<a href="result?petId=${(query.petId)!""}&status=${query.status!""}&name=${query.name!""}&createdDateFrom=${(query.createdDateFrom?string("yyyy-MM-dd"))!""}&createdDateTo=${(query.createdDateTo?string("yyyy-MM-dd"))!""}&page.pageNo=${(page.prePage)!"1"}"><@spring.messageText "petowner.interrogation.query.result.btn.prev", "Prev" /></a>
			<#else>
			<@spring.messageText "petowner.interrogation.query.result.btn.prev", "Prev" />
			</#if>
			&nbsp;
			<#if page.hasNext>
			<a href="result?petId=${(query.petId)!""}&status=${query.status!""}&name=${query.name!""}&createdDateFrom=${(query.createdDateFrom?string("yyyy-MM-dd"))!""}&createdDateTo=${(query.createdDateTo?string("yyyy-MM-dd"))!""}&page.pageNo=${(page.nextPage)!"1"}"><@spring.messageText "petowner.interrogation.query.result.btn.next", "Next" /></a>
			<#else>
			<@spring.messageText "petowner.interrogation.query.result.btn.next", "Next" />
			</#if>
			&nbsp;
			<@spring.messageArgsText "petowner.interrogation.query.result.pageInfo", ["${page.currentPageNo}", "${page.totalPages}", "${page.totalCount}"], "Page Info" />
		</td>
	</tr>
	<tr>
		<td align="center"><@spring.messageText "petowner.interrogation.query.result.title.no", "No." /></td>
		<td align="center"><@spring.messageText "petowner.interrogation.query.result.pet.name", "Interrogation Pet" /></td>
		<td align="center"><@spring.messageText "petowner.interrogation.query.result.name", "Interrogation name" /></td>
		<td align="center"><@spring.messageText "petowner.interrogation.query.result.createdDate", "Interrogation Created Date" /></td>
		<td align="center"><@spring.messageText "petowner.interrogation.query.result.status", "Interrogation Status" /></td>
		<td align="center"><@spring.messageText "petowner.interrogation.query.result.operation", "Operation" /></td>
	</tr>
	<#list page.result as interrogation>
	<tr>
		<td align="center">${page.first + interrogation_index}</td>
		<td>${interrogation.pet.name}</td>
		<td>${interrogation.name}</td>
		<td align="center">${interrogation.createdTime?string("yyyy-MM-dd")}</td>
		<td align="center">${interrogationStatuses["${interrogation.status}"]}</td>
		<td align="center">
			<a href="${contextPath}/petowner/interrogation/${interrogation.id}" target="_blank"><@spring.messageText "petowner.interrogation.query.result.oper.detail", "Detail" /></a>
		</td>
	</tr>
	</#list>
	<tr>
		<td colspan="6" align="right">
			<#if page.hasPre>
			<a href="result?petId=${(query.petId)!""}&status=${query.status!""}&name=${query.name!""}&createdDateFrom=${(query.createdDateFrom?string("yyyy-MM-dd"))!""}&createdDateTo=${(query.createdDateTo?string("yyyy-MM-dd"))!""}&page.pageNo=${(page.prePage)!"1"}"><@spring.messageText "petowner.interrogation.query.result.btn.prev", "Prev" /></a>
			<#else>
			<@spring.messageText "petowner.interrogation.query.result.btn.prev", "Prev" />
			</#if>
			&nbsp;
			<#if page.hasNext>
			<a href="result?petId=${(query.petId)!""}&status=${query.status!""}&name=${query.name!""}&createdDateFrom=${(query.createdDateFrom?string("yyyy-MM-dd"))!""}&createdDateTo=${(query.createdDateTo?string("yyyy-MM-dd"))!""}&page.pageNo=${(page.nextPage)!"1"}"><@spring.messageText "petowner.interrogation.query.result.btn.next", "Next" /></a>
			<#else>
			<@spring.messageText "petowner.interrogation.query.result.btn.next", "Next" />
			</#if>
			&nbsp;
			<@spring.messageArgsText "petowner.interrogation.query.result.pageInfo", ["${page.currentPageNo}", "${page.totalPages}", "${page.totalCount}"], "Page Info" />
		</td>
	</tr>
</table>
</#if>
