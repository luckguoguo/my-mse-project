<#setting url_escaping_charset="UTF-8">
<#import "spring.ftl" as spring />
<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign tiles=JspTaglibs["http://tiles.apache.org/tags-tiles"]>
<#assign contextPath=Request["javax.servlet.forward.context_path"]>
<#assign requestUri=Request["javax.servlet.forward.request_uri"]!"">
<#assign queryString=Request["javax.servlet.forward.query_string"]!"">
<#assign sessionUser=Session["cn.edu.sjtu.petclinic.session.user"]!"">

<#assign allGenders={"":"-", "MALE":"男", "FEMALE":"女"}>
<#assign clinicGrades={"":"-", "1":"一级", "2":"二级", "3":"三级"}>
<#assign clinicStars={"":"-", "1":"一星", "2":"二星", "3":"三星", "4":"四星", "5":"五星"}>
<#assign clinicStatuses={"ACTIVE":"已激活", "INACTIVE":"未激活", "PENDING":"待处理"}>