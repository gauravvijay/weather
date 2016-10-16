package com.weather.modules;

import java.io.File;

import com.google.inject.servlet.ServletModule;
import com.google.template.soy.SoyFileSet;
import com.google.template.soy.tofu.SoyTofu;
import com.weather.backend.WeatherClient;
import com.weather.backend.YahooWeatherClientImpl;
import com.weather.frontend.HtmlWeatherPresenter;
import com.weather.frontend.WeatherPresenter;
import com.weather.frontend.WeatherServlet;


/**
 * Module to provide bindings for the servlets
 */
public class FrontendGuiceModule extends ServletModule {
  // TODO: move these modules to a modules dir
  @Override protected void configureServlets() {
    serve("/*").with(WeatherServlet.class);
    bind(WeatherClient.class).to(YahooWeatherClientImpl.class);
    bind(WeatherPresenter.class).to(HtmlWeatherPresenter.class);
    bind(SoyTofu.class).toInstance(SoyFileSet.builder()
    		.add(new File("template.soy")).build().compileToTofu());
  }
}
