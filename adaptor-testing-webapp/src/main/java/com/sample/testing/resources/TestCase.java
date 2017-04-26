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
 *     Russell Boykin       - initial API and implementation
 *     Alberto Giammaria    - initial API and implementation
 *     Chris Peters         - initial API and implementation
 *     Gianluca Bernardini  - initial API and implementation
 *	   Sam Padgett          - initial API and implementation
 *     Michael Fiedler      - adapted for OSLC4J
 *     Jad El-khoury        - initial implementation of code generator (https://bugs.eclipse.org/bugs/show_bug.cgi?id=422448)
 *     Matthieu Helleboid   - Support for multiple Service Providers.
 *     Anass Radouani       - Support for multiple Service Providers.
 *
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/

package com.sample.testing.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.ws.rs.core.UriBuilder;

import org.eclipse.lyo.oslc4j.core.annotation.OslcAllowedValue;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDescription;
import org.eclipse.lyo.oslc4j.core.annotation.OslcMemberProperty;
import org.eclipse.lyo.oslc4j.core.annotation.OslcName;
import org.eclipse.lyo.oslc4j.core.annotation.OslcNamespace;
import org.eclipse.lyo.oslc4j.core.annotation.OslcOccurs;
import org.eclipse.lyo.oslc4j.core.annotation.OslcPropertyDefinition;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRange;
import org.eclipse.lyo.oslc4j.core.annotation.OslcReadOnly;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRepresentation;
import org.eclipse.lyo.oslc4j.core.annotation.OslcResourceShape;
import org.eclipse.lyo.oslc4j.core.annotation.OslcTitle;
import org.eclipse.lyo.oslc4j.core.annotation.OslcValueType;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;
import org.eclipse.lyo.oslc4j.core.model.Link;
import org.eclipse.lyo.oslc4j.core.model.Occurs;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.Representation;
import org.eclipse.lyo.oslc4j.core.model.ValueType;

import com.sample.testing.servlet.ServletListener;
import com.sample.testing.TestingToolConstants;
import com.sample.testing.resources.Person;
import com.sample.testing.resources.TestScript;

// Start of user code imports
// End of user code

// Start of user code preClassCode
// End of user code

// Start of user code classAnnotations
// End of user code
@OslcNamespace(TestingToolConstants.QUALITY_MANAGEMENT_NAMSPACE)
@OslcName(TestingToolConstants.TESTCASE)
@OslcResourceShape(title = "Test Case Resource Shape", describes = TestingToolConstants.TYPE_TESTCASE)
public class TestCase
    extends AbstractResource
    implements ITestCase
{
    // Start of user code attributeAnnotation:uses
    // End of user code
    private Link uses = new Link();
    // Start of user code attributeAnnotation:title
    // End of user code
    private String title;
    // Start of user code attributeAnnotation:contributor
    // End of user code
    private Link contributor = new Link();
    
    // Start of user code classAttributes
    // End of user code
    // Start of user code classMethods
    // End of user code
    public TestCase()
           throws URISyntaxException
    {
        super();
    
        // Start of user code constructor1
        // End of user code
    }
    
    public TestCase(final URI about)
           throws URISyntaxException
    {
        super(about);
    
        // Start of user code constructor2
        // End of user code
    }
    
    public TestCase(final String serviceProviderId, final String testCaseId)
           throws URISyntaxException
    {
        this (constructURI(serviceProviderId, testCaseId));
        // Start of user code constructor3
        // End of user code
    }
    
    public static URI constructURI(final String serviceProviderId, final String testCaseId)
    {
        String basePath = ServletListener.getServicesBase();
        Map<String, Object> pathParameters = new HashMap<String, Object>();
        pathParameters.put("serviceProviderId", serviceProviderId);
        pathParameters.put("testCaseId", testCaseId);
        String instanceURI = "serviceProviders/{serviceProviderId}/testCases/{testCaseId}";
    
        final UriBuilder builder = UriBuilder.fromUri(basePath);
        return builder.path(instanceURI).buildFromMap(pathParameters);
    }
    
    public static Link constructLink(final String serviceProviderId, final String testCaseId , final String label)
    {
        return new Link(constructURI(serviceProviderId, testCaseId), label);
    }
    
    public static Link constructLink(final String serviceProviderId, final String testCaseId)
    {
        return new Link(constructURI(serviceProviderId, testCaseId));
    }
    
    public String toString()
    {
        return toString(false);
    }
    
    public String toString(boolean asLocalResource)
    {
        String result = "";
        // Start of user code toString_init
        // End of user code
    
        if (asLocalResource) {
            result = result + "{a Local Test Case Resource} - update Test Case.toString() to present resource as desired.";
            // Start of user code toString_bodyForLocalResource
            // End of user code
        }
        else {
            result = getAbout().toString();
        }
    
        // Start of user code toString_finalize
        // End of user code
    
        return result;
    }
    
    public String toHtml()
    {
        return toHtml(false);
    }
    
    public String toHtml(boolean asLocalResource)
    {
        String result = "";
        // Start of user code toHtml_init
        // End of user code
    
        if (asLocalResource) {
            result = toString(true);
            // Start of user code toHtml_bodyForLocalResource
            // End of user code
        }
        else {
            result = "<a href=\"" + getAbout() + "\">" + toString() + "</a>";
        }
    
        // Start of user code toHtml_finalize
        // End of user code
    
        return result;
    }
    
    
    // Start of user code getterAnnotation:uses
    // End of user code
    @OslcName("uses")
    @OslcPropertyDefinition(TestingToolConstants.QUALITY_MANAGEMENT_NAMSPACE + "uses")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcValueType(ValueType.Resource)
    @OslcRange({TestingToolConstants.TYPE_TESTSCRIPT})
    @OslcReadOnly(false)
    public Link getUses()
    {
        // Start of user code getterInit:uses
        // End of user code
        return uses;
    }
    
    // Start of user code getterAnnotation:title
    // End of user code
    @OslcName("title")
    @OslcPropertyDefinition(TestingToolConstants.DUBLIN_CORE_NAMSPACE + "title")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcValueType(ValueType.String)
    @OslcReadOnly(false)
    public String getTitle()
    {
        // Start of user code getterInit:title
        // End of user code
        return title;
    }
    
    // Start of user code getterAnnotation:contributor
    // End of user code
    @OslcName("contributor")
    @OslcPropertyDefinition(TestingToolConstants.DUBLIN_CORE_NAMSPACE + "contributor")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcValueType(ValueType.Resource)
    @OslcRange({TestingToolConstants.TYPE_PERSON})
    @OslcReadOnly(false)
    public Link getContributor()
    {
        // Start of user code getterInit:contributor
        // End of user code
        return contributor;
    }
    
    
    // Start of user code setterAnnotation:uses
    // End of user code
    public void setUses(final Link uses )
    {
        // Start of user code setterInit:uses
        // End of user code
        this.uses = uses;
    
        // Start of user code setterFinalize:uses
        // End of user code
    }
    
    // Start of user code setterAnnotation:title
    // End of user code
    public void setTitle(final String title )
    {
        // Start of user code setterInit:title
        // End of user code
        this.title = title;
    
        // Start of user code setterFinalize:title
        // End of user code
    }
    
    // Start of user code setterAnnotation:contributor
    // End of user code
    public void setContributor(final Link contributor )
    {
        // Start of user code setterInit:contributor
        // End of user code
        this.contributor = contributor;
    
        // Start of user code setterFinalize:contributor
        // End of user code
    }
    
    
    static public String usesToHtmlForCreation (final HttpServletRequest httpServletRequest)
    {
        String s = "";
    
        // Start of user code "Init:usesToHtmlForCreation(...)"
        // End of user code
    
        s = s + "<label for=\"uses\">uses: </LABEL>";
    
        // Start of user code "Mid:usesToHtmlForCreation(...)"
        // End of user code
    
        // Start of user code "Finalize:usesToHtmlForCreation(...)"
        // End of user code
    
        return s;
    }
    
    static public String titleToHtmlForCreation (final HttpServletRequest httpServletRequest)
    {
        String s = "";
    
        // Start of user code "Init:titleToHtmlForCreation(...)"
        // End of user code
    
        s = s + "<label for=\"title\">title: </LABEL>";
    
        // Start of user code "Mid:titleToHtmlForCreation(...)"
        // End of user code
    
        s= s + "<input name=\"title\" type=\"text\" style=\"width: 400px\" id=\"title\" >";
        // Start of user code "Finalize:titleToHtmlForCreation(...)"
        // End of user code
    
        return s;
    }
    
    static public String contributorToHtmlForCreation (final HttpServletRequest httpServletRequest)
    {
        String s = "";
    
        // Start of user code "Init:contributorToHtmlForCreation(...)"
        // End of user code
    
        s = s + "<label for=\"contributor\">contributor: </LABEL>";
    
        // Start of user code "Mid:contributorToHtmlForCreation(...)"
        // End of user code
    
        // Start of user code "Finalize:contributorToHtmlForCreation(...)"
        // End of user code
    
        return s;
    }
    
    
    public String usesToHtml()
    {
        String s = "";
    
        // Start of user code usestoHtml_init
        // End of user code
    
        s = s + "<label for=\"uses\"><strong>uses</strong>: </LABEL>";
    
        // Start of user code usestoHtml_mid
        // End of user code
    
        try {
            s = s + (new TestScript (uses.getValue())).toHtml(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        // Start of user code usestoHtml_finalize
        // End of user code
    
        return s;
    }
    
    public String titleToHtml()
    {
        String s = "";
    
        // Start of user code titletoHtml_init
        // End of user code
    
        s = s + "<label for=\"title\"><strong>title</strong>: </LABEL>";
    
        // Start of user code titletoHtml_mid
        // End of user code
    
        try {
            if (title == null) {
                s= s + "<em>null</em>";
            }
            else {
                s= s + title.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        // Start of user code titletoHtml_finalize
        // End of user code
    
        return s;
    }
    
    public String contributorToHtml()
    {
        String s = "";
    
        // Start of user code contributortoHtml_init
        // End of user code
    
        s = s + "<label for=\"contributor\"><strong>contributor</strong>: </LABEL>";
    
        // Start of user code contributortoHtml_mid
        // End of user code
    
        try {
            s = s + (new Person (contributor.getValue())).toHtml(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        // Start of user code contributortoHtml_finalize
        // End of user code
    
        return s;
    }
    
    
}