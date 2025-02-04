package testCases;

import java.io.IOException;
import utilities.ExcelUtility;

public class Dataprovider {
	
	public String[][] getData() throws IOException
	{
		String path =".\\testData\\Opencart_LoginDatas.xlsx"; //taking xl file from test data
		
		
		ExcelUtility xlutil= new ExcelUtility(path); //created an object for XLutility
		int totalrows= xlutil.getRowCount("Sheet1");
		int totalcols= xlutil.getCellCount("Sheet1", 1);
		
		System.out.println("Total rows are"+totalrows);
		System.out.println("Total cols are"+totalcols);
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++) //1 //read the data from xl & storing in two dimensional array
		{
			for(int j=0;j<totalcols;j++)//0 i is rows j is col
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1", i, j) ;
			}
			
		}
		
		return logindata;//returning two dimension array
		
	}

	
	
	public static void main(String[] args) throws IOException
	{
		Dataprovider dp = new Dataprovider();
		
		dp.getData();
	}

}
