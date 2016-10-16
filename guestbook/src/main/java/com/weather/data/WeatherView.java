package com.weather.data;

public class WeatherView {
  City city;
  WeatherInfo weatherInfo;
  /**
   * @param city
   * @param weatherInfo
   */
  public WeatherView(City city, WeatherInfo weatherInfo) {
    super();
    this.city = city;
    this.weatherInfo = weatherInfo;
  }
  /**
   * @return the city
   */
  public City getCity() {
    return city;
  }
  /**
   * @return the weatherInfo
   */
  public WeatherInfo getWeatherInfo() {
    return weatherInfo;
  }
}