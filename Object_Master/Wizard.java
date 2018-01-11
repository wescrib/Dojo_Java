public class Wizard extends Human{
    public Wizard() {
        setHealth(50);
    }

    public void fireball(Human human){
        human.setHealth(human.getHealth() - this.getIntel()*3);

    }

    public void heal(Human human) {
        human.setHealth(human.getHealth() + getIntel());
    }
}