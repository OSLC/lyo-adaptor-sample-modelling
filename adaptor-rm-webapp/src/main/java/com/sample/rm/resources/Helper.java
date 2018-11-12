package com.sample.rm.resources;

/**
 * TBD
 *
 * @version $version-stub$
 * @since FIXME
 */
public interface Helper<T> {
    String resourceToString(boolean asLocalResource);
    String resourceToString();

    String resourceToHtml(boolean asLocalResource);
    String resourceToHtml();

    String resourcePropertyToHtml(String propertyName);
    String resourcePropertyToHtmlCreation(String propertyName);
}
