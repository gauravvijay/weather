package com.weather.frontend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.weather.backend.BackendException;
import com.weather.backend.WeatherService;
import com.weather.data.City;

/**
 * Weather servlet showing weather from cities of the world.
 *
 */
@Singleton
public class WeatherServlet extends HttpServlet {
  WeatherService weatherService;
  WeatherPresenter weatherPresenter;

  @Inject
  public WeatherServlet(WeatherService wc, WeatherPresenter wp) {
    super();
    this.weatherService = wc;
    this.weatherPresenter = wp;
  }

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    PrintWriter writer = resp.getWriter();
    try {
      resp.setContentType("text/html");
      City city = City.getSanitized(req.getParameter("city"));
      writer.println(weatherPresenter.getHtml(city, weatherService.getWeatherInfo(city)));
    } catch (BackendException e) {
      resp.setContentType("text/plain");
      // TODO: implement a proper exception handling servlet.
      writer.println("Sorry, you have reached an error page.. Try something else");
    }
  }
}
