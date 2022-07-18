<%--To avoid the overriding of any manual code changes upon subsequent code generations, disable "Generate JSP Files" option in the Adaptor model.--%>
<!DOCTYPE html>
<%--
 Copyright (c) 2020 Contributors to the Eclipse Foundation
 
 See the NOTICE file(s) distributed with this work for additional
 information regarding copyright ownership.
 
 This program and the accompanying materials are made available under the
 terms of the Eclipse Distribution License 1.0 which is available at
 http://www.eclipse.org/org/documents/edl-v10.php.
 
 SPDX-License-Identifier: BSD-3-Simple

 This file is generated by Lyo Designer (https://www.eclipse.org/lyo/)
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>

<%
  String resourceTitle = (String) request.getAttribute("resourceTitle");
  String resourcePreviewDataSet = (String) request.getAttribute("resourcePreviewDataSet");
%>

<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title><%= resourceTitle %></title>
</head>

<body>
    <oslc-small-preview input-data='<%=resourcePreviewDataSet%>' id="oslc-small-preview-id" title="<%=resourceTitle%>"></oslc-small-preview>

    <script src="<c:url value="/static/dist/oslc-ui/main.js"/>" type="module"></script> 

</body>
</html>
