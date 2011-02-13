<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<script type="text/javascript" src="${contextPath}/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="${contextPath}/ckeditor/adapters/jquery.js"></script>
<script>
$(document).ready(function() {
	$("input[name='startDate']").datepicker({
		changeMonth: true,
		changeYear: true,
		dateFormat: 'yy-mm-dd',
		yearRange: 'c-70:c+70'
	});
	$("textarea[name='symptom']").ckeditor({
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
<#if interrogation.id??>
	<@spring.messageText "petowner.interrogation.form.update.title", "Update Interrogation" />
<#else>
	<@spring.messageText "petowner.interrogation.form.register.title", "Register Interrogation" />
</#if>
</a></h2>
<form id="interrogationForm" action="" method="POST">
<input type="hidden" name="id" value="${interrogation.id!""}" />
<input type="hidden" name="veterinarian.id" value="${interrogation.veterinarian.id!""}" />
<#if globalErrorMessage??>
<div class="error">
	${globalErrorMessage}
</div>
</#if>
<table width="80%">
	<tr>
		<td width="12%"><span class="required">*</span> <@spring.messageText "petowner.interrogation.form.label.name", "Interrogation Name" /></td>
		<td width="88%">
			<@spring.bind "interrogation.name" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><span class="required">*</span> <@spring.messageText "petowner.interrogation.form.label.pet", "Interrogation Pet" /></td>
		<td>
			<@spring.bind "interrogation.pet.id" />
			<@spring.formSingleSelect path="interrogation.pet.id" options=ownerPets />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><span class="required">*</span> <@spring.messageText "petowner.interrogation.form.label.startDate", "Interrogation StartDate" /></td>
		<td>
			<@spring.bind "interrogation.startDate" />
			<input type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" />
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><span class="required">*</span> <@spring.messageText "petowner.interrogation.form.label.symptom", "Interrogation Symptom" /></td>
		<td>
			<span style="color: red;"><@spring.messageText "petowner.interrogation.form.label.symptom.tips", "Interrogation Symptom Tips" /></span>
			<@spring.bind "interrogation.symptom" />
			<textarea cols="80" name="${spring.status.expression}" rows="10">${spring.status.value?default("")}</textarea>
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "petowner.interrogation.form.label.memo", "Interrogation Memo" /></td>
		<td>
			<@spring.bind "interrogation.memo" />
			<textarea cols="68" name="${spring.status.expression}" rows="2">${spring.status.value?default("")}</textarea>
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td></td>
		<td><input type="reset" value="<@spring.messageText "petowner.interrogation.form.btn.reset", "Reset" />" /><input type="submit" value="<@spring.messageText "petowner.interrogation.form.btn.submit", "Submit" />" /></td>
	</tr>
</table>
</form>
