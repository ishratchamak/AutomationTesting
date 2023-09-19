package imp;

import java.util.Date;

public class Utilities {
	
	public static String GenerateEmailWithTimeStamp() {
		Date date = new Date();
		String timestamp = date.toString().replace(" ", "_").replace(":", "_");
		return "sonali_" + timestamp + "@gmail.com";
	}
}
