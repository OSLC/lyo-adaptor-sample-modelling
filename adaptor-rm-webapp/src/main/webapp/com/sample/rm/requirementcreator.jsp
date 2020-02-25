<%--To avoid the overriding of any manual code changes upon subsequent code generations, disable "Generate JSP Files" option in the Adaptor model.--%>
<!DOCTYPE html>
<%--
 Copyright (c) 2011, 2012 IBM Corporation and others.

 All rights reserved. This program and the accompanying materials
 are made available under the terms of the Eclipse Public License v1.0
 and Eclipse Distribution License v. 1.0 which accompanies this distribution.

 The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 and the Eclipse Distribution License is available at
 http://www.eclipse.org/org/documents/edl-v10.php.

 Contributors:

  Sam Padgett     - initial API and implementation
  Michael Fiedler - adapted for OSLC4J
  Jad El-khoury   - initial implementation of code generator (https://bugs.eclipse.org/bugs/show_bug.cgi?id=422448)

 This file is generated by org.eclipse.lyo.oslc4j.codegenerator
--%>

<%@page import="org.eclipse.lyo.oslc4j.core.model.ServiceProvider"%>
<%@page import="java.util.List" %>
<%@page import="com.sample.rm.resources.Requirement"%>
<%@page import="org.eclipse.lyo.oslc4j.core.OSLC4JUtils"%>
<%@page import="javax.ws.rs.core.UriBuilder"%>

<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>

<%
  String creatorUri = (String) request.getAttribute("creatorUri");
%>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>CreationDialog1</title>
    <script type="text/javascript" src="<%=UriBuilder.fromUri(OSLC4JUtils.getPublicURI()).path("delegatedUI.js").build().toString()%>"></script>
  </head>
  <body style="padding: 10px;">
    <div id="bugzilla-body">
    <form id="Create" method="POST" class="enter_bug_form">
        <table style="clear: both;">
          <tr>
            <td>
            <label for="identifier">identifier: </LABEL>
            <%
            out.write("<input name=\"identifier\" type=\"text\" style=\"width: 400px\" id=\"identifier\" >");
            %>
            </td>
          </tr>
          <tr>
            <td>
            <label for="title">title: </LABEL>
            <%
            out.write("<input name=\"title\" type=\"text\" style=\"width: 400px\" id=\"title\" >");
            %>
            </td>
          </tr>
          <tr>
            <td>
            <label for="description">description: </LABEL>
            <%
            out.write("<input name=\"description\" type=\"text\" style=\"width: 400px\" id=\"description\" >");
            %>
            </td>
          </tr>
          <tr>
            <td></td>
            <td>
              <input type="button"
                value="Submit"
                onclick="javascript: create( '<%= creatorUri %>' )">
              <input type="reset">
            </td>
          </tr>
        </table>
        <div style="width: 500px;">
        </div>
      </form>

      <div style="clear: both;"></div>
    </div>
  </body>
</html>
