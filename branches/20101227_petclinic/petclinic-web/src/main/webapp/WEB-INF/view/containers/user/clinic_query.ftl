<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<script>
$(document).ready(function() {
});
</script>
<h2><a href="###"><@spring.messageText "clinic.query.title", "Clinic Query" /></a></h2>
<form id="clinicQueryForm" action="result" method="GET">
<#if globalErrorMessage??>
<div class="error">
	${globalErrorMessage}
</div>
</#if>
<table width="100%">
	<tr>
		<td width="10%"><@spring.messageText "clinic.query.form.label.name", "Clinic Name" /></td>
		<td width="30%">
			<@spring.bind "query.name" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
		<td width="20%"><@spring.messageText "clinic.query.form.label.grade", "Clinic Grade" /></td>
		<td width="40%">
			<@spring.bind "query.grade" />
			<@spring.formSingleSelect path="query.grade" options=clinicGrades />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "clinic.query.form.label.address", "Clinic Address" /></td>
		<td>
			<@spring.bind "query.address" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
		<td><@spring.messageText "clinic.query.form.label.star", "Clinic Star" /></td>
		<td>
			<@spring.bind "query.star" />
			<@spring.formSingleSelect path="query.star" options=clinicStars />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td></td>
		<td colspan="3"><input type="reset" value="<@spring.messageText "clinic.query.form.btn.reset", "Reset" />" /><input type="submit" value="<@spring.messageText "clinic.query.form.btn.submit", "Submit" />" /></td>
	</tr>
</table>
</form>

<!-- Query Results -->
<#if page??>
<table width="100%">
	<tr>
		<td colspan="7" align="right">
			<#if page.hasPre>
			<a href="result?name=${query.name!""}&grade=${query.grade!""}&address=${query.address!""}&star=${query.star!""}&page.pageNo=${page.prePage}"><@spring.messageText "clinic.query.result.btn.prev", "Prev" /></a>
			<#else>
			<@spring.messageText "clinic.query.result.btn.prev", "Prev" />
			</#if>
			&nbsp;
			<#if page.hasNext>
			<a href="result?name=${query.name!""}&grade=${query.grade!""}&address=${query.address!""}&star=${query.star!""}&page.pageNo=${page.nextPage}"><@spring.messageText "clinic.query.result.btn.next", "Next" /></a>
			<#else>
			<@spring.messageText "clinic.query.result.btn.next", "Next" />
			</#if>
			&nbsp;
			<@spring.messageArgsText "clinic.query.result.pageInfo", ["${page.currentPageNo}", "${page.totalPages}", "${page.totalCount}"], "Page Info" />
		</td>
	</tr>
	<tr>
		<td align="center"><@spring.messageText "clinic.query.result.title.no", "No." /></td>
		<td align="center"><@spring.messageText "clinic.query.result.title.name", "Clinic Name" /></td>
		<td align="center"><@spring.messageText "clinic.query.result.title.grade", "Clinic Grade" /></td>
		<td align="center"><@spring.messageText "clinic.query.result.title.address", "Clinic Address" /></td>
		<td align="center"><@spring.messageText "clinic.query.result.title.telephone", "Clinic Telephone" /></td>
		<td align="center"><@spring.messageText "clinic.query.result.title.star", "Clinic Star" /></td>
		<td align="center"><@spring.messageText "clinic.query.result.title.operation", "Operation" /></td>
	</tr>
	<#list page.result as clinic>
	<tr>
		<td align="center">${page.first + clinic_index}</td>
		<td>${clinic.name}</td>
		<td align="center">${clinicGrades["${clinic.grade}"]}</td>
		<td>${clinic.address}</td>
		<td>${clinic.telephone}</td>
		<td align="center">${clinicStars["${clinic.star}"]}</td>
		<td align="center">
			<a href="../../clinic/${clinic.id}" target="_blank"><@spring.messageText "clinic.query.result.oper.detail", "Detail" /></a>
		</td>
	</tr>
	</#list>
	<tr>
		<td colspan="7" align="right">
			<#if page.hasPre>
			<a href="result?name=${query.name!""}&grade=${query.grade!""}&address=${query.address!""}&star=${query.star!""}&page.pageNo=${page.prePage}"><@spring.messageText "clinic.query.result.btn.prev", "Prev" /></a>
			<#else>
			<@spring.messageText "clinic.query.result.btn.prev", "Prev" />
			</#if>
			&nbsp;
			<#if page.hasNext>
			<a href="result?name=${query.name!""}&grade=${query.grade!""}&address=${query.address!""}&star=${query.star!""}&page.pageNo=${page.nextPage}"><@spring.messageText "clinic.query.result.btn.next", "Next" /></a>
			<#else>
			<@spring.messageText "clinic.query.result.btn.next", "Next" />
			</#if>
			&nbsp;
			<@spring.messageArgsText "clinic.query.result.pageInfo", ["${page.currentPageNo}", "${page.totalPages}", "${page.totalCount}"], "Page Info" />
		</td>
	</tr>
</table>
</#if>
