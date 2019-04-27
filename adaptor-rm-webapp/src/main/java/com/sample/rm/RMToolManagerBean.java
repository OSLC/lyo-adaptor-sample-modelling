package com.sample.rm;

import com.sample.rm.resources.Requirement;
import javax.servlet.http.HttpServletRequest;

public class RMToolManagerBean implements RequirementsManager, ServiceProviderManager {

    @Override
    public Requirement getRequirement(HttpServletRequest httpServletRequest,
            final String requirementId) {
        return RMToolManager.getRequirement(httpServletRequest, requirementId);
    }

    @Override
    public ServiceProviderInfo[] getServiceProviderInfos(HttpServletRequest httpServletRequest) {
        return RMToolManager.getServiceProviderInfos(httpServletRequest);
    }


}
