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

package com.sample.testing.clients;

import org.apache.wink.client.ClientResponse;
import org.eclipse.lyo.client.oslc.OSLCConstants;
import org.eclipse.lyo.client.oslc.OslcClient;
import org.eclipse.lyo.oslc4j.core.model.ServiceProviderCatalog;
import com.sample.testing.resources.Requirement;

// Start of user code imports
import java.net.URI;

import org.eclipse.lyo.oslc4j.core.model.ServiceProvider;
import org.eclipse.lyo.client.oslc.resources.OslcQuery;
import org.eclipse.lyo.client.oslc.resources.OslcQueryParameters;
import org.eclipse.lyo.client.oslc.resources.OslcQueryResult;

import com.sample.testing.resources.Oslc_rmConstants;
// End of user code


// Start of user code pre_class_code
// End of user code

public class RequirementsAdaptorClient
{

    // Start of user code class_attributes
    // End of user code
    
    // Start of user code class_methods
	public static String[] queryRequirements() throws Exception 
	{	
        OslcClient client = new OslcClient();
        ClientResponse response = null;
        ServiceProviderCatalog catalog = null;

        //Get the SPC
        response = client.getResource(serviceProviderCatalogURI,OSLCConstants.CT_RDF);
        if (response != null) {
            catalog = response.getEntity(ServiceProviderCatalog.class);
        }
		
        //Get first SP.
		ServiceProvider sp = catalog.getServiceProviders()[0];
		
		//Find the QCBase that deals with SecondOT
		String queryBaseUri = client.lookupQueryCapability(sp.getAbout().toString(), Oslc_rmConstants.REQUIREMENTS_MANAGEMENT_DOMAIN, Oslc_rmConstants.TYPE_REQUIREMENT);
        URI queryBase = new URI(queryBaseUri);

        String where = "";

        OslcQueryParameters queryParameters = new OslcQueryParameters();
        queryParameters.setWhere(where);
        OslcQuery query = new OslcQuery(client, queryBase.toString(), queryParameters);
        OslcQueryResult queryResults = query.submit();    
        String[] urls = queryResults.getMembersUrls();
        return urls;
	}
    // End of user code

    static String serviceProviderCatalogURI = "http://localhost:8081/adaptor-rm/services/catalog/singleton";

    public static ServiceProviderCatalog getServiceProviderCatalog() throws Exception {
        OslcClient client = new OslcClient();
        ClientResponse response = null;
        ServiceProviderCatalog catalog = null;

        // Start of user code getServiceProviderCatalog_init
        // End of user code

        response = client.getResource(serviceProviderCatalogURI,OSLCConstants.CT_RDF);
        if (response != null) {
            catalog = response.getEntity(ServiceProviderCatalog.class);
        }
        // Start of user code getServiceProviderCatalog_final
        // End of user code
        return catalog;
    }

    public static Requirement getRequirement(String resourceURI) throws Exception {
        OslcClient client = new OslcClient();
        ClientResponse response = null;
        Requirement resource = null;

        // Start of user code getRequirement_init
        // End of user code

        response = client.getResource(resourceURI, OSLCConstants.CT_RDF);
        if (response != null) {
            resource = response.getEntity(Requirement.class);
        }
        // Start of user code getRequirement_final
        // End of user code
        return resource;
    }
}
