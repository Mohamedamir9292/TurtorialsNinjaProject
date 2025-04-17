package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility{

	
	public FileInputStream file;
	public FileOutputStream fileOutput;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row; 
	XSSFCell cell;
	XSSFCellStyle cellStyle;
	String path;
	
	public ExcelUtility(String path) {
		this.path = path;
	}
	
	public int getRowCount(String sheetName) throws IOException {
		file = new FileInputStream(path);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		file.close();
		return rowcount;
		
	}
	
	public int getCellCount(String sheetName, int rownum) throws IOException {
		file = new FileInputStream(path);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		int cellCount = row.getLastCellNum();
		workbook.close();
		file.close();
		return cellCount;
	}
	
	public String getCellData(String sheetName, int rownum, int colnum) throws IOException {
		file = new FileInputStream(path);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		try{
			data = formatter.formatCellValue(cell); // returns the formatted value of the cell as a string regardless
		}
		catch(Exception e) {
			data = "";
		}
		workbook.close();
		file.close();
		return data;	
	}
	
	public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException {
		File xfile = new File(path);
		if(!xfile.exists()) // if file does not exist then create new file
		{
			workbook = new XSSFWorkbook();
			fileOutput = new FileOutputStream(path);
			workbook.write(fileOutput);
		}
		
		file = new FileInputStream(path);
		workbook = new XSSFWorkbook(file);
		
		if(workbook.getSheetIndex(sheetName)==-1) // if sheet does not exist then create new sheet
			workbook.createSheet(sheetName);
		sheet = workbook.getSheet(sheetName);
		
		if(sheet.getRow(rownum)==null)// if row does not exist then create new Row
			sheet.createRow(rownum);
		sheet.getRow(rownum);
		
		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fileOutput = new FileOutputStream(path);
		workbook.write(fileOutput);
		workbook.close();
		file.close();
		fileOutput.close();
	}
	
	public void fillGreenColor(String sheetName, int rownum, int colnum) throws IOException {
		file = new FileInputStream(path);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		
		cellStyle = workbook.createCellStyle();
		
		cellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(cellStyle);
		workbook.write(fileOutput);
		workbook.close();
		file.close();
		fileOutput.close();
		
	}
	
	public void fillRedColor(String sheetName, int rownum, int colnum) throws IOException {
		
		file = new FileInputStream(path);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		
		cellStyle = workbook.createCellStyle();
		
		cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(cellStyle);
		workbook.write(fileOutput);
		workbook.close();
		file.close();
		fileOutput.close();
		
	}
	
	
	
	
	
	
	
	
}
