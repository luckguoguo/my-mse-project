<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<script>
$(document).ready(function() {
	$("#clinicStarWidget").raty({
		path: "${contextPath}/image/raty",
		start: ${clinic.star!"0"},
		readOnly: true
	});
});
</script>
<h2><a href="###"><@spring.messageText "clinic.detail.title", "Clinic Detail" /></a></h2>
<table width="80%">
	<tr>
		<td><@spring.messageText "clinic.detail.label.name", "Clinic Name" /></td>
		<td>
			<@spring.bind "clinic.name" />
			${spring.status.value?default("")}
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "clinic.detail.label.grade", "Clinic Grade" /></td>
		<td>
			<@spring.bind "clinic.grade" />
			${clinicGrades[spring.status.value?default("")]}
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "clinic.detail.label.address", "Clinic Address" /></td>
		<td>
			<@spring.bind "clinic.address" />
			${spring.status.value?default("")}
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "clinic.detail.label.telephone", "Clinic Telephone" /></td>
		<td>
			<@spring.bind "clinic.telephone" />
			${spring.status.value?default("")}
			<input type="hidden" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "clinic.detail.label.email", "Clinic Email" /></td>
		<td>
			<@spring.bind "clinic.email" />
			${spring.status.value?default("")}
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "clinic.detail.label.introduction", "Clinic Introduction" /></td>
		<td>
			<@spring.bind "clinic.introduction" />
			${spring.status.value?default("")}
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "clinic.detail.label.star", "Clinic Star" /></td>
		<td>
			<@spring.bind "clinic.star" />
			<div id="clinicStarWidget"></div>
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td></td>
		<td><input type="button" value="<@spring.messageText "clinic.detail.btn.close", "Close" />" onclick="javascript:window.close();" /></td>
	</tr>
</table>

<h2><a href="###"><@spring.messageText "clinic.detail.veterinarians.title", "Clinic Veterinarians" /></a></h2>
<#if veterinarians??>
<table width="100%">
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
	<#list veterinarians as veterinarian>
	<tr>
		<td align="center">${veterinarian_index + 1}</td>
		<td>${veterinarian.username}</td>
		<td>${veterinarian.name}</td>
		<td>${veterinarian.clinic.name}</td>
		<td>${veterinarian.clinic.address}</td>
		<td align="center">${allGenders["${veterinarian.gender}"]}</td>
		<td>${veterinarian.telephone}</td>
		<td>${veterinarian.email}</td>
		<td align="center">${(veterinarian.specialityPetCategory.name)!""}</td>
		<td align="center">
			<a href="../vet/${veterinarian.id}" target="_blank"><@spring.messageText "veterinarian.query.result.oper.detail", "Detail" /></a>
		</td>
	</tr>
	</#list>
</table>
</#if>