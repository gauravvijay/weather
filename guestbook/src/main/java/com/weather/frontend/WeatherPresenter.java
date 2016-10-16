package com.weather.frontend;

import com.weather.data.WeatherView;

/**
 * UI presentation layer to render weather view model.
 *
 */
public interface WeatherPresenter {
  String getHtml(WeatherView wv);
}
