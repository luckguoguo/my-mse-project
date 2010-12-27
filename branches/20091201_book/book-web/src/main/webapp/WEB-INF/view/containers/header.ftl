<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">

<div>
	<h1>
		<@spring.messageText "header.label.title", "Book System" />
			<#if Session["cn.edu.sjtu.book.session.user"]?? >
			<#assign sessionUser = Session["cn.edu.sjtu.book.session.user"]>
			${sessionUser.store.name}
			<@spring.messageText "header.label.operator", "Operator" />${sessionUser.name}
			<a href="${contextPath}/logout"><@spring.messageText "header.label.logout", "Log Out" /></a>
		</#if>
	</h1>
</div>