package com.weather.frontend;

import com.weather.data.City;
import com.weather.data.WeatherInfo;

/**
 * UI presentation layer to render weather view model.
 *
 */
public interface WeatherPresenter {
  String getHtml(City selectedCity, WeatherInfo weatherInfo);
}
