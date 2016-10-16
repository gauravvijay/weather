package com.weather.backend;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.weather.data.City;
import com.weather.data.WeatherInfo;

/**
 * WeatherService implementation using Yahoo weather API
 */
public class YahooWeatherServiceImpl implements WeatherService {
  private static final String YQL = "select * from weather.forecast "
      + "where woeid in (select woeid from geo.places(1) where text=\"%s\")";
  // TODO: Use API key for accounting and productionization.
  private static final String WEATHER_URL = "http://query.yahooapis.com/v1/public/yql?format=json&q=";

  @Override
  public WeatherInfo getWeatherInfo(City city) throws BackendException {
    String cityStr = city.toString();
    // TODO: throw only server exception with a cause.
    try {
      URL weatherUrl = new URL(WEATHER_URL + URLEncoder.encode(String.format(YQL, cityStr), "UTF-8"));
      String weatherResultStr = IOUtils.toString(weatherUrl, Charset.forName("UTF-8"));
      JSONObject itemJson = new JSONObject(weatherResultStr).getJSONObject("query").getJSONObject("results")
          .getJSONObject("channel").getJSONObject("item");
      return new WeatherInfo(itemJson.getString("title"), itemJson.getString("description"));
    } catch (JSONException e) {
      // TODO: Do some json exception specific tasks.
      throw new BackendException(e);
    } catch (IOException e) {
      throw new BackendException(e);
    }
  }
}
