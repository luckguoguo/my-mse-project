<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<script>
$(document).ready(function() {
	$("input[name='workingDateFrom'], input[name='workingDateTo']").datepicker({
		changeMonth: true,
		changeYear: true,
		dateFormat: 'yy-mm-dd',
		yearRange: 'c-70:c+70'
	});
	$("a[id^=activeBtn_]").click(function() {
		active($(this).attr("id").replace("activeBtn_", ""));
	});
	$("a[id^=inactiveBtn_]").click(function() {
		inactive($(this).attr("id").replace("inactiveBtn_", ""));
	});
});

function active(veterinarianId) {
	$.post(ctx + "/admin/veterinarian/" + veterinarianId + "/active",
		{},
		function(data) {
			location.href = "result?clinicName=${query.clinicName!""}&username=${query.username!""}&name=${query.name!""}&gender=${query.gender!""}&workingDateFrom=${(query.workingDateFrom?string("yyyy-MM-dd"))!""}&workingDateTo=${(query.workingDateTo?string("yyyy-MM-dd"))!""}&specialityPetCategoryId=${query.specialityPetCategoryId!""}&page.pageNo=${(page.currentPageNo)!"1"}";
		},
		"json"
	);
}

function inactive(veterinarianId) {
	$.post(ctx + "/admin/veterinarian/" + veterinarianId + "/inactive",
		{},
		function(data) {
			location.href = "result?clinicName=${query.clinicName!""}&username=${query.username!""}&name=${query.name!""}&gender=${query.gender!""}&workingDateFrom=${(query.workingDateFrom?string("yyyy-MM-dd"))!""}&workingDateTo=${(query.workingDateTo?string("yyyy-MM-dd"))!""}&specialityPetCategoryId=${query.specialityPetCategoryId!""}&page.pageNo=${(page.currentPageNo)!"1"}";
		},
		"json"
	);
}
</script>
<h2><a href="###"><@spring.messageText "admin.veterinarian.query.title", "Veterinarian Query" /></a></h2>
<form id="veterinarianQueryForm" action="result" method="GET">
<#if globalErrorMessage??>
<div class="error">
	${globalErrorMessage}
</div>
</#if>
<table width="100%">
	<tr>
		<td width="10%"><@spring.messageText "admin.veterinarian.query.form.label.clinicName", "Veterinarian Clinic Name" /></td>
		<td width="30%">
			<@spring.bind "query.clinicName" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
		<td width="20%"><@spring.messageText "admin.veterinarian.query.form.label.username", "Veterinarian Username" /></td>
		<td width="40%">
			<@spring.bind "query.username" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.veterinarian.query.form.label.name", "Veterinarian Name" /></td>
		<td>
			<@spring.bind "query.name" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
		<td><@spring.messageText "admin.veterinarian.query.form.label.gender", "Veterinarian Gender" /></td>
		<td>
			<@spring.bind "query.gender" />
			<@spring.formSingleSelect path="query.gender" options=allGenders />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.veterinarian.query.form.label.speciality", "Veterinarian Speciality" /></td>
		<td colspan="3">
			<@spring.bind "query.specialityPetCategoryId" />
			<@spring.formSingleSelect path="query.specialityPetCategoryId" options=allPetCategories />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.veterinarian.query.form.label.workingdate", "Veterinarian Workingdate" /></td>
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
		<td colspan="3"><input type="reset" value="<@spring.messageText "admin.veterinarian.query.form.btn.reset", "Reset" />" /><input type="submit" value="<@spring.messageText "admin.veterinarian.query.form.btn.submit", "Submit" />" /></td>
	</tr>
</table>
</form>

<!-- Query Results -->
<#if page??>
<table width="100%">
	<tr>
		<td colspan="11" align="right">
			<#if page.hasPre>
			<a href="result?clinicName=${query.clinicName!""}&username=${query.username!""}&name=${query.name!""}&gender=${query.gender!""}&workingDateFrom=${(query.workingDateFrom?string("yyyy-MM-dd"))!""}&workingDateTo=${(query.workingDateTo?string("yyyy-MM-dd"))!""}&specialityPetCategoryId=${query.specialityPetCategoryId!""}&page.pageNo=${(page.prePage)!"1"}"><@spring.messageText "admin.veterinarian.query.result.btn.prev", "Prev" /></a>
			<#else>
			<@spring.messageText "admin.veterinarian.query.result.btn.prev", "Prev" />
			</#if>
			<#if page.hasNext>
			<a href="result?clinicName=${query.clinicName!""}&username=${query.username!""}&name=${query.name!""}&gender=${query.gender!""}&workingDateFrom=${(query.workingDateFrom?string("yyyy-MM-dd"))!""}&workingDateTo=${(query.workingDateTo?string("yyyy-MM-dd"))!""}&specialityPetCategoryId=${query.specialityPetCategoryId!""}&page.pageNo=${(page.nextPage)!"1"}"><@spring.messageText "admin.veterinarian.query.result.btn.next", "Next" /></a>
			<#else>
			<@spring.messageText "admin.veterinarian.query.result.btn.next", "Next" />
			</#if>
			&nbsp;<@spring.messageArgsText "admin.veterinarian.query.result.pageInfo", ["${page.currentPageNo}", "${page.totalPages}", "${page.totalCount}"], "Page Info" />
		</td>
	</tr>
	<tr>
		<td align="center"><@spring.messageText "admin.veterinarian.query.result.title.no", "No." /></td>
		<td align="center"><@spring.messageText "admin.veterinarian.query.result.title.username", "Veterinarian Username" /></td>
		<td align="center"><@spring.messageText "admin.veterinarian.query.result.title.name", "Veterinarian Name" /></td>
		<td align="center"><@spring.messageText "admin.veterinarian.query.result.title.clinicName", "Veterinarian Clinic Name" /></td>
		<td align="center"><@spring.messageText "admin.veterinarian.query.result.title.gender", "Veterinarian Gender" /></td>
		<td align="center"><@spring.messageText "admin.veterinarian.query.result.title.telephone", "Veterinarian Telephone" /></td>
		<td align="center"><@spring.messageText "admin.veterinarian.query.result.title.email", "Veterinarian Email" /></td>
		<td align="center"><@spring.messageText "admin.veterinarian.query.result.title.createdDate", "Veterinarian Created Date" /></td>
		<td align="center"><@spring.messageText "admin.veterinarian.query.result.title.speciality", "Veterinarian Speciality" /></td>
		<td align="center"><@spring.messageText "admin.veterinarian.query.result.title.status", "Veterinarian Status" /></td>
		<td align="center"><@spring.messageText "admin.veterinarian.query.result.title.operation", "Operation" /></td>
	</tr>
	<#list page.result as veterinarian>
	<tr>
		<td align="center">${page.first + veterinarian_index}</td>
		<td>${veterinarian.username}</td>
		<td>${veterinarian.name}</td>
		<td>${veterinarian.clinic.name}</td>
		<td align="center">${allGenders["${veterinarian.gender}"]}</td>
		<td>${veterinarian.telephone}</td>
		<td>${veterinarian.email}</td>
		<td align="center">${veterinarian.createdTime?string("yyyy-MM-dd")}</td>
		<td align="center">${(allPetCategories["${veterinarian.specialityPetCategory.id}"])!"-"}</td>
		<td align="center">${userStatuses["${veterinarian.status}"]}</td>
		<td align="center">
			<a href="${contextPath}/admin/veterinarian/${veterinarian.id}" target="_blank"><@spring.messageText "admin.veterinarian.query.result.oper.modify", "Modify" /></a> /
			<#if veterinarian.status != "ACTIVE">
			<a href="###" id="activeBtn_${veterinarian.id}"><@spring.messageText "admin.veterinarian.query.result.oper.active", "Active" /></a> /
			<@spring.messageText "admin.veterinarian.query.result.oper.inactive", "Inactive" />
			<#else>
			<@spring.messageText "admin.veterinarian.query.result.oper.active", "Active" /> /
			<a href="###" id="inactiveBtn_${veterinarian.id}"><@spring.messageText "admin.veterinarian.query.result.oper.inactive", "Inactive" /></a>
			</#if>
		</td>
	</tr>
	</#list>
	<tr>
		<td colspan="11" align="right">
			<#if page.hasPre>
			<a href="result?clinicName=${query.clinicName!""}&username=${query.username!""}&name=${query.name!""}&gender=${query.gender!""}&workingDateFrom=${(query.workingDateFrom?string("yyyy-MM-dd"))!""}&workingDateTo=${(query.workingDateTo?string("yyyy-MM-dd"))!""}&specialityPetCategoryId=${query.specialityPetCategoryId!""}&page.pageNo=${(page.prePage)!"1"}"><@spring.messageText "admin.veterinarian.query.result.btn.prev", "Prev" /></a>
			<#else>
			<@spring.messageText "admin.veterinarian.query.result.btn.prev", "Prev" />
			</#if>
			<#if page.hasNext>
			<a href="result?clinicName=${query.clinicName!""}&username=${query.username!""}&name=${query.name!""}&gender=${query.gender!""}&workingDateFrom=${(query.workingDateFrom?string("yyyy-MM-dd"))!""}&workingDateTo=${(query.workingDateTo?string("yyyy-MM-dd"))!""}&specialityPetCategoryId=${query.specialityPetCategoryId!""}&page.pageNo=${(page.nextPage)!"1"}"><@spring.messageText "admin.veterinarian.query.result.btn.next", "Next" /></a>
			<#else>
			<@spring.messageText "admin.veterinarian.query.result.btn.next", "Next" />
			</#if>
			&nbsp;<@spring.messageArgsText "admin.veterinarian.query.result.pageInfo", ["${page.currentPageNo}", "${page.totalPages}", "${page.totalCount}"], "Page Info" />
		</td>
	</tr>
</table>
</#if>
