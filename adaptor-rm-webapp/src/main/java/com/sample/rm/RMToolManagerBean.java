package com.sample.rm;

import com.sample.rm.resources.Requirement;
import javax.servlet.http.HttpServletRequest;

public class RMToolManagerBean {

    public static Requirement getRequirement(HttpServletRequest httpServletRequest, final String requirementId) {
        return RMToolManager.getRequirement(httpServletRequest, requirementId);
    }

}
