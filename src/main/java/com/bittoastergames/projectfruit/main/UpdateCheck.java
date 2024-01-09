package com.bittoastergames.projectfruit.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class UpdateCheck {


     public static String curVersion;
	
	public static boolean isUpdateAvailable() throws IOException,
			MalformedURLException {
		BufferedReader versionFile = new BufferedReader(
				new InputStreamReader(
						new URL(
								"http://bittoastergames.com/wp-content/uploads/2014/03/projectfruitversion.txt")
								.openStream()));
		curVersion = versionFile.readLine();

		versionFile.close();

		if (!curVersion.contains(ProjectFruit.version)) {
			return true;
		}

		return false;
	}

    public static String getNewVersion(){
        return curVersion;
    }

}
