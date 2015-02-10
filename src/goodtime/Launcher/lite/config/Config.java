package goodtime.Launcher.lite.config;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import goodtime.Launcher.lite.config.Info;

public class Config {

	private static Properties cfgprop = new Properties();

	public static String getConfig(String configKey) {
		InputStream cfgin = Config.class.getResourceAsStream(Info.configPath.toString());
		String cfgkey = null;
		try {
			cfgprop.load(cfgin);
			cfgkey = cfgprop.getProperty(configKey);
			cfgin.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cfgkey;
	}
	
	public static void setConfig(String configkey, String value) {
		try {
			OutputStream cfgout = new FileOutputStream(Info.configPath);
			cfgprop.setProperty(configkey, value);
			cfgprop.store(cfgout, "GoodTime Launcher Lite Config File");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}
}
