<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<script>
$(document).ready(function() {
	$("input[name='birthdate']").datepicker({
		changeMonth: true,
		changeYear: true,
		dateFormat: 'yy-mm-dd',
		yearRange: 'c-70:c+70'
	});
});
</script>
<h2><a href="###">
<#if petOwner.id??>
	<@spring.messageText "petowner.profile.form.update.title", "Update PetOwner" />
<#else>
	<@spring.messageText "petowner.profile.form.register.title", "Register PetOwner" />
</#if>
</a></h2>
<form id="petOwnerForm" action="" method="POST">
<input type="hidden" name="id" value="${petOwner.id!""}" />
<#if globalErrorMessage??>
<div class="error">
	${globalErrorMessage}
</div>
</#if>
<table width="80%">
	<tr>
		<td width="20%"><span class="required">*</span> <@spring.messageText "petowner.profile.form.label.username", "PetOwner Username" /></td>
		<td width="80%">
			<@spring.bind "petOwner.username" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<#if petOwner.id??>
	<input type="hidden" name="password" value="${petOwner.password!"111111"}" />
	<#else>
	<tr>
		<td><span class="required">*</span> <@spring.messageText "petowner.profile.form.label.password", "PetOwner Password" /></td>
		<td>
			<@spring.bind "petOwner.password" />
			<input type="password" name="${spring.status.expression}" value="" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "petowner.profile.form.label.confirmPassword", "PetOwner Confirm Password" /></td>
		<td>
			<@spring.bind "petOwner.confirmPassword" />
			<input type="password" name="${spring.status.expression}" value="" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	</#if>
	<tr>
		<td><span class="required">*</span> <@spring.messageText "petowner.profile.form.label.name", "PetOwner Name" /></td>
		<td>
			<@spring.bind "petOwner.name" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><span class="required">*</span> <@spring.messageText "petowner.profile.form.label.gender", "PetOwner Gender" /></td>
		<td>
			<@spring.bind "petOwner.gender" />
			<@spring.formSingleSelect path="petOwner.gender" options=allGenders />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><span class="required">*</span> <@spring.messageText "petowner.profile.form.label.birthdate", "PetOwner Birthdate" /></td>
		<td>
			<@spring.bind "petOwner.birthdate" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><span class="required">*</span> <@spring.messageText "petowner.profile.form.label.idcard", "PetOwner Idcard" /></td>
		<td>
			<@spring.bind "petOwner.idCard" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><span class="required">*</span> <@spring.messageText "petowner.profile.form.label.address", "PetOwner Address" /></td>
		<td>
			<@spring.bind "petOwner.address" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><span class="required">*</span> <@spring.messageText "petowner.profile.form.label.zipcode", "PetOwner Zipcode" /></td>
		<td>
			<@spring.bind "petOwner.zipcode" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><span class="required">*</span> <@spring.messageText "petowner.profile.form.label.telephone", "PetOwner Telephone" /></td>
		<td>
			<@spring.bind "petOwner.telephone" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><span class="required">*</span> <@spring.messageText "petowner.profile.form.label.email", "PetOwner Email" /></td>
		<td>
			<@spring.bind "petOwner.email" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td></td>
		<td><input type="reset" value="<@spring.messageText "petowner.profile.form.btn.reset", "Reset" />" /><input type="submit" value="<@spring.messageText "petowner.profile.form.btn.submit", "Submit" />" /></td>
	</tr>
</table>
</form>
