package goodtime.Launcher.lite.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;

public class Config {

	private static Properties cfgprop = new Properties();

	public static String getConfig(String configKey) {
		String cfgkey = null;
		try {
			FileInputStream cfgin = new FileInputStream(Info.configPath);
			InputStreamReader cfgr = new InputStreamReader(cfgin, "UTF-8");
			cfgprop.load(cfgr);
			cfgkey = cfgprop.getProperty(configKey);
			cfgin.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cfgkey;
	}
	static OutputStream cfgout;
	static OutputStreamWriter cfgw;
	public static void setConfig(String configkey, String value) {
		try {
			cfgout = new FileOutputStream(Info.configPath);
			cfgprop.setProperty(configkey, value);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  
	}
	
	public static void save() {
		try {
			cfgprop.store(cfgout, "GoodTime Launcher Lite Config File");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
