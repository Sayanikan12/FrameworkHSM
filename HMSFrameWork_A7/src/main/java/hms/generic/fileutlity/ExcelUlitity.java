package hms.generic.fileutlity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelUlitity {
	
	
		public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws Throwable {
			FileInputStream fis=new FileInputStream("./src/test/resources/testHMSdata.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
			String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).toString();
			wb.close();
			return data;
			}
			
			public int getRowcount(String sheetName) throws Throwable {
				FileInputStream fis=new FileInputStream("./src/test/resources/testHMSdata.xlsx");
				Workbook wb = WorkbookFactory.create(fis);
				int rowCount = wb.getSheet(sheetName).getLastRowNum();
				wb.close();
				return rowCount;
						
			}
			
			public void setDataIntoExcel(String sheetName, int rowNum, int cellNum, String value) throws Throwable, IOException {
				FileInputStream fis=new FileInputStream("./src/test/resources/testHMSdata.xlsx");
				Workbook wb = WorkbookFactory.create(fis);
					wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum,CellType.STRING).setCellValue(value);
					
					FileOutputStream fos=new FileOutputStream("./src/test/resources/testHMSdata.xlsx");
				wb.write(fos);
				wb.close();
			}
			
	}
	
	
