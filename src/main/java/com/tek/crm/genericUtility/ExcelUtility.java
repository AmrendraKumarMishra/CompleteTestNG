package com.tek.crm.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcel(String sheetName, int rowNum, int cellNum)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./TestData/TestCaseExample.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return data;
	}

	public void setDataBackToExcel(String sheetName, int rowNum, int cellNum, String key)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./TestData/TestCaseExample.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Row Row = wb.getSheet(sheetName).getRow(rowNum);
		Cell cell = Row.createCell(5);
		cell.setCellType(CellType.STRING);
		cell.setCellValue(100);

		FileOutputStream fos = new FileOutputStream("./TestData/TestCaseExample.xlsx");
		wb.write(fos);
		wb.close();
	}

	public String getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./TestData/TestCaseExample.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getLastRowNum();
		return sheetName;

	}

	public double getNumericData(String sheetName, int rowNum, int cellNum)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./TestData/TestCaseExample.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		double data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getNumericCellValue();
		return cellNum;

	}
}