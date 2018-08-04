package microservice.sc.util;

import java.io.InputStream;
import java.util.Properties;

public class Prop {

	public static String arcgis_js_api_ipport = null;

	
	static {
		InputStream is = null;
		try {
			Properties prop = new Properties();
			is = Prop.class.getClassLoader().getResourceAsStream(
					"config.properties");
			prop.load(is);
			arcgis_js_api_ipport = prop.getProperty("arcgis_js_api_ipport");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
					is = null;
				} catch (Exception e) {

				}
			}
		}
	}


}
