<%--To avoid the overriding of any manual code changes upon subsequent code generations, disable "Generate JSP Files" option in the Adaptor model.--%>
<!DOCTYPE html>
<%--
 Copyright (c) 2020 KTH Royal Institute of Technology.

 All rights reserved. This program and the accompanying materials
 are made available under the terms of the Eclipse Public License v1.0
 and Eclipse Distribution License v. 1.0 which accompanies this distribution.

 The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 and the Eclipse Distribution License is available at
 http://www.eclipse.org/org/documents/edl-v10.php.

 This file is generated by org.eclipse.lyo.oslc4j.codegenerator
--%>

<%@page import="org.eclipse.lyo.oslc4j.core.OSLC4JUtils"%>
<%@page import="javax.ws.rs.core.UriBuilder"%>
<%@page import="java.net.URI"%>
<%@page import="java.io.File"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
URI yamlPath = UriBuilder.fromUri(OSLC4JUtils.getServletURI()).path("/openapi.yaml").build();
%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Swagger UI</title>
   <link rel="stylesheet" type="text/css" href="./dist/swagger-ui.css" >
   <link rel="icon" type="image/png" href="./dist/favicon-32x32.png" sizes="32x32" />
   <link rel="icon" type="image/png" href="./dist/favicon-16x16.png" sizes="16x16" />
   <style>
     html
     {
       box-sizing: border-box;
       overflow: -moz-scrollbars-vertical;
       overflow-y: scroll;
     }

     *,
     *:before,
     *:after
     {
       box-sizing: inherit;
     }

     body
     {
       margin:0;
       background: #fafafa;
     }
   </style>
</head>
<body>
    <div id="swagger-ui"></div>
    <script src="./dist/swagger-ui-bundle.js"> </script>
    <script src="./dist/swagger-ui-standalone-preset.js"> </script>
    <script>
     window.onload = function() {
       // Begin Swagger UI call region
       const ui = SwaggerUIBundle({
         url: "<%=yamlPath%>",
         dom_id: '#swagger-ui',
         deepLinking: true,
         presets: [
           SwaggerUIBundle.presets.apis,
           SwaggerUIStandalonePreset
         ],
         plugins: [
           SwaggerUIBundle.plugins.DownloadUrl
         ],
         layout: "StandaloneLayout"
       })
       // End Swagger UI call region
 
       window.ui = ui
     }
</script>
</body>
</html>
