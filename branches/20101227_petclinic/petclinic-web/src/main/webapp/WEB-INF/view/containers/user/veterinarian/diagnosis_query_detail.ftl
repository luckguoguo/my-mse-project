<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<script>
$(document).ready(function() {
	$("#diagnosisStarWidget").raty({
		path: "${contextPath}/image/raty",
		start: ${(diagnosis.star)!"0"},
		readOnly: true
	});
});
</script>
<h2><a href="###"><@spring.messageText "veterinarian.diagnosis.detail.title", "Diagnosis Detail" /></a></h2>
<table width="80%">
	<tr>
		<td><@spring.messageText "veterinarian.diagnosis.detail.label.interrogation.name", "Interrogation Name" /></td>
		<td colspan="3">${(diagnosis.interrogation.name)!""}</td>
		<td><@spring.messageText "veterinarian.diagnosis.detail.label.interrogation.startDate", "Interrogation StartDate" /></td>
		<td colspan="3">${(diagnosis.interrogation.startDate?string("yyyy-MM-dd"))!""}</td>
	</tr>
	<tr>
		<td width="12.5%"><@spring.messageText "veterinarian.diagnosis.detail.label.interrogation.pet.name", "Interrogation Pet" /></td>
		<td width="20%">${(diagnosis.interrogation.pet.name)!""}</td>
		<td width="12.5%"><@spring.messageText "veterinarian.diagnosis.detail.label.interrogation.pet.gender", "Interrogation Pet Gender" /></td>
		<td width="5%">${allPetGenders[(diagnosis.interrogation.pet.gender?default(""))!""]}</td>
		<td width="12.5%"><@spring.messageText "veterinarian.diagnosis.detail.label.interrogation.pet.category", "Interrogation Pet Category" /></td>
		<td width="12.5%">${(diagnosis.interrogation.pet.category.name)!""}</td>
		<td width="12.5%"><@spring.messageText "veterinarian.diagnosis.detail.label.interrogation.pet.birthdate", "Interrogation Pet Birthdate" /></td>
		<td width="12.5%">${(diagnosis.interrogation.pet.birthdate?string("yyyy-MM-dd"))!""}</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.diagnosis.detail.label.interrogation.pet.introduction", "Interrogation Pet Introduction" /></td>
		<td colspan="7">${(diagnosis.interrogation.pet.introduction)!""}</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.diagnosis.detail.label.interrogation.symptom", "Interrogation Symptom" /></td>
		<td colspan="7">${(diagnosis.interrogation.symptom)!""}</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.diagnosis.detail.label.interrogation.memo", "Interrogation Memo" /></td>
		<td colspan="7">${(diagnosis.interrogation.memo)!""}</td>
	</tr>
	<#if diagnosis??>
	<#else>
	<tr>
		<td></td>
		<td colspan="7"><input type="button" value="<@spring.messageText "veterinarian.diagnosis.detail.btn.close", "Close" />" onclick="javascript:window.close();" /></td>
	</tr>
	</#if>
</table>

<#if diagnosis??>
<table width="80%">
	<tr>
		<td colspan="2"><@spring.messageText "veterinarian.diagnosis.detail.label.diagnosis", "Diagnosis Detail" /></td>
	</tr>
	<tr>
		<td width="12%"><@spring.messageText "veterinarian.diagnosis.detail.label.diagnosis.createdDate", "Diagnosis Created Date" /></td>
		<td width="88%">${diagnosis.createdTime?string("yyyy-MM-dd")}</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.diagnosis.detail.label.diagnosis.symptom", "Diagnosis Symptom" /></td>
		<td>${diagnosis.symptom}</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.diagnosis.detail.label.diagnosis.diagnosis", "Diagnosis Diagnosis" /></td>
		<td>${diagnosis.diagnosis}</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.diagnosis.detail.label.diagnosis.therapy", "Diagnosis Therapy" /></td>
		<td>${diagnosis.therapy}</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.diagnosis.detail.label.diagnosis.prescription", "Diagnosis Prescription" /></td>
		<td>${diagnosis.prescription}</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.diagnosis.detail.label.diagnosis.star", "Diagnosis Star" /></td>
		<td>
			<@spring.bind "diagnosis.star" />
			<div id="diagnosisStarWidget"></div>
			<input type="hidden" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
		</td>
	</tr>
	<tr>
		<td></td>
		<td><input type="button" value="<@spring.messageText "veterinarian.diagnosis.detail.btn.close", "Close" />" onclick="javascript:window.close();" /></td>
	</tr>
</table>
</#if>