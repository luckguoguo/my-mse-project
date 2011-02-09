<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<h2><a href="###"><@spring.messageText "user.index.p1.title", "P1 Title" /></a></h2>
<div class="center">
<@spring.messageArgsText "user.index.p1.content", ["${contextPath}/login", "${contextPath}/register"], "P1 Content" />
<br /><br />
<img src="${contextPath}/image/user/pic.jpg" alt="Example pic" style="border: 3px solid #ccc;" />
</div>

<h2><a href="###"><@spring.messageText "user.index.p2.title", "P2 Title" /></a></h2>
<div class="center">
<@spring.messageArgsText "user.index.p2.content", ["${contextPath}/login", "${contextPath}/register"], "P2 Content" />
</div>

<h2><a href="###"><@spring.messageText "user.index.p3.title", "P3 Title" /></a></h2>
<div class="center">
<@spring.messageArgsText "user.index.p3.content", ["${contextPath}/login", "${contextPath}/register"], "P3 Content" />
</div>