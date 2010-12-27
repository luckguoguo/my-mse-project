<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<#assign sessionUser = Session["cn.edu.sjtu.book.session.user"]>
<h1><@spring.messageText "welcome.label.title", "Welcome" /> ${(sessionUser.name)!"???"}</h1>