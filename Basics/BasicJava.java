import java.util.ArrayList;
import java.util.Arrays;

public class BasicJava {
    public static void main(String [] args) {
        ArrayList<Integer> two55Arr = new ArrayList<Integer>();
        for(int i=1; i <=255; i++) {
            two55Arr.add(i);
        }
        System.out.println("PRINT 1 TO 255");
        System.out.println(two55Arr);

        ArrayList<Integer> odds = new ArrayList<Integer>();
        for(int i=1; i<=255; i++) {
            if(i%2 == 0){
                odds.add(i);
            }
        }

        System.out.println("PRINT ALL NUMBERS BETWEEN 1 AND 255 THAT ARE DIVISIBLE BY 2");
        System.out.println("2)" + odds);
        
        System.out.println("PRINT SUM OF ALL NUMBERS BETWIXT 1 AND 255");
        int sum = 0;
        for(int i=0; i<=255; i++){
            sum = sum + i;
            System.out.println("New number:" + i + " Sum: " + sum);
        }

        int[]maxArr = {23,11,45,76,42,55};
        int max = maxArr[0];
        for(int i=0; i < maxArr.length; i++){
            if (max < maxArr[i]) {
                max = maxArr[i];
            }
        }

        int avg = max / maxArr.length;
        System.out.println("MAX AND AVERAGE OF ARRAY");
        System.out.println("MAX: " + max + " AVG: " + avg);

        int Y = 30;
        int counter = 0;
        for(int i=0; i < maxArr.length; i++){
            if(maxArr[i]>Y){
                counter++;
            }
        }
        System.out.println("ITEMS GREATER THAN THE VALUE OF Y");
        System.out.println(counter);

        for(int i=0; i < maxArr.length; i++) {
            maxArr[i] = maxArr[i]*maxArr[i];
            // System.out.println(maxArr[i]);
        }
        System.out.println("SQUARE THE ARRAY");
        System.out.println(Arrays.toString(maxArr));

        int[] negArr = {-23,11,-2,0,42,-45};
        for(int i=0; i < maxArr.length; i++) {
            if(negArr[i] < 0){
                negArr[i] = 0;
            }
        }
        System.out.println("TURN NEGATIVES TO 0s");
        System.out.println(Arrays.toString(negArr));

        int[] Arr = {1,5,10,-2};
        max = Arr[0];
        int min = Arr[0];
        sum = 0;
        avg = sum/Arr.length;
        for(int i=0; i < Arr.length; i++) {
            if (max < Arr[i]) {
                max = Arr[i];
            }
            if (min > Arr[i]) {
                min = Arr[i];
            }
            sum = sum + i;
        }
        
        int[] meanArr = {min,max,avg};
        System.out.println("MIN, MAX, AVG");
        System.out.println(Arrays.toString(meanArr));
        System.out.println("SHIFT THE ELEMENTS DOWN");
        System.out.println(Arrays.toString(Arr));

        for(int i=0; i < Arr.length-1; i++) {
            Arr[i] = Arr[i+1];
        }
        Arr[Arr.length -1] = 0;
        System.out.println(Arrays.toString(Arr));
    }

}