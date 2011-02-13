<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<h2><@spring.messageText "veterinarian.left.information", "Information" /></h2>
<p class="welcome"><@spring.messageText "veterinarian.left.welcome", "Welcome!" />${sessionUser.name}</p>
<ul class="top">
<li><a href="${contextPath}/veterinarian/profile"><@spring.messageText "veterinarian.left.user.viewProfile", "View Profile" /></a></li>
<li><a href="${contextPath}/veterinarian/password"><@spring.messageText "veterinarian.left.user.updatePassword", "Update Password" /></a></li>
<li><a href="${contextPath}/logout"><@spring.messageText "veterinarian.left.user.logout", "Logout" /></a></li>
</ul>
<h2><@spring.messageText "veterinarian.left.interrogation", "Interrogation" /></h2>
<ul>
<li><a href="${contextPath}/veterinarian/interrogation/query/form"><@spring.messageText "veterinarian.left.interrogation.query", "Interrogation Query" /></a></li>
<li><a href="${contextPath}/veterinarian/diagnosis/query/form"><@spring.messageText "veterinarian.left.interrogation.diagnosis.query", "Diagnosis Query" /></a></li>
</ul>
<h2><@spring.messageText "veterinarian.left.appointment", "Appointment" /></h2>
<ul>
<li><a href="#"><@spring.messageText "veterinarian.left.appointment.register", "Appointment Register" /></a></li>
<li><a href="#"><@spring.messageText "veterinarian.left.appointment.query", "Appointment Query" /></a></li>
</ul>