import java.awt.*;

public class MergeSort{

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Error: the argument must be exactly one");
            System.exit(1);
        }

        int n = Integer.parseInt(args[0]);

        Element[] elements = new Element[n];
        int minValue = Integer.MAX_VALUE;


        for (int i = 0; i < n; i++) {
            elements[i] = new Element((int) ((Math.random() * n) + 1));
            minValue = Math.min(minValue, elements[i].getValue());

            int hz = 440 * (int) (Math.pow(2, (elements[i].getValue() - minValue / 12.0)));
            elements[i].setSound(hz);
        }

        StdDraw.setCanvasSize(800, 600);
        StdDraw.setXscale(0, n);
        StdDraw.setYscale(0, 1.2);

        mergeSort(elements, 0, n-1, n);

    }

    private static void mergeSort(Element[] elements, int low, int high, int n){
        if (low >= high){
            drawAndPlaySound(elements, low, high, n);
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(elements, low, mid, n);
        mergeSort(elements, mid + 1, high, n);
        merge(elements, low, mid, high);
        drawAndPlaySound(elements, low, high, n);
    }

    private static void merge(Element[] mergedArrays, int low, int mid, int high) {
        Element[] temp = new Element[high-low + 1];
        int i = low;
        int j = mid+1;
        int k = 0;

        while (i <= mid && j <= high) {
            if (mergedArrays[i].getValue() <= mergedArrays[j].getValue()) {
                temp[k++] = mergedArrays[i++];
            } else {
                temp[k++] = mergedArrays[j++];
            }
        }


        while (i <= mid) {
            temp[k++] = mergedArrays[i++];
        }

        while (j <= high) {
            temp[k++] = mergedArrays[j++];
        }

        for (int z = 0; z < temp.length; z++){
            mergedArrays[low+z] = temp[z];
        }

    }

    private static void drawAndPlaySound(Element[] elements, int low, int high, int n){
        StdDraw.clear();

        for (int i = 0; i < elements.length; i++){

            if (i >= low  && i <= high){
                elements[i].draw2(i, 0.6, n, Color.yellow);
            }else{
                elements[i].draw2(i, 0.6, n, Color.BLACK);
            }
            StdAudio.play(elements[i].getSound());
        }
    }
}