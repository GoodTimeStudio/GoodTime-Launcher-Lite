package goodtime.Launcher.lite.config;

import goodtime.Launcher.lite.core.GTLLite;

import java.io.File;

public class Info {
	public static final File configPath = new File("GTL.cfg");
	public static final File versionPath = new File("./.minecraft/versions");
	
	public static String username;
	public static String password;
	public static String javaPath;
	public static String javaArgs;
	public static String memory;
	
	public static String version;
	
	public static void getGameInfo() {
		
	}
	
	
	
	
	public static void getSelectVersion() {
		version = GTLLite.selectVersion.getSelectedItem().toString();
	}
	
	public static void findAllVersion() {
		try {
			String[] versionDirName = versionPath.list();
			for (int i = 0; i < versionDirName.length; i++) {
				String foundVersion = versionDirName[i].toString();
				GTLLite.selectVersion.addItem(foundVersion);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
