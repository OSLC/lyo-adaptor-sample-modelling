// Start of user code Copyright
/*******************************************************************************
 * Copyright (c) 2015 Jad El-khoury.
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
 *     Jad El-khoury        - initial implementation of client code
 *     
 *******************************************************************************/
// End of user code

package com.sample.client.clients;

import javax.ws.rs.core.Response;
import org.eclipse.lyo.client.OSLCConstants;
import org.eclipse.lyo.client.OslcClient;
import org.eclipse.lyo.oslc4j.core.model.ServiceProviderCatalog;
import com.sample.client.resources.Requirement;
import com.sample.client.resources.TestScript;

// Start of user code imports
// End of user code


// Start of user code pre_class_code
// End of user code

public class GenericRequiredAdaptorClient
{

    // Start of user code class_attributes
    // End of user code
    
    // Start of user code class_methods
    // End of user code

    static String serviceProviderCatalogURI = "http://localhost:8083/adaptor-rm/services/catalog/singleton";

    public static ServiceProviderCatalog getServiceProviderCatalog() throws Exception {
        OslcClient client = new OslcClient();
        Response response = null;
        ServiceProviderCatalog catalog = null;

        // Start of user code getServiceProviderCatalog_init
        // End of user code

        response = client.getResource(serviceProviderCatalogURI,OSLCConstants.CT_RDF);
        if (response != null) {
            catalog = response.readEntity(ServiceProviderCatalog.class);
        }
        // Start of user code getServiceProviderCatalog_final
        // End of user code
        return catalog;
    }

    public static Requirement getRequirement(String resourceURI) throws Exception {
        OslcClient client = new OslcClient();
        Response response = null;
        Requirement resource = null;

        // Start of user code getRequirement_init
        // End of user code

        response = client.getResource(resourceURI, OSLCConstants.CT_RDF);
        if (response != null) {
            resource = response.readEntity(Requirement.class);
        }
        // Start of user code getRequirement_final
        // End of user code
        return resource;
    }

    public static TestScript getTestScript(String resourceURI) throws Exception {
        OslcClient client = new OslcClient();
        Response response = null;
        TestScript resource = null;

        // Start of user code getTestScript_init
        // End of user code

        response = client.getResource(resourceURI, OSLCConstants.CT_RDF);
        if (response != null) {
            resource = response.readEntity(TestScript.class);
        }
        // Start of user code getTestScript_final
        // End of user code
        return resource;
    }
}
