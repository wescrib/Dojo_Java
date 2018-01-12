import java.lang.Math;
import java.util.Random;

public class test {
    public static void main(String[]args) {
    // long x = 1234567L;
    // long y = 23456789L;
    // Random r = new Random();
    // long number = x+((long)(r.nextDouble()*(y-x)));

    // System.out.println(String.valueOf(number));
    
    // int num = 15;
    // double dNum = Double.valueOf(num);
    // System.out.println(num);
    // System.out.println(dNum);

    BankAccount william = new BankAccount();
    // william.setAccNum();
    System.out.println("Total number of accounts: " + BankAccount.accCounter());
    System.out.println("William Account # : " + william.getAccNum());
    william.setAccBal(10000000.0);
    System.out.printf("Deposted $%f\n",william.getAccBal());
    // william.withdrawChecking(10000001); //prints insufficient funds
    william.setSavingsBal(3.0);
    System.out.println("Deposted $3 into savings");

    william.withdrawChecking(100000);
    System.out.printf("Withdrew $10000, so now I have %f\n",william.getAccBal());

    System.out.printf("Between checking and savings : %f\n",william.getTotalBal());

    }
}