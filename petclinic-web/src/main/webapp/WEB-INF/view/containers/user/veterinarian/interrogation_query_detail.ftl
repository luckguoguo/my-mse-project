<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<script>
$(document).ready(function() {
});
</script>
<h2><a href="###"><@spring.messageText "veterinarian.interrogation.detail.title", "Interrogation Detail" /></a></h2>
<table width="80%">
	<tr>
		<td width="15%"><@spring.messageText "veterinarian.interrogation.detail.label.name", "Interrogation Name" /></td>
		<td width="85%">
			${(interrogation.name)!""}
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.interrogation.detail.label.pet.name", "Interrogation Pet Name" /></td>
		<td>
			${(interrogation.pet.name)!""}
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.interrogation.detail.label.pet.gender", "Interrogation Pet Gender" /></td>
		<td>
			${allPetGenders[(interrogation.pet.gender?default(""))!""]}
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.interrogation.detail.label.pet.birthdate", "Interrogation Pet Birthdate" /></td>
		<td>
			${(interrogation.pet.birthdate?string("yyyy-MM-dd"))!""}
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.interrogation.detail.label.pet.category", "Interrogation Pet Category" /></td>
		<td>
			${(interrogation.pet.category.name)!""}
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.interrogation.detail.label.pet.introduction", "Interrogation Pet Introduction" /></td>
		<td>
			${(interrogation.pet.introduction)!""}
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.interrogation.detail.label.startDate", "Interrogation StartDate" /></td>
		<td>
			${(interrogation.startDate?string("yyyy-MM-dd"))!""}
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.interrogation.detail.label.symptom", "Interrogation Symptom" /></td>
		<td>
			${(interrogation.symptom)!""}
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.interrogation.detail.label.memo", "Interrogation Memo" /></td>
		<td>
			${(interrogation.memo)!""}
		</td>
	</tr>
	<tr>
		<td></td>
		<td>
			<input type="button" value="<@spring.messageText "veterinarian.interrogation.detail.btn.diagnosis", "Diagnosis" />" onclick="javascript:location.href='${contextPath}/veterinarian/diagnosis?interrogationId=${(interrogation.id)!""}';" />
			<input type="button" value="<@spring.messageText "veterinarian.interrogation.detail.btn.close", "Close" />" onclick="javascript:window.close();" />
		</td>
	</tr>
</table>
</form>
