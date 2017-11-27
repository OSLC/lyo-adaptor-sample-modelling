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

package com.sample.rm;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.UriBuilder;

import org.eclipse.lyo.oslc4j.core.model.Link;
import org.eclipse.lyo.oslc4j.core.OSLC4JUtils;
import com.sample.rm.resources.Requirement;

// Start of user code imports
// End of user code

// Start of user code pre_class_code
// End of user code

public class RMToolResourcesFactory {

    // Start of user code class_attributes
    // End of user code
    
    // Start of user code class_methods
    // End of user code

    //methods for Requirement resource
    public static Requirement createRequirement(final String requirementId)
           throws URISyntaxException
    {
        return new Requirement(constructURIForRequirement(requirementId));
    }
    
    public static URI constructURIForRequirement(final String requirementId)
    {
        String basePath = OSLC4JUtils.getServletURI();
        Map<String, Object> pathParameters = new HashMap<String, Object>();
        pathParameters.put("requirementId", requirementId);
        String instanceURI = "requirements/{requirementId}";
    
        final UriBuilder builder = UriBuilder.fromUri(basePath);
        return builder.path(instanceURI).buildFromMap(pathParameters);
    }
    
    public static Link constructLinkForRequirement(final String requirementId , final String label)
    {
        return new Link(constructURIForRequirement(requirementId), label);
    }
    
    public static Link constructLinkForRequirement(final String requirementId)
    {
        return new Link(constructURIForRequirement(requirementId));
    }
    

}
