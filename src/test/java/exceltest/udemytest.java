package exceltest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class udemytest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\Users\\hp\\Documents\\mygov1.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		int sheets=workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("Sheet1"))
			{
				XSSFSheet sheet=workbook.getSheetAt(i);
				Iterator<Row> rows=sheet.iterator();
				Row firstrow=rows.next();
				Iterator<Cell> ce=firstrow.cellIterator();
				int k=0;
				int coloumn=0;
			while(ce.hasNext()) {
				
				Cell value=ce.next();
				if(value.getStringCellValue().equalsIgnoreCase("Full Name")) {
					coloumn=k;
					
				}
				k++;
				}
			System.out.println(coloumn);
			while(rows.hasNext())
			{
				Row r=rows.next();
				if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase("rahul"))
				{
					Iterator<Cell> cv=r.cellIterator();
					while(cv.hasNext()) {
					System.out.println(cv.next().getStringCellValue());	
					}
				}
			}
			}
		}

	}

}
