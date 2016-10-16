package com.weather.data;

/**
 * Weather related container information.
 *
 */
public class WeatherInfo {
  String description;
  String title;
  
  /**
   * @param title
   * @param description
   */
  public WeatherInfo(String title, String description) {
    super();
    this.title = title;
    this.description = description;
  }
  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }
  /**
   * @return the title
   */
  public String getTitle() {
    return title;
  }
}