<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<script>
$(document).ready(function() {
});
</script>
<h2><a href="###"><@spring.messageText "veterinarian.query.title", "Veterinarian Query" /></a></h2>
<form id="veterinarianQueryForm" action="result" method="GET">
<#if globalErrorMessage??>
<div class="error">
	${globalErrorMessage}
</div>
</#if>
<table width="100%">
	<tr>
		<td width="10%"><@spring.messageText "veterinarian.query.form.label.clinicName", "Veterinarian Clinic Name" /></td>
		<td width="30%">
			<@spring.bind "query.clinicName" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
		<td width="20%"><@spring.messageText "veterinarian.query.form.label.username", "Veterinarian Username" /></td>
		<td width="40%">
			<@spring.bind "query.username" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.query.form.label.clinicAddress", "Veterinarian Clinic Address" /></td>
		<td colspan="3">
			<@spring.bind "query.clinicAddress" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.query.form.label.name", "Veterinarian Name" /></td>
		<td>
			<@spring.bind "query.name" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
		<td><@spring.messageText "veterinarian.query.form.label.gender", "Veterinarian Gender" /></td>
		<td>
			<@spring.bind "query.gender" />
			<@spring.formSingleSelect path="query.gender" options=allGenders />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.query.form.label.speciality", "Veterinarian Speciality" /></td>
		<td colspan="3">
			<@spring.bind "query.specialityPetCategoryId" />
			<@spring.formSingleSelect path="query.specialityPetCategoryId" options=allPetCategories />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.query.form.label.workingdate", "Veterinarian Workingdate" /></td>
		<td colspan="3">
			<@spring.bind "query.workingDateFrom" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
			-
			<@spring.bind "query.workingDateTo" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td></td>
		<td colspan="3"><input type="reset" value="<@spring.messageText "veterinarian.query.form.btn.reset", "Reset" />" /><input type="submit" value="<@spring.messageText "veterinarian.query.form.btn.submit", "Submit" />" /></td>
	</tr>
</table>
</form>

<!-- Query Results -->
<#if page??>
<table width="100%">
	<tr>
		<td colspan="10" align="right">
			<#if page.hasPre>
			<a href="result?clinicName=${query.clinicName!""}&clinicAddress=${query.clinicAddress!""}&username=${query.username!""}&name=${query.name!""}&gender=${query.gender!""}&workingDateFrom=${(query.workingDateFrom?string("yyyy-MM-dd"))!""}&workingDateTo=${(query.workingDateTo?string("yyyy-MM-dd"))!""}&specialityPetCategoryId=${query.specialityPetCategoryId!""}&page.pageNo=${(page.prePage)!"1"}"><@spring.messageText "veterinarian.query.result.btn.prev", "Prev" /></a>
			<#else>
			<@spring.messageText "veterinarian.query.result.btn.prev", "Prev" />
			</#if>
			&nbsp;
			<#if page.hasNext>
			<a href="result?clinicName=${query.clinicName!""}&clinicAddress=${query.clinicAddress!""}&username=${query.username!""}&name=${query.name!""}&gender=${query.gender!""}&workingDateFrom=${(query.workingDateFrom?string("yyyy-MM-dd"))!""}&workingDateTo=${(query.workingDateTo?string("yyyy-MM-dd"))!""}&specialityPetCategoryId=${query.specialityPetCategoryId!""}&page.pageNo=${(page.nextPage)!"1"}"><@spring.messageText "veterinarian.query.result.btn.next", "Next" /></a>
			<#else>
			<@spring.messageText "veterinarian.query.result.btn.next", "Next" />
			</#if>
			&nbsp;
			<@spring.messageArgsText "veterinarian.query.result.pageInfo", ["${page.currentPageNo}", "${page.totalPages}", "${page.totalCount}"], "Page Info" />
		</td>
	</tr>
	<tr>
		<td align="center"><@spring.messageText "veterinarian.query.result.no", "No." /></td>
		<td align="center"><@spring.messageText "veterinarian.query.result.username", "Veterinarian Username" /></td>
		<td align="center"><@spring.messageText "veterinarian.query.result.name", "Veterinarian Name" /></td>
		<td align="center"><@spring.messageText "veterinarian.query.result.clinicName", "Veterinarian Clinic Name" /></td>
		<td align="center"><@spring.messageText "veterinarian.query.result.clinicAddress", "Veterinarian Clinic Address" /></td>
		<td align="center"><@spring.messageText "veterinarian.query.result.gender", "Veterinarian Gender" /></td>
		<td align="center"><@spring.messageText "veterinarian.query.result.telephone", "Veterinarian Telephone" /></td>
		<td align="center"><@spring.messageText "veterinarian.query.result.email", "Veterinarian Email" /></td>
		<td align="center"><@spring.messageText "veterinarian.query.result.speciality", "Veterinarian Speciality" /></td>
		<td align="center"><@spring.messageText "veterinarian.query.result.operation", "Operation" /></td>
	</tr>
	<#list page.result as veterinarian>
	<tr>
		<td align="center">${page.first + veterinarian_index}</td>
		<td>${veterinarian.username}</td>
		<td>${veterinarian.name}</td>
		<td>${veterinarian.clinic.name}</td>
		<td>${veterinarian.clinic.address}</td>
		<td align="center">${allGenders["${veterinarian.gender}"]}</td>
		<td>${veterinarian.telephone}</td>
		<td>${veterinarian.email}</td>
		<td align="center">${(veterinarian.specialityPetCategory.name)!""}</td>
		<td align="center">
			<a href="../../vet/${veterinarian.id}" target="_blank"><@spring.messageText "veterinarian.query.result.oper.detail", "Detail" /></a>
		</td>
	</tr>
	</#list>
	<tr>
		<td colspan="10" align="right">
			<#if page.hasPre>
			<a href="result?clinicName=${query.clinicName!""}&clinicAddress=${query.clinicAddress!""}&username=${query.username!""}&name=${query.name!""}&gender=${query.gender!""}&workingDateFrom=${(query.workingDateFrom?string("yyyy-MM-dd"))!""}&workingDateTo=${(query.workingDateTo?string("yyyy-MM-dd"))!""}&specialityPetCategoryId=${query.specialityPetCategoryId!""}&page.pageNo=${(page.prePage)!"1"}"><@spring.messageText "veterinarian.query.result.btn.prev", "Prev" /></a>
			<#else>
			<@spring.messageText "veterinarian.query.result.btn.prev", "Prev" />
			</#if>
			&nbsp;
			<#if page.hasNext>
			<a href="result?clinicName=${query.clinicName!""}&clinicAddress=${query.clinicAddress!""}&username=${query.username!""}&name=${query.name!""}&gender=${query.gender!""}&workingDateFrom=${(query.workingDateFrom?string("yyyy-MM-dd"))!""}&workingDateTo=${(query.workingDateTo?string("yyyy-MM-dd"))!""}&specialityPetCategoryId=${query.specialityPetCategoryId!""}&page.pageNo=${(page.nextPage)!"1"}"><@spring.messageText "veterinarian.query.result.btn.next", "Next" /></a>
			<#else>
			<@spring.messageText "veterinarian.query.result.btn.next", "Next" />
			</#if>
			&nbsp;
			<@spring.messageArgsText "veterinarian.query.result.pageInfo", ["${page.currentPageNo}", "${page.totalPages}", "${page.totalCount}"], "Page Info" />
		</td>
	</tr>
</table>
</#if>
