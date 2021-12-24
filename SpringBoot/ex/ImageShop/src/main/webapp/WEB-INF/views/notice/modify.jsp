<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<h2><spring:message code="notice.header.modify" /></h2>
<form:form modelAttribute="notice" action="modify">
	<form:hidden path="noticeNo" />

	<table>
		<tr>
			<td><spring:message code="notice.title" /></td>
			<td><form:input path="title"/></td>
			<td><font color="red"><form:errors path="title" /></font></td>
		</tr>
		<tr>
			<td><spring:message code="notice.content" /></td>
			<td><form:textarea path="content"/></td>
			<td><font color="red"><form:errors path="content" /></font></td>
		</tr>
	</table>
</form:form>

<div>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<button type="submit" id="btnModify"><spring:message code="action.modify" /></button>
	</sec:authorize>
	
	<button type="submit" id="btnList"><spring:message code="action.list" /></button>
</div>

<script>
	$(function(){
		
		var formObj = $("#notice");
		
		$("#btnModify").on("click", function(){
			formObj.submit();
		});
		$("#btnList").on("click", function(){
			// 페이징 관련 정보를 쿼리 파라미터로 전달한다.
			self.location="list";
		});
	});
</script>