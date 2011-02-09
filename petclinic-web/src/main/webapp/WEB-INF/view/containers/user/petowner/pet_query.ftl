<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<script>
$(document).ready(function() {
});
</script>
<h2><a href="###"><@spring.messageText "petowner.pet.query.title", "Pet Query" /></a></h2>
<!-- Query Results -->
<table width="100%">
	<tr>
		<td align="center"><@spring.messageText "petowner.pet.query.result.title.no", "No." /></td>
		<td align="center"><@spring.messageText "petowner.pet.query.result.title.name", "Pet Name" /></td>
		<td align="center"><@spring.messageText "petowner.pet.query.result.title.category", "Pet Category" /></td>
		<td align="center"><@spring.messageText "petowner.pet.query.result.title.gender", "Pet Gender" /></td>
		<td align="center"><@spring.messageText "petowner.pet.query.result.title.birthdate", "Pet Birthdate" /></td>
		<td align="center"><@spring.messageText "petowner.pet.query.result.title.createdDate", "Pet Created Date" /></td>
		<td align="center"><@spring.messageText "petowner.pet.query.result.title.operation", "Operation" /></td>
	</tr>
	<#list pets as pet>
	<tr>
		<td align="center">${pet_index + 1}</td>
		<td>${pet.name}</td>
		<td align="center">${(pet.category.name)!"-"}</td>
		<td align="center">${allPetGenders["${pet.gender}"]}</td>
		<td align="center">${pet.birthdate?string("yyyy-MM-dd")}</td>
		<td align="center">${pet.createdTime?string("yyyy-MM-dd")}</td>
		<td align="center">
			<a href="${contextPath}/petowner/pet/${pet.id}" target="_blank"><@spring.messageText "petowner.pet.query.result.oper.modify", "Modify" /></a>
		</td>
	</tr>
	</#list>
</table>
