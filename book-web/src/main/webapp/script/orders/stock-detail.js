$(function() {
	// Initialize each button handler.
	$("#verifyBtn").bind("click", verifyHandler);
	$("#returnBtn").bind("click", returnHandler);
});

function verifyHandler() {
	if (confirm("Are you sure?")) {
		$("#verifyForm").submit();
	}
}

function returnHandler() {
	history.back();
}