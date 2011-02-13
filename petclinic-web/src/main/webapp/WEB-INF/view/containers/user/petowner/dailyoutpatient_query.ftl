<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<script>
$(document).ready(function() {
	$("input[name='dayFrom'], input[name='dayTo']").datepicker({
		changeMonth: true,
		changeYear: true,
		dateFormat: 'yy-mm-dd',
		yearRange: 'c-70:c+70',
		minDate: +1,
		maxDate: "+14D"
	});
});
</script>
<h2><a href="###"><@spring.messageText "petowner.dailyoutpatient.query.title", "DailyOutpatient Query" /></a></h2>
<form id="dailyOutpatientQueryForm" action="result" method="GET">
<#if globalErrorMessage??>
<div class="error">
	${globalErrorMessage}
</div>
</#if>
<table width="100%">
	<tr>
		<td width="10%"><@spring.messageText "petowner.dailyoutpatient.query.form.label.clinicName", "DailyOutpatient Clinic Name" /></td>
		<td width="30%">
			<@spring.bind "query.clinicName" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
		<td width="20%"><@spring.messageText "petowner.dailyoutpatient.query.form.label.clinicAddress", "DailyOutpatient Clinic Address" /></td>
		<td width="40%">
			<@spring.bind "query.clinicAddress" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "petowner.dailyoutpatient.query.form.label.veterinarianName", "DailyOutpatient Veterinarian Name" /></td>
		<td>
			<@spring.bind "query.veterinarianName" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
		<td><@spring.messageText "petowner.dailyoutpatient.query.form.label.speciality", "Veterinarian Speciality" /></td>
		<td>
			<@spring.bind "query.specialityPetCategoryId" />
			<@spring.formSingleSelect path="query.specialityPetCategoryId" options=allPetCategories />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "petowner.dailyoutpatient.query.form.label.day", "DailyOutpatient Day" /></td>
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
		<td colspan="3"><input type="reset" value="<@spring.messageText "petowner.dailyoutpatient.query.form.btn.reset", "Reset" />" /><input type="submit" value="<@spring.messageText "petowner.dailyoutpatient.query.form.btn.submit", "Submit" />" /></td>
	</tr>
</table>
</form>

<!-- Query Results -->
<#if page??>
<table width="100%">
	<tr>
		<td colspan="8" align="right">
			<#if page.hasPre>
			<a href="result?clinicName=${(query.clinicName)!""}&clinicAddress=${query.clinicAddress!""}&veterinarianName=${query.veterinarianName!""}&specialityPetCategoryId=${query.specialityPetCategoryId!""}&dayFrom=${(query.dayFrom?string("yyyy-MM-dd"))!""}&dayTo=${(query.dayTo?string("yyyy-MM-dd"))!""}&page.pageNo=${(page.prePage)!"1"}"><@spring.messageText "petowner.dailyoutpatient.query.result.btn.prev", "Prev" /></a>
			<#else>
			<@spring.messageText "petowner.dailyoutpatient.query.result.btn.prev", "Prev" />
			</#if>
			&nbsp;
			<#if page.hasNext>
			<a href="result?clinicName=${(query.clinicName)!""}&clinicAddress=${query.clinicAddress!""}&veterinarianName=${query.veterinarianName!""}&specialityPetCategoryId=${query.specialityPetCategoryId!""}&dayFrom=${(query.dayFrom?string("yyyy-MM-dd"))!""}&dayTo=${(query.dayTo?string("yyyy-MM-dd"))!""}&page.pageNo=${(page.nextPage)!"1"}"><@spring.messageText "petowner.dailyoutpatient.query.result.btn.next", "Next" /></a>
			<#else>
			<@spring.messageText "petowner.dailyoutpatient.query.result.btn.next", "Next" />
			</#if>
			&nbsp;
			<@spring.messageArgsText "petowner.dailyoutpatient.query.result.pageInfo", ["${page.currentPageNo}", "${page.totalPages}", "${page.totalCount}"], "Page Info" />
		</td>
	</tr>
	<tr>
		<td align="center"><@spring.messageText "petowner.dailyoutpatient.query.result.no", "No." /></td>
		<td align="center"><@spring.messageText "petowner.dailyoutpatient.query.result.veterinarian.name", "DailyOutpatient Vet Name" /></td>
		<td align="center"><@spring.messageText "petowner.dailyoutpatient.query.result.veterinarian.clinic.name", "DailyOutpatient Clinic Name" /></td>
		<td align="center"><@spring.messageText "petowner.dailyoutpatient.query.result.veterinarian.clinic.address", "DailyOutpatient Clinic Address" /></td>
		<td align="center"><@spring.messageText "petowner.dailyoutpatient.query.result.veterinarian.speciality", "DailyOutpatient Speciality" /></td>
		<td align="center"><@spring.messageText "petowner.dailyoutpatient.query.result.day", "DailyOutpatient Day" /></td>
		<td align="center"><@spring.messageText "petowner.dailyoutpatient.query.result.status", "DailyOutpatient Status" /></td>
		<td align="center"><@spring.messageText "petowner.dailyoutpatient.query.result.operation", "Operation" /></td>
	</tr>
	<#list page.result as dailyOutpatient>
	<tr>
		<td align="center">${page.first + dailyOutpatient_index}</td>
		<td>${dailyOutpatient.veterinarian.name}</td>
		<td>${dailyOutpatient.veterinarian.clinic.name}</td>
		<td>${dailyOutpatient.veterinarian.clinic.address}</td>
		<td align="center">${dailyOutpatient.veterinarian.specialityPetCategory.name}</td>
		<td align="center">${dailyOutpatient.day?string("yyyy-MM-dd")}</td>
		<td align="center">
		<#if dailyOutpatient.countActual &gt;= dailyOutpatient.countLimit>
			<span style="color: red">${dailyOutpatient.countActual}/${dailyOutpatient.countLimit}</span>
		<#else>
			${dailyOutpatient.countActual}/${dailyOutpatient.countLimit}
		</#if>
		</td>
		<td align="center">
			<a href="${contextPath}/petowner/vet/${dailyOutpatient.veterinarian.id}?dailyOutpatientId=${dailyOutpatient.id}" target="_blank"><@spring.messageText "petowner.dailyoutpatient.query.result.oper.detail", "Detail" /></a>
		</td>
	</tr>
	</#list>
	<tr>
		<td colspan="8" align="right">
			<#if page.hasPre>
			<a href="result?clinicName=${(query.clinicName)!""}&clinicAddress=${query.clinicAddress!""}&veterinarianName=${query.veterinarianName!""}&specialityPetCategoryId=${query.specialityPetCategoryId!""}&dayFrom=${(query.dayFrom?string("yyyy-MM-dd"))!""}&dayTo=${(query.dayTo?string("yyyy-MM-dd"))!""}&page.pageNo=${(page.prePage)!"1"}"><@spring.messageText "petowner.dailyoutpatient.query.result.btn.prev", "Prev" /></a>
			<#else>
			<@spring.messageText "petowner.dailyoutpatient.query.result.btn.prev", "Prev" />
			</#if>
			&nbsp;
			<#if page.hasNext>
			<a href="result?clinicName=${(query.clinicName)!""}&clinicAddress=${query.clinicAddress!""}&veterinarianName=${query.veterinarianName!""}&specialityPetCategoryId=${query.specialityPetCategoryId!""}&dayFrom=${(query.dayFrom?string("yyyy-MM-dd"))!""}&dayTo=${(query.dayTo?string("yyyy-MM-dd"))!""}&page.pageNo=${(page.nextPage)!"1"}"><@spring.messageText "petowner.dailyoutpatient.query.result.btn.next", "Next" /></a>
			<#else>
			<@spring.messageText "petowner.dailyoutpatient.query.result.btn.next", "Next" />
			</#if>
			&nbsp;
			<@spring.messageArgsText "petowner.dailyoutpatient.query.result.pageInfo", ["${page.currentPageNo}", "${page.totalPages}", "${page.totalCount}"], "Page Info" />
		</td>
	</tr>
</table>
</#if>
