package goodtime.Launcher.lite.core;

import java.io.IOException;

import goodtime.Launcher.lite.config.Info;

public class Launch {
	public static void main(String[] args) {
		try {
			System.out.println(Info.cmdLaunch);
			Runtime.getRuntime().exec(Info.cmdLaunch);
			System.out.println("“—‘À––");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
