package test1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writedynamicdataexcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\myfile1.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook();
       XSSFSheet sheet= workbook.createSheet("DynamicData");
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter how many rows");
       int noOfrows=sc.nextInt();
       System.out.println("Enter how may cells");
       int noOfCells=sc.nextInt();
       
       for(int r=0;r<noOfrows;r++)
       {
    	  XSSFRow currentrow=sheet.createRow(r);
    	   for(int c=0;c<noOfCells;c++)
    	   {
    		   XSSFCell cell=currentrow.createCell(c);
    		   cell.setCellValue(sc.next());
    		   
    	   }
       }
       
       workbook.write(file);
       System.out.println("file is created ");

	}

}
