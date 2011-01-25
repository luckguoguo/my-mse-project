<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<h2><@spring.messageText "admin.left.information", "Information" /></h2>
<p><@spring.messageText "admin.left.welcome", "Welcome!" />${sessionUser.name}</p>
<h2><@spring.messageText "admin.left.clinic", "Clinic" /></h2>
<ul>
<li><a href="#"><@spring.messageText "admin.left.clinic.register", "Clinic Register" /></a></li>
<li><a href="#"><@spring.messageText "admin.left.clinic.query", "Clinic Query" /></a></li>
<li><a href="#"><@spring.messageText "admin.left.clinic.updateProfile", "Clinic Update Profile" /></a></li>
<li><a href="#"><@spring.messageText "admin.left.clinic.updateStatus", "Clinic Update Status" /></a></li>
</ul>
<h2><@spring.messageText "admin.left.veterinarian", "Veterinarian" /></h2>
<ul>
<li><a href="#"><@spring.messageText "admin.left.veterinarian.register", "Veterinarian Register" /></a></li>
<li><a href="#"><@spring.messageText "admin.left.veterinarian.query", "Veterinarian Query" /></a></li>
<li><a href="#"><@spring.messageText "admin.left.veterinarian.updateProfile", "Veterinarian Update Profile" /></a></li>
<li><a href="#"><@spring.messageText "admin.left.veterinarian.updateStatus", "Veterinarian Update Status" /></a></li>
</ul>