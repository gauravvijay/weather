package weatherapp;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import com.weather.WeatherPresenter;
import com.weather.WeatherService;
import com.weather.WeatherServlet;
import com.weather.data.City;
import com.weather.data.WeatherInfo;

public class WeatherServletTest {
  private WeatherServlet servlet;

  @Test
  public void testDoGet() throws IOException, ServletException {
    HttpServletRequest req = mock(HttpServletRequest.class);
    HttpServletResponse resp = mock(HttpServletResponse.class);
    PrintWriter printWriter = mock(PrintWriter.class);
    WeatherPresenter weatherPresenter = mock(WeatherPresenter.class);
    WeatherService weatherService = mock(WeatherService.class);
    WeatherInfo weatherInfo = new WeatherInfo("test", "description");

    when(resp.getWriter()).thenReturn(printWriter);
    when(req.getParameter("city")).thenReturn("London");
    when(weatherService.getWeatherInfo(City.LONDON)).thenReturn(weatherInfo);
    when(weatherPresenter.getHtml(City.LONDON, weatherInfo)).thenReturn("test");

    servlet = new WeatherServlet(weatherService, weatherPresenter);
    servlet.doGet(req, resp);
    verify(printWriter).println("test");
  }

}
