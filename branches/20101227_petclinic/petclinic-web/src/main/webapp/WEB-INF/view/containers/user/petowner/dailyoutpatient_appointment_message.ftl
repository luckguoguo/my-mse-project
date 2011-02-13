<#include "*/common/taglibs.ftl" parse=true encoding="UTF-8">
<h2><a href="###"><@spring.messageText "petowner.dailyoutpatient.appointment.message", "DailyOutpatient Appointment" /></a></h2>
<#if success?? && success>
<@spring.messageArgsText "${messageCode}", ["${serialNo!''}"], "Success" />
<#else>
<@spring.messageText "${messageCode}", "Error" />
</#if>
