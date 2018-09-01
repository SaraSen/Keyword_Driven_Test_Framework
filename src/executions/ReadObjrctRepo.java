package executions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadObjrctRepo {
	Properties p = new Properties();
	
	public Properties getObjectRepo() throws IOException {
		InputStream is = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\objects\\objects.properties"));
		p.load(is);
		return p;
	}

}
