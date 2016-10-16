package com.weather.backend;

import com.weather.data.City;
import com.weather.data.WeatherInfo;
import java.io.IOException;

// TODO add documentation
public interface WeatherClient {
  /**
   * @param city
   * @return
   * @throws IOException
   */
  WeatherInfo getWeatherInfo(City city) throws IOException;
}
