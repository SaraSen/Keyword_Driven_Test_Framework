package xlreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFile {

	public Sheet readxl(String path, String name, String sheetname) throws IOException {
		File file = new File(path + "\\" + name);

		FileInputStream inputstream = new FileInputStream(file);
		Workbook wb = null;
		String fileextention = name.substring(name.indexOf("."));
		if (fileextention.equals(".xlsx")) {
			wb = new XSSFWorkbook(inputstream);
		} else if (fileextention.equals(".xls")) {
			wb = new HSSFWorkbook();
		}
		Sheet sheet = wb.getSheet(sheetname);
		return sheet;

	}

}
