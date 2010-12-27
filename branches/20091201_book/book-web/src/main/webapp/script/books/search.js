$(function() {
	// Initialize each button handler.
	$("#bookName").focus();
	
	$("#searchBtn").bind("click", searchHandler);
	
	$(":input").each( function() {
		$(this).keypress( function(e) {
			var key = window.event ? e.keyCode : e.which;
			if (key.toString() == "13") {
				$("#searchBtn").click();
			}
		});
	});
});

function searchHandler() {
	var action = $("#searchForm").attr("action");
	if ($("#bookName").val() != "") {
		$("#searchForm").attr("action", action + $("#bookName").val() + "/");
	}
	$("#searchForm").submit();
}