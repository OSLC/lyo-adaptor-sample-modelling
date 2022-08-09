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
import com.sample.rm.resources.Oslc_rmDomainConstants;
import com.sample.rm.resources.Oslc_rmDomainConstants;
import com.sample.rm.servlet.ServiceProviderCatalogSingleton;
import com.sample.rm.resources.Comment;
import com.sample.rm.resources.Person;
import com.sample.rm.resources.Requirement;
import com.sample.rm.resources.TestScript;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

// Start of user code imports
// End of user code

// Start of user code pre_class_code
// End of user code
@OslcService(Oslc_rmDomainConstants.REQUIREMENTS_MANAGEMENT_NAMSPACE)
@Path("service1/requirements")
public class ServiceProviderService1
{
    @Context private HttpServletRequest httpServletRequest;
    @Context private HttpServletResponse httpServletResponse;
    @Context private UriInfo uriInfo;
    @Inject  private RMToolManager delegate;

    private static final Logger log = LoggerFactory.getLogger(ServiceProviderService1.class);

    // Start of user code class_attributes
    // End of user code

    // Start of user code class_methods
    // End of user code

    public ServiceProviderService1()
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

    @OslcQueryCapability
    (
        title = "QueryCapability",
        label = "QueryCapability",
        resourceShape = OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_rmDomainConstants.REQUIREMENT_PATH,
        resourceTypes = {Oslc_rmDomainConstants.REQUIREMENT_TYPE},
        usages = {}
    )
    @GET
    @Path("query")
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_JSON_LD, OslcMediaType.TEXT_TURTLE, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
    @Operation(
        summary = "Query capability for resources of type {" + Oslc_rmDomainConstants.REQUIREMENT_LOCALNAME + "}",
        description = "Query capability for resources of type {" + "<a href=\"" + Oslc_rmDomainConstants.REQUIREMENT_TYPE + "\">" + Oslc_rmDomainConstants.REQUIREMENT_LOCALNAME + "</a>" + "}" +
            ", with respective resource shapes {" + "<a href=\"" + "../services/" + OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_rmDomainConstants.REQUIREMENT_PATH + "\">" + Oslc_rmDomainConstants.REQUIREMENT_LOCALNAME + "</a>" + "}",
        responses = { 
            @ApiResponse(description = "default response", content = {@Content(mediaType = OslcMediaType.APPLICATION_RDF_XML), @Content(mediaType = OslcMediaType.APPLICATION_XML), @Content(mediaType = OslcMediaType.APPLICATION_JSON), @Content(mediaType = OslcMediaType.TEXT_TURTLE), @Content(mediaType = MediaType.TEXT_HTML)})
        }
    )
    public Requirement[] queryRequirements(
                                                    
                                                     @QueryParam("oslc.where") final String where,
                                                     @QueryParam("oslc.prefix") final String prefix,
                                                     @QueryParam("oslc.paging") final String pagingString,
                                                     @QueryParam("page") final String pageString,
                                                     @QueryParam("oslc.pageSize") final String pageSizeString) throws IOException, ServletException
    {
        boolean paging=false;
        int page=0;
        int pageSize=20;
        if (null != pagingString) {
            paging = Boolean.parseBoolean(pagingString);
        }
        if (null != pageString) {
            page = Integer.parseInt(pageString);
        }
        if (null != pageSizeString) {
            pageSize = Integer.parseInt(pageSizeString);
        }

        // Start of user code queryRequirements
        // Here additional logic can be implemented that complements main action taken in RMToolManager
        // End of user code

        List<Requirement> resources = delegate.queryRequirements(httpServletRequest, where, prefix, paging, page, pageSize);
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
        return resources.toArray(new Requirement [resources.size()]);
    }

    @GET
    @Path("query")
    @Produces({ MediaType.TEXT_HTML })
    @Operation(
        summary = "Query capability for resources of type {" + Oslc_rmDomainConstants.REQUIREMENT_LOCALNAME + "}",
        description = "Query capability for resources of type {" + "<a href=\"" + Oslc_rmDomainConstants.REQUIREMENT_TYPE + "\">" + Oslc_rmDomainConstants.REQUIREMENT_LOCALNAME + "</a>" + "}" +
            ", with respective resource shapes {" + "<a href=\"" + "../services/" + OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_rmDomainConstants.REQUIREMENT_PATH + "\">" + Oslc_rmDomainConstants.REQUIREMENT_LOCALNAME + "</a>" + "}",
        responses = { 
            @ApiResponse(description = "default response", content = {@Content(mediaType = OslcMediaType.APPLICATION_RDF_XML), @Content(mediaType = OslcMediaType.APPLICATION_XML), @Content(mediaType = OslcMediaType.APPLICATION_JSON), @Content(mediaType = OslcMediaType.TEXT_TURTLE), @Content(mediaType = MediaType.TEXT_HTML)})
        }
    )
    public void queryRequirementsAsHtml(
                                    
                                       @QueryParam("oslc.where") final String where,
                                       @QueryParam("oslc.prefix") final String prefix,
                                       @QueryParam("oslc.paging") final String pagingString,
                                       @QueryParam("page") final String pageString,
                                       @QueryParam("oslc.pageSize") final String pageSizeString) throws ServletException, IOException, JSONException
    {
        boolean paging=false;
        int page=0;
        int pageSize=20;
        if (null != pagingString) {
            paging = Boolean.parseBoolean(pagingString);
        }
        if (null != pageString) {
            page = Integer.parseInt(pageString);
        }
        if (null != pageSizeString) {
            pageSize = Integer.parseInt(pageSizeString);
        }

        // Start of user code queryRequirementsAsHtml
        // End of user code

        List<Requirement> resources = delegate.queryRequirements(httpServletRequest, where, prefix, paging, page, pageSize);

        if (resources!= null) {
            // Start of user code queryRequirementsAsHtml_setAttributes
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
            JSONArray resourceArray = new JSONArray();
            if(resources !=null){
            for (Requirement resource : resources) {
                JSONObject r = new JSONObject();
                // Start of user code RequirementSelector_setResponse
                // End of user code
                resourceArray.add(resource.toString());
            }}
            httpServletRequest.setAttribute("resources", resourceArray);
            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/com/sample/rm/requirementscollection.jsp");
            rd.forward(httpServletRequest,httpServletResponse);
            return;
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @OslcDialog
    (
         title = "SelectionDialog1",
         label = "SelectionDialog1",
         uri = "service1/requirements/selector",
         hintWidth = "0px",
         hintHeight = "0px",
         resourceTypes = {Oslc_rmDomainConstants.REQUIREMENT_TYPE},
         usages = {}
    )
    @GET
    @Path("selector")
    @Consumes({ MediaType.TEXT_HTML, MediaType.WILDCARD })
    public Response RequirementSelector(
        @QueryParam("terms") final String terms
        
        ) throws ServletException, IOException, JSONException
    {
        // Start of user code RequirementSelector_init
            // End of user code

        httpServletRequest.setAttribute("selectionUri",UriBuilder.fromUri(OSLC4JUtils.getServletURI()).path(uriInfo.getPath()).build().toString());
        // Start of user code RequirementSelector_setAttributes
            // End of user code

        if (terms != null ) {
            httpServletRequest.setAttribute("terms", terms);
            final List<Requirement> resources = delegate.RequirementSelector(httpServletRequest, terms);
            if (resources!= null) {
                JSONArray resourceArray = new JSONArray();
                for (Requirement resource : resources) {
                    JSONObject r = new JSONObject();
                    r.put("oslc:label", resource.toString());
                    r.put("rdf:resource", resource.getAbout().toString());
                    r.put("Label", resource.toString());
                    // Start of user code RequirementSelector_setResponse
                    // End of user code
                    resourceArray.add(r);
                }
                JSONObject response = new JSONObject();
                response.put("oslc:results", resourceArray);
                return Response.ok(response.write()).build();
            }
            log.error("A empty search should return an empty list and not NULL!");
            throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);

        } else {
            httpServletRequest.setAttribute("resourceTypeLabel", "Requirement");
            httpServletRequest.setAttribute("fieldsToList", "[\"Label\"]");
            httpServletRequest.setAttribute("resourceShapes", OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_rmDomainConstants.REQUIREMENT_PATH);
            // Start of user code RequirementSelector_setAttribute_fieldsToList
            //TODO: set the attribute "fieldsToList" to form the list of properties you want displayed in the search result
            // End of user code
            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/com/sample/rm/selectiondialog.jsp");
            rd.forward(httpServletRequest, httpServletResponse);
            return null;
        }
    }

    /**
     * Create a single Requirement via RDF/XML, XML or JSON POST
     *
     * @throws IOException
     * @throws ServletException
     */
    @OslcCreationFactory
    (
         title = "CreationFactory1",
         label = "CreationFactory1",
         resourceShapes = {OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_rmDomainConstants.REQUIREMENT_PATH},
         resourceTypes = {Oslc_rmDomainConstants.REQUIREMENT_TYPE},
         usages = {}
    )
    @POST
    @Path("create")
    @Consumes({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_JSON_LD, OslcMediaType.TEXT_TURTLE, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON })
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_JSON_LD, OslcMediaType.TEXT_TURTLE, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
    @Operation(
        summary = "Creation factory for resources of type {" + Oslc_rmDomainConstants.REQUIREMENT_LOCALNAME + "}",
        description = "Creation factory for resources of type {" + "<a href=\"" + Oslc_rmDomainConstants.REQUIREMENT_TYPE + "\">" + Oslc_rmDomainConstants.REQUIREMENT_LOCALNAME + "</a>" + "}" +
            ", with respective resource shapes {" + "<a href=\"" + "../services/" + OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_rmDomainConstants.REQUIREMENT_PATH + "\">" + Oslc_rmDomainConstants.REQUIREMENT_LOCALNAME + "</a>" + "}",
        responses = { 
            @ApiResponse(description = "default response", content = {@Content(mediaType = OslcMediaType.APPLICATION_RDF_XML), @Content(mediaType = OslcMediaType.APPLICATION_XML), @Content(mediaType = OslcMediaType.APPLICATION_JSON), @Content(mediaType = OslcMediaType.TEXT_TURTLE)})
        }
    )
    public Response createRequirement(
            
            final Requirement aResource
        ) throws IOException, ServletException
    {
        Requirement newResource = delegate.createRequirement(httpServletRequest, aResource);
        httpServletResponse.setHeader("ETag", delegate.getETagFromRequirement(newResource));
        return Response.created(newResource.getAbout()).entity(newResource).header(ServerConstants.HDR_OSLC_VERSION, ServerConstants.OSLC_VERSION_V2).build();
    }

    /**
     * OSLC delegated creation dialog for a single resource
     *
     * @throws IOException
     * @throws ServletException
     */
    @GET
    @Path("creator")
    @Consumes({MediaType.WILDCARD})
    public Response RequirementCreator(
                
        ) throws IOException, ServletException
    {
        // Start of user code RequirementCreator
        // End of user code

        httpServletRequest.setAttribute("creatorUri", UriBuilder.fromUri(OSLC4JUtils.getServletURI()).path(uriInfo.getPath()).build().toString());

        RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/com/sample/rm/requirementcreator.jsp");
        rd.forward(httpServletRequest, httpServletResponse);
        return null;
    }

    /**
     * Backend creator for the OSLC delegated creation dialog.
     *
     * Accepts the input in FormParams and returns a small JSON response
     */
    @OslcDialog
    (
         title = "CreationDialog1",
         label = "CreationDialog1",
         uri = "service1/requirements/creator",
         hintWidth = "0px",
         hintHeight = "0px",
         resourceTypes = {Oslc_rmDomainConstants.REQUIREMENT_TYPE},
         usages = {}
    )
    @POST
    @Path("creator")
    @Consumes({ MediaType.APPLICATION_FORM_URLENCODED})
    public void createRequirementFromDialog(MultivaluedMap<String, String> formParams
            
        ) throws URISyntaxException, ParseException {
        Requirement newResource = null;

        Requirement aResource = new Requirement();

        List<String> paramValues;

        paramValues = formParams.get("identifier");
        if (paramValues != null) {
                if (paramValues.size() == 1) {
                    if (paramValues.get(0).length() != 0)
                        aResource.setIdentifier(paramValues.get(0));
                    // else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
                }

        }
        paramValues = formParams.get("title");
        if (paramValues != null) {
                if (paramValues.size() == 1) {
                    if (paramValues.get(0).length() != 0)
                        aResource.setTitle(paramValues.get(0));
                    // else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
                }

        }
        paramValues = formParams.get("description");
        if (paramValues != null) {
                if (paramValues.size() == 1) {
                    if (paramValues.get(0).length() != 0)
                        aResource.setDescription(paramValues.get(0));
                    // else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
                }

        }
        paramValues = formParams.get("priority");
        if (paramValues != null) {
                if (paramValues.size() == 1) {
                    if (paramValues.get(0).length() != 0)
                        aResource.setPriority(paramValues.get(0));
                    // else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
                }

        }
        paramValues = formParams.get("approvalDate");
        if (paramValues != null) {
                if (paramValues.size() == 1) {
                    if (paramValues.get(0).length() != 0)
                        aResource.setApprovalDate(new SimpleDateFormat("M/D/y").parse(paramValues.get(0)));
                    // else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
                }

        }
        paramValues = formParams.get("status");
        if (paramValues != null) {
                if (paramValues.size() == 1) {
                    if (paramValues.get(0).length() != 0)
                        aResource.setStatus(paramValues.get(0));
                    // else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
                }

        }
        paramValues = formParams.get("author");
        if (paramValues != null) {
                if (paramValues.size() == 1) {
                    if (paramValues.get(0).length() != 0)
                        aResource.setAuthor(new Link(new URI(paramValues.get(0))));
                    // else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
                }

        }
        paramValues = formParams.get("comments");
        if (paramValues != null) {
                for(int i=0; i<paramValues.size(); i++) {
                    aResource.addComments(new Comment(new URI(paramValues.get(i))));
                }
        }
        paramValues = formParams.get("testScripts");
        if (paramValues != null) {
                for(int i=0; i<paramValues.size(); i++) {
                    aResource.addTestScripts(new Link(new URI(paramValues.get(i))));
                }
        }
        paramValues = formParams.get("someIntegerProperty");
        if (paramValues != null) {
                if (paramValues.size() == 1) {
                    if (paramValues.get(0).length() != 0)
                        aResource.setSomeIntegerProperty(Integer.valueOf(paramValues.get(0)));
                    // else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
                }

        }
        paramValues = formParams.get("someListOfIntegers");
        if (paramValues != null) {
                for(int i=0; i<paramValues.size(); i++) {
                    aResource.addSomeListOfIntegers(Integer.valueOf(paramValues.get(i)));
                }
        }

        newResource = delegate.createRequirementFromDialog(httpServletRequest, aResource);

        if (newResource != null) {
            httpServletRequest.setAttribute("newResource", newResource);
            httpServletRequest.setAttribute("newResourceUri", newResource.getAbout().toString());

            // Send back to the form a small JSON response
            httpServletResponse.setContentType("application/json");
            httpServletResponse.setStatus(Status.CREATED.getStatusCode());
            httpServletResponse.addHeader("Location", newResource.getAbout().toString());
            try {
                PrintWriter out = httpServletResponse.getWriter();
    
                JSONObject oslcResponse = new JSONObject();
                JSONObject newResourceJson = new JSONObject();
                newResourceJson.put("rdf:resource", newResource.getAbout().toString());
                // Start of user code OSLC Resource Label
                newResourceJson.put("oslc:label", newResource.toString());
                // End of user code
                oslcResponse.put("oslc:results", new Object[]{newResourceJson});
    
                out.print(oslcResponse.toString());
                out.close();
            } catch (IOException | JSONException e) {
                throw new WebApplicationException(e);
            }
        }
    }
}
