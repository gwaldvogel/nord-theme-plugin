package io.jenkins.plugins.nordtheme;

import hudson.Extension;
import hudson.model.UnprotectedRootAction;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.kohsuke.accmod.Restricted;
import org.kohsuke.accmod.restrictions.NoExternalUse;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;
import org.kohsuke.stapler.WebMethod;

import static io.jenkins.plugins.nordtheme.NordThemeManagerFactory.*;
import static java.util.Objects.requireNonNull;

@Extension
@Restricted(NoExternalUse.class)
public class NordThemeRootAction implements UnprotectedRootAction {

    @Override
    public String getIconFileName() {
        return null;
    }

    @Override
    public String getDisplayName() {
        return null;
    }

    @Override
    public String getUrlName() {
        return THEME_URL_NAME;
    }

    @WebMethod(name = THEME_CSS)
    public void doDarkThemeCss(StaplerRequest req, StaplerResponse res) throws IOException {
        try (InputStream themeInputStream = getClass().getResourceAsStream(THEME_CSS)) {
            res.setContentType("text/css");
            requireNonNull(themeInputStream);
            String s1 = IOUtils.toString(themeInputStream, StandardCharsets.UTF_8);
            res.getWriter().print(s1);
        }
    }
    @WebMethod(name = NORD_CSS)
    public void doNordCss(StaplerRequest req, StaplerResponse res) throws IOException {
        try (InputStream themeInputStream = getClass().getResourceAsStream(NORD_CSS)) {
            res.setContentType("text/css");
            requireNonNull(themeInputStream);
            String s1 = IOUtils.toString(themeInputStream, StandardCharsets.UTF_8);
            res.getWriter().print(s1);
        }
    }
}
