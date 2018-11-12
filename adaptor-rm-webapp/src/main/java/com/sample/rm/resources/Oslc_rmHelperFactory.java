package com.sample.rm.resources;

/**
 * TBD
 *
 * @version $version-stub$
 * @since FIXME
 */
public class Oslc_rmHelperFactory implements HelperFactory {

    public static Oslc_rmHelperFactory INSTANCE = new Oslc_rmHelperFactory();

    private Oslc_rmHelperFactory() {}

    @SuppressWarnings("unchecked")
    public <R> Helper<R> getHelperFor(R resource) {
        if(resource instanceof Requirement) {
            return (Helper<R>) new RequirementHelperImpl((Requirement) resource);
        }
        throw new IllegalArgumentException("Unknown resource type");
    }
}
