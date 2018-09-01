package test_cases;

import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import executions.ReadObjrctRepo;
import executions.UIHandle;
import xlreader.ReadFile;

public class TestRunner {
	@Test
	public void testLogin() throws Exception {

		WebDriver webdriver = new FirefoxDriver();
		ReadFile file = new ReadFile();
		ReadObjrctRepo object = new ReadObjrctRepo();
		Properties allObjects = object.getObjectRepo();
		UIHandle operation = new UIHandle(webdriver);
		Sheet sheet = file.readxl(System.getProperty("user.dir") + "\\", "TestCase.xlsx", "Sheet1");
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		for (int i = 1; i < rowCount + 1; i++) {
			Row row = sheet.getRow(i);
			if (row.getCell(0).toString().length() == 0) {
				System.out.println(row.getCell(1).toString() + "----" + row.getCell(2).toString() + "----"
						+ row.getCell(3).toString() + "----" + row.getCell(4).toString());
				operation.perform(allObjects, row.getCell(1).toString(), row.getCell(2).toString(),
						row.getCell(3).toString(), row.getCell(4).toString());
			} else {
				System.out.println("New Testcase->" + row.getCell(0).toString() + " Started");
			}
		}
	}

}
