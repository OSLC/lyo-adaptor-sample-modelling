package com.sample.rm.resources;

import javax.servlet.http.HttpServletRequest;

/**
 * TBD
 *
 * @version $version-stub$
 * @since FIXME
 */
public class Oslc_rmHtmlHelperOverload {

    public static String resourceToString(Requirement resource, boolean asLocalResource)
    {
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

    public static String resourceToHtml(Requirement resource)
    {
        return resourceToHtml(resource, false);
    }

    public static String resourceToHtml(Requirement resource, boolean asLocalResource)
    {
        String result = "";
        // Start of user code requirementToHtml_init
        // End of user code

        if (asLocalResource) {
            result = resourceToString(resource, true);
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

    // NB! nothing we can do here as the properties are bound to invidual shapes in this ctx
    static public String titleToHtmlForCreation(Requirement resource)
    {
        String s = "";

        // Start of user code "Init:titleToHtmlForCreation(...)"
        // End of user code

        s = s + "<label for=\"title\">title: </LABEL>";

        // Start of user code "Mid:titleToHtmlForCreation(...)"
        // End of user code

        s= s + "<input name=\"title\" type=\"text\" style=\"width: 400px\" id=\"title\" >";
        // Start of user code "Finalize:titleToHtmlForCreation(...)"
        // End of user code

        return s;
    }

    public static String requirementDescriptionToHtmlForCreation (Requirement resource)
    {
        String s = "";

        // Start of user code "Init:descriptionToHtmlForCreation(...)"
        // End of user code

        s = s + "<label for=\"description\">description: </LABEL>";

        // Start of user code "Mid:descriptionToHtmlForCreation(...)"
        // End of user code

        // FIXME Andrew@2018-11-12: what about pre-filling for edit?
        s= s + "<input name=\"description\" type=\"text\" style=\"width: 400px\" id=\"description\" >";
        // Start of user code "Finalize:descriptionToHtmlForCreation(...)"
        // End of user code

        return s;
    }

    public static String requirementTitleToHtml(Requirement resource)
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

    public static String requirementDescriptionToHtml(Requirement resource)
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



}
