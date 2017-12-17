package graphics;

import app.CarsApplication;
import jade.core.AID;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.*;

public class SignSymbol {
    private Long y;
    private Long y2;
    private AID aid;
    private Line line;
    private Line line2;
    private static final double SYMBOL_LENGTH = GUIApp.SIGN_LINE_WIDTH;
    private Text text,text2;

    public SignSymbol(AID aid, Long y, Long y2, Long limit_max_speed) {
        this.y=y;
        this.y2=y2;
        this.aid = aid;
        line = new Line();
        line2 = new Line();
        text =new Text();
        text2 =new Text();


        Color color = SymbolColor.random().value();

        double newY = GUIApp.ROAD_START_Y - (GUIApp.ROAD_START_Y - GUIApp.ROAD_END_Y) * y / CarsApplication.MAX_Y;
        line.setStartY(newY);
        line.setEndY(newY);
        line.setStartX(GUIApp.LANE_SIGN_X);
        line.setEndX(GUIApp.LANE_SIGN_X+SYMBOL_LENGTH);
        line.setStroke(color);
        line.setStrokeWidth(1.0);
        line.toFront();

        text.setText(limit_max_speed.toString());
        text.setX(GUIApp.LANE_SIGN_X+SYMBOL_LENGTH);
        text.setY(newY);
        text.setFill(Color.RED);
        text.setStroke(Color.RED);

        double newY2 = GUIApp.ROAD_START_Y - (GUIApp.ROAD_START_Y - GUIApp.ROAD_END_Y) * y2 / CarsApplication.MAX_Y;
        line2.setStartY(newY2);
        line2.setEndY(newY2);
        line2.setStartX(GUIApp.LANE_SIGN_X);
        line2.setEndX(GUIApp.LANE_SIGN_X+SYMBOL_LENGTH);
        line2.setStroke(color);
        line2.setStrokeWidth(1.0);
        line2.toFront();

        text2.setText(limit_max_speed.toString());
        text2.setX(GUIApp.LANE_SIGN_X+SYMBOL_LENGTH);
        text2.setY(newY2);
        text2.setFill(Color.BLACK);
        text2.setStroke(Color.BLACK);
    }

    public Line getLine() {
        return line;
    }

    public Line getLine2() {
        return line2;
    }

    public Text getText() {
        return text;
    }
    public Text getText2() {
        return text2;
    }
    public AID getAid() {
        return aid;
    }

//    public void translate(Long x, Long y) {
//        double newY = GUIApp.ROAD_START_Y - (GUIApp.ROAD_START_Y - GUIApp.ROAD_END_Y) * y / CarsApplication.MAX_Y;
//        line.setStartY(newY);
//        line.setEndY(newY);
//        if (!x.equals(this.x)) {
//            if (x == 1) {
//                moveToRightLane();
//            } else if (x == 2) {
//                moveToLeftLane();
//            }
//            this.x = x;
//        }
//
//        line.toFront();
//    }

}
