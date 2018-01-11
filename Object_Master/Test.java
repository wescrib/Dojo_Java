public class Test{
    public static void main(String[]args){
        Human bob = new Human();
        Human linda = new Human();

        System.out.println("Bob's health is at " + bob.getHealth());
        System.out.println("Linda's health is at " + linda.getHealth());
        bob.attackedBy(linda);
        System.out.println("Bob attacked linda maybe");
        System.out.println("Bob's health is at " + bob.getHealth());
        System.out.println("Linda's health is at " + linda.getHealth());

        Ninja bernard = new Ninja();
        System.out.println("********************************NINJA*******************************************");
        bernard.stoleFrom(linda);
        System.out.println("Ninja Health: " + bernard.getHealth());
        System.out.println("Linda's health: " + linda.getHealth());
        bernard.runaway();
        System.out.print("Ninja health: " + bernard.getHealth());

        Wizard harry = new Wizard();
        System.out.println("****************************WIZARD*****************************************");
        System.out.println("Harry's health: " + harry.getHealth());
        System.out.println("Bob's health: " + bob.getHealth());
        harry.fireball(bob);
        System.out.println("Harry's health: " + harry.getHealth());
        System.out.println("Bob's health: " + bob.getHealth());
        harry.heal(bob);
        System.out.println("Harry's health: " + harry.getHealth());
        System.out.println("Bob's health: " + bob.getHealth());

        Samurai jack = new Samurai();
        System.out.println("*************************************SAMURAI********************************");
        System.out.println("Jack's health: " + jack.getHealth());
        System.out.println("Bob's health: " + bob.getHealth());
        jack.deathBlow(bob);
        System.out.println("Jack's health: " + jack.getHealth());
        System.out.println("Bob's health: " + bob.getHealth());
        jack.meditate();
        System.out.println("Jack's health: " + jack.getHealth());
        System.out.println("Bob's health: " + bob.getHealth());
        System.out.println(Samurai.samuraiCount());

    }
}