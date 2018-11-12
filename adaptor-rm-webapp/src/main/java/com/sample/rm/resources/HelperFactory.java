package com.sample.rm.resources;

/**
 * TBD
 *
 * @version $version-stub$
 * @since FIXME
 */
public interface HelperFactory {
    <T> Helper<T> getHelperFor(T resource);
}
