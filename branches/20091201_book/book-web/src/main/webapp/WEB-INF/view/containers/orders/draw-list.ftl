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
<script language="javascript" type="text/javascript" src="${contextPath}/script/orders/search.js"></script>
<h1><@spring.messageText "orders.draw.list.label.title", "Draw Order Management" /></h1>
<form id="searchForm" action="${contextPath}/orders/draw/list/{status}/{startDate}to{endDate}/" method="GET">
</form>
<table>
	<tr>
		<td><@spring.messageText "orders.draw.list.label.status", "Status" /></td>
		<td>
			<select id="status">
			<#if statusList??>
				<#list statusList as statusOption>
					<#if status == statusOption>
						<option	selected value="${statusOption}">${statusOption}</option>
					<#else>
						<option	value="${statusOption}">${statusOption}</option>
					</#if>
				</#list>
			</#if>
			</select>
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "orders.draw.list.label.startDate", "Date From" /></td>
		<td>
			<input type="text" id="startDate" value="${startDate?string("yyyy-MM-dd")}" readonly="readonly" class="date-pick" />
		</td>
	</tr>
	<tr>
		<td><@spring.messageText "orders.draw.list.label.endDate", "Date To" /></td>
		<td>
			<input type="text" id="endDate" value="${endDate?string("yyyy-MM-dd")}" readonly="readonly" class="date-pick" />
		</td>
	</tr>
	<tr>
		<td></td>
		<td>
			<input id="searchBtn" type="button" value="<@spring.messageText "orders.draw.list.label.submit", "Search" />" />
			<a href="${contextPath}/orders/draw/form"><@spring.messageText "orders.draw.list.label.new", "New" /></a>
		</td>
	</tr>
</table>

<#if orders??>
	<table>
		<tr>
			<td><@spring.messageText "orders.draw.list.label.orderdate", "Order Date" /><td>
			<td><@spring.messageText "orders.draw.list.label.orderno", "Order No" /><td>
			<td><@spring.messageText "orders.draw.list.label.status", "Status" /><td>
			<td><@spring.messageText "orders.draw.list.label.num", "Num" /><td>
			<td><@spring.messageText "orders.draw.list.label.total", "Total Price" /><td>
			<td><@spring.messageText "orders.draw.list.label.operation", "Operation" /><td>
		</tr>
		<#list orders as order>
		<tr>
			<td>${order.orderDate?string("yyyy-MM-dd")}<td>
			<td>${order.orderNo}<td>
			<td>${order.status}<td>
			<td>${order.num}<td>
			<td>${order.totalPrice?string("0.00")}<td>
			<td><a href="${contextPath}/orders/draw/${order.id}"><@spring.messageText "orders.draw.list.label.detail", "See Detail" /></a></td>
		</tr>
		</#list>
	</table>
</#if>