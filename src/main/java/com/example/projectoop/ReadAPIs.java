package com.example.projectoop;

import java.io.IOException;
import java.util.ArrayList;

import static com.example.projectoop.objFldList.readBooksFromExcelFile;

public class ReadAPIs {
    public static ArrayList<API> APIs(String excelFilePath) throws IOException {
        ArrayList<API> totalAPI = new ArrayList<>();
        ArrayList<objectFld> totalFile = new ArrayList<>();
        totalFile = readBooksFromExcelFile(excelFilePath);

        String ApiName = new String();

        for (int i = 1; i < totalFile.size()-1; i++) {

            API newApi = new API();

            ArrayList<objectFld> newApiData = new ArrayList<>();
           // Saving api name
            int start = totalFile.get(i-1).getIO().indexOf('(')+1;
            int end = totalFile.get(i-1).getIO().indexOf(')',start)+1;
            ApiName = totalFile.get(i-1).getIO().substring(start , end );


            if(i < totalFile.size()-1){i++;}
            else {break;}

           while (!(totalFile.get(i).getIO().matches("REST.*"))){

                if (totalFile.get(i).getIO().equals("I") || totalFile.get(i).getIO().equals("O")){
                    newApiData.add(totalFile.get(i));
                }
               if(i < totalFile.size()-1){i++;}
               else {break;}

           }
            newApi.setApiName(ApiName.replace(')',' '));
            newApi.setAPIData(newApiData);
            totalAPI.add(newApi);
        }
        return totalAPI;            // arraylist of arraylist of apis
                                    // arraylist of types of arraylist of arraylist of apis
    }
}