<#setting url_escaping_charset="UTF-8">
<#import "spring.ftl" as spring />
<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign tiles=JspTaglibs["http://tiles.apache.org/tags-tiles"]>
<#assign contextPath=Request["javax.servlet.forward.context_path"]>
<#assign requestUri=Request["javax.servlet.forward.request_uri"]!"">
<#assign queryString=Request["javax.servlet.forward.query_string"]!"">