<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<script type="text/javascript" src="${contextPath}/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="${contextPath}/ckeditor/adapters/jquery.js"></script>
<script>
$(document).ready(function() {
	$("input[name='birthdate'], input[name='workingdate']").datepicker({
		changeMonth: true,
		changeYear: true,
		dateFormat: 'yy-mm-dd',
		yearRange: 'c-70:c+70'
	});
	$("textarea[name='introduction']").ckeditor({
		toolbar: [
			['Source','-','Bold','Italic','Underline','Strike','-','NumberedList','BulletedList','-','Link','Unlink','-','Smiley','SpecialChar'],'/',
			['Styles','Format','Font','FontSize'],
			['TextColor','BGColor'],
			['Maximize']
		]
		/* toolbar_Full=[['Source','-','Save','NewPage','Preview','-','Templates'],['Cut','Copy','Paste','PasteText','PasteFromWord','-','Print','SpellChecker','Scayt'],['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],['Form','Checkbox','Radio','TextField','Textarea','Select','Button','ImageButton','HiddenField'],'/',['Bold','Italic','Underline','Strike','-','Subscript','Superscript'],['NumberedList','BulletedList','-','Outdent','Indent','Blockquote','CreateDiv'],['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],['BidiLtr','BidiRtl'],['Link','Unlink','Anchor'],['Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','PageBreak','Iframe'],'/',['Styles','Format','Font','FontSize'],['TextColor','BGColor'],['Maximize','ShowBlocks','-','About']] */
	});
});
</script>
<h2><a href="###">
<#if veterinarian.id??>
	<@spring.messageText "admin.veterinarian.form.update.title", "Update Veterinarian" />
<#else>
	<@spring.messageText "admin.veterinarian.form.register.title", "Register Veterinarian" />
</#if>
</a></h2>
<form id="veterinarianForm" action="" method="POST">
<input type="hidden" name="step" value="1" />
<input type="hidden" name="id" value="${veterinarian.id!""}" />
<input type="hidden" name="password" value="${veterinarian.password!"111111"}" />
<#if globalErrorMessage??>
<div class="error">
	${globalErrorMessage}
</div>
</#if>
<table width="80%">
	<tr>
		<td width="20%"><@spring.messageText "admin.veterinarian.form.label.clinic", "Veterinarian Clinic" /></td>
		<td width="80%">
			<@spring.bind "veterinarian.clinic.id" />
			<@spring.formSingleSelect path="veterinarian.clinic.id" options=allClinics />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.veterinarian.form.label.username", "Veterinarian Username" /></td>
		<td>
			<@spring.bind "veterinarian.username" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.veterinarian.form.label.title", "Veterinarian Title" /></td>
		<td>
			<@spring.bind "veterinarian.title" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.veterinarian.form.label.name", "Veterinarian Name" /></td>
		<td>
			<@spring.bind "veterinarian.name" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.veterinarian.form.label.gender", "Veterinarian Gender" /></td>
		<td>
			<@spring.bind "veterinarian.gender" />
			<@spring.formSingleSelect path="veterinarian.gender" options=allGenders />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.veterinarian.form.label.birthdate", "Veterinarian Birthdate" /></td>
		<td>
			<@spring.bind "veterinarian.birthdate" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.veterinarian.form.label.workingdate", "Veterinarian Workingdate" /></td>
		<td>
			<@spring.bind "veterinarian.workingdate" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.veterinarian.form.label.telephone", "Veterinarian Telephone" /></td>
		<td>
			<@spring.bind "veterinarian.telephone" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.veterinarian.form.label.email", "Veterinarian Email" /></td>
		<td>
			<@spring.bind "veterinarian.email" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.veterinarian.form.label.speciality", "Veterinarian Speiality" /></td>
		<td>
			<@spring.bind "veterinarian.specialityPetCategory.id" />
			<@spring.formSingleSelect path="veterinarian.specialityPetCategory.id" options=allPetCategories />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "admin.veterinarian.form.label.introduction", "Veterinarian Introduction" /></td>
		<td>
			<@spring.bind "veterinarian.introduction" />
			<textarea cols="80" name="${spring.status.expression}" rows="10">${spring.status.value?default("")}</textarea>
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td></td>
		<td><input type="reset" value="<@spring.messageText "admin.veterinarian.form.btn.reset", "Reset" />" /><input type="submit" value="<@spring.messageText "admin.veterinarian.form.btn.next", "Next" />" /></td>
	</tr>
</table>
</form>
