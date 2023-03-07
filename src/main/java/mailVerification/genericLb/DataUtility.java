package mailVerification.genericLb;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataUtility {
public String getDataFromPropertiesFile(String key) throws IOException {
	FileInputStream fis= new FileInputStream("./src/test/resources/PropertiesData.properties");
	Properties pObj=new Properties();
	pObj.load(fis);
	String value=pObj.getProperty(key);
	return value;
}
}
