package com.dfteam.todo.util;

import com.dfteam.apisdk.SDK;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

/**
 * Class that creates, shows and closes all windows
 */
public class StageManager {

    private static Stage loginStage;
    private static Stage todoStage;
    private static Stage taskInfoStage;
    private static Stage createTaskStage;

    public static void LoginStage() throws IOException {
        loginStage = new Stage();
        // set the look of window
        Parent root = FXMLLoader.load(Objects.requireNonNull(StageManager.class.getClassLoader().getResource("login.fxml")));
        loginStage.setTitle("DFteam - Login");
        loginStage.getIcons().add(new Image("/images/DF.png"));
        loginStage.setScene(new Scene(root)); // apply settings to the scene
        loginStage.show();
    }

    public static void TODOStage(Stage primaryStage) throws Exception {
        todoStage = primaryStage;
        Parent root = FXMLLoader.load(Objects.requireNonNull(StageManager.class.getClassLoader().getResource("todo.fxml")));
        primaryStage.setTitle("TODO List");
        primaryStage.getIcons().add(new Image("/images/DF.png"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setOnCloseRequest(event -> Platform.exit());
        if ( SDK.CheckToken() ) {
            primaryStage.show();
        } else {
            hideTODO();
        }
    }

    public static void TaskInfoStage() throws IOException {
        taskInfoStage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(StageManager.class.getClassLoader().getResource("taskInfo.fxml")));
        taskInfoStage.setTitle("Task");
        taskInfoStage.getIcons().add(new Image("/images/DF.png"));
        taskInfoStage.setScene(new Scene(root));
        taskInfoStage.show();
    }

    public static void CreateTaskStage() throws IOException {
        taskInfoStage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(StageManager.class.getClassLoader().getResource("createTask.fxml")));
        taskInfoStage.setTitle("Create Task");
        taskInfoStage.getIcons().add(new Image("/images/DF.png"));
        taskInfoStage.setScene(new Scene(root));
        taskInfoStage.show();
    }

    private static void closeWindow(Stage stage){
        if (stage!=null) {
            if(stage.isShowing()){
                stage.hide();
            }
        }
    }

    public static void closeAllWindows(){
        hideTODO();
        hideTaskInfo();
        hideCreateTask();
    }

    public static void hideLogin(){
        closeWindow(loginStage);
    }

    public static void hideTaskInfo(){
        closeWindow(taskInfoStage);
    }

    public static void hideTODO(){
        closeWindow(todoStage);
    }

    public static void hideCreateTask(){
        closeWindow(createTaskStage);
    }

}