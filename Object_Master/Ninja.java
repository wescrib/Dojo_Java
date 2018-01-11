public class Ninja extends Human{
    public Ninja() {
        setStealth(10);
    }

    public void stoleFrom(Human human){
        int humanHealth = human.getHealth();
        setHealth(getHealth() + getStealth());
        human.setHealth(human.getHealth() - this.getStealth());

    }

    public void runaway() {
        setHealth(getHealth()-10);
    }
}