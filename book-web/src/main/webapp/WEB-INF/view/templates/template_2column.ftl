<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
<head>
	<title>BOOK</title>
	<meta name="keywords" content="book"/>
	<meta name="description" content="book"/>
	<meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>
	<link rel="stylesheet" type="text/css" href="${contextPath}/style/global.css"></link>
	<script language="javascript" type="text/javascript" src="${contextPath}/script/jquery/jquery-1.4.min.js"></script>
	<script language="javascript" type="text/javascript">
		var ctx = "${contextPath}";
	</script>
</head>
<body>
	<div id="header">
		<@tiles.insertAttribute name="header" />
	</div>
	<div id="content">
		<div id="leftbar">
			<@tiles.insertAttribute name="leftbar" />
		</div>
		<div id="main">
			<@tiles.insertAttribute name="body" />
		</div>
	</div>
	<div id="footer">
		<@tiles.insertAttribute name="footer" />
	</div>
</body>
</html>