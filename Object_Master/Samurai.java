public class Samurai extends Human{

    private static int counter = 0;

    public Samurai() {
        setHealth(200);
        counter++;

    }

    public static int samuraiCount() {
        return counter;
    }

    public void deathBlow(Human human){
        human.setHealth(human.getHealth() - human.getHealth());
        setHealth(getHealth()/2);

    }

    public void meditate() {
        setHealth(getHealth()*2);
    }

}