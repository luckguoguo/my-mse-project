<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<script>
$(document).ready(function() {
});
</script>
<h2><a href="###">
<@spring.messageText "veterinarian.petowner.profile.title", "PetOwner Profile" />
</a></h2>
<table width="80%">
	<tr>
		<td width="20%"><@spring.messageText "veterinarian.petowner.profile.username", "PetOwner Username" /></td>
		<td width="80%">
			<@spring.bind "petOwner.username" />
			${spring.status.value?default("")}
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.petowner.profile.name", "PetOwner Name" /></td>
		<td>
			<@spring.bind "petOwner.name" />
			${spring.status.value?default("")}
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.petowner.profile.gender", "PetOwner Gender" /></td>
		<td>
			<@spring.bind "petOwner.gender" />
			${allGenders[spring.status.value?default("")]}
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.petowner.profile.birthdate", "PetOwner Birthdate" /></td>
		<td>
			<@spring.bind "petOwner.birthdate" />
			${spring.status.value?default("")}
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.petowner.profile.idcard", "PetOwner Idcard" /></td>
		<td>
			<@spring.bind "petOwner.idCard" />
			${spring.status.value?default("")}
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.petowner.profile.address", "PetOwner Address" /></td>
		<td>
			<@spring.bind "petOwner.address" />
			${spring.status.value?default("")}
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.petowner.profile.zipcode", "PetOwner Zipcode" /></td>
		<td>
			<@spring.bind "petOwner.zipcode" />
			${spring.status.value?default("")}
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.petowner.profile.telephone", "PetOwner Telephone" /></td>
		<td>
			<@spring.bind "petOwner.telephone" />
			${spring.status.value?default("")}
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.petowner.profile.email", "PetOwner Email" /></td>
		<td>
			<@spring.bind "petOwner.email" />
			${spring.status.value?default("")}
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td></td>
		<td><input type="button" value="<@spring.messageText "veterinarian.petowner.profile.btn.close", "Close" />" onclick="javascript:window.close();" /></td>
	</tr>
</table>
