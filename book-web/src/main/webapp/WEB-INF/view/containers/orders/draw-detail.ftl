<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<h1><@spring.messageText "orders.draw.detail.label.title", "Draw Order Detail" /></h1>
<table>
	<tr>
		<td><@spring.messageText "orders.draw.detail.label.operation", "Operation" /></td>
		<td>
			<input id="returnBtn" type="button" value="<@spring.messageText "orders.draw.detail.label.return", "Return" />" onclick="javascript:history.back();" />
		</td>
	</tr>
</table>
<#if order??>
	<table>
		<tr>
			<td><@spring.messageText "orders.draw.detail.label.orderdate", "Order Date" /><td>
			<td><@spring.messageText "orders.draw.detail.label.orderno", "Order No" /><td>
			<td><@spring.messageText "orders.draw.detail.label.status", "Status" /><td>
			<td><@spring.messageText "orders.draw.detail.label.num", "Num" /><td>
			<td><@spring.messageText "orders.draw.detail.label.total", "Total Price" /><td>
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
			<td><@spring.messageText "orders.draw.detail.label.isbn", "ISBN" /><td>
			<td><@spring.messageText "orders.draw.detail.label.name", "Book Name" /><td>
			<td><@spring.messageText "orders.draw.detail.label.author", "Author" /><td>
			<td><@spring.messageText "orders.draw.detail.label.publisher", "Publisher" /><td>
			<td><@spring.messageText "orders.draw.detail.label.publishDate", "Publish Date" /><td>
			<td><@spring.messageText "orders.draw.detail.label.num", "Num" /><td>
			<td><@spring.messageText "orders.draw.detail.label.price", "Price" /><td>
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

	
