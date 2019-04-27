package com.sample.rm;

import javax.servlet.http.HttpServletRequest;

public interface ServiceProviderManager {
    ServiceProviderInfo[] getServiceProviderInfos(HttpServletRequest httpServletRequest);
}
