import processing.core.PApplet;

public class Main extends PApplet {

    private int windowSize = 800;

    public static void main(String[] args) {
        PApplet.main("Main", args);
    }

    public void settings() {
        size(windowSize, windowSize);
    }

    public void setup() {
        frameRate(60);
    }

    public void draw() {
        drawSudoku();
    }

    private void drawSudoku() {
        rect((int)(windowSize/6), (int)(windowSize/40), (int)(windowSize*2/3), (int)(windowSize*2/3));
    }
}
