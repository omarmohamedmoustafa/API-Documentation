package com.example.projectoop;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventDispatchChain;
import javafx.event.EventDispatcher;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static com.example.projectoop.ReadAPIs.APIs;
import static com.example.projectoop.objFldList.readBooksFromExcelFile;
import static com.example.projectoop.objectX.arrange;

public class HelloApplication extends Application{


    @Override
    public void start(Stage stage) throws IOException {
        ArrayList<API> apis = new ArrayList<>();
        String filePath = "Example_1.xlsx";
        apis = arrange(filePath);
        stage.setTitle("APIs");
        final ArrayList<API> lambada =apis;
        VBox layout= new VBox();
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(10);
        layout.setMinWidth(200);
        layout.setBackground(Background.EMPTY);
        int p=0;

        for( ; p<lambada.size(); p++) {
            Button API = new Button(apis.get(p).getApiName());

            int finalP = p;
            API.setOnAction(e -> {
                Stage frstAPI = new Stage();
                frstAPI.setTitle(lambada.get(finalP).getApiName());
                VBox body = new VBox();


                BorderPane layout1 = new BorderPane();
                layout1.setBackground(Background.EMPTY);
                layout1.setCenter(body);



                for (int i = 0; i < lambada.get(finalP).getObjectXES().size(); i++) {
                    Label ObjXname = new Label(lambada.get(finalP).getObjectXES().get(i).getName());
                    ObjXname.setFont(new Font("",16));
                    // Label spacing = new Label("-------");
                    body.getChildren().addAll(ObjXname);

                    for (fields y : lambada.get(finalP).getObjectXES().get(i).getFieldSplit()) { //for fields
                        Label field = new Label(" ♣ " + y.getFieldNames() + " " + y.getAllowedValue() + " " + y.getMandatory() + " ");
                        body.getChildren().addAll(field);
                    }
                    for (String y : lambada.get(finalP).getObjectXES().get(i).getObjInh()) { //for ObjInh
                        Label objInh = new Label(" ♣ " + y);
                        body.getChildren().add(objInh);
                    }
                    Label spaceLines = new Label("================================");
                    body.getChildren().add(spaceLines);
                }


                Scene scene1 = new Scene(layout1,400,600,Color.web("#ECF0F1"));
                frstAPI.setScene(scene1);
                frstAPI.show();
            });
            layout.getChildren().add(API);
            layout.setPadding(new Insets(15,15,15,15));
        }

        Scene scene = new Scene(layout);
        scene.setFill(new RadialGradient(
                0, 0, 0, 0, 1, true,                  //sizing
                CycleMethod.NO_CYCLE,                 //cycling
                new Stop(0, Color.web("#ECF0F1")),    //colors
                new Stop(1, Color.web("#95A5A6")))
        );
        stage.setScene(scene);
        stage.show();


    }



    public static void main(String[] args) throws IOException {
        launch();
    }
}