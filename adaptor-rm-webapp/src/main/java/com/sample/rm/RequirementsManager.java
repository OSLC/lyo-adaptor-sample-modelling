package com.sample.rm;

import com.sample.rm.resources.Requirement;
import javax.servlet.http.HttpServletRequest;

public interface RequirementsManager {
    Requirement getRequirement(HttpServletRequest httpServletRequest, String requirementId);
}
