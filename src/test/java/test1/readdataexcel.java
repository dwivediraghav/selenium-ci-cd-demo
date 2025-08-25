package test1;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Excel File ---->workbook--->Sheets---->Rows------>Cells
//Rows counting starts from 0,and cell from 1 

public class readdataexcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream file = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\seleniumwebdriver\\testdata\\seleniumpractice.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int totalRow=sheet.getLastRowNum();
		int totalCell=sheet.getRow(1).getLastCellNum();
		System.out.println(totalRow);
		System.out.println(totalCell);
		for(int r=0;r<=totalRow;r++)
		{
			XSSFRow currentRow=sheet.getRow(r);
			for(int c=0;c<totalCell;c++)
			{
				XSSFCell currentCell=currentRow.getCell(c);
				System.out.print(currentCell.toString()+"\t");
				
				
			}
			System.out.println();
		}

	}

}
