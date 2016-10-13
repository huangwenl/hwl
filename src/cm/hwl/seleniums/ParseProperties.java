package cm.hwl.seleniums;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ParseProperties {
    private Properties pro = new Properties();

    public ParseProperties(String path) {
	this.loadProperties(path);
    }

    public void loadProperties(String FilePath) {
	try {
	    InputStream in = new FileInputStream(FilePath);
	    pro.load(in);
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public String getData(String keyName) {
	return pro.getProperty(keyName).trim();
    }

}
