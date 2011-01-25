<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><@spring.messageText "admin.page.title", "Pet Clinic - Backend" /></title>
	<meta http-equiv="Content-Language" content="<@spring.messageText "admin.page.content.language", "English" />" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/style/admin/style.css" media="screen" />
	<script language="javascript" type="text/javascript" src="${contextPath}/script/jquery/jquery-1.4.min.js"></script>
	<script language="javascript" type="text/javascript">
		var ctx = "${contextPath}";
	</script>
</head>
<body>
	<div id="wrap">
		<div id="header">
			<@tiles.insertAttribute name="header" />
		</div>
		<div id="content">
			<div class="right">
				<@tiles.insertAttribute name="body" />
			</div>
			<div class="left">
				<@tiles.insertAttribute name="left" />
			</div>
		</div>
		<div style="clear: both;"> </div>
		<div id="footer">
			<@tiles.insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>