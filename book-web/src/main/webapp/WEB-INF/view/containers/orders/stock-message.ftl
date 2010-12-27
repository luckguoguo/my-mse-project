<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<h1><@spring.messageText "orders.stock.message.label.title", "Stock Order Message" /></h1>
<p>
	${(order.orderNo)!""} <@spring.messageText "orders.stock.message.label.verify.success", "Stock Order Verify Success" />
	<a href="${contextPath}/orders/stock/search/form/"><@spring.messageText "orders.stock.message.label.return", "Return" /></a>
</p>
