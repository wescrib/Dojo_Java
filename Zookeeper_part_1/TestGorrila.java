public class TestGorrila {
    public static void main(String[] args) {
        Gorilla bernard = new Gorilla();
        bernard.displayEnergy();
        bernard.climb();
        bernard.displayEnergy();
        bernard.eat_banana();
        bernard.displayEnergy();
        bernard.throw_something();
        bernard.displayEnergy();

        Dragon darwin = new Dragon();
        System.out.println("DRAGON");
        darwin.displayEnergy();
        darwin.attack_town();
        darwin.displayEnergy();
        darwin.fly();
        darwin.displayEnergy();
    }
}