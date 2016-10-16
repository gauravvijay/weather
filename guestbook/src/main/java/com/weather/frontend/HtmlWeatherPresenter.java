package com.weather.frontend;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.template.soy.data.SanitizedContent.ContentKind;
import com.google.template.soy.data.UnsafeSanitizedContentOrdainer;
import com.google.template.soy.tofu.SoyTofu;
import com.weather.data.City;
import com.weather.data.WeatherInfo;

/**
 * Soy template based UI presentation layer.
 *
 */
public class HtmlWeatherPresenter implements WeatherPresenter {
  @Inject
  SoyTofu tofu;

  @Override
  public String getHtml(City city, WeatherInfo weatherInfo) {
    String html = tofu.newRenderer("com.weather.weatherPageTemplate")
        .setData(ImmutableMap.<String, Object>of("selectedCity", city.toString(), "weatherTitle",
            weatherInfo.getTitle(), "weatherDescription",
            UnsafeSanitizedContentOrdainer.ordainAsSafe(weatherInfo.getDescription(), ContentKind.HTML),
            // TODO: use rate limiting.
            // parse json correctly on only show the next 3 days of forecast.
            // send for review
            "cities", City.getCities()))
        .render();
    return html;
  }
}