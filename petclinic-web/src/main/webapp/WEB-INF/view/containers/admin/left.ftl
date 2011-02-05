<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<h2><@spring.messageText "admin.left.information", "Information" /></h2>
<p class="welcome"><@spring.messageText "admin.left.welcome", "Welcome!" />${sessionUser.name}</p>
<ul class="top">
<li><a href="#"><@spring.messageText "admin.left.user.updatePassword", "Update Password" /></a></li>
<li><a href="${contextPath}/admin/logout"><@spring.messageText "admin.left.user.logout", "Logout" /></a></li>
</ul>
<h2><@spring.messageText "admin.left.clinic", "Clinic" /></h2>
<ul>
<li><a href="${contextPath}/admin/clinic"><@spring.messageText "admin.left.clinic.register", "Clinic Register" /></a></li>
<li><a href="${contextPath}/admin/clinic/query/form"><@spring.messageText "admin.left.clinic.query", "Clinic Query" /></a></li>
</ul>
<h2><@spring.messageText "admin.left.veterinarian", "Veterinarian" /></h2>
<ul>
<li><a href="#"><@spring.messageText "admin.left.veterinarian.register", "Veterinarian Register" /></a></li>
<li><a href="#"><@spring.messageText "admin.left.veterinarian.query", "Veterinarian Query" /></a></li>
</ul>