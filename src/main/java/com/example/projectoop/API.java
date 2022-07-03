package com.example.projectoop;

import java.io.IOException;
import java.util.ArrayList;
import static com.example.projectoop.objFldList.readBooksFromExcelFile;

public class API {

    private String ApiName;
    private ArrayList<objectFld> APIData = new ArrayList<>(); //not printed

    private ArrayList<objectX> objectXES = new ArrayList<>();


    public ArrayList<objectX> getObjectXES() {
        return objectXES;
    }

    public void setObjectXES(ArrayList<objectX> objectXES) {
        this.objectXES = objectXES;
    }

    public API() {
    }

    public API(String apiName, ArrayList<objectFld> APIData) {
        ApiName = apiName;
        this.APIData = APIData;
    }

    public String getApiName() {
        return ApiName;
    }

    public void setApiName(String apiName) {
        ApiName = apiName;
    }

    public ArrayList<objectFld> getAPIData() {
        return APIData;
    }

    public void setAPIData(ArrayList<objectFld> APIData) {
        this.APIData = APIData;
    }


    public void print() {
        int count=0;

        System.out.println("API Name: "+this.getApiName());
        System.out.println("API XED: ");
        for(objectX x:objectXES){
            System.out.println(x.toString()) ;
        }
    }

    @Override
    public String toString() {
        return "API{" +
                "ApiName='" + ApiName + '\'' +
                ", APIData=" + APIData +
                ", objectXES=" + objectXES +
                '}';
    }

    //    private String  printXEs(){
//        for(objectX x:objectXES){
//           return x.toString();
//        }
//        return null;
//    }
//    @Override
//    public String toString() {
//        return "API{" +
//                "ApiName='" + ApiName + '\'' +
//                ", objectXES=" + this.printXEs() +
//                '}';
//    }
}

