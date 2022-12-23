package com.sample.testing;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sample.testing.clients.RequirementsAdaptorClient;
import com.sample.testing.resources.TestScript;

import org.eclipse.lyo.oslc4j.core.model.Link;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.HashMap;
import java.util.List;

public class Backend {

    private static final Logger log = LoggerFactory.getLogger(Backend.class);

    @Inject ResourcesFactory resourcesFactory;

    public Backend() {
        log.trace("Backend is initialized");
    }
    
    
    public int randomNumber(int origin, int bound) {
        return ThreadLocalRandom.current().nextInt(origin, bound);
    }

    public Link queryForRandomRequirementLink() throws URISyntaxException {
        try {
            String[] requirements = RequirementsAdaptorClient.queryRequirements();
            int index = randomNumber(0, requirements.length);
            return new Link (new URI (requirements[index]));
        } catch (Exception e) {
            log.error("Failed to query resources", e);
            return null;
        }
    }

    public TestScript createRandomTestScript(String id) {
        TestScript r = null;
        try {
            r = resourcesFactory.createTestScript(id);
            r.setTitle("A sample TestScript with id:" + id);
            r.setDescription("A sample TestScript with id:" + id);
            int size = randomNumber(1, 3);
            for (int i = 0; i < size; i++) {
                r.addValidatesRequirement(queryForRandomRequirementLink());
            }
        } catch (URISyntaxException e) {
            log.error("Failed to create resource", e);
        }
        return r;
    }

    public List<TestScript> createRandomTestScripts(String serviceProviderId, int min, int max, int minId, int maxId) {
        int size = randomNumber(min, max);
        List<TestScript> resources = new ArrayList<TestScript>(size);
        for (int i = 0; i < size; i++) {
            resources.add(createRandomTestScript(Integer.toString(randomNumber(minId, maxId))));
        }
        return resources;
    }
    
}
