import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        String name = "William,daBoss,Scribner";

        String [] names = name.split(",");

        for(int i=0; i < names.length; i++){
            System.out.println(names[i]);
        }
        System.out.println(Arrays.toString(names));
    }
}