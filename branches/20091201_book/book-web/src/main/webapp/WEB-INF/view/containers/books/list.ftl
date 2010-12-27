<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<script language="javascript" type="text/javascript" src="${contextPath}/script/books/search.js"></script>
<h1><@spring.messageText "books.list.label.title", "Book Search" /></h1>
<form id="searchForm" action="${contextPath}/books/list/" method="GET">
</form>
<table>
	<tr>
		<td><@spring.messageText "books.list.label.bookName", "Book Name" /></td>
		<td>
			<input type="text" id="bookName" value="${bookName!""}" />
		</td>
	</tr>
	<tr>
		<td></td>
		<td><input id="searchBtn" type="button" value="<@spring.messageText "books.list.label.submit", "Search" />" /></td>
	</tr>
</table>

<#if books??>
	<table>
		<tr>
			<td><@spring.messageText "books.list.label.book.isbn", "isbn" /><td>
			<td><@spring.messageText "books.list.label.book.name", "name" /><td>
			<td><@spring.messageText "books.list.label.book.author", "author" /><td>
			<td><@spring.messageText "books.list.label.book.publisher", "publisher" /><td>
			<td><@spring.messageText "books.list.label.book.publishdate", "publishdate" /><td>
			<td><@spring.messageText "books.list.label.book.price", "price" /><td>
			<td><@spring.messageText "books.list.label.book.operation", "operation" /><td>
		</tr>
		<#list books as book>
		<tr>
			<td>${book.isbn}<td>
			<td>${book.name}<td>
			<td>${book.author}<td>
			<td>${book.publisher}<td>
			<td>${book.publishDate?string("yyyy/M")}<td>
			<td>${book.price?string("0.00")}<td>
			<td><a href="${contextPath}/books/${book.id}/history" target="_blank"><@spring.messageText "books.list.label.operation.history", "See History" /></a></td>
		</tr>
		</#list>
	</table>
</#if>