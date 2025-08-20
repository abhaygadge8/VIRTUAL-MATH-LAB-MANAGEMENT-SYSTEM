package com.coep.genericque;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ExcelModifier {
    public static void main(String[] args) {
        try {
            String filename = "Excel//_Intern_0901_108_Assign1_Abhay.xlsx";
            FileInputStream fis = new FileInputStream(filename);
            
            // Open the existing workbook
            XSSFWorkbook workbook = new XSSFWorkbook(filename);
            fis.close(); // Close input stream

            // Add a new sheet
            XSSFSheet newSheet = workbook.createSheet("NewSheet");

            // Optionally write some data
            newSheet.createRow(0).createCell(0).setCellValue("This is a new sheet!");

            // Save changes to the same file
            FileOutputStream fos = new FileOutputStream(filename);
            workbook.write(fos);
            fos.close();
            //workbook.close();

            System.out.println("New sheet added successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
