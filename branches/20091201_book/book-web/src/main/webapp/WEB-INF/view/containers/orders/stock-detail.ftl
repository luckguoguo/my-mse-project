<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<script language="javascript" type="text/javascript" src="${contextPath}/script/orders/stock-detail.js"></script>
<h1><@spring.messageText "orders.stock.detail.label.title", "Stock Order Detail" /></h1>
<form id="verifyForm" action="${contextPath}/orders/stock/verify/${order.id}" method="POST">
	<input type="hidden" name="_method" value="put"/>
</form>
<table>
	<tr>
		<td><@spring.messageText "orders.stock.detail.label.operation", "Operation" /></td>
		<td>
			<#if order.status != "VERIFY">
				<input id="verifyBtn" type="button" value="<@spring.messageText "orders.stock.detail.label.submit", "Verify" />" />
			</#if>
			<input id="returnBtn" type="button" value="<@spring.messageText "orders.stock.detail.label.return", "Return" />" />
		</td>
	</tr>
</table>

<#if order??>
	<table>
		<tr>
			<td><@spring.messageText "orders.stock.detail.label.orderdate", "Order Date" /><td>
			<td><@spring.messageText "orders.stock.detail.label.orderno", "Order No" /><td>
			<td><@spring.messageText "orders.stock.detail.label.status", "Status" /><td>
			<td><@spring.messageText "orders.stock.detail.label.num", "Num" /><td>
			<td><@spring.messageText "orders.stock.detail.label.total", "Total Price" /><td>
		</tr>
		<tr>
			<td>${order.orderDate?string("yyyy-MM-dd")}<td>
			<td>${order.orderNo}<td>
			<td>${order.status}<td>
			<td>${order.num}<td>
			<td>${order.totalPrice?string("0.00")}<td>
		</tr>
	</table>
	
	<table>
		<tr>
			<td><@spring.messageText "orders.stock.detail.label.isbn", "ISBN" /><td>
			<td><@spring.messageText "orders.stock.detail.label.name", "Book Name" /><td>
			<td><@spring.messageText "orders.stock.detail.label.author", "Author" /><td>
			<td><@spring.messageText "orders.stock.detail.label.publisher", "Publisher" /><td>
			<td><@spring.messageText "orders.stock.detail.label.publishDate", "Publish Date" /><td>
			<td><@spring.messageText "orders.stock.detail.label.num", "Num" /><td>
			<td><@spring.messageText "orders.stock.detail.label.price", "Price" /><td>
		</tr>
		<#if order.items??>
			<#list order.items as item>
			<tr>
				<td>${item.book.isbn}<td>
				<td>${item.book.name}<td>
				<td>${item.book.author}<td>
				<td>${item.book.publisher}<td>
				<td>${item.book.publishDate?string("yyyy/MM")}<td>
				<td>${item.num}<td>
				<td>${item.price?string("0.00")}<td>
			</tr>
			</#list>
		</#if>
	</table>
</#if>

	
