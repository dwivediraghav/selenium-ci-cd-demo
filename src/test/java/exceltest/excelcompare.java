package exceltest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelcompare {

    public static void main(String[] args) throws IOException {
        // File paths for the Excel sheets to compare
        String file1 = System.getProperty("user.dir") + "\\testdata\\LGD.xlsx";
        String file2 = System.getProperty("user.dir") + "\\testdata\\authdistrict.xlsx";
        String resultFile = System.getProperty("user.dir") + "\\testdata\\result_file.xlsx";

        // Load the first Excel file
        FileInputStream fis1 = new FileInputStream(file1);
        XSSFWorkbook wb1 = new XSSFWorkbook(fis1);
        XSSFSheet sheet1 = wb1.getSheetAt(0);

        // Load the second Excel file
        FileInputStream fis2 = new FileInputStream(file2);
        XSSFWorkbook wb2 = new XSSFWorkbook(fis2);
        XSSFSheet sheet2 = wb2.getSheetAt(0);

        // Create a workbook for the result file
        XSSFWorkbook resultWb = new XSSFWorkbook();
        XSSFSheet resultSheet = resultWb.createSheet("ComparisonResult");

        // Loop through the maximum row count between the two sheets
        int maxRowCount = Math.max(sheet1.getLastRowNum(), sheet2.getLastRowNum());

        for (int i = 0; i <= maxRowCount; i++) {
            Row row1 = sheet1.getRow(i);
            Row row2 = sheet2.getRow(i);
            Row resultRow = resultSheet.createRow(i);

            // Loop through the maximum cell count in the two sheets
            int maxCellCount = Math.max(
                row1 != null ? row1.getLastCellNum() : 0, 
                row2 != null ? row2.getLastCellNum() : 0
            );

            for (int j = 0; j < maxCellCount; j++) {
                Cell cell1 = row1 != null ? row1.getCell(j) : null;
                Cell cell2 = row2 != null ? row2.getCell(j) : null;
                Cell resultCell = resultRow.createCell(j);

                // Get the cell values as strings
                String data1 = getCellValueAsString(cell1);
                String data2 = getCellValueAsString(cell2);

                // Compare data case-insensitively and highlight differences in red
                if (!data1.equalsIgnoreCase(data2)) {
                    resultCell.setCellValue(data1 + " ≠ " + data2); // Show both values in result
                    fillRedColor(resultCell, resultWb); // Mark as red
                } else {
                    resultCell.setCellValue(data1); // Matching cells
                }
            }
        }

        // Save the result Excel file
        FileOutputStream fos = new FileOutputStream(resultFile);
        resultWb.write(fos);
        fos.close();
        fis1.close();
        fis2.close();
        wb1.close();
        wb2.close();
        resultWb.close();

        System.out.println("Excel comparison complete. Differences are highlighted in the result file.");
    }

    // Helper method to get cell value as a string
    private static String getCellValueAsString(Cell cell) {
        DataFormatter formatter = new DataFormatter();
        return cell == null ? "" : formatter.formatCellValue(cell);
    }

    // Helper method to fill a cell with red color
    private static void fillRedColor(Cell cell, XSSFWorkbook workbook) {
        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(style);
    }
}
