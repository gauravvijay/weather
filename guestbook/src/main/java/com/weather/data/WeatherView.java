package com.weather.data;

/**
 * UI model information.
 *
 */
public class WeatherView {
  City selectedCity;
  WeatherInfo weatherInfo;
  /**
   * @param city
   * @param weatherInfo
   */
  public WeatherView(City city, WeatherInfo weatherInfo) {
    super();
    this.selectedCity = city;
    this.weatherInfo = weatherInfo;
  }
  /**
   * @return the city
   */
  public City getSelectedCity() {
    return selectedCity;
  }
  /**
   * @return the weatherInfo
   */
  public WeatherInfo getWeatherInfo() {
    return weatherInfo;
  }
}