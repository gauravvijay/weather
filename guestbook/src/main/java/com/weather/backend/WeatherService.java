package com.weather.backend;

import com.weather.data.City;
import com.weather.data.WeatherInfo;
import java.io.IOException;

/**
 * Service interface to get weather info.
 *
 */
public interface WeatherService {
  /**
   * @param city
   * @return
   * @throws IOException
   */
  WeatherInfo getWeatherInfo(City city) throws BackendException;
}
