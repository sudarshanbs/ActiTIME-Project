package com.demo.generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib
{
	public String getPropertiesFileData(String key) throws Exception
	{
		FileInputStream fis = new FileInputStream("./data/commonData.properties");

		Properties p = new Properties();

		p.load(fis);

		String property = p.getProperty(key);

		fis.close();

		return property;
	}

	public String getExcelFileData(String sheet, int row, int cell) throws Exception
	{
		FileInputStream fis = new FileInputStream("./data/testScriptData.xlsx");

		Workbook wb = WorkbookFactory.create(fis);

		String testScript = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();

		fis.close();
		wb.close();

		return testScript;
	}

	public void setTestScriptData(String sheet, int row, int cell, String data, String filePath) throws Exception
	{
		FileInputStream fis = new FileInputStream(filePath);

		Workbook wb = WorkbookFactory.create(fis);

		wb.getSheet(sheet).getRow(row).getCell(cell).setCellValue(data);

		FileOutputStream fos = new FileOutputStream(filePath);

		wb.write(fos);

		fis.close();
		fos.close();
		wb.close();
	}
}
