<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<h2><@spring.messageText "user.left.unlogin.information", "Information" /></h2>
<p class="welcome"><@spring.messageText "user.left.unlogin.welcome", "Welcome!" /></p>
<ul class="top">
<li><a href="${contextPath}/login"><@spring.messageText "user.left.unlogin.user.login", "Login" /></a></li>
<li><a href="${contextPath}/register"><@spring.messageText "user.left.unlogin.user.register", "Register" /></a></li>
</ul>
<h2><@spring.messageText "user.left.unlogin.query", "Query" /></h2>
<ul>
<li><a href="${contextPath}/clinic/query/form"><@spring.messageText "user.left.unlogin.clinic.query", "Clinic Query" /></a></li>
<li><a href="${contextPath}/vet/query/form"><@spring.messageText "user.left.unlogin.veterinarian.query", "Veterinarian Query" /></a></li>
</ul>
<h2><@spring.messageText "user.left.unlogin.ad", "AD" /></h2>
<ul>
</ul>
