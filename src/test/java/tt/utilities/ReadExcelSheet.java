package tt.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelSheet {

	public static Map<String, Map<String, String>> setMapData() throws IOException{
		
		String path ="C:/Users/rasel/workspace/SaturdayThorAutomationProject/src/test/resource/Datasheets/EbayDataSheet.xlsx";
		
		FileInputStream fis = new FileInputStream(path);

		Workbook workbook = new XSSFWorkbook(fis);

		Sheet sheet = workbook.getSheetAt(0);

		int lastRow = sheet.getLastRowNum();

		Map<String, Map<String, String>> excelFileMap = new HashMap<String, Map<String, String>>();

		Map<String, String> dataMap = new HashMap<String, String>();
		

		// Looping over entire row
		for (int i = 0; i <= lastRow; i++) {

			Row row = sheet.getRow(i);
			
			// 0th Cell as Key
			Cell keyCell = row.getCell(0);

			// 1st Cell as Value
			Cell valueCell = row.getCell(1);
							
			final DataFormatter df = new DataFormatter();
			String key = df.formatCellValue(keyCell);
			String value = df.formatCellValue(valueCell);
			
			
			// Putting key & value in dataMap
			dataMap.put(key, value);

			// Putting dataMap to excelFileMap
			excelFileMap.put("EbayDataSheet", dataMap);
			}

		// Returning excelFileMap
		return excelFileMap;

		}

		// Method to retrieve value
		public static String getMapData(String key) throws IOException {
		
			Map<String, String> m = setMapData().get("EbayDataSheet");
			String value = m.get(key);
		
			return value;
		
		}
}
