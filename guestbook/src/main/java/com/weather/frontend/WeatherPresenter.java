package com.weather.frontend;

import com.weather.data.WeatherView;

public interface WeatherPresenter {
  String getHtml(WeatherView wv);
}
