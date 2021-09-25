package com.crm.autodesk.GenericLib;
/**
 * This class contains generics methods to read and write the data from excell sheet
 * @author JAnsari
 * 
 */

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	/**
	 * This method will contains data from excell sheet wrt to row number and cell number
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getExcelData(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		
		Workbook workbook=WorkbookFactory.create(fis);//workbookfactory is an interface 
		Sheet sheet = workbook.getSheet(sheetName);
		DataFormatter format = new DataFormatter();
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
	      //cell.getStringCellValue()
		String value = format.formatCellValue(cell);
		
		return value;
	}
	public String getExcelDataTest(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPathTest);
		
		Workbook workbook=WorkbookFactory.create(fis); 
		Sheet sheet = workbook.getSheet(sheetName);
		DataFormatter format = new DataFormatter();
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String value = format.formatCellValue(cell);
		
		return value;
	}
	public String getExcelDataTest1(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPathTest1);
		
		Workbook workbook=WorkbookFactory.create(fis); 
		Sheet sheet = workbook.getSheet(sheetName);
		DataFormatter format = new DataFormatter();
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String value = format.formatCellValue(cell);
		
		return value;
	}
	public Object[][] getExcelData1(String SheetName) throws Throwable, IOException 
	{
		//create the object of fileinputstream and pass the path
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelDataProvider);
		
		Workbook workbook=WorkbookFactory.create(fis); 
		Sheet sheet = workbook.getSheet(SheetName);
		int lastRow=sheet.getLastRowNum();
		int lastcell=sheet.getRow(0).getLastCellNum();
		Object[][] data=new Object[lastRow][lastcell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastcell;j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return data;
	}
	

}
