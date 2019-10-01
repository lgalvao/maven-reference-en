package org.sonatype.mavenbook.weather;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Logger;

public class YahooRetriever {
	private static Logger log = Logger.getLogger(YahooRetriever.class.getName());

	public InputStream retrieve(String zipcode) throws Exception {
		log.info( "Retrieving Weather Data" );
		String url = "http://weather.yahooapis.com/forecastrss?p=" + zipcode;
		URLConnection conn = new URL(url).openConnection();
		return conn.getInputStream();
	}

}
