package com.weather;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;

import javax.servlet.ServletException;

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
  public WeatherInfo getWeatherInfo(City city) throws ServletException {
    String cityStr = city.toString();
    try {
      URL weatherUrl = new URL(WEATHER_URL + URLEncoder.encode(String.format(YQL, cityStr), "UTF-8"));
      String weatherResultStr = IOUtils.toString(weatherUrl, Charset.forName("UTF-8"));
      JSONObject itemJson = new JSONObject(weatherResultStr)
          .getJSONObject("query")
          .getJSONObject("results")
          .getJSONObject("channel")
          .getJSONObject("item");
      // TODO: Parse information for 3 day forecast, instead of using the description
      // from Yahoo API directly.
      return new WeatherInfo(itemJson.getString("title"), stripCData(itemJson));
    } catch (JSONException e) {
      // TODO: Do some json exception specific tasks.
      throw new ServletException(e);
    } catch (IOException e) {
      throw new ServletException(e);
    }
  }

  private String stripCData(JSONObject itemJson) {
    String descriptionStr = itemJson.getString("description");
    return descriptionStr.substring(9, descriptionStr.indexOf("]]>"));
  }
}
