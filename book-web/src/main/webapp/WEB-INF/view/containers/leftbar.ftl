<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">

<div><a href="javascript:void(0);"><@spring.messageText "leftbar.menu.book", "Book Management" /></a></div>
<ul>
	<li><a href="${contextPath}/books/search/form"><@spring.messageText "leftbar.menu.book.search", "Book Search" /></a></li>
</ul>

<div><a href="javascript:void(0);"><@spring.messageText "leftbar.menu.sale", "Sale Management" /></a></div>
<ul>
	<li><a href="${contextPath}/sales/search/form"><@spring.messageText "leftbar.menu.sale.search", "Sale search" /></a></li>
</ul>

<div><a href="javascript:void(0);"><@spring.messageText "leftbar.menu.order", "Order Management" /></a></div>
<ul>
	<li><a href="${contextPath}/orders/stock/search/form"><@spring.messageText "leftbar.menu.stockOrder", "StockOrder Management" /></a></li>
	<li><a href="${contextPath}/orders/draw/search/form"><@spring.messageText "leftbar.menu.drawOrder", "DrawOrder Management" /></a></li>
	<li><a href="${contextPath}/orders/quota/search/form"><@spring.messageText "leftbar.menu.quotaOrder", "QuotaOrder Management" /></a></li>
</ul>