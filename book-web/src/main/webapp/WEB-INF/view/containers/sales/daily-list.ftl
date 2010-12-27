<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<link rel="stylesheet" type="text/css" href="${contextPath}/style/datePicker.css"></link>
<style>
	/* located in demo.css and creates a little calendar icon
	 * instead of a text link for "Choose date"
	 */
	a.dp-choose-date {
		float: left;
		width: 16px;
		height: 16px;
		padding: 0;
		margin: 5px 3px 0;
		display: block;
		text-indent: -2000px;
		overflow: hidden;
		background: url(${contextPath}/image/calendar.png) no-repeat;
	}
	a.dp-choose-date.dp-disabled {
		background-position: 0 -20px;
		cursor: default;
	}
	/* makes the input field shorter once the date picker code
	 * has run (to allow space for the calendar icon
	 */
	input.dp-applied {
		width: 140px;
		float: left;
	}
</style>
<script language="javascript" type="text/javascript" src="${contextPath}/script/date.js"></script>
<!--[if IE]><script language="javascript" type="text/javascript" src="${contextPath}/script/jquery/jquery.bgiframe.min.js"></script><![endif]-->
<script language="javascript" type="text/javascript" src="${contextPath}/script/jquery/jquery.datePicker.min-2.1.2.js"></script>
<script language="javascript" type="text/javascript" src="${contextPath}/script/sales/search.js"></script>
<h1><@spring.messageText "sales.daily.list.label.title", "Sales Daily Search" /></h1>
<form id="searchForm" action="${contextPath}/sales/daily/list/{startDate}to{endDate}/" method="GET">
</form>
<table>
	<tr>
		<td><@spring.messageText "sales.daily.list.label.startDate", "Date From" /></td>
		<td>
			<input type="text" id="startDate" value="${startDate?string("yyyy-MM-dd")}" readonly="readonly" class="date-pick" />
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "sales.daily.list.label.endDate", "Date To" /></td>
		<td>
			<input type="text" id="endDate" value="${endDate?string("yyyy-MM-dd")}" readonly="readonly" class="date-pick" />
		</td>
	</tr>
	<tr>
		<td></td>
		<td><input id="searchBtn" type="button" value="<@spring.messageText "sales.daily.list.label.submit", "Search" />" /></td>
	</tr>
</table>

<#if dailySales??>
	<table>
		<tr>
			<td><@spring.messageText "sales.daily.list.label.saleDate", "Sale Date" /><td>
			<td><@spring.messageText "sales.daily.list.label.total", "Total" /><td>
			<td><@spring.messageText "sales.daily.list.label.num", "Num" /><td>
			<td><@spring.messageText "sales.daily.list.label.operation", "Operation" /><td>
		</tr>
		<#list dailySales as dailySale>
		<tr>
			<td>${dailySale.saleDate?string("yyyy-MM-dd")}<td>
			<td>${dailySale.total?string("0.00")}<td>
			<td>${dailySale.num}<td>
			<td><a href="${contextPath}/sales/daily/${dailySale.saleDate?string("yyyy-MM-dd")}/books/" target="_blank"><@spring.messageText "sales.daily.list.label.books", "See books" /></a></td>
		</tr>
		</#list>
	</table>
</#if>