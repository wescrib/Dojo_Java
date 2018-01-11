public class Gorilla extends Mammal {

    public void throw_something(){
        this.setEnergy(this.getEnergy()-5);
        System.out.println("Gorrila threw something");
    }

    public void eat_banana() {
        this.setEnergy(this.getEnergy() + 10);
        System.out.println("Gorrila ate a banana");
    }

    public void climb() {
        this.setEnergy(this.getEnergy()-10);
        System.out.println("Gorrila climbed");
    }

}