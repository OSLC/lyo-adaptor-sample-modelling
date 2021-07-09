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

<%@page import="org.eclipse.lyo.oslc4j.core.model.Link" %>
<%@page import="org.eclipse.lyo.oslc4j.core.model.ServiceProvider"%>
<%@page import="org.eclipse.lyo.oslc4j.core.model.OslcConstants"%>
<%@page import="org.eclipse.lyo.oslc4j.core.OSLC4JUtils"%>
<%@page import="org.eclipse.lyo.oslc4j.core.annotation.OslcPropertyDefinition"%>
<%@page import="org.eclipse.lyo.oslc4j.core.annotation.OslcName"%>
<%@page import="java.lang.reflect.Method"%>
<%@page import="java.net.URI"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@page import="javax.xml.namespace.QName"%>
<%@page import="javax.ws.rs.core.UriBuilder"%>

<%@page import="com.sample.rm.resources.Comment"%>
<%@page import="com.sample.rm.resources.Oslc_rmDomainConstants"%>

<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>

<%
  Comment aComment = (Comment) request.getAttribute("aComment");
  String catalogUrl = UriBuilder.fromUri(OSLC4JUtils.getServletURI()).path("/catalog/singleton").build().toString();
%>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title><%= aComment.toString() %></title>

  <link href="<c:url value="/static/css/bootstrap-4.0.0-beta.min.css"/>" rel="stylesheet">
  <link href="<c:url value="/static/css/adaptor.css"/>" rel="stylesheet">

  <script src="<c:url value="/static/js/jquery-3.2.1.min.js"/>"></script>
  <script src="<c:url value="/static/js/popper-1.11.0.min.js"/>"></script>
  <script src="<c:url value="/static/js/bootstrap-4.0.0-beta.min.js"/>"></script>
  <script src="<c:url value="/static/js/ui-preview-helper.js"/>"></script>
  <script type="text/javascript">
    $(function () {setupUiPreviewOnPopover($("a.oslc-resource-link"));});
  </script>
</head>

<body>
<!-- Fixed navbar -->
  <nav class="navbar navbar-expand-lg sticky-top navbar-light bg-light">
    <div class="container">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item"><a class="nav-link" href="<c:url value="/"/>"><%= application.getServletContextName() %></a></li>
        <li class="nav-item"><a class="nav-link" href="<c:url value="<%= catalogUrl %>"/>">Service Provider Catalog</a></li>
        <li class="nav-item"><a class="nav-link" href="<c:url value="/swagger-ui/index.jsp"/>">Swagger UI</a></li>
      </ul>
    </div>
  </nav>
<!-- Begin page content -->
<div class="container">
    <div class="page-header">
        <h1>Comment: <%= aComment.toString() %></h1>
        <%
        URI shapeUri = UriBuilder.fromUri(OSLC4JUtils.getServletURI()).path(OslcConstants.PATH_RESOURCE_SHAPES).path(Oslc_rmDomainConstants.COMMENT_PATH).build();
        Collection<URI> types = aComment.getTypes();   
        %>
        <p class="lead">Resource URI:&nbsp;
        <jsp:include page="/com/sample/rm/commenttohtml.jsp"></jsp:include>
        </p>
        <p class="lead">Shape:&nbsp;
        <a href="<%=shapeUri%>"><%=shapeUri%></a>
        </p>
        <p class="lead">rdf:type(s):</p>
        <ul>
        <%for (URI type : aComment.getTypes()) {%>
        <li><a href="<%=type%>"><%=type%></a></li>
        <%}%>
        </ul>
    </div>
        <h2>Properties</h2>
        <div>
          <% Method method = null; %>
          <dl class="row">
            <% method = Comment.class.getMethod("getTitle"); %>
            <dt  class="col-sm-2 text-right"><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
            <dd class="col-sm-9">
            <%
            if (aComment.getTitle() == null) {
                out.write("<em>null</em>");
            }
            else {
                out.write(aComment.getTitle().toString());
            }
            %>
            
            </dd>
          </dl>
        </div>
        <%
        Map<QName, Object> extendedProperties = aComment.getExtendedProperties();
        if (!extendedProperties.isEmpty()) {
        %>
            <h3>Extended Properties</h3>
            <div>
            <%
            for (Map.Entry<QName, Object> entry : extendedProperties.entrySet()) 
            {
                QName key = entry.getKey();
                Object value = entry.getValue();
            %>
            <dl class="row">
                <dt  class="col-sm-2 text-right"><a href="<%=key.getNamespaceURI() + key.getLocalPart() %>"><%=key.getLocalPart()%></a></dt>
                <dd class="col-sm-9"><%= value.toString()%></dd>
            </dl>
            <%
            }
            %>
            </div>
        <%
        }
        %>
</div>
  <footer class="footer">
    <div class="container">
      <p class="text-muted">
        OSLC Adaptor was generated using <a href="http://eclipse.org/lyo">Eclipse Lyo</a>.
      </p>
    </div>
  </footer>
</body>
</html>
