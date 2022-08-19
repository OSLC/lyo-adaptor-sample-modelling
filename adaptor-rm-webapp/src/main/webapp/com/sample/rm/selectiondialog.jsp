<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>

<%
  String selectionUri = (String) request.getAttribute("selectionUri");
  String queryUri = (String) request.getAttribute("queryUri");
  String resourceTypeLabel = (String) request.getAttribute("resourceTypeLabel");
  String resourceShapes = (String) request.getAttribute("resourceShapes");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    </head>
    <body>
    
        <oslc-selector url="<%=queryUri%>" id="oslc-selector-id" no-data-text="No <%=resourceTypeLabel%> found" search-placeholder-text="Search for resources of type: <%=resourceTypeLabel%>" resource-shapes="<%=resourceShapes%>" label="<%=resourceTypeLabel%>"></oslc-selector>
        <script src="<c:url value="/static/dist/react/main.js"/>" type="module"></script>


    </body>
</html>
