package com.sample.rm;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sample.rm.resources.Requirement;
import org.eclipse.lyo.oslc4j.trs.server.TrsEventHandler;
import java.net.URI;
import java.util.Map;
import java.util.HashMap;

public class Backend {

    private static final Logger log = LoggerFactory.getLogger(Backend.class);

    @Inject ResourcesFactory resourcesFactory;

    private static Map<String, Requirement> requirements = new HashMap<String, Requirement>(1000);
    private static int nextRequirementId;
    
    public Backend() {
        log.trace("Backend is initialized");
    }
    
    public ArrayList<Requirement> getRequirements() {
        return new ArrayList<Requirement>(requirements.values());
    }

    public Requirement getRequirement(String id) {
        return requirements.get(id);
    }

    public Requirement produceRandomRequirement(String id) {
        Requirement r = null;
        r = resourcesFactory.createRequirement(id);
        r.setIdentifier(id);
        r.setTitle("aTitle with id:" + id);
        r.setDescription("A sample Requirement with id:" + id);
        return r;
    }

    public void initializeRequirements(int size) {
        for (int i = 0; i < size; i++) {
            nextRequirementId++;
            String id = Integer.toString(nextRequirementId);
            Requirement r = produceRandomRequirement(id);
            requirements.put(id, r);
        }
    }

    public Requirement createOrUpdateRequirement(HttpServletRequest httpServletRequest, final Requirement aResource) {
        if (!requirements.containsKey(aResource.getIdentifier())) {
            nextRequirementId++;
            String id = Integer.toString(nextRequirementId);
            URI uri = resourcesFactory.constructURIForRequirement(id);
            aResource.setAbout(uri);
            requirements.put(id, aResource);
        }
        else {
            URI uri = resourcesFactory.constructURIForRequirement(aResource.getIdentifier());
            aResource.setAbout(uri);
            requirements.put(aResource.getIdentifier(), aResource);
        }
        return aResource;
    }
}
