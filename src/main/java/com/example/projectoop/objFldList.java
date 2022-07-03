package com.example.projectoop;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class objFldList {


    public static ArrayList<objectFld> readBooksFromExcelFile(String excelFilePath) throws IOException {
        ArrayList<objectFld> listObj = new ArrayList<>();
        // excelFilePath = "D:/Example.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = new XSSFWorkbook(inputStream);

        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();

        while (iterator.hasNext()) {                    //check if there are more rows
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            objectFld obj = new objectFld();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                switch (cell.getColumnIndex()) {
                    case 0:
                            obj.setIO(cell.getStringCellValue());
                        //System.out.print(obj.getIO()+" ");
                        break;
                    case 1: {
                        obj.setFieldName(cell.getStringCellValue());
                        // System.out.print(obj.getFields()+" ");
                        break;
                    }
                    case 2:
                            obj.setType(cell.getStringCellValue());
                           // System.out.print(obj.getType()+" ");
                        break;
                    case 3:
                            obj.setAllowedValues(cell.getStringCellValue());
                        //  System.out.print(obj.getAllowedValues()+" ");
                        break;
                    case 4:
                            obj.setMandatory(cell.getStringCellValue());
                        //   System.out.print(obj.getAllowedValues()+" ");
                        break;
                }
                System.out.print("");
            }
            if (obj.isNotEmpty()) {
                listObj.add(obj);
            }
                // System.out.println();
            workbook.close();
            inputStream.close();

        }
        return listObj;
    }
}
