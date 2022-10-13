// Start of user code Copyright
/*
 * Copyright (c) 2020 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Simple
 *
 * This file is generated by Lyo Designer (https://www.eclipse.org/lyo/)
 */
// End of user code

package com.sample.rm.services;

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

import javax.inject.Inject;
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
import org.apache.wink.json4j.JSONArray;
import org.eclipse.lyo.oslc4j.provider.json4j.JsonHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.eclipse.lyo.oslc4j.core.OSLC4JConstants;
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

import com.sample.rm.RMToolManager;
import com.sample.rm.ServerConstants;
import com.sample.rm.resources.Oslc_qmDomainConstants;
import com.sample.rm.resources.Oslc_rmDomainConstants;
import com.sample.rm.resources.Oslc_qmDomainConstants;
import com.sample.rm.servlet.ServiceProviderCatalogSingleton;
import com.sample.rm.resources.Person;
import com.sample.rm.resources.TestScript;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

// Start of user code imports
// End of user code

// Start of user code pre_class_code
// End of user code
@OslcService(Oslc_qmDomainConstants.QUALITY_MANAGEMENT_NAMSPACE)
@Path("service2/testScripts")
public class ServiceProviderService2 {
    @Context
    private HttpServletRequest httpServletRequest;
    @Context
    private HttpServletResponse httpServletResponse;
    @Context
    private UriInfo uriInfo;
    @Inject
    private RMToolManager delegate;

    private static final Logger log = LoggerFactory.getLogger(ServiceProviderService2.class);

    // Start of user code class_attributes
    // End of user code

    // Start of user code class_methods
    // End of user code

    public ServiceProviderService2() {
        super();
    }

    private void addCORSHeaders(final HttpServletResponse httpServletResponse) {
        // UI preview can be blocked by CORS policy.
        // add select CORS headers to every response that is embedded in an iframe.
        httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD");
        httpServletResponse.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
        httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
    }

    @OslcQueryCapability(title = "QueryCapability1", label = "QueryCapability1", resourceShape = OslcConstants.PATH_RESOURCE_SHAPES
            + "/" + Oslc_qmDomainConstants.TESTSCRIPT_PATH, resourceTypes = {
                    Oslc_qmDomainConstants.TESTSCRIPT_TYPE }, usages = {})
    @GET
    @Path("query")
    @Produces({ OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_JSON_LD, OslcMediaType.TEXT_TURTLE,
            OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON })
    @Operation(summary = "Query capability for resources of type {" + Oslc_qmDomainConstants.TESTSCRIPT_LOCALNAME
            + "}", description = "Query capability for resources of type {" + "<a href=\""
                    + Oslc_qmDomainConstants.TESTSCRIPT_TYPE + "\">" + Oslc_qmDomainConstants.TESTSCRIPT_LOCALNAME
                    + "</a>" + "}" +
                    ", with respective resource shapes {" + "<a href=\"" + "../services/"
                    + OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_qmDomainConstants.TESTSCRIPT_PATH + "\">"
                    + Oslc_qmDomainConstants.TESTSCRIPT_LOCALNAME + "</a>" + "}", responses = {
                            @ApiResponse(description = "default response", content = {
                                    @Content(mediaType = OslcMediaType.APPLICATION_RDF_XML),
                                    @Content(mediaType = OslcMediaType.APPLICATION_XML),
                                    @Content(mediaType = OslcMediaType.APPLICATION_JSON),
                                    @Content(mediaType = OslcMediaType.TEXT_TURTLE),
                                    @Content(mediaType = MediaType.TEXT_HTML) })
                    })
    public TestScript[] queryTestScripts(

            @QueryParam("oslc.where") final String where,
            @QueryParam("oslc.prefix") final String prefix,
            @QueryParam("oslc.paging") final String pagingString,
            @QueryParam("page") final String pageString,
            @QueryParam("oslc.pageSize") final String pageSizeString) throws IOException, ServletException {
        boolean paging = false;
        int page = 0;
        int pageSize = 20;
        if (null != pagingString) {
            paging = Boolean.parseBoolean(pagingString);
        }
        if (null != pageString) {
            page = Integer.parseInt(pageString);
        }
        if (null != pageSizeString) {
            pageSize = Integer.parseInt(pageSizeString);
        }

        // Start of user code queryTestScripts
        // Here additional logic can be implemented that complements main action taken
        // in RMToolManager
        // End of user code

        List<TestScript> resources = delegate.queryTestScripts(httpServletRequest, where, prefix, paging, page,
                pageSize);
        UriBuilder uriBuilder = UriBuilder.fromUri(uriInfo.getAbsolutePath())
                .queryParam("oslc.paging", "true")
                .queryParam("oslc.pageSize", pageSize)
                .queryParam("page", page);
        if (null != where) {
            uriBuilder.queryParam("oslc.where", where);
        }
        if (null != prefix) {
            uriBuilder.queryParam("oslc.prefix", prefix);
        }
        httpServletRequest.setAttribute("queryUri", uriBuilder.build().toString());
        if ((OSLC4JUtils.hasLyoStorePagingPreciseLimit() && resources.size() >= pageSize)
                || (!OSLC4JUtils.hasLyoStorePagingPreciseLimit() && resources.size() > pageSize)) {
            resources = resources.subList(0, pageSize);
            uriBuilder.replaceQueryParam("page", page + 1);
            httpServletRequest.setAttribute(OSLC4JConstants.OSLC4J_NEXT_PAGE, uriBuilder.build().toString());
        }
        return resources.toArray(new TestScript[resources.size()]);
    }

    @GET
    @Path("query")
    @Produces({ MediaType.TEXT_HTML })
    @Operation(summary = "Query capability for resources of type {" + Oslc_qmDomainConstants.TESTSCRIPT_LOCALNAME
            + "}", description = "Query capability for resources of type {" + "<a href=\""
                    + Oslc_qmDomainConstants.TESTSCRIPT_TYPE + "\">" + Oslc_qmDomainConstants.TESTSCRIPT_LOCALNAME
                    + "</a>" + "}" +
                    ", with respective resource shapes {" + "<a href=\"" + "../services/"
                    + OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_qmDomainConstants.TESTSCRIPT_PATH + "\">"
                    + Oslc_qmDomainConstants.TESTSCRIPT_LOCALNAME + "</a>" + "}", responses = {
                            @ApiResponse(description = "default response", content = {
                                    @Content(mediaType = OslcMediaType.APPLICATION_RDF_XML),
                                    @Content(mediaType = OslcMediaType.APPLICATION_XML),
                                    @Content(mediaType = OslcMediaType.APPLICATION_JSON),
                                    @Content(mediaType = OslcMediaType.TEXT_TURTLE),
                                    @Content(mediaType = MediaType.TEXT_HTML) })
                    })
    public void queryTestScriptsAsHtml(

            @QueryParam("oslc.where") final String where,
            @QueryParam("oslc.prefix") final String prefix,
            @QueryParam("oslc.paging") final String pagingString,
            @QueryParam("page") final String pageString,
            @QueryParam("oslc.pageSize") final String pageSizeString) throws ServletException, IOException {
        boolean paging = false;
        int page = 0;
        int pageSize = 20;
        if (null != pagingString) {
            paging = Boolean.parseBoolean(pagingString);
        }
        if (null != pageString) {
            page = Integer.parseInt(pageString);
        }
        if (null != pageSizeString) {
            pageSize = Integer.parseInt(pageSizeString);
        }

        // Start of user code queryTestScriptsAsHtml
        // End of user code

        List<TestScript> resources = delegate.queryTestScripts(httpServletRequest, where, prefix, paging, page,
                pageSize);

        if (resources != null) {
            // Start of user code queryTestScriptsAsHtml_setAttributes
            // End of user code

            UriBuilder uriBuilder = UriBuilder.fromUri(uriInfo.getAbsolutePath())
                    .queryParam("oslc.paging", "true")
                    .queryParam("oslc.pageSize", pageSize)
                    .queryParam("page", page);
            if (null != where) {
                uriBuilder.queryParam("oslc.where", where);
            }
            if (null != prefix) {
                uriBuilder.queryParam("oslc.prefix", prefix);
            }
            httpServletRequest.setAttribute("queryUri", uriBuilder.build().toString());

            if ((OSLC4JUtils.hasLyoStorePagingPreciseLimit() && resources.size() >= pageSize)
                    || (!OSLC4JUtils.hasLyoStorePagingPreciseLimit() && resources.size() > pageSize)) {
                resources = resources.subList(0, pageSize);
                uriBuilder.replaceQueryParam("page", page + 1);
                httpServletRequest.setAttribute(OSLC4JConstants.OSLC4J_NEXT_PAGE, uriBuilder.build().toString());
            }
            httpServletRequest.setAttribute("resourcesQueryPage", "testscripts-query-page");
            httpServletRequest.setAttribute("resources", resources);
            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/com/sample/rm/testscriptscollection.jsp");
            rd.forward(httpServletRequest, httpServletResponse);
            return;
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @OslcDialog(title = "SelectionDialog1", label = "SelectionDialog1", uri = "service2/testScripts/selector", hintWidth = "800px", hintHeight = "800px", resourceTypes = {
            Oslc_qmDomainConstants.TESTSCRIPT_TYPE }, usages = {})
    @GET
    @Path("selector")
    @Consumes({ MediaType.TEXT_HTML, MediaType.WILDCARD })
    public Response TestScriptSelector(
            @QueryParam("terms") final String terms

    ) throws ServletException, IOException, JSONException {
        UriBuilder uriBuilder = UriBuilder.fromUri(OSLC4JUtils.getServletURI())
                .path("service2/testScripts/query");
        if (null != terms) {
            uriBuilder.queryParam("oslc.searchTerms", terms);
        }
        httpServletRequest.setAttribute("selectionUri",UriBuilder.fromUri(OSLC4JUtils.getServletURI()).path(uriInfo.getPath()).build().toString());
        httpServletRequest.setAttribute("queryUri", uriBuilder.build().toString());
        httpServletRequest.setAttribute("resourceTypeLabel", "testscripts");
        httpServletRequest.setAttribute("resourceShapes", UriBuilder.fromUri(OSLC4JUtils.getServletURI()).path(OslcConstants.PATH_RESOURCE_SHAPES).path(Oslc_qmDomainConstants.TESTSCRIPT_PATH).build().toString());
        httpServletRequest.setAttribute("selector-id", "testscripts-selector");
        RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/com/sample/rm/selectiondialog.jsp");
        rd.forward(httpServletRequest, httpServletResponse);
        return null;
    }

}
