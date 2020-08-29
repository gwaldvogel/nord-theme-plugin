package io.jenkins.plugins.nordtheme;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import io.jenkins.plugins.thememanager.Theme;
import io.jenkins.plugins.thememanager.ThemeManagerFactory;
import io.jenkins.plugins.thememanager.ThemeManagerFactoryDescriptor;
import org.jenkinsci.Symbol;
import org.kohsuke.stapler.DataBoundConstructor;

public class NordThemeManagerFactory extends ThemeManagerFactory {

    public static final String THEME_CSS = "theme.css";
    public static final String NORD_CSS = "nord.css";
    public static final String THEME_URL_NAME = "theme-nord";

    @DataBoundConstructor
    public NordThemeManagerFactory() {
    }

    @Override
    public Theme getTheme() {
        return Theme.builder()
                .withCssUrl(getCssUrl())
                .build();
    }

    @Extension
    @Symbol("dark")
    public static class DarkThemeManagerFactoryDescriptor extends ThemeManagerFactoryDescriptor {

        @NonNull
        @Override
        public String getDisplayName() {
            return "Nord";
        }

        @Override
        public ThemeManagerFactory getInstance() {
            return new NordThemeManagerFactory();
        }

        @NonNull
        @Override
        public String getThemeId() {
            return "nord";
        }
    }
}
