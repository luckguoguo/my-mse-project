<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<script>
$(document).ready(function() {
});
</script>
<h2><a href="###"><@spring.messageText "veterinarian.detail.profile.title", "Veterinarian Detail" /></a></h2>
<table width="80%">
	<tr>
		<td width="20%"><@spring.messageText "veterinarian.detail.label.clinic", "Veterinarian Clinic" /></td>
		<td width="80%">
			<@spring.bind "veterinarian.clinic.name" />
			${spring.status.value?default("")}
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.detail.label.clinic.address", "Veterinarian Email" /></td>
		<td>
			<@spring.bind "veterinarian.clinic.address" />
			${spring.status.value?default("")}
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.detail.label.username", "Veterinarian Username" /></td>
		<td>
			<@spring.bind "veterinarian.username" />
			${spring.status.value?default("")}
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.detail.label.title", "Veterinarian Title" /></td>
		<td>
			<@spring.bind "veterinarian.title" />
			${spring.status.value?default("")}
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.detail.label.name", "Veterinarian Name" /></td>
		<td>
			<@spring.bind "veterinarian.name" />
			${spring.status.value?default("")}
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.detail.label.gender", "Veterinarian Gender" /></td>
		<td>
			<@spring.bind "veterinarian.gender" />
			${allGenders[spring.status.value?default("")]}
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.detail.label.speciality", "Veterinarian Speiality" /></td>
		<td>
			<@spring.bind "veterinarian.specialityPetCategory.name" />
			${spring.status.value?default("")}
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.detail.label.birthdate", "Veterinarian Birthdate" /></td>
		<td>
			<@spring.bind "veterinarian.birthdate" />
			${spring.status.value?default("")}
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.detail.label.workingdate", "Veterinarian Workingdate" /></td>
		<td>
			<@spring.bind "veterinarian.workingdate" />
			${spring.status.value?default("")}
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.detail.label.telephone", "Veterinarian Telephone" /></td>
		<td>
			<@spring.bind "veterinarian.telephone" />
			${spring.status.value?default("")}
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.detail.label.email", "Veterinarian Email" /></td>
		<td>
			<@spring.bind "veterinarian.email" />
			${spring.status.value?default("")}
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.detail.label.introduction", "Veterinarian Introduction" /></td>
		<td>
			<@spring.bind "veterinarian.introduction" />
			${spring.status.value?default("")}
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
</table>
