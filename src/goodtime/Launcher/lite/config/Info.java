package goodtime.Launcher.lite.config;

import goodtime.Launcher.lite.core.GTLLite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Info {
	public static final File configPath = new File("GTL.cfg");
	public static final File versionPath = new File("./.minecraft/versions");
	
	public static String username;
	public static String password;
	public static String javaPath;
	public static String javaArgs;
	public static String memory;
	
	public static String version;
	public static String mcVersion;
	
	public static String versionID;
	public static String versionArgs;
	public static String versionMain;
	public static String versionProfilePath;
	
	public static String library;
	public static String libraries = "";
	public static String nativesPath;
	public static String classPath;
	
	public static String cmdLaunch;
	
	private static JSONObject object;
	
	public static void getGameInfo() {
		getVersionProfilePath();
		
		StringBuffer stringBuffer = new StringBuffer();
		String line = null ;
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(versionProfilePath)));
			while( (line = br.readLine())!= null ){
				stringBuffer.append(line);
			} 
			br.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		object = new JSONObject(stringBuffer.toString());
		System.out.println(object);
			
	
		try {
			versionID = object.getString("id");
			versionArgs = object.getString("minecraftArguments");
			versionMain = object.getString("mainClass");
		} catch (JSONException e) {
			e.printStackTrace();
		} 
	
	}
	
	public static void getLibraries() {
		JSONArray array = (JSONArray) object.get("libraries");
		for (int a = 0; a < array.length(); a++) 
		{	
			JSONObject arrayObject = (JSONObject) array.get(a);
			library = arrayObject.get("name").toString();
			String p1 = library.substring(0 , library.lastIndexOf(":"));
			String p2 = p1.replace(".", "/");
			String p3 = p2.replace(":", "/");
			String p4 = library.substring(library.lastIndexOf(":")+1 );
			String p5 = p3+"/"+p4+"/";
			String p6 = library.substring(library.indexOf(":")+1);
			String lib = "\""+"./.minecraft/libraries/"+p5+p6.replace(":", "-")+".jar" ;
			libraries += lib+"\""+";";
		}
	}
	public static void getLaunchInfo() {
		try {
			getGameInfo();
			getLibraries();
			getMcVersion();
			getNativesPath();
			getClassPath();
			username = Config.getConfig("username");
			memory = Config.getConfig("memory");
			String one = Info.versionArgs.replace("${auth_player_name}", username);
			String two = one.replace("${version_name}", mcVersion);
			String three = two.replace("${game_directory}", "./.minecraft");
			String four = three.replace("${assets_root}", "./.minecraft/assets");
			String five = four.replace("${assets_index_name}", mcVersion);
			String six = five.replace("${auth_uuid}", "auth_uuid");
			String seven = six.replace("${auth_access_token}", "auth_access_token"); 
			String eight = seven.replace("${user_properties}", "{}");
			String ma = eight.replace("${user_type}", "legacy");
			cmdLaunch = "java -Xmx"+Info.memory+"M "+"-Djava.library.path="+nativesPath+" -classpath "+libraries+classPath+" "+versionMain+" "+ma;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getMcVersion() {
		mcVersion = versionID;
		mcVersion = mcVersion.substring(0, mcVersion.lastIndexOf("-"));
	}
	
	public static void getNativesPath() {
		nativesPath = "\""+versionPath+"/"+version+"/"+version+"-Natives\"";
	}
	
	public static void getClassPath() {
		classPath = versionPath+"/"+version+"/"+version+".jar";
	}
	
	public static void getVersionProfilePath() {
		versionProfilePath = versionPath+"/"+version+"/"+version+".json";
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
