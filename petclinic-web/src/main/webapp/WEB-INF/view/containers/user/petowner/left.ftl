<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<h2><@spring.messageText "petowner.left.information", "Information" /></h2>
<p class="welcome"><@spring.messageText "petowner.left.welcome", "Welcome!" />${sessionUser.name}</p>
<ul class="top">
<li><a href="#"><@spring.messageText "petowner.left.user.updateProfile", "Update Profile" /></a></li>
<li><a href="#"><@spring.messageText "petowner.left.user.updatePassword", "Update Password" /></a></li>
<li><a href="${contextPath}/logout"><@spring.messageText "petowner.left.user.logout", "Logout" /></a></li>
</ul>
<h2><@spring.messageText "petowner.left.pet", "Pet" /></h2>
<ul>
<li><a href="#"><@spring.messageText "petowner.left.pet.register", "Pet Register" /></a></li>
<li><a href="#"><@spring.messageText "petowner.left.pet.query", "Pet Query" /></a></li>
</ul>
<h2><@spring.messageText "petowner.left.interrogation", "Interrogation" /></h2>
<ul>
<li><a href="#"><@spring.messageText "petowner.left.interrogation.register", "Interrogation Register" /></a></li>
<li><a href="#"><@spring.messageText "petowner.left.interrogation.query", "Interrogation Query" /></a></li>
</ul>
<h2><@spring.messageText "petowner.left.appointment", "Appointment" /></h2>
<ul>
<li><a href="#"><@spring.messageText "petowner.left.appointment.register", "Appointment Register" /></a></li>
<li><a href="#"><@spring.messageText "petowner.left.appointment.query", "Appointment Query" /></a></li>
</ul>