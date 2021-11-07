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

<%@page import="org.eclipse.lyo.oslc4j.core.OSLC4JUtils"%>
<%@page import="javax.ws.rs.core.UriBuilder"%>
<%@page import="java.net.URI"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Latest compiled and minified CSS -->
    <title>Adaptor home</title>

    <link href="<c:url value="/static/css/bootstrap-4.0.0-beta.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/static/css/adaptor.css"/>" rel="stylesheet">

    <script src="<c:url value="/static/js/jquery-3.2.1.min.js"/>"></script>
    <script src="<c:url value="/static/js/bootstrap-4.0.0-beta.min.js"/>"></script>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h1 class="display-3"><%= application.getServletContextName() %></h1>
        <p class="lead">This is a homepage of the <em>Testing Tool</em> that was generated using
            Eclipse Lyo Toolchain Designer.</p>
        <hr class="my-4">
        <p class="lead">
            <a class="btn btn-primary btn-lg" href="<%= UriBuilder.fromUri(OSLC4JUtils.getServletURI()).path("/catalog/singleton").build() %>" role="button">Service Provider
                Catalog</a>
        </p>
        <p>Start from the Service Provider Catalog, to navigate your adaptor's services and resources, using the available Query capabilities, Selection and Creation Dialogs. 
            Note that these are end-user HTML pages, which is very useful for debugging your adaptor.</p>
        <p class="lead">
            <a class="btn btn-primary btn-lg" href="<c:url value="/swagger-ui/index.jsp"/>" role="button">Interactive Swagger UI</a>
        </p>
        <p>Use Swagger UI To interact with the adaptor services dedicated for RDF.
        </p>
        <p>You can also copy <a href="<%= UriBuilder.fromUri(OSLC4JUtils.getServletURI()).path("/openapi.yaml").build() %>">this OpenAPI specification document (yaml file) of this adaptor</a> to a <a href="<%= "https://editor.swagger.io" %>">Swagger Editor</a> to generate client SDK code for a number of languages and platforms.
        </p>
    </div>
</div>
</body>
</html>
