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

package com.sample.rm;

// Start of user code Notice
//Note: The Lyo code generator is migrating the name of this class from 'RMToolResourcesFactory' to the new shorter name 'ResourcesFactory'.
//You are still using the old name. The generator will continue to use this old name until you actively trigger the change.
//To migrate to the new class name:
//1. Rename your class to ResourcesFactory 
//    * Please rename and do not simply create a copy of the file. The generator needs to detect the file deletion in order to activate the name change.
//2. Regenerate the code. 
//    * The generator will generate this class with the new name.
//    * Besides the class name, the code - including the user clode blocks - remain intact.
//    * All other class references to the new class name are updated.
//3. Delete this notice
// End of user code

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.UriBuilder;

import org.eclipse.lyo.oslc4j.core.model.Link;
import org.eclipse.lyo.oslc4j.core.OSLC4JUtils;
import com.sample.rm.resources.Person;
import com.sample.rm.resources.Requirement;
import com.sample.rm.resources.TestScript;

// Start of user code imports
// End of user code

// Start of user code pre_class_code
// End of user code

public class RMToolResourcesFactory {

    private String basePath;

    // Start of user code class_attributes
    // End of user code

    public RMToolResourcesFactory(String basePath) {
        this.basePath = basePath;
    }

    // Start of user code class_methods
    // End of user code

    //methods for Requirement resource
    
    public Requirement createRequirement(final String requirementId) {
        return new Requirement(constructURIForRequirement(requirementId));
    }
    
    public URI constructURIForRequirement(final String requirementId) {
        Map<String, Object> pathParameters = new HashMap<String, Object>();
        pathParameters.put("requirementId", requirementId);
        String instanceURI = "requirements/{requirementId}";
    
        final UriBuilder builder = UriBuilder.fromUri(this.basePath);
        return builder.path(instanceURI).buildFromMap(pathParameters);
    }
    
    public Link constructLinkForRequirement(final String requirementId , final String label) {
        return new Link(constructURIForRequirement(requirementId), label);
    }
    
    public Link constructLinkForRequirement(final String requirementId) {
        return new Link(constructURIForRequirement(requirementId));
    }
    

    //methods for TestScript resource
    
    public TestScript createTestScript(final String testScriptId) {
        return new TestScript(constructURIForTestScript(testScriptId));
    }
    
    public URI constructURIForTestScript(final String testScriptId) {
        Map<String, Object> pathParameters = new HashMap<String, Object>();
        pathParameters.put("testScriptId", testScriptId);
        String instanceURI = "testScript/{testScriptId}";
    
        final UriBuilder builder = UriBuilder.fromUri(this.basePath);
        return builder.path(instanceURI).buildFromMap(pathParameters);
    }
    
    public Link constructLinkForTestScript(final String testScriptId , final String label) {
        return new Link(constructURIForTestScript(testScriptId), label);
    }
    
    public Link constructLinkForTestScript(final String testScriptId) {
        return new Link(constructURIForTestScript(testScriptId));
    }
    

}
