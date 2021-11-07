// Start of user code Copyright
/*******************************************************************************
 * Copyright (c) 2012 IBM Corporation and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompanies this distribution.
 *
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *
 *     Michael Fiedler     - initial API and implementation for Bugzilla adapter
 *     Jad El-khoury       - initial implementation of code generator (https://bugs.eclipse.org/bugs/show_bug.cgi?id=422448)
 *     Jim Amsden          - Support for UI Preview (494303)
 *
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/
// End of user code

package com.sample.testing.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.UriBuilder;

import org.apache.wink.json4j.JSONException;
import org.apache.wink.json4j.JSONObject;
import org.eclipse.lyo.oslc4j.provider.json4j.JsonHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.eclipse.lyo.oslc4j.core.OSLC4JUtils;
import org.eclipse.lyo.oslc4j.core.annotation.OslcCreationFactory;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDialog;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDialogs;
import org.eclipse.lyo.oslc4j.core.annotation.OslcQueryCapability;
import org.eclipse.lyo.oslc4j.core.annotation.OslcService;
import org.eclipse.lyo.oslc4j.core.model.Compact;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.OslcMediaType;
import org.eclipse.lyo.oslc4j.core.model.Preview;
import org.eclipse.lyo.oslc4j.core.model.ServiceProvider;
import org.eclipse.lyo.oslc4j.core.model.Link;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;

import com.sample.testing.TestingToolManager;
import com.sample.testing.TestingToolConstants;
import com.sample.testing.resources.Oslc_qmDomainConstants;
import com.sample.testing.servlet.ServiceProviderCatalogSingleton;
import com.sample.testing.resources.TestScript;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

// Start of user code imports
// End of user code

// Start of user code pre_class_code
// End of user code
@Path("testScripts")
public class TestScriptService
{
    @Context private HttpServletRequest httpServletRequest;
    @Context private HttpServletResponse httpServletResponse;
    @Context private UriInfo uriInfo;

    private static final Logger log = LoggerFactory.getLogger(TestScriptService.class);

    // Start of user code class_attributes
    // End of user code

    // Start of user code class_methods
    // End of user code

    public TestScriptService()
    {
        super();
    }

    private void addCORSHeaders (final HttpServletResponse httpServletResponse) {
        //UI preview can be blocked by CORS policy.
        //add select CORS headers to every response that is embedded in an iframe.
        httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD");
        httpServletResponse.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
        httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
    }

    @GET
    @Path("{testScriptId}")
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_JSON_LD, OslcMediaType.TEXT_TURTLE, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
    @Operation(
        summary = "GET for resources of type {'" + Oslc_qmDomainConstants.TESTSCRIPT_LOCALNAME + "'}",
        description = "GET for resources of type {'" + "<a href=\"" + Oslc_qmDomainConstants.TESTSCRIPT_TYPE + "\">" + Oslc_qmDomainConstants.TESTSCRIPT_LOCALNAME + "</a>" + "'}" +
            ", with respective resource shapes {'" + "<a href=\"" + "../services/" + OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_qmDomainConstants.TESTSCRIPT_PATH + "\">" + Oslc_qmDomainConstants.TESTSCRIPT_LOCALNAME + "</a>" + "'}",
        responses = {
            @ApiResponse(content = {@Content(mediaType = OslcMediaType.APPLICATION_RDF_XML), @Content(mediaType = OslcMediaType.APPLICATION_XML), @Content(mediaType = OslcMediaType.APPLICATION_JSON), @Content(mediaType = OslcMediaType.TEXT_TURTLE), @Content(mediaType = MediaType.TEXT_HTML), @Content(mediaType = OslcMediaType.APPLICATION_X_OSLC_COMPACT_XML)})
        }
    )
    public TestScript getTestScript(
                @PathParam("testScriptId") final String testScriptId
        ) throws IOException, ServletException, URISyntaxException
    {
        // Start of user code getResource_init
        // End of user code

        final TestScript aTestScript = TestingToolManager.getTestScript(httpServletRequest, testScriptId);

        if (aTestScript != null) {
            // Start of user code getTestScript
            // End of user code
            httpServletResponse.setHeader("ETag", TestingToolManager.getETagFromTestScript(aTestScript));
            httpServletResponse.addHeader(TestingToolConstants.HDR_OSLC_VERSION, TestingToolConstants.OSLC_VERSION_V2);
            return aTestScript;
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("{testScriptId}")
    @Produces({ MediaType.TEXT_HTML })
    @Operation(
        summary = "GET for resources of type {'" + Oslc_qmDomainConstants.TESTSCRIPT_LOCALNAME + "'}",
        description = "GET for resources of type {'" + "<a href=\"" + Oslc_qmDomainConstants.TESTSCRIPT_TYPE + "\">" + Oslc_qmDomainConstants.TESTSCRIPT_LOCALNAME + "</a>" + "'}" +
            ", with respective resource shapes {'" + "<a href=\"" + "../services/" + OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_qmDomainConstants.TESTSCRIPT_PATH + "\">" + Oslc_qmDomainConstants.TESTSCRIPT_LOCALNAME + "</a>" + "'}",
        responses = {
            @ApiResponse(content = {@Content(mediaType = OslcMediaType.APPLICATION_RDF_XML), @Content(mediaType = OslcMediaType.APPLICATION_XML), @Content(mediaType = OslcMediaType.APPLICATION_JSON), @Content(mediaType = OslcMediaType.TEXT_TURTLE), @Content(mediaType = MediaType.TEXT_HTML), @Content(mediaType = OslcMediaType.APPLICATION_X_OSLC_COMPACT_XML)})
        }
    )
    public void getTestScriptAsHtml(
        @PathParam("testScriptId") final String testScriptId
        ) throws ServletException, IOException, URISyntaxException
    {
        // Start of user code getTestScriptAsHtml_init
        // End of user code

        final TestScript aTestScript = TestingToolManager.getTestScript(httpServletRequest, testScriptId);

        if (aTestScript != null) {
            httpServletRequest.setAttribute("aTestScript", aTestScript);
            // Start of user code getTestScriptAsHtml_setAttributes
            // End of user code

            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/com/sample/testing/testscript.jsp");
            rd.forward(httpServletRequest,httpServletResponse);
            return;
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("{testScriptId}")
    @Produces({OslcMediaType.APPLICATION_X_OSLC_COMPACT_XML})
    @Operation(
        summary = "GET for resources of type {'" + Oslc_qmDomainConstants.TESTSCRIPT_LOCALNAME + "'}",
        description = "GET for resources of type {'" + "<a href=\"" + Oslc_qmDomainConstants.TESTSCRIPT_TYPE + "\">" + Oslc_qmDomainConstants.TESTSCRIPT_LOCALNAME + "</a>" + "'}" +
            ", with respective resource shapes {'" + "<a href=\"" + "../services/" + OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_qmDomainConstants.TESTSCRIPT_PATH + "\">" + Oslc_qmDomainConstants.TESTSCRIPT_LOCALNAME + "</a>" + "'}",
        responses = {
            @ApiResponse(content = {@Content(mediaType = OslcMediaType.APPLICATION_RDF_XML), @Content(mediaType = OslcMediaType.APPLICATION_XML), @Content(mediaType = OslcMediaType.APPLICATION_JSON), @Content(mediaType = OslcMediaType.TEXT_TURTLE), @Content(mediaType = MediaType.TEXT_HTML), @Content(mediaType = OslcMediaType.APPLICATION_X_OSLC_COMPACT_XML)})
        }
    )
    public Compact getTestScriptCompact(
        @PathParam("testScriptId") final String testScriptId
        ) throws ServletException, IOException, URISyntaxException
    {
        String iconUri = OSLC4JUtils.getPublicURI() + "/images/ui_preview_icon.gif";
        String smallPreviewHintHeight = "200px";
        String smallPreviewHintWidth = "300px";
        String largePreviewHintHeight = "400px";
        String largePreviewHintWidth = "600px";

        // Start of user code getTestScriptCompact_init
        //TODO: adjust the preview height & width values from the default values provided above.
        // End of user code

        final TestScript aTestScript = TestingToolManager.getTestScript(httpServletRequest, testScriptId);

        if (aTestScript != null) {
            final Compact compact = new Compact();

            compact.setAbout(aTestScript.getAbout());
            compact.setTitle(aTestScript.toString());

            compact.setIcon(new URI(iconUri));

            //Create and set attributes for OSLC preview resource
            final Preview smallPreview = new Preview();
            smallPreview.setHintHeight(smallPreviewHintHeight);
            smallPreview.setHintWidth(smallPreviewHintWidth);
            smallPreview.setDocument(UriBuilder.fromUri(aTestScript.getAbout()).path("smallPreview").build());
            compact.setSmallPreview(smallPreview);

            final Preview largePreview = new Preview();
            largePreview.setHintHeight(largePreviewHintHeight);
            largePreview.setHintWidth(largePreviewHintWidth);
            largePreview.setDocument(UriBuilder.fromUri(aTestScript.getAbout()).path("largePreview").build());
            compact.setLargePreview(largePreview);

            httpServletResponse.addHeader(TestingToolConstants.HDR_OSLC_VERSION, TestingToolConstants.OSLC_VERSION_V2);
            addCORSHeaders(httpServletResponse);
            return compact;
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("{testScriptId}/smallPreview")
    @Produces({ MediaType.TEXT_HTML })
    public void getTestScriptAsHtmlSmallPreview(
        @PathParam("testScriptId") final String testScriptId
        ) throws ServletException, IOException, URISyntaxException
    {
        // Start of user code getTestScriptAsHtmlSmallPreview_init
        // End of user code

        final TestScript aTestScript = TestingToolManager.getTestScript(httpServletRequest, testScriptId);

        if (aTestScript != null) {
            httpServletRequest.setAttribute("aTestScript", aTestScript);
            // Start of user code getTestScriptAsHtmlSmallPreview_setAttributes
            // End of user code

            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/com/sample/testing/testscriptsmallpreview.jsp");
            httpServletResponse.addHeader(TestingToolConstants.HDR_OSLC_VERSION, TestingToolConstants.OSLC_VERSION_V2);
            addCORSHeaders(httpServletResponse);
            rd.forward(httpServletRequest, httpServletResponse);
            return;
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("{testScriptId}/largePreview")
    @Produces({ MediaType.TEXT_HTML })
    public void getTestScriptAsHtmlLargePreview(
        @PathParam("testScriptId") final String testScriptId
        ) throws ServletException, IOException, URISyntaxException
    {
        // Start of user code getTestScriptAsHtmlLargePreview_init
        // End of user code

        final TestScript aTestScript = TestingToolManager.getTestScript(httpServletRequest, testScriptId);

        if (aTestScript != null) {
            httpServletRequest.setAttribute("aTestScript", aTestScript);
            // Start of user code getTestScriptAsHtmlLargePreview_setAttributes
            // End of user code

            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/com/sample/testing/testscriptlargepreview.jsp");
            httpServletResponse.addHeader(TestingToolConstants.HDR_OSLC_VERSION, TestingToolConstants.OSLC_VERSION_V2);
            addCORSHeaders(httpServletResponse);
            rd.forward(httpServletRequest, httpServletResponse);
            return;
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }
    @DELETE
    @Path("{testScriptId}")
    @Operation(
        summary = "DELETE for resources of type {'" + Oslc_qmDomainConstants.TESTSCRIPT_LOCALNAME + "'}",
        description = "DELETE for resources of type {'" + "<a href=\"" + Oslc_qmDomainConstants.TESTSCRIPT_TYPE + "\">" + Oslc_qmDomainConstants.TESTSCRIPT_LOCALNAME + "</a>" + "'}" +
            ", with respective resource shapes {'" + "<a href=\"" + "../services/" + OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_qmDomainConstants.TESTSCRIPT_PATH + "\">" + Oslc_qmDomainConstants.TESTSCRIPT_LOCALNAME + "</a>" + "'}",
        responses = {
            @ApiResponse(content = {@Content(mediaType = OslcMediaType.APPLICATION_RDF_XML), @Content(mediaType = OslcMediaType.APPLICATION_XML), @Content(mediaType = OslcMediaType.APPLICATION_JSON), @Content(mediaType = OslcMediaType.TEXT_TURTLE), @Content(mediaType = MediaType.TEXT_HTML), @Content(mediaType = OslcMediaType.APPLICATION_X_OSLC_COMPACT_XML)})
        }
    )
    public Response deleteTestScript(
                @PathParam("testScriptId") final String testScriptId
        ) throws IOException, ServletException, URISyntaxException
    {
        // Start of user code deleteTestScript_init
        // End of user code
        final TestScript aResource = TestingToolManager.getTestScript(httpServletRequest, testScriptId);

        if (aResource != null) {
            // Start of user code deleteTestScript
            // End of user code
            boolean deleted = TestingToolManager.deleteTestScript(httpServletRequest, testScriptId);
            if (deleted)
                return Response.ok().header(TestingToolConstants.HDR_OSLC_VERSION, TestingToolConstants.OSLC_VERSION_V2).build();
            else
                throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @PUT
    @Path("{testScriptId}")
    @Consumes({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_JSON_LD, OslcMediaType.TEXT_TURTLE, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON })
    @Operation(
        summary = "PUT for resources of type {'" + Oslc_qmDomainConstants.TESTSCRIPT_LOCALNAME + "'}",
        description = "PUT for resources of type {'" + "<a href=\"" + Oslc_qmDomainConstants.TESTSCRIPT_TYPE + "\">" + Oslc_qmDomainConstants.TESTSCRIPT_LOCALNAME + "</a>" + "'}" +
            ", with respective resource shapes {'" + "<a href=\"" + "../services/" + OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_qmDomainConstants.TESTSCRIPT_PATH + "\">" + Oslc_qmDomainConstants.TESTSCRIPT_LOCALNAME + "</a>" + "'}",
        responses = {
            @ApiResponse(content = {@Content(mediaType = OslcMediaType.APPLICATION_RDF_XML), @Content(mediaType = OslcMediaType.APPLICATION_XML), @Content(mediaType = OslcMediaType.APPLICATION_JSON), @Content(mediaType = OslcMediaType.TEXT_TURTLE), @Content(mediaType = MediaType.TEXT_HTML), @Content(mediaType = OslcMediaType.APPLICATION_X_OSLC_COMPACT_XML)})
        }
    )
    public Response updateTestScript(
            @HeaderParam("If-Match") final String eTagHeader,
            @PathParam("testScriptId") final String testScriptId ,
            final TestScript aResource
        ) throws IOException, ServletException
    {
        // Start of user code updateTestScript_init
        // End of user code
        final TestScript originalResource = TestingToolManager.getTestScript(httpServletRequest, testScriptId);

        if (originalResource != null) {
            final String originalETag = TestingToolManager.getETagFromTestScript(originalResource);

            if ((eTagHeader == null) || (originalETag.equals(eTagHeader))) {
                // Start of user code updateTestScript
                // End of user code
                final TestScript updatedResource = TestingToolManager.updateTestScript(httpServletRequest, aResource, testScriptId);
                httpServletResponse.setHeader("ETag", TestingToolManager.getETagFromTestScript(updatedResource));
                return Response.ok().header(TestingToolConstants.HDR_OSLC_VERSION, TestingToolConstants.OSLC_VERSION_V2).build();
            }
            else {
                throw new WebApplicationException(Status.PRECONDITION_FAILED);
            }
        }
        else {
            throw new WebApplicationException(Status.NOT_FOUND);
        }
    }

}
