package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Data_Providers {
	
	@DataProvider(name = "LoginData")
	public String[][]getData() throws IOException{
		String path = System.getProperty("user.dir")+"\\test_data\\login_test_data.xlsx";
		
		ExcelUtility xlutil = new ExcelUtility(path);
		
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcolumns = xlutil.getCellCount("Sheet1", 1);
		
		String logindata[][]= new String[totalrows][totalcolumns];
		
		for(int i=1; i<=totalrows; i++) {
			for(int j=0; j<totalcolumns; j++) {
				logindata[i-1][j] = xlutil.getCellData("Sheet1", i, j);
			}
		}
	return logindata;
	}

}
