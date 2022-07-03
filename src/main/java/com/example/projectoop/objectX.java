package com.example.projectoop;

import java.io.IOException;
import java.util.ArrayList;

import static com.example.projectoop.ReadAPIs.APIs;

public class objectX {

    private String name;
    private ArrayList<fields> fieldSplit = new ArrayList<>();
    private ArrayList<String> objInh = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<fields> getFieldSplit() {
        return fieldSplit;
    }

    public void setFieldSplit(ArrayList<fields> fieldSplit) {
        this.fieldSplit = fieldSplit;
    }

    public ArrayList<String> getObjInh() {
        return objInh;
    }

    public void setObjInh(ArrayList<String> objInh) {
        this.objInh = objInh;
    }

    public static ArrayList<API> arrange(String excelFilePath) throws IOException {
     //   ArrayList<objectX> objects = new ArrayList<>();
        ArrayList<API> apis = new ArrayList<>();
        apis = APIs(excelFilePath);



        for (API obj : apis) {
            ArrayList<objectX> arrOfobjects = new ArrayList<>();        //storing return
                for (int j=0 ; j< obj.getAPIData().size()-1;j++) {

                    //check type ==> if object --> create new objectX
                    if((obj.getAPIData().get(j).getType().matches("object.*"))){

                        objectX o1 = new objectX();
                        o1.setName(obj.getAPIData().get(j).getType());


                        for (int f=j+1; f< obj.getAPIData().size();f++) {
                            if (obj.getAPIData().get(f).getFields().getFieldNames().contains(o1.getName())) {
                                o1.objInh.add(obj.getAPIData().get(f).getType());
                            }
                        }



                       if(j< obj.getAPIData().size()-1){ j++;}
                       else {break;}

                       int m = j;
                        while (!(obj.getAPIData().get(m).getType().matches("object.*"))) {
                            //then add to objectX.data untill find next object type
                            o1.fieldSplit.add(obj.getAPIData().get(m).getFields());
                            if(m< obj.getAPIData().size()-1){m++;}
                            else {break;}
                        }
                        arrOfobjects.add(o1);
                    }

                }


                obj.setObjectXES(arrOfobjects);
            }

        return  apis; //da ely yn returno lel guiiiiiiiiiiiiiiiiiiiii

    }



    public String toString() {
        return "objectX{" +
                "name='" + name + '\'' +
                ", fieldSplit=" + fieldSplit +
                ", objInh=" + objInh +
                '}';
    }
}
