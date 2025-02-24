import java.awt.*;

public class Element {
    public int value;
    public double[] sound;

    private static final int SAMPLING_RATE = 441000;
    private static final int NUM_SAMPLES = 4410;


    public Element(int value){
        this.value = value;
        this.sound = new double[NUM_SAMPLES];
    }

    public int getValue(){
        return this.value;
    }

    public double[] getSound(){
        return this.sound;
    }

    public int compareTo(Element other){
        if (this.value < other.value) return -1;
        if (this.value > other.value) return 1;
        return 0;
    }

    public void setSound(int hz){
        for (int i = 0; i < NUM_SAMPLES; i++){
            double time = i / (double) SAMPLING_RATE;
            sound[i] = Math.sin(2 * Math.PI * hz * time);
        }
    }

    public void draw(int position, double yPosition, int n) {

        double radius = 0.3 + 0.1 * (value / (double) n);
        double xPosition = position + 0.5;

        StdDraw.setPenColor((int) (255 * (value / (double) n)), 0, (int) (255 * (1 - value / (double) n)));

        StdDraw.filledCircle(xPosition, yPosition, radius);

    }

    public void draw2(int position, double yPosition, int n, Color color) {

        double radius = 0.3 + 0.1 * (value / (double) n);
        double xPosition = position + 0.5;

        StdDraw.setPenColor(color);
        StdDraw.filledCircle(xPosition, yPosition, radius);

    }

}
