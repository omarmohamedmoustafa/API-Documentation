package com.example.projectoop;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class objectFld {

    private String IO;
    private String type;

    private fields field = new fields();
    // private String fields;
   // private String allowedValues;
   // private String mandatory;

    public objectFld( ) {
    }

    public objectFld(String IO, fields fields, String type, String allowedValues, String mandatory) {
        this.IO = IO;
        this.field = fields;
        this.type = type;
        this.field.setAllowedValue(allowedValues);  ;
        this.field.setMandatory(mandatory);
    }

    public String getIO() {
        return IO;
    }

    public void setIO(String IO) {
        this.IO = IO;
    }

    public fields getFields() {
        return field;
    }

    public void setFields(fields field) {
        this.field = field;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void setFieldName(String fieldName) {
        this.field.setFieldNames(fieldName);
    }


    public void setAllowedValues(String allowedValues) {
        this.field.setAllowedValue(allowedValues) ;
    }

    public String getMandatory() {
        return this.field.getMandatory();
    }

    public void setMandatory(String mandatory) {
        this.field.setMandatory(mandatory);
    }


    private Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();

            case BOOLEAN:
                return cell.getBooleanCellValue();

            case NUMERIC:
                return cell.getNumericCellValue();
        }

        return null;
    }


    public boolean isNotEmpty(){
        if (this.IO == null)
            return false;
        return true;
    }


    public String print() {
        return "objectFld{" +
                "IO='" + IO + '\'' +
                ", fields='" + field.toString() + '\'' +
                '}';
    }
}