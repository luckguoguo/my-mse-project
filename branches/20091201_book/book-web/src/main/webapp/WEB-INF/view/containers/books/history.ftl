<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<h1><@spring.messageText "books.history.label.title", "Book History" /></h1>

<#if repository??>
	<table>
		<tr>
			<td colspan="6"><@spring.messageText "books.history.label.repository", "Book Repository" /><td>
		</tr>
		<tr>
			<td><@spring.messageText "books.history.label.book.isbn", "isbn" /><td>
			<td><@spring.messageText "books.history.label.book.name", "name" /><td>
			<td><@spring.messageText "books.history.label.book.price", "price" /><td>
			<td><@spring.messageText "books.history.label.book.repository.num", "num" /></td>
		</tr>
		<tr>
			<td>${repository.book.isbn}<td>
			<td>${repository.book.name}<td>
			<td>${repository.book.price?string("0.00")}<td>
			<td>${repository.num}</td>
		</tr>
	</talbe>
</#if>

<#if sales??>
	<table>
		<tr>
			<td colspan="5"><@spring.messageText "books.history.label.sales", "Book Sales" /><td>
		</tr>
		<tr>
			<td><@spring.messageText "books.history.label.sale.date", "date" /><td>
			<td><@spring.messageText "books.history.label.sale.total", "total" /><td>
			<td><@spring.messageText "books.history.label.sale.num", "num" /><td>
		</tr>
		<#list sales as sale>
		<tr>
			<td>${sale.saleDate?string("yyyy-MM-dd")}<td>
			<td>${sale.saleTotal?string("0.00")}<td>
			<td>${sale.saleNum}<td>
		</tr>
		</#list>
	</talbe>
</#if>

<#if stockOrders??>
	<table>
		<tr>
			<td colspan="11"><@spring.messageText "books.history.label.stockOrders", "Book StockOrders" /><td>
		</tr>
		<tr>
			<td><@spring.messageText "books.history.label.stockorder.orderno", "orderno" /><td>
			<td><@spring.messageText "books.history.label.stockorder.date", "date" /><td>
			<td><@spring.messageText "books.history.label.stockorder.status", "status" /><td>
			<td><@spring.messageText "books.history.label.stockorder.price", "price" /><td>
			<td><@spring.messageText "books.history.label.stockorder.num", "num" /><td>
			<td><@spring.messageText "books.history.label.stockorder.memo", "memo" /><td>
		</tr>
		<#list stockOrders as order>
		<tr>
			<td>${order.orderNo!""}<td>
			<td>${order.orderDate?string("yyyy-MM-dd")}<td>
			<td>${order.status}<td>
			<#list order.items as item>
				<#if item.book.id == repository.book.id>
					<td>${item.price?string("0.00")}<td>
					<td>${item.num}<td>
				</#if>
			</#list>
			<td>${order.memo!""}<td>
		</tr>
		</#list>
	</talbe>
</#if>

<#if drawOrders??>
	<table>
		<tr>
			<td colspan="11"><@spring.messageText "books.history.label.drawOrders", "Book DrawOrders" /><td>
		</tr>
		<tr>
			<td><@spring.messageText "books.history.label.draworder.orderno", "orderno" /><td>
			<td><@spring.messageText "books.history.label.draworder.date", "date" /><td>
			<td><@spring.messageText "books.history.label.draworder.status", "status" /><td>
			<td><@spring.messageText "books.history.label.draworder.price", "price" /><td>
			<td><@spring.messageText "books.history.label.draworder.num", "num" /><td>
			<td><@spring.messageText "books.history.label.draworder.memo", "memo" /><td>
		</tr>
		<#list drawOrders as order>
		<tr>
			<td>${order.orderNo!""}<td>
			<td>${order.orderDate?string("yyyy-MM-dd")}<td>
			<td>${order.status}<td>
			<#list order.items as item>
				<#if item.book.id == repository.book.id>
					<td>${item.price?string("0.00")}<td>
					<td>${item.num}<td>
				</#if>
			</#list>
			<td>${order.memo!""}<td>
		</tr>
		</#list>
	</talbe>
</#if>
