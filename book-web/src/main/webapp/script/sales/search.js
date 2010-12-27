Date.firstDayOfWeek = 0;
Date.format = "yyyy-mm-dd";
$(function() {
	$(".date-pick").datePicker({startDate:"2009-01-01", clickInput:true});
	
	// Initialize each button handler.
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
	action = action.replace("{startDate}", $("#startDate").val());
	action = action.replace("{endDate}", $("#endDate").val());
	$("#searchForm").attr("action", action);
	$("#searchForm").submit();
}