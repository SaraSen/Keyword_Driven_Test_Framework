package executions;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UIHandle {

	WebDriver driver;

	public UIHandle(WebDriver driver) {
		this.driver = driver;
	}

	public void perform(Properties p, String operation, String objectName, String objectType, String value)
			throws Exception {
		switch (operation.toUpperCase()) {
		case "CLICK":
			driver.findElement(this.getObject(p, objectName, objectType)).click();
			break;
		case "SETTEXT":
			driver.findElement(this.getObject(p, objectName, objectType)).sendKeys(value);
			break;
		case "GOTOURL":
			driver.get(p.getProperty(value));
			break;
		default:
			break;
		}
	}

	private By getObject(Properties p, String objectName, String objectType) throws Exception {

		if (objectType.equalsIgnoreCase("XPATH")) {
			return By.xpath(p.getProperty(objectName));
		} else {
			throw new Exception("Wrong object type");
		}
	}
}
