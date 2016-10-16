package com.weather.modules;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.template.soy.SoyModule;
import com.google.template.soy.xliffmsgplugin.XliffMsgPluginModule;

/**
 * Guice Servlet context listener to install required modules for the app.
 */
public class FrontendServletContextListener extends GuiceServletContextListener{
  @Override
  protected Injector getInjector() {
    return Guice.createInjector(
        new FrontendGuiceModule(),
        new SoyModule(),
        new XliffMsgPluginModule());
  }
}
