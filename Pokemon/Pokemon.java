import java.util.ArrayList;

public class Pokemon {
    private String name;
    private int health;
    private String type;
    private static int counter=0;
    private ArrayList<Pokemon> pokemen = new ArrayList<Pokemon>();
    
    // public Pokemon() {
    //     counter++;
    // }

    public Pokemon(String name, int health, String type) {
        this.name = name;
        this.health = health;
        this.type = type;
        counter++;
    }
    @Deprecated
    public static String pokeCounter() {
        return "There are " + counter + " pokemon in the wild";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }



}