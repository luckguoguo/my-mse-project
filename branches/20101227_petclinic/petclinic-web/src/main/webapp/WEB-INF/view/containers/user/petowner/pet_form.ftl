<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<script type="text/javascript" src="${contextPath}/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="${contextPath}/ckeditor/adapters/jquery.js"></script>
<script>
$(document).ready(function() {
	$("input[name='birthdate']").datepicker({
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
<#if pet.id??>
	<@spring.messageText "petowner.pet.form.update.title", "Update Pet" />
<#else>
	<@spring.messageText "petowner.pet.form.register.title", "Register Pet" />
</#if>
</a></h2>
<form id="petForm" action="" method="POST">
<input type="hidden" name="id" value="${pet.id!""}" />
<#if globalErrorMessage??>
<div class="error">
	${globalErrorMessage}
</div>
</#if>
<table width="80%">
	<tr>
		<td width="20%"><@spring.messageText "petowner.pet.form.label.name", "Pet Name" /></td>
		<td width="80%">
			<@spring.bind "pet.name" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "petowner.pet.form.label.category", "Pet Category" /></td>
		<td>
			<@spring.bind "pet.category.id" />
			<@spring.formSingleSelect path="pet.category.id" options=allPetCategories />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "petowner.pet.form.label.gender", "Pet Gender" /></td>
		<td>
			<@spring.bind "pet.gender" />
			<@spring.formSingleSelect path="pet.gender" options=allPetGenders />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "petowner.pet.form.label.birthdate", "Pet Birthdate" /></td>
		<td>
			<@spring.bind "pet.birthdate" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "petowner.pet.form.label.introduction", "Pet Introduction" /></td>
		<td>
			<@spring.bind "pet.introduction" />
			<textarea cols="80" name="${spring.status.expression}" rows="10">${spring.status.value?default("")}</textarea>
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td></td>
		<td><input type="reset" value="<@spring.messageText "petowner.pet.form.btn.reset", "Reset" />" /><input type="submit" value="<@spring.messageText "petowner.pet.form.btn.submit", "Next" />" /></td>
	</tr>
</table>
</form>
