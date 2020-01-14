package com.sample.rm;

import com.sample.rm.resources.Requirement;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;

import javax.ws.rs.core.UriBuilder;
import org.eclipse.lyo.oslc4j.core.OSLC4JUtils;
import org.eclipse.lyo.oslc4j.trs.server.InmemPagedTrs;
import org.eclipse.lyo.oslc4j.trs.server.PagedTrs;
import org.eclipse.lyo.oslc4j.trs.server.service.TrackedResourceSetService;
import org.glassfish.hk2.api.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InmemPagedTrsSingleton implements Factory<PagedTrs> {
    
    private final static Logger log = LoggerFactory.getLogger(InmemPagedTrsSingleton.class);
    private static InmemPagedTrs inmemPagedTrs;

    @Override
    public InmemPagedTrs provide() {
        return getInmemPagedTrs();
    }

    @Override
    public void dispose(final PagedTrs instance) {
        log.debug("{} is getting disposed", instance);
    }

    public static InmemPagedTrs getInmemPagedTrs() {
        if(inmemPagedTrs == null) {
            log.debug("Initialising 'InmemPagedTrs' instance");
            
            ArrayList<URI> uris = new ArrayList<URI>();
            ArrayList<Requirement> requirements = RMToolManager.getRequirements();
            for (Iterator iterator = requirements.iterator(); iterator.hasNext();) {
                uris.add(((Requirement) iterator.next()).getAbout());
            }
            // not thread-safe
            inmemPagedTrs = new InmemPagedTrs(5, 5,
                UriBuilder.fromUri(OSLC4JUtils.getServletURI()).path(TrackedResourceSetService.RESOURCE_PATH).build(), 
                TrackedResourceSetService.BASE_PATH, TrackedResourceSetService.CHANGELOG_PATH, uris);
        }
        return inmemPagedTrs;
    }
}
