<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<h1><@spring.messageText "orders.draw.message.label.title", "Draw Order Message" /></h1>
<p>
	${(order.orderNo)!""} <@spring.messageText "orders.draw.message.label.add.success", "Draw Order Add Success" />
	<a href="${contextPath}/orders/draw/search/form/"><@spring.messageText "orders.draw.message.label.return", "Return" /></a>
</p>
