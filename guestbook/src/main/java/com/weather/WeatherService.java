package com.weather;

import java.io.IOException;

import javax.servlet.ServletException;

import com.weather.data.City;
import com.weather.data.WeatherInfo;

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
  WeatherInfo getWeatherInfo(City city) throws ServletException;
}
