<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<h1><@spring.messageText "orders.quota.message.label.title", "Quota Order Message" /></h1>
<p>
	${(order.orderNo)!""} <@spring.messageText "orders.quota.message.label.add.success", "Quota Order Add Success" />
	<a href="${contextPath}/orders/quota/search/form/"><@spring.messageText "orders.quota.message.label.return", "Return" /></a>
</p>
