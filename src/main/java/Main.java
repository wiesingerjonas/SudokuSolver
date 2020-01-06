import processing.core.PApplet;

public class Main extends PApplet {

    private int windowSize = 600;
    private int sudokuSize = (windowSize*2/3);

    private int occupiedNumber = -1;
    private Field[] fields;
    boolean done = false;

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

        while (!done){

            fields = createFields();

            done = true;
        }

        //zeichnet Sudoku
        drawSudoku();

        //gibt Koordinaten des ausgewählten Feldes aus
        if(mousePressed){
            getCoordinates();
        }

        //zeichnet Nummernfeld
        drawNumbers();
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

    private void getCoordinates() {

        char[] letterRow = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};

        if(     mouseX >= (int)(windowSize/6) &&
                mouseX <= (int)(windowSize/6) + sudokuSize &&
                mouseY >= (int)(windowSize/40) &&
                mouseY <= (int)(windowSize/40) + sudokuSize) {

            for (int i = 0; i < 9; i++) {
                if(     mouseX >= (sudokuSize/9)*i + windowSize/6 &&
                        mouseX <= (sudokuSize/9)*(i+1) + windowSize/6){

                    System.out.print(letterRow[i]);;
                }

                if(     mouseY >= (sudokuSize/9)*i + windowSize/40 &&
                        mouseY <= (sudokuSize/9)*(i+1) + windowSize/40){

                    System.out.println(" " + (i+1));;
                }
            }

        }
    }

    private void drawNumbers() {

        int marginTop = sudokuSize/18;

        textSize((int)(sudokuSize/12));

        for (int i = 0; i < 9; i++) {

            if(mouseX > (int)((windowSize/6) + (sudokuSize/9)*i) &&
                    mouseX < (int)((windowSize/6) + (sudokuSize/9)*i + (sudokuSize/9)) &&
                    mouseY > (int)(windowSize/40) + sudokuSize + marginTop &&
                    mouseY < (int)(windowSize/40) + sudokuSize + marginTop + sudokuSize/9){

                hoverNumbers(i);
            }

            rect((int)((windowSize/6) + (sudokuSize/9)*i),
                    (int)(windowSize/40) + sudokuSize + marginTop,
                    (int)(sudokuSize/9)+4,
                    (int)(sudokuSize/9));

            fill(0);


            text(i+1,
                    (int)((windowSize/6 + (sudokuSize/9)*i) + (sudokuSize/9)/3),
                    (int)(windowSize/40 + sudokuSize + marginTop + sudokuSize/11));
            fill(250);
        }

    }

    private void hoverNumbers(int index){
        fill(225);

        if (mousePressed){
            fill(215);

            occupiedNumber = index+1;
        }
    }

    private Field[] createFields() {
        char[] letterRow = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};

        Field[] fields = new Field[81];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                fields[i*9+j] = new Field(letterRow[j] + Integer.toString(((int)((i*9+j)/9) + 1)));
                System.out.println(letterRow[j] + Integer.toString(((int)((i*9+j)/9) + 1)));
            }
        }

        return fields;
    }
}
