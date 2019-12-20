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

        int sudokuSize = (windowSize*2/3);

        strokeWeight(3);
        rect((int)(windowSize/6), (int)(windowSize/40), sudokuSize, sudokuSize);

        for (int i = 1; i < 9; i++) {

            strokeWeight(1);

            //horizontal
            line(   (int) ((sudokuSize/9)*i + windowSize/6),
                    (int)(windowSize/40),
                    (int) ((sudokuSize/9)*i + windowSize/6),
                    (int)(windowSize/40)+sudokuSize);

            //vertikal
            line(   (int)(windowSize/6),
                    (int) ((sudokuSize/9)*i + windowSize/40),
                    (int)(windowSize/6 + sudokuSize),
                    (int) ((sudokuSize/9)*i + windowSize/40));

        }

        for (int i = 1; i < 3; i++) {

            strokeWeight(3);

            //horizontal
            line(   (int) ((sudokuSize/3)*i + windowSize/6),
                    (int)(windowSize/40),
                    (int) ((sudokuSize/3)*i + windowSize/6),
                    (int)(windowSize/40)+sudokuSize);

            //vertikal
            line(   (int)(windowSize/6),
                    (int) ((sudokuSize/3)*i + windowSize/40),
                    (int)(windowSize/6 + sudokuSize),
                    (int) ((sudokuSize/3)*i + windowSize/40));
        }
    }
}
