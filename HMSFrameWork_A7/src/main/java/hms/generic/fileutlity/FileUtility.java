package hms.generic.fileutlity;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	public String toReadDatafromPropertyfile(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/configData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String data = prop.getProperty(key);
		return data;
	}

}
