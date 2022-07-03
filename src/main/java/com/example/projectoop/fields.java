package com.example.projectoop;

public class fields {

    private String fieldNames;
    private String allowedValue;
    private String mandatory;

    public String getFieldNames() {
        return fieldNames;
    }

    public void setFieldNames(String fieldNames) {


        String last = fieldNames.replaceAll(".*field","field ");


        this.fieldNames = last;
    }

    public String getAllowedValue() {
        return allowedValue;
    }

    public void setAllowedValue(String allowedValue) {
        this.allowedValue = allowedValue;
    }

    public String getMandatory() {
        return mandatory;
    }

    public void setMandatory(String mandatory) {
        this.mandatory = mandatory;
    }

    @Override
    public String toString() {
        return "fields{" +
                "fieldNames='" + fieldNames + '\'' +
                ", allowedValue='" + allowedValue + '\'' +
                ", mandatory='" + mandatory + '\'' +
                '}';
    }
}
