import java.util.HashMap;

public class Hashmatique {
    //STATIC HAS GOTTA GO WHEN DEFINING THE HASHMAP OR ELSE JAVA ISNT GONNA KNOW WHAT YOURE TALKING ABOUT. STATIC WILL ACT LIKE AN UMBRELLA OVER THE METHOD AND THE MAIN
    static HashMap<String, String> trackList = new HashMap<>();


    public static void getTrack(){
        for (String key : trackList.keySet()){ //.keySet returns a set view of the keys contained in this map. so it basically makes the keys callable?
            System.out.println(key + " | Lyrics : " + trackList.get(key));
        }
    }

    public static void main(String[]args) {

        trackList.put("Mermaider", "Mermaider, mermaider, mermaider");
        trackList.put("Into the Water", "Go into the water, live there, die there");
        trackList.put("Birthday Dethday" , "Many years ago, something grew inside of your mother. That thing was you!");
        trackList.put("Detharmonic" , "I want to keep my money.");
        //PUT BASICALLY ASSIGNS VALUE TO THE KEY

        getTrack();
    }
}