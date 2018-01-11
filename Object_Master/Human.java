public class Human {
    private int strength = 3;
    private int stealth = 3;
    private int intelligence = 3;
    private int health = 100;
    
    public Human (){

    }

    public void setStrength(int strength){
        this.strength = strength;
    }
    public int getStrength(){
        return strength;
    }

    public void setStealth(int stealth) {
        this.stealth = stealth;
    }

    public int getStealth(){
        return stealth;
    }

    public void setIntel(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getIntel(){
        return intelligence;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void attackedBy(Object Human){
        setHealth(getHealth()-getStrength());
    }


}