package graphics;

import app.CarsApplication;
import jade.core.AID;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import wsd.Agent2;
import wsd.Sign;
import wsd.Emergency;

import java.util.ArrayList;

public class GUIApp extends Application {
    private static Group rootView = new Group();

    private static ArrayList<VehicleSymbol> vehicleSymbols = new ArrayList<>();
    private static VehicleSymbol findSymbolBy(AID aid) {
        return vehicleSymbols.stream().filter(vs -> vs.getAid().equals(aid)).findFirst().orElse(null);
    }

    public static void onSetup(AID aid, Long x) {
        VehicleSymbol symbol = new VehicleSymbol(aid, x);
        vehicleSymbols.add(symbol);
        Platform.runLater(() -> {
            rootView.getChildren().add(symbol.getLine());
            symbol.getLine().toFront();
        });
    }

    public static void onUpdateParameters(AID aid, Long x, Long y) {
        VehicleSymbol symbol = findSymbolBy(aid);
        if (symbol != null) {
            Platform.runLater(() -> symbol.translate(x, y));
        }
    }

    public static void onDelete(AID aid) {
        VehicleSymbol symbol = findSymbolBy(aid);
        if (symbol != null) {
            Platform.runLater(() -> rootView.getChildren().remove(symbol.getLine()));
        }
    }

    //nowe
    private static ArrayList<SignSymbol> signSymbols = new ArrayList<>();

    private static SignSymbol findSymbolBySign(AID aid) {
        return signSymbols.stream().filter(vs -> vs.getAid().equals(aid)).findFirst().orElse(null);
    }

    public static void onSetupSign(AID aid, Long y, Long y2, Long limit_max_speed) {
        SignSymbol symbol = new SignSymbol(aid, y, y2, limit_max_speed);
        signSymbols.add(symbol);
        Platform.runLater(() -> {
            rootView.getChildren().add(symbol.getLine());
            symbol.getLine().toFront();
            rootView.getChildren().add(symbol.getLine2());
            symbol.getLine2().toFront();
            rootView.getChildren().add(symbol.getText());
            symbol.getText().toFront();
            rootView.getChildren().add(symbol.getText2());
            symbol.getText2().toFront();
        });
    }

//    public static void onUpdateParametersSign(AID aid, Long x, Long y) {
//        SignSymbol symbol = findSymbolBySign(aid);
//        if (symbol != null) {
//            Platform.runLater(() -> symbol.translate(x, y));
//        }
//    }

    public static void onDeleteSign(AID aid) {
        SignSymbol symbol = findSymbolBySign(aid);
        if (symbol != null) {
            Platform.runLater(() -> rootView.getChildren().remove(symbol.getLine()));
        }
    }
    //


    // nowe MM

    private static ArrayList<EmergencySymbol> emergencySymbols = new ArrayList<>();

    private static EmergencySymbol findSymbolByEmergency(AID aid) {
        return emergencySymbols.stream().filter(vs -> vs.getAid().equals(aid)).findFirst().orElse(null);
        }

    public static void onSetupEmergency(AID aid, Long x) {
        EmergencySymbol symbol = new EmergencySymbol(aid, x);
        emergencySymbols.add(symbol);
        Platform.runLater(() -> {
            rootView.getChildren().add(symbol.getLine());
            symbol.getLine().toFront();
        });
    }

    public static void onUpdateParametersEmergency(AID aid, Long x, Long y) {
        EmergencySymbol symbol = findSymbolByEmergency(aid);
        if (symbol != null) {
            Platform.runLater(() -> symbol.translate(x, y));
        }
    }

    public static void onDeleteEmergency(AID aid) {
        EmergencySymbol symbol = findSymbolByEmergency(aid);
        if (symbol != null) {
            Platform.runLater(() -> rootView.getChildren().remove(symbol.getLine()));
        }
    }


    // koniec noweMM

    static final Long ROAD_START_Y = 550L;
    static final Long ROAD_END_Y = 50L;
    static final double LANE_LEFT_X = 50.0;
    static final double LANE_RIGHT_X = 160.0;
    static final double ROAD_WIDTH = 210.0;
    static final double MIDDLE_LINE_WIDTH = 10.0;

    static final double LANE_SIGN_X = LANE_LEFT_X+ROAD_WIDTH;
    static final double SIGN_LINE_WIDTH =ROAD_WIDTH/8;



    private void drawRoad() {
        Rectangle roadRect = new Rectangle();
        roadRect.setX(LANE_LEFT_X);
        roadRect.setY(ROAD_END_Y);
        roadRect.setHeight(ROAD_START_Y - ROAD_END_Y);
        roadRect.setWidth(ROAD_WIDTH);
        roadRect.setFill(Color.BLACK);
        roadRect.setArcWidth(2.0);
        roadRect.setArcHeight(2.0);
        roadRect.toBack();
        rootView.getChildren().add(roadRect);
    }

    private void drawMiddleLine() {
        Rectangle lineRect = new Rectangle();
        lineRect.setX(LANE_RIGHT_X - MIDDLE_LINE_WIDTH);
        lineRect.setY(ROAD_END_Y);
        lineRect.setHeight(ROAD_START_Y - ROAD_END_Y);
        lineRect.setWidth(MIDDLE_LINE_WIDTH);
        lineRect.setFill(Color.WHITE);
        lineRect.toFront();
        rootView.getChildren().add(lineRect);
    }

    private void drawSignLine() {
        Rectangle roadRect = new Rectangle();
        roadRect.setX(LANE_SIGN_X);
        roadRect.setY(ROAD_END_Y);
        roadRect.setHeight(ROAD_START_Y - ROAD_END_Y);
        roadRect.setWidth(SIGN_LINE_WIDTH);
        roadRect.setFill(Color.WHITE);
        roadRect.setArcWidth(2.0);
        roadRect.setArcHeight(2.0);
        roadRect.toBack();
        rootView.getChildren().add(roadRect);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //
        //System.out.print("test");
        //

        Scene scene = new Scene(rootView,900, 600);

        VBox newVehicleBox = new VBox(10);
        newVehicleBox.setLayoutX(300);
        newVehicleBox.setLayoutY(50);

        TextField newVehicleNameField = new TextField();
        newVehicleNameField.setPromptText("Name");
        newVehicleNameField.setFocusTraversable(false);

        TextField newVehicleSpeedField = new TextField();
        newVehicleSpeedField.setPromptText("Speed");
        newVehicleSpeedField.setFocusTraversable(false);

        TextField newVehicleMaxSpeedField = new TextField();
        newVehicleMaxSpeedField.setPromptText("MaxSpeed");
        newVehicleMaxSpeedField.setFocusTraversable(false);

        Button btnAddVehicle = new Button("New vehicle");



        btnAddVehicle.setOnMouseClicked(event -> {
            String speedStr = newVehicleSpeedField.getText();
            String name = newVehicleNameField.getText();
            String maxSpeed = newVehicleMaxSpeedField.getText();
            if (speedStr != null && !speedStr.isEmpty() && speedStr.matches("[0-9]+")
                    && name != null && !name.isEmpty()) {
                String[] args = {"speed:" + speedStr, "maxSpeed:"+maxSpeed};
                CarsApplication.createAgent(name, Agent2.class.getName(), args);
                //CarsApplication.createAgent("qwerty", Sign.class.getName(), args9);

            }
        });

        newVehicleBox.getChildren().addAll(newVehicleNameField, newVehicleSpeedField, newVehicleMaxSpeedField,  btnAddVehicle);

        rootView.getChildren().add(newVehicleBox);

        //nowe
        VBox newSignBox = new VBox(10);
        newSignBox.setLayoutX(500);
        newSignBox.setLayoutY(50);

        TextField newSignNameField = new TextField();
        newSignNameField.setPromptText("Name");
        newSignNameField.setFocusTraversable(false);

        TextField newSignYBeginField = new TextField();
        newSignYBeginField.setPromptText("Y Begin");
        newSignYBeginField.setFocusTraversable(false);

        TextField newSignYEndField = new TextField();
        newSignYEndField.setPromptText("Y End");
        newSignYEndField.setFocusTraversable(false);

        TextField newSignLimitMaxSpeedField = new TextField();
        newSignLimitMaxSpeedField.setPromptText("LimitMaxSpeed");
        newSignLimitMaxSpeedField.setFocusTraversable(false);

        Button btnAddSign = new Button("New Sign");
        btnAddSign.setOnMouseClicked(event2 -> {
            String name_sign = newSignNameField.getText();
            String Y_begin_str = newSignYBeginField.getText();
            String Y_end_str = newSignYEndField.getText();
            String limitMaxSpeed_str = newSignLimitMaxSpeedField.getText();

            if (Y_begin_str != null && !Y_begin_str.isEmpty() && Y_begin_str.matches("[0-9]+")
                    && Y_end_str != null && !Y_end_str.isEmpty() && Y_end_str.matches("[0-9]+")
                    && limitMaxSpeed_str != null && !limitMaxSpeed_str.isEmpty() && limitMaxSpeed_str.matches("[0-9]+")
                    && name_sign != null && !name_sign.isEmpty()) {

                String[] args = {"y_begin:" + Y_begin_str, "y_end:" + Y_end_str, "maxSpeed:" + limitMaxSpeed_str};
                CarsApplication.createAgent(name_sign, Sign.class.getName(), args);
            }
        });
        newSignBox.getChildren().addAll(newSignNameField, newSignYBeginField, newSignYEndField,newSignLimitMaxSpeedField ,  btnAddSign);
        rootView.getChildren().add(newSignBox);
        //

        //nowe MM

        VBox newEmergencyBox = new VBox(10);
        newEmergencyBox.setLayoutX(700);
        newEmergencyBox.setLayoutY(50);

        TextField newEmergencyNameField = new TextField();
        newEmergencyNameField.setPromptText("Name");
        newEmergencyNameField.setFocusTraversable(false);

        TextField newEmergencySpeedField = new TextField();
        newEmergencySpeedField.setPromptText("Speed");
        newEmergencySpeedField.setFocusTraversable(false);

        TextField newEmergencyMaxSpeedField = new TextField();
        newEmergencyMaxSpeedField.setPromptText("MaxSpeed");
        newEmergencyMaxSpeedField.setFocusTraversable(false);

        Button btnAddEmergency = new Button("New Emergency Vehicle");

        btnAddEmergency.setOnMouseClicked(event3 -> {
            String speedStr = newEmergencySpeedField.getText();
            String name = newEmergencyNameField.getText();
            String maxSpeed = newEmergencyMaxSpeedField.getText();
            if (speedStr != null && !speedStr.isEmpty() && speedStr.matches("[0-9]+")
                    && name != null && !name.isEmpty()) {
                String[] args = {"speed:" + speedStr, "maxSpeed:"+maxSpeed};
                CarsApplication.createAgent(name, Emergency.class.getName(), args);
                //CarsApplication.createAgent("qwerty", Sign.class.getName(), args9);

            }
        });

        newEmergencyBox.getChildren().addAll(newEmergencyNameField, newEmergencySpeedField, newEmergencyMaxSpeedField,  btnAddEmergency);

        rootView.getChildren().add(newEmergencyBox);

        //koniec nowe MM

        scene.setFill(Color.LIGHTGREY);
        drawRoad();
        drawMiddleLine();
        drawSignLine();

        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();



    }

    public static void main(String[] args) {
        launch(args);

    }
}
