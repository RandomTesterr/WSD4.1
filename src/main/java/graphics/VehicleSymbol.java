package graphics;

import app.CarsApplication;
import jade.core.AID;
import javafx.scene.shape.Line;

public class VehicleSymbol {
    private Long x;
    private AID aid;
    private Line line;

    private static final double SYMBOL_LENGTH = 100.0;

    public VehicleSymbol(AID aid, Long x) {
        this.aid = aid;
        this.x = x;
        line = new Line();
        if (x == 1) {
            moveToRightLane();
        } else if (x == 2) {
            moveToLeftLane();
        }
        line.setStartY(GUIApp.ROAD_START_Y);
        line.setEndY(GUIApp.ROAD_START_Y);
        line.setStroke(SymbolColor.random().value());
        line.setStrokeWidth(1.0);
        line.toFront();
    }

    public Line getLine() {
        return line;
    }

    public AID getAid() {
        return aid;
    }

    public void translate(Long x, Long y) {
        double newY = GUIApp.ROAD_START_Y - (GUIApp.ROAD_START_Y - GUIApp.ROAD_END_Y) * y / CarsApplication.MAX_Y;
        line.setStartY(newY);
        line.setEndY(newY);
        if (!x.equals(this.x)) {
            if (x == 1) {
                moveToRightLane();
            } else if (x == 2) {
                moveToLeftLane();
            }
            this.x = x;
        }

        line.toFront();
    }

    private void moveToLeftLane() {
        line.setStartX(GUIApp.LANE_LEFT_X);
        line.setEndX(GUIApp.LANE_LEFT_X + SYMBOL_LENGTH);
    }

    private void moveToRightLane() {
        line.setStartX(GUIApp.LANE_RIGHT_X);
        line.setEndX(GUIApp.LANE_RIGHT_X + SYMBOL_LENGTH);
    }
}
