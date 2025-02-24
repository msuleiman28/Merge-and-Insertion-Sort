public class InsertionSort {

    public static void main(String[] args){
        if (args.length != 1){
            System.err.println("Error: the argument must be exactly one");
            System.exit(1);
        }

        int n = Integer.parseInt(args[0]);


        Element[] elements = new Element[n];
        int minValue = Integer.MAX_VALUE;


        for (int i = 0; i < n; i++){
            elements[i] = new Element((int) (Math.random() * n) + 1);
            minValue = Math.min(minValue, elements[i].getValue());

            int hz = 440 * (int) (Math.pow(2, (elements[i].getValue() - minValue / 12.0)));
            elements[i].setSound(hz);
        }

        StdDraw.setCanvasSize(800, 600);
        StdDraw.setXscale(0, n);
        StdDraw.setYscale(0, 1.2);

        for (int i = 1; i < n; i++){
            Element key = elements[i];
            int j = i-1;

            while (j>= 0 && elements[j].getValue() > key.getValue()){
                elements[j+1] = elements[j];
                elements[j].draw(j + 1, 0.5, n);
                StdAudio.play(elements[j].getSound());
                StdDraw.clear();
                drawAllElements(elements, n);
                StdDraw.show();
                StdDraw.pause(30);
                j--;
            }

            elements[j+1] = key;
            elements[j+1].draw(j + 1, 0.5, n);
            StdAudio.play(elements[j+1].getSound());
            StdDraw.clear();
            drawAllElements(elements, n);
            StdDraw.show();
            StdDraw.pause(30);


        }


    }

    private static void drawAllElements(Element[] elements, int n){
        for (int i = 0; i < elements.length; i++){
            elements[i].draw(i, 0.6, n);
        }
    }


}
