package com.weather.frontend;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.weather.backend.BackendException;
import com.weather.backend.WeatherService;
import com.weather.data.City;
import com.weather.data.WeatherView;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Weather servlet showing weather from cities of the world.
 *
 */
@Singleton
public class WeatherServlet extends HttpServlet {
	@Inject
	WeatherService wc;
	@Inject
	WeatherPresenter wp;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			resp.setContentType("text/html");
			resp.getWriter().println(wp.getHtml(getView(req)));
		} catch (BackendException e) {
			resp.setContentType("text/plain");
			// TODO: implement a proper exception handling servlet.
			resp.getWriter().println("Sorry, you have reached an error page.. Try something else");
		}
	}

	/**
	 * @param req
	 * @return ui model to be passed on to the template.
	 * @throws IOException
	 */
	private WeatherView getView(HttpServletRequest req) throws BackendException {
		City city = City.getSanitized(req.getParameter("city"));
		WeatherView wv = new WeatherView(city, wc.getWeatherInfo(city));
		return wv;
	}
}
