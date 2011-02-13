<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<script>
$(document).ready(function() {
	$("a[id^=activeBtn_]").click(function() {
		active($(this).attr("id").replace("activeBtn_", ""));
	});
	$("a[id^=inactiveBtn_]").click(function() {
		inactive($(this).attr("id").replace("inactiveBtn_", ""));
	});
});

function active(clinicId) {
	$.post(ctx + "/admin/clinic/" + clinicId + "/active",
		{},
		function(data) {
			location.href = "result?name=${query.name!""}&grade=${query.grade!""}&address=${query.address!""}&star=${query.star!""}&page.pageNo=${(page.currentPageNo)!"1"}";
		},
		"json"
	);
}

function inactive(clinicId) {
	$.post(ctx + "/admin/clinic/" + clinicId + "/inactive",
		{},
		function(data) {
			location.href = "result?name=${query.name!""}&grade=${query.grade!""}&address=${query.address!""}&star=${query.star!""}&page.pageNo=${(page.currentPageNo)!"0"}";
		},
		"json"
	);
}
</script>
<h2><a href="###"><@spring.messageText "admin.clinic.query.title", "Clinic Query" /></a></h2>
<form id="clinicQueryForm" action="result" method="GET">
<#if globalErrorMessage??>
<div class="error">
	${globalErrorMessage}
</div>
</#if>
<table width="100%">
	<tr>
		<td width="10%"><@spring.messageText "admin.clinic.query.form.label.name", "Clinic Name" /></td>
		<td width="30%">
			<@spring.bind "query.name" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
		<td width="20%"><@spring.messageText "admin.clinic.query.form.label.grade", "Clinic Grade" /></td>
		<td width="40%">
			<@spring.bind "query.grade" />
			<@spring.formSingleSelect path="query.grade" options=clinicGrades />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.clinic.query.form.label.address", "Clinic Address" /></td>
		<td>
			<@spring.bind "query.address" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
		<td><@spring.messageText "admin.clinic.query.form.label.star", "Clinic Star" /></td>
		<td>
			<@spring.bind "query.star" />
			<@spring.formSingleSelect path="query.star" options=clinicStars />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td></td>
		<td colspan="3"><input type="reset" value="<@spring.messageText "admin.clinic.query.form.btn.reset", "Reset" />" /><input type="submit" value="<@spring.messageText "admin.clinic.query.form.btn.submit", "Submit" />" /></td>
	</tr>
</table>
</form>

<!-- Query Results -->
<#if page??>
<table width="100%">
	<tr>
		<td colspan="9" align="right">
			<#if page.hasPre>
			<a href="result?name=${query.name!""}&grade=${query.grade!""}&address=${query.address!""}&star=${query.star!""}&page.pageNo=${page.prePage}"><@spring.messageText "admin.clinic.query.result.btn.prev", "Prev" /></a>
			<#else>
			<@spring.messageText "admin.clinic.query.result.btn.prev", "Prev" />
			</#if>
			&nbsp;
			<#if page.hasNext>
			<a href="result?name=${query.name!""}&grade=${query.grade!""}&address=${query.address!""}&star=${query.star!""}&page.pageNo=${page.nextPage}"><@spring.messageText "admin.clinic.query.result.btn.next", "Next" /></a>
			<#else>
			<@spring.messageText "admin.clinic.query.result.btn.next", "Next" />
			</#if>
			&nbsp;
			<@spring.messageArgsText "admin.clinic.query.result.pageInfo", ["${page.currentPageNo}", "${page.totalPages}", "${page.totalCount}"], "Page Info" />
		</td>
	</tr>
	<tr>
		<td align="center"><@spring.messageText "admin.clinic.query.result.no", "No." /></td>
		<td align="center"><@spring.messageText "admin.clinic.query.result.name", "Clinic Name" /></td>
		<td align="center"><@spring.messageText "admin.clinic.query.result.grade", "Clinic Grade" /></td>
		<td align="center"><@spring.messageText "admin.clinic.query.result.address", "Clinic Address" /></td>
		<td align="center"><@spring.messageText "admin.clinic.query.result.telephone", "Clinic Telephone" /></td>
		<td align="center"><@spring.messageText "admin.clinic.query.result.star", "Clinic Star" /></td>
		<td align="center"><@spring.messageText "admin.clinic.query.result.createdDate", "Clinic Created Date" /></td>
		<td align="center"><@spring.messageText "admin.clinic.query.result.status", "Clinic Status" /></td>
		<td align="center"><@spring.messageText "admin.clinic.query.result.operation", "Operation" /></td>
	</tr>
	<#list page.result as clinic>
	<tr>
		<td align="center">${page.first + clinic_index}</td>
		<td>${clinic.name}</td>
		<td align="center">${clinicGrades["${clinic.grade}"]}</td>
		<td>${clinic.address}</td>
		<td>${clinic.telephone}</td>
		<td align="center">${clinicStars["${clinic.star}"]}</td>
		<td align="center">${clinic.createdTime?string("yyyy-MM-dd")}</td>
		<td align="center">${clinicStatuses["${clinic.status}"]}</td>
		<td align="center">
			<a href="${contextPath}/admin/clinic/${clinic.id}" target="_blank"><@spring.messageText "admin.clinic.query.result.oper.modify", "Modify" /></a> /
			<#if clinic.status != "ACTIVE">
			<a href="###" id="activeBtn_${clinic.id}"><@spring.messageText "admin.clinic.query.result.oper.active", "Active" /></a> /
			<@spring.messageText "admin.clinic.query.result.oper.inactive", "Inactive" />
			<#else>
			<@spring.messageText "admin.clinic.query.result.oper.active", "Active" /> /
			<a href="###" id="inactiveBtn_${clinic.id}"><@spring.messageText "admin.clinic.query.result.oper.inactive", "Inactive" /></a>
			</#if>
		</td>
	</tr>
	</#list>
	<tr>
		<td colspan="9" align="right">
			<#if page.hasPre>
			<a href="result?name=${query.name!""}&grade=${query.grade!""}&address=${query.address!""}&star=${query.star!""}&page.pageNo=${page.prePage}"><@spring.messageText "admin.clinic.query.result.btn.prev", "Prev" /></a>
			<#else>
			<@spring.messageText "admin.clinic.query.result.btn.prev", "Prev" />
			</#if>
			&nbsp;
			<#if page.hasNext>
			<a href="result?name=${query.name!""}&grade=${query.grade!""}&address=${query.address!""}&star=${query.star!""}&page.pageNo=${page.nextPage}"><@spring.messageText "admin.clinic.query.result.btn.next", "Next" /></a>
			<#else>
			<@spring.messageText "admin.clinic.query.result.btn.next", "Next" />
			</#if>
			&nbsp;
			<@spring.messageArgsText "admin.clinic.query.result.pageInfo", ["${page.currentPageNo}", "${page.totalPages}", "${page.totalCount}"], "Page Info" />
		</td>
	</tr>
</table>
</#if>
