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

package com.sample.rm.servlet;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import javax.inject.Singleton;

import com.sample.rm.RMToolManager;
import com.sample.rm.RMToolResourcesFactory;
import java.net.URI;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import org.eclipse.lyo.store.StorePool;

import org.eclipse.lyo.oslc4j.trs.server.InmemPagedTrs;
import org.eclipse.lyo.oslc4j.trs.server.PagedTrs;
import org.eclipse.lyo.oslc4j.trs.server.PagedTrsFactory;
import org.eclipse.lyo.oslc4j.trs.server.TrsEventHandler;
import org.eclipse.lyo.oslc4j.core.OSLC4JUtils;
// Start of user code imports
// End of user code

// Start of user code pre_class_code
// End of user code

public class ApplicationBinder extends AbstractBinder {

    private static final Logger log = LoggerFactory.getLogger(ApplicationBinder.class);

    // Start of user code class_attributes
    // End of user code

    // Start of user code class_methods
    // End of user code

    public ApplicationBinder()
    {
        log.info("HK2 contract binding init");
    }

    @Override
    protected void configure() {
        log.info("HK2 contract binding start");
    
        bindAsContract(RMToolManager.class).in(Singleton.class);
        bindFactory(new ResourcesFactoryFactory()).to(RMToolResourcesFactory.class).in(Singleton.class);
    
        bindFactory(new StorePoolFactory()).to(StorePool.class).in(Singleton.class);
        // Start of user code TRSInitialise
        // End of user code
        ArrayList<URI> uris = new ArrayList<URI>();
        // Start of user code TRSInitialBase
        //TODO: Provide the initial list of URIs to populate the TRS log with
        // End of user code
        InmemPagedTrs inmemTrs = new PagedTrsFactory().getInmemPagedTrs(50, 50, uris);
        bind(inmemTrs).to(TrsEventHandler.class);
        bind(inmemTrs).to(PagedTrs.class);
        // Start of user code TRSFinalize
        // End of user code
    }
    private final class ResourcesFactoryFactory implements Factory<RMToolResourcesFactory> {
        @Override
        public RMToolResourcesFactory provide() {
            return new RMToolResourcesFactory(OSLC4JUtils.getServletURI());
        }
    
        @Override
        public void dispose(RMToolResourcesFactory instance) {
        }
    }
    private final class StorePoolFactory implements Factory<StorePool> {
        @Override
        public StorePool provide() {
            // Start of user code StoreInitialise
            // End of user code
            Properties lyoStoreProperties = new Properties();
            String lyoStorePropertiesFile = ApplicationBinder.class.getResource("/store.properties").getFile();
            try {
                lyoStoreProperties.load(new FileInputStream(lyoStorePropertiesFile));
            } catch (IOException e) {
                log.error("Failed to initialize Store. properties file for Store configuration could not be loaded.", e);
                throw new RuntimeException(e);
            }
            
            int initialPoolSize = Integer.parseInt(lyoStoreProperties.getProperty("initialPoolSize"));
            URI defaultNamedGraph;
            URI sparqlQueryEndpoint;
            URI sparqlUpdateEndpoint;
            try {
                defaultNamedGraph = new URI(lyoStoreProperties.getProperty("defaultNamedGraph"));
                sparqlQueryEndpoint = new URI(lyoStoreProperties.getProperty("sparqlQueryEndpoint"));
                sparqlUpdateEndpoint = new URI(lyoStoreProperties.getProperty("sparqlUpdateEndpoint"));
            } catch (URISyntaxException e) {
                log.error("Failed to initialize Store. One of the configuration property ('defaultNamedGraph' or 'sparqlQueryEndpoint' or 'sparqlUpdateEndpoint') is not a valid URI.", e);
                throw new RuntimeException(e);
            }
            String userName = null;
            String password = null;
            StorePool storePool = new StorePool(initialPoolSize, defaultNamedGraph, sparqlQueryEndpoint, sparqlUpdateEndpoint, userName, password);
            // Start of user code StoreFinalize
            // End of user code
            return storePool;
            
        }
    
        @Override
        public void dispose(StorePool instance) {
        }
    }
}
