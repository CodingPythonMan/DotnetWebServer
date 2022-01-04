<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<h2><spring:message code="common.error.errorOccurred" /></h2>

<a href="javascript:window.history.back();"><spring:message code="common.error.backPage" /></a><br>
<a href="/"><spring:message code="common.error.returnHome" /></a>