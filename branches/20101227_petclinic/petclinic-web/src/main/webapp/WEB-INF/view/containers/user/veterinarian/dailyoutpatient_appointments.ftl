<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<script>
$(document).ready(function() {
});
</script>
<h2><a href="###"><@spring.messageText "veterinarian.dailyoutpatient.appointments.title", "Pet Query" /></a></h2>
<!-- Query Results -->
<table width="100%">
	<tr>
		<td align="center"><@spring.messageText "veterinarian.dailyoutpatient.appointments.no", "No." /></td>
		<td align="center"><@spring.messageText "veterinarian.dailyoutpatient.appointments.username", "Username" /></td>
		<td align="center"><@spring.messageText "veterinarian.dailyoutpatient.appointments.name", "Name" /></td>
		<td align="center"><@spring.messageText "veterinarian.dailyoutpatient.appointments.gender", "Gender" /></td>
		<td align="center"><@spring.messageText "veterinarian.dailyoutpatient.appointments.telephone", "Telephone" /></td>
		<td align="center"><@spring.messageText "veterinarian.dailyoutpatient.appointments.email", "Email" /></td>
		<td align="center"><@spring.messageText "veterinarian.dailyoutpatient.appointments.serialNo", "Day" /></td>
		<td align="center"><@spring.messageText "veterinarian.dailyoutpatient.appointments.createdTime", "Created Date" /></td>
		<td align="center"><@spring.messageText "veterinarian.dailyoutpatient.appointments.operation", "Operation" /></td>
	</tr>
	<#list appointments as appointment>
	<tr>
		<td align="center">${appointment_index + 1}</td>
		<td>${appointment.petOwner.username}</td>
		<td>${appointment.petOwner.name}</td>
		<td align="center">${allGenders["${appointment.petOwner.gender}"]}</td>
		<td>${appointment.petOwner.telephone}</td>
		<td>${appointment.petOwner.email}</td>
		<td align="center">${appointment.serialNo}</td>
		<td align="center">${appointment.createdTime?string("yyyy-MM-dd")}</td>
		<td align="center">
			<a href="${contextPath}/veterinarian/petowner/${appointment.petOwner.username}" target="_blank"><@spring.messageText "veterinarian.dailyoutpatient.appointments.result.oper.detail", "Detail" /></a>
		</td>
	</tr>
	</#list>
</table>
