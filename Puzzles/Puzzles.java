import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Collections;


public class Puzzles {
    public static void main(String [] args) {

        int[] Arr = {3,5,1,2,7,9,8,13,25,32};
        int sum = 0;
        for(int i=0; i <Arr.length;i++){
            sum = sum + Arr[i];
        }
        System.out.println("The sum of " + (Arrays.toString(Arr) + " is " + sum));
        ArrayList<Integer> newArr = new ArrayList<Integer>();
        for(int i=0; i <Arr.length;i++) {
            if(Arr[i] > 10) {
                newArr.add(Arr[i]);
            }
        }

        System.out.println("The numbers in the array greater than 10 are " + (Arrays.toString(newArr.toArray())));
        
        String[] names = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        ArrayList<String> newNames = new ArrayList<String>();

        Collections.shuffle(Arrays.asList(names));
        System.out.println("Names array shuffled are as follows: " + Arrays.toString(names));
        String temp;
        for(int i=0; i <names.length;i++){
            if(names[i].length() > 5){
                newNames.add(names[i]);
            }
        }
        System.out.println("Names with lengths greather than 5 are: " + (Arrays.toString(newNames.toArray())));
        Random random = new Random();
        String[] alphabet = {"a", "b", "c", "d", "e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        Collections.shuffle(Arrays.asList(alphabet));
        String firstLetter = alphabet[0];
        String lastLetter = alphabet[alphabet.length-1];
        if(alphabet[0] == "a" || alphabet[0] == "i" || alphabet[0] == "e" || alphabet[0] == "o" || alphabet[0] == "u"){
            System.out.println("The first letter is a vowel!! | " + alphabet[0]);
        }
        System.out.print(alphabet[0]);

        System.out.println("Last letter: " + alphabet[alphabet.length-1]);

        ArrayList<Integer> randomNum = new ArrayList<Integer>();
        for(int i=0; i <= 10; i++) {
            randomNum.add(random.nextInt(46) + 55);
        }

        // randomNum.toArray();
        int max = randomNum.get(0);
        int min = randomNum.get(0);
        for(int i=0; i<randomNum.size(); i++){
            if(max < randomNum.get(i)){
                max = randomNum.get(i);
            }
            if(min > randomNum.get(i)){
                min = randomNum.get(i);
            }
        }
        System.out.println("Random Numbers: " + (Arrays.toString(randomNum.toArray())));
        Collections.sort(randomNum);
        System.out.println("Sorted Random Numbers: " + (Arrays.toString(randomNum.toArray())));
        System.out.println(max + " " + min);

        String randString = "";
        for(int i=0; i < 6; i++) {
            System.out.println(alphabet[i]);
            randString += alphabet[i];
        }

        System.out.println(randString);
        ArrayList<String> newStrings = new ArrayList<String>();

        while(newStrings.size() < 5){
            String testString = "";
            for(int i=0; i<5; i++){
                testString += alphabet[i];
            }

            newStrings.add(testString);

        }
        System.out.println("Test String array " + (Arrays.toString(newStrings.toArray())));

    }

}