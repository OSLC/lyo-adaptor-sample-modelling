// Start of user code Copyright
/*******************************************************************************
 * Copyright (c) 2017 Jad El-khoury.
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
 *     Jad El-khoury        - initial implementation
 *     
 *******************************************************************************/
// End of user code

package com.sample.testing;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.UriBuilder;

import org.eclipse.lyo.oslc4j.core.model.Link;
import org.eclipse.lyo.oslc4j.core.OSLC4JUtils;
import com.sample.testing.resources.Requirement;
import com.sample.testing.resources.TestScript;

// Start of user code imports
// End of user code

// Start of user code pre_class_code
// End of user code

public class TestingToolResourcesFactory {

    // Start of user code class_attributes
    // End of user code
    
    // Start of user code class_methods
    // End of user code

    //methods for TestScript resource
    public static TestScript createTestScript(final String serviceProviderId, final String testScriptId)
           throws URISyntaxException
    {
        return new TestScript(constructURIForTestScript(serviceProviderId, testScriptId));
    }
    
    public static URI constructURIForTestScript(final String serviceProviderId, final String testScriptId)
    {
        String basePath = OSLC4JUtils.getServletURI();
        Map<String, Object> pathParameters = new HashMap<String, Object>();
        pathParameters.put("serviceProviderId", serviceProviderId);
        pathParameters.put("testScriptId", testScriptId);
        String instanceURI = "serviceProviders/{serviceProviderId}/testScripts/{testScriptId}";
    
        final UriBuilder builder = UriBuilder.fromUri(basePath);
        return builder.path(instanceURI).buildFromMap(pathParameters);
    }
    
    public static Link constructLinkForTestScript(final String serviceProviderId, final String testScriptId , final String label)
    {
        return new Link(constructURIForTestScript(serviceProviderId, testScriptId), label);
    }
    
    public static Link constructLinkForTestScript(final String serviceProviderId, final String testScriptId)
    {
        return new Link(constructURIForTestScript(serviceProviderId, testScriptId));
    }
    

}
