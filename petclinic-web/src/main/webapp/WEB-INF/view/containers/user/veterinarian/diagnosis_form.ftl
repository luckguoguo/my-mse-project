<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<script type="text/javascript" src="${contextPath}/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="${contextPath}/ckeditor/adapters/jquery.js"></script>
<script>
$(document).ready(function() {
	$("textarea[name='symptom'], textarea[name='diagnosis'], textarea[name='therapy'], textarea[name='prescription']").ckeditor({
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
<#if diagnosis.id??>
	<@spring.messageText "veterinarian.diagnosis.form.update.title", "Update Diagnosis" />
<#else>
	<@spring.messageText "veterinarian.diagnosis.form.register.title", "Register Diagnosis" />
</#if>
</a></h2>

<table width="80%">
	<tr>
		<td colspan="8"><@spring.messageText "veterinarian.diagnosis.form.label.interrogation", "Diagnosis Interrogation" /></td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.diagnosis.form.label.interrogation.name", "Diagnosis Name" /></td>
		<td colspan="3">${diagnosis.interrogation.name}</td>
		<td><@spring.messageText "veterinarian.diagnosis.form.label.interrogation.startDate", "Diagnosis StartDate" /></td>
		<td colspan="3">${diagnosis.interrogation.startDate?string("yyyy-MM-dd")}</td>
	</tr>
	<tr>
		<td width="12.5%"><@spring.messageText "veterinarian.diagnosis.form.label.pet.name", "Diagnosis Pet" /></td>
		<td width="20%">${diagnosis.interrogation.pet.name}</td>
		<td width="12.5%"><@spring.messageText "veterinarian.diagnosis.form.label.pet.gender", "Diagnosis Pet Gender" /></td>
		<td width="5%">${allPetGenders[diagnosis.interrogation.pet.gender?default("")]}</td>
		<td width="12.5%"><@spring.messageText "veterinarian.diagnosis.form.label.pet.category", "Diagnosis Pet Category" /></td>
		<td width="12.5%">${diagnosis.interrogation.pet.category.name}</td>
		<td width="12.5%"><@spring.messageText "veterinarian.diagnosis.form.label.pet.birthdate", "Diagnosis Pet Birthdate" /></td>
		<td width="12.5%">${diagnosis.interrogation.pet.birthdate?string("yyyy-MM-dd")}</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.diagnosis.form.label.pet.introduction", "Diagnosis Pet Introduction" /></td>
		<td colspan="7">${diagnosis.interrogation.pet.introduction}</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.diagnosis.form.label.interrogation.symptom", "Diagnosis Symptom" /></td>
		<td colspan="7">${diagnosis.interrogation.symptom}</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.diagnosis.form.label.interrogation.memo", "Diagnosis Memo" /></td>
		<td colspan="7">${diagnosis.interrogation.memo}</td>
	</tr>
</table>

<form id="diagnosisForm" action="" method="POST">
<input type="hidden" name="id" value="${diagnosis.id!""}" />
<input type="hidden" name="interrogation.id" value="${diagnosis.interrogation.id!""}" />
<#if globalErrorMessage??>
<div class="error">
	${globalErrorMessage}
</div>
</#if>
<table width="80%">
	<tr>
		<td colspan="2">
		<#if diagnosis.id??>
			<@spring.messageText "veterinarian.diagnosis.form.update.title", "Update Diagnosis" />
		<#else>
			<@spring.messageText "veterinarian.diagnosis.form.register.title", "Register Diagnosis" />
		</#if>
		</td>
	</tr>
	<tr>
		<td width="15%"><span class="required">*</span> <@spring.messageText "veterinarian.diagnosis.form.label.symptom", "Diagnosis Symptom" /></td>
		<td width="85%">
			<@spring.bind "diagnosis.symptom" />
			<textarea cols="80" name="${spring.status.expression}" rows="10">${spring.status.value?default("")}</textarea>
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><span class="required">*</span> <@spring.messageText "veterinarian.diagnosis.form.label.diagnosis", "Diagnosis Diagnosis" /></td>
		<td>
			<@spring.bind "diagnosis.diagnosis" />
			<textarea cols="80" name="${spring.status.expression}" rows="10">${spring.status.value?default("")}</textarea>
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><span class="required">*</span> <@spring.messageText "veterinarian.diagnosis.form.label.therapy", "Diagnosis Therapy" /></td>
		<td>
			<@spring.bind "diagnosis.therapy" />
			<textarea cols="80" name="${spring.status.expression}" rows="10">${spring.status.value?default("")}</textarea>
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "veterinarian.diagnosis.form.label.prescription", "Diagnosis Prescription" /></td>
		<td>
			<@spring.bind "diagnosis.prescription" />
			<textarea cols="80" name="${spring.status.expression}" rows="10">${spring.status.value?default("")}</textarea>
			<@spring.showErrors ", ", "error"/>
		</td>
	</tr>
	<tr>
		<td></td>
		<td><input type="reset" value="<@spring.messageText "veterinarian.diagnosis.form.btn.reset", "Reset" />" /><input type="submit" value="<@spring.messageText "veterinarian.diagnosis.form.btn.submit", "Submit" />" /></td>
	</tr>
</table>
</form>
