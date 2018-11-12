package com.sample.rm.resources;

import javax.xml.namespace.QName;

/**
 * TBD
 *
 * @version $version-stub$
 * @since FIXME
 */
public class RequirementHelperImpl implements Helper<Requirement> {
    private final Requirement resource;

    public RequirementHelperImpl(final Requirement resource) {
        this.resource = resource;
    }

    public String resourceToString(final boolean asLocalResource) {
        String result = "";
        // Start of user code requirementToString_init
        // End of user code

        if (asLocalResource) {
            result = result + "{a Local Requirement Resource} - update Requirement.toString() to present resource as desired.";
            // Start of user code requirementToString_body
            // End of user code
        }
        else {
            result = resource.getAbout().toString();
        }

        // Start of user code requirementToString_finalise
        // End of user code

        return result;
    }

    public String resourceToString() {
        return resourceToString(false);
    }

    public String resourceToHtml(final boolean asLocalResource) {
        String result = "";
        // Start of user code requirementToHtml_init
        // End of user code

        if (asLocalResource) {
            result = resourceToString(true);
            // Start of user code requirementToHtml_body
            // End of user code
        }
        else {
            result = "<a href=\"" + resource.getAbout() + "\" class=\"oslc-resource-link\">" + resource.toString() + "</a>";
        }

        // Start of user code requirementToHtml_init_finalize
        // End of user code

        return result;
    }

    public String resourceToHtml() {
        return resourceToHtml(false);
    }

    public String resourcePropertyToHtml(final String propertyName) {
        if("title".equals(propertyName)) {
            return requirementTitleToHtml(resource);
        } else if("description".equals(propertyName)) {
            return requirementDescriptionToHtml(resource);
        } else {
            // or something more creative
            final QName key = QName.valueOf(propertyName);
            if(resource.getExtendedProperties().containsKey(key)) {
                return resource.getExtendedProperties().get(key).toString();
            }
        }

        throw new IllegalArgumentException("Unknown property");
    }

    private String requirementTitleToHtml(Requirement resource)
    {
        String s = "";

        // Start of user code titletoHtml_mid
        // End of user code

        try {
            // TODO Andrew@2018-11-12: note the switch to use getters
            if (resource.getTitle() == null) {
                s = s + "<em>null</em>";
            }
            else {
                s = s + resource.getTitle().toString();
            }
        } catch (Exception e) {
            // FIXME Andrew@2018-11-12: I think this needs to change
            // option 1: slf4j log
            // option 2: new IllegalStateException() (can be both)
            e.printStackTrace();
        }

        // Start of user code titletoHtml_finalize
        // End of user code

        return s;
    }

    private String requirementDescriptionToHtml(Requirement resource)
    {
        String s = "";

        // Start of user code descriptiontoHtml_mid
        // End of user code

        try {
            // TODO Andrew@2018-11-12: consider using Java 8 Optional class for zero-or-one card.
            if (resource.getDescription() == null) {
                s = s + "<em>null</em>";
            }
            else {
                s = s + resource.getDescription().toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Start of user code descriptiontoHtml_finalize
        // End of user code

        return s;
    }


    public String resourcePropertyToHtmlCreation(final String propertyName) {
        throw new IllegalStateException("Not implemented, similar to toHtml methods");
    }
}
