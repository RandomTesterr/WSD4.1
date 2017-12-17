package graphics;

import javafx.scene.paint.Color;

import java.util.Random;

public enum SymbolColor {
    RED(Color.RED), BLUE(Color.BLUE), GREEN(Color.GREEN), YELLOW(Color.YELLOW), PURPLE(Color.PURPLE), PINK(Color.PINK), ORANGE(Color.ORANGE), WHITE(Color.WHITE), GRAY(Color.GRAY), BROWN(Color.BROWN), CYAN(Color.CYAN);

    private Color color;

    SymbolColor(Color color) {
        this.color = color;
    }

    public Color value() {
        return color;
    }

    public static SymbolColor random() {
        return SymbolColor.values()[new Random().nextInt(SymbolColor.values().length)];
    }
}
