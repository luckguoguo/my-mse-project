$(function() {
	// Initialize each button handler.
	bindAddBtnEvent();
	sortItems();
	bindDelBtnEvent();
});

function bindAddBtnEvent() {
	$("#addBtn").bind("click", addBtnHandler);
}

function addBtnHandler() {
	$("#itemsTable").append("<tr>" +
			"<td><input type=\"text\" id=\"bookId\" name=\"items[].book.id\" /></td>" +
			"<td><input type=\"text\" id=\"num\" name=\"items[].num\" /></td>" +
			"<td><input type=\"button\" id=\"delBtn\" value=\"" + delBtnValue + "\" /></td>" +
					"</tr>");
	sortItems();
	bindDelBtnEvent();
}

function sortItems() {
	var i = 0;
	
	// sort bookId input
	i = 0;
	$("input[id^='bookId']").each(function() {
		var id = $(this).attr("id");
		id = id.substring(0, 6) + i++;
		$(this).attr("id", id);
	});
	i = 0;
	$("input[name$='].book.id']").each(function() {
		var name = $(this).attr("name");
		name = name.substring(0, 6) + i++ + "].book.id";
		$(this).attr("name", name);
	});
	
	// sort num input
	i = 0;
	$("input[id^='num']").each(function() {
		var id = $(this).attr("id");
		id = id.substring(0, 3) + i++;
		$(this).attr("id", id);
	});
	i = 0;
	$("input[name$='].num']").each(function() {
		var name = $(this).attr("name");
		name = name.substring(0, 6) + i++ + "].num";
		$(this).attr("name", name);
	});
	
	// sort delBtn input
	i = 0;
	$("input[id^='delBtn']").each(function() {
		var id = $(this).attr("id");
		id = id.substring(0, 6) + i++;
		$(this).attr("id", id);
	});
}

function bindDelBtnEvent() {
	$("input[id^='delBtn']").bind("click", delItemHandler);
}

function delItemHandler() {
	$(this).parent().parent().remove();
	sortItems();
	bindDelBtnEvent();
}