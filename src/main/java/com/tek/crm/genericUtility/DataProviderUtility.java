package com.tek.crm.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

// Taking data from excel sheet and passing it to script using data provider
public class DataProviderUtility {
	@DataProvider
	//(name = "getData")
	public String[][] getData() throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Amrendra Mishra\\OneDrive\\Desktop\\TestCaseExample.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet4");
		int rowCount = sheet.getPhysicalNumberOfRows();

		int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();
		
		String[][] data = new String[rowCount][cellCount];

		for (int row = 0; row < rowCount; row++) {
			for (int col = 0; col < cellCount; col++) {
				try {
				data[row][col] = sheet.getRow(row).getCell(col).toString();
				} catch(Exception e) {
					data[row][col]=null;
				}
			}
		}
		return data;
	}

}
