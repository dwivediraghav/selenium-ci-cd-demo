package test1;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writedataexcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\myfile.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook();
       XSSFSheet sheet= workbook.createSheet("Data");
       
      XSSFRow r1= sheet.createRow(0);
             r1.createCell(0).setCellValue("Selnemium");
             r1.createCell(1).setCellValue(19);
             r1.createCell(2).setCellValue("Automation");
       XSSFRow r2= sheet.createRow(1);
             r2.createCell(0).setCellValue("Python");
             r2.createCell(1).setCellValue(2);
             r2.createCell(2).setCellValue("Automation");
       XSSFRow r3= sheet.createRow(2);
             r3.createCell(0).setCellValue("C#");
             r3.createCell(1).setCellValue(3);
             r3.createCell(2).setCellValue("Automation");
             workbook.write(file);
       System.out.println("Data is created");
           
             
	}

}
