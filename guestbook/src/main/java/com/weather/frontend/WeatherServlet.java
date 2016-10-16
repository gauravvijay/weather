package com.weather.frontend;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.weather.backend.WeatherClient;
import com.weather.data.City;
import com.weather.data.WeatherView;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Singleton
public class WeatherServlet extends HttpServlet {
  @Inject
  WeatherClient wc;
  @Inject
  WeatherPresenter wp;

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    resp.setContentType("text/html");
    resp.getWriter().println(wp.getHtml(getView(req)));
  }
  
  /**
   * @param req
   * @return
   * @throws IOException
   */
  private WeatherView getView(HttpServletRequest req) throws IOException {
    City city = City.getSanitized(req.getParameter("city"));
    WeatherView wv = new WeatherView(city, wc.getWeatherInfo(city));
    return wv;
  }
}
