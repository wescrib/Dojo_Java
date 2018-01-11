public class Dragon extends Mammal {
    
    public Dragon() {
        this.setEnergy(getEnergy()*3);
    }

    public void fly(){
        this.setEnergy(this.getEnergy()-50);
        System.out.println("Dragon flew!");
    }

    public void eat_humans() {
        this.setEnergy(this.getEnergy() + 25);
        System.out.println("Dragon ate people!");
    }

    public void attack_town() {
        this.setEnergy(this.getEnergy()-100);
        System.out.println("Dragon attacked a town!");
    }

}