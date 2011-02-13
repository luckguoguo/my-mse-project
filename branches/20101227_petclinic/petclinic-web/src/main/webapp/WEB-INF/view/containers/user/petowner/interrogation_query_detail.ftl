<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<script>
$(document).ready(function() {
<#if diagnosis?? && diagnosis.status=="STARED">
	$("#diagnosisStarWidget").raty({
		path: "${contextPath}/image/raty",
		start: ${diagnosis.star!"0"},
		readOnly: true
	});
<#else>
	$("#diagnosisStarWidget").raty({
		path: "${contextPath}/image/raty",
		start: ${diagnosis.star!"0"},
		onClick: function(score) {
			$("input[name='star']").val(score);
		}
	});
	$("#btnStar").click(function() {
		$.post(ctx + "/petowner/diagnosis/" + ${diagnosis.id} + "/star",
		{star: $("input[name='star']").val()},
		function(data) {
			alert(data.success);
			//location.href = "";
		},
		"json"
	);
	});
</#if>
});
</script>
<h2><a href="###"><@spring.messageText "petowner.interrogation.detail.title", "Interrogation Detail" /></a></h2>
<table width="80%">
	<tr>
		<td><@spring.messageText "petowner.interrogation.detail.label.name", "Interrogation Name" /></td>
		<td colspan="3">${interrogation.name}</td>
		<td><@spring.messageText "petowner.interrogation.detail.label.startDate", "Interrogation StartDate" /></td>
		<td colspan="3">${interrogation.startDate?string("yyyy-MM-dd")}</td>
	</tr>
	<tr>
		<td width="12.5%"><@spring.messageText "petowner.interrogation.detail.label.pet.name", "Interrogation Pet" /></td>
		<td width="20%">${interrogation.pet.name}</td>
		<td width="12.5%"><@spring.messageText "petowner.interrogation.detail.label.pet.gender", "Interrogation Pet Gender" /></td>
		<td width="5%">${allPetGenders[interrogation.pet.gender?default("")]}</td>
		<td width="12.5%"><@spring.messageText "petowner.interrogation.detail.label.pet.category", "Interrogation Pet Category" /></td>
		<td width="12.5%">${interrogation.pet.category.name}</td>
		<td width="12.5%"><@spring.messageText "petowner.interrogation.detail.label.pet.birthdate", "Interrogation Pet Birthdate" /></td>
		<td width="12.5%">${interrogation.pet.birthdate?string("yyyy-MM-dd")}</td>
	</tr>
	<tr>
		<td><@spring.messageText "petowner.interrogation.detail.label.pet.introduction", "Diagnosis Pet Introduction" /></td>
		<td colspan="7">${interrogation.pet.introduction}</td>
	</tr>
	<tr>
		<td><@spring.messageText "petowner.interrogation.detail.label.symptom", "Interrogation Symptom" /></td>
		<td colspan="7">${interrogation.symptom}</td>
	</tr>
	<tr>
		<td><@spring.messageText "petowner.interrogation.detail.label.memo", "Interrogation Memo" /></td>
		<td colspan="7">${interrogation.memo}</td>
	</tr>
	<#if diagnosis??>
	<#else>
	<tr>
		<td></td>
		<td colspan="7"><input type="button" value="<@spring.messageText "petowner.interrogation.detail.btn.close", "Close" />" onclick="javascript:window.close();" /></td>
	</tr>
	</#if>
</table>

<#if diagnosis??>
<table width="80%">
	<tr>
		<td colspan="2"><@spring.messageText "petowner.interrogation.detail.label.diagnosis", "Diagnosis Detail" /></td>
	</tr>
	<tr>
		<td width="12%"><@spring.messageText "petowner.interrogation.detail.label.diagnosis.createdDate", "Diagnosis Created Date" /></td>
		<td width="88%">${diagnosis.createdTime?string("yyyy-MM-dd")}</td>
	</tr>
	<tr>
		<td><@spring.messageText "petowner.interrogation.detail.label.diagnosis.symptom", "Diagnosis Symptom" /></td>
		<td>${diagnosis.symptom}</td>
	</tr>
	<tr>
		<td><@spring.messageText "petowner.interrogation.detail.label.diagnosis.diagnosis", "Diagnosis Diagnosis" /></td>
		<td>${diagnosis.diagnosis}</td>
	</tr>
	<tr>
		<td><@spring.messageText "petowner.interrogation.detail.label.diagnosis.therapy", "Diagnosis Therapy" /></td>
		<td>${diagnosis.therapy}</td>
	</tr>
	<tr>
		<td><@spring.messageText "petowner.interrogation.detail.label.diagnosis.prescription", "Diagnosis Prescription" /></td>
		<td>${diagnosis.prescription}</td>
	</tr>
	<tr>
		<td><@spring.messageText "petowner.interrogation.detail.label.diagnosis.star", "Diagnosis Star" /></td>
		<td>
			<@spring.bind "diagnosis.star" />
			<div id="diagnosisStarWidget"></div>
			<input type="hidden" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<#if diagnosis?? && diagnosis.status=="STARED">
			<#else>
			<input id="btnStar" type="button" value="<@spring.messageText "petowner.interrogation.detail.btn.star", "Star" />" />
			</#if>
		</td>
	</tr>
	<tr>
		<td></td>
		<td><input type="button" value="<@spring.messageText "petowner.interrogation.detail.btn.close", "Close" />" onclick="javascript:window.close();" /></td>
	</tr>
</table>
</#if>