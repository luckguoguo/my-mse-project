<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<script language="javascript" type="text/javascript" src="${contextPath}/script/orders/draw-form.js"></script>
<script language="javascript" type="text/javascript">
	var delBtnValue = "<@spring.messageText "orders.draw.form.label.del", "Del" />";
</script>
<h1><@spring.messageText "orders.draw.form.label.title", "Draw Order Form" /></h1>
<form id="orderForm" action="${contextPath}/orders/draw/form" method="POST">
<#if globalErrorMessage??>
<div class="error">
	${globalErrorMessage}
</div>
</#if>
<table>
	<tr>
		<td><@spring.messageText "orders.draw.form.label.memo", "Memo" /></td>
		<td>
			<textarea name="memo">${(orderForm.memo)!""}</textarea>
		</td>
	</tr>
	<tr>
		<td></td>
		<td>
			<input id="submitBtn" type="submit" value="<@spring.messageText "orders.draw.form.label.submit", "Submit" />" />
			<input id="returnBtn" type="button" value="<@spring.messageText "orders.draw.form.label.return", "Return" />" />
		</td>
	</tr>
</table>

<table id="itemsTable">
	<tr>
		<td><@spring.messageText "orders.draw.form.label.book.id", "Book Id" /></td>
		<td><@spring.messageText "orders.draw.form.label.num", "Draw num" /></td>
		<td><input id="addBtn" type="button" value="<@spring.messageText "orders.draw.form.label.add", "Add" />" /></td>
	</tr>
	<#if orderForm?? && orderForm.items??>
		<#list orderForm.items as item>
			<tr>
				<td><input type="text" id="bookId${item_index}" name="items[${item_index}].book.id" value="${(item.book.id)!""}" /></td>
				<td><input type="text" id="num${item_index}" name="items[${item_index}].num" value="${(item.num)!""}" /></td>
				<td><input type="button" id="delBtn" value="<@spring.messageText "orders.draw.form.label.del", "Del" />" /></td>
			</tr>
		</#list>
	</#if>
</table>
</form>