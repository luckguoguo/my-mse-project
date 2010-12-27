<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<h1><@spring.messageText "sales.daily.books.label.title", "Sales Daily Books" /> ${saleDate?string("yyyy-MM-dd")}</h1>
<#if booksSaleDaily??>
	<table>
		<tr>
			<td><@spring.messageText "sales.daily.books.label.isbn", "ISBN" /><td>
			<td><@spring.messageText "sales.daily.books.label.name", "Book Name" /><td>
			<td><@spring.messageText "sales.daily.books.label.author", "Author" /><td>
			<td><@spring.messageText "sales.daily.books.label.publisher", "Publisher" /><td>
			<td><@spring.messageText "sales.daily.books.label.publishDate", "Publish Date" /><td>
			<td><@spring.messageText "sales.daily.books.label.price", "Unit Price" /><td>
			<td><@spring.messageText "sales.daily.books.label.salenum", "Sale Num" /><td>
			<td><@spring.messageText "sales.daily.books.label.saletotal", "Sale Total" /><td>
		</tr>
		<#list booksSaleDaily as bookSale>
		<tr>
			<td>${bookSale.book.isbn}<td>
			<td>${bookSale.book.name}<td>
			<td>${bookSale.book.author}<td>
			<td>${bookSale.book.publisher}<td>
			<td>${bookSale.book.publishDate?string("yyyy/MM")}<td>
			<td>${bookSale.book.price?string("0.00")}<td>
			<td>${bookSale.saleNum}<td>
			<td>${bookSale.saleTotal?string("0.00")}<td>
		</tr>
		</#list>
	</table>
</#if>