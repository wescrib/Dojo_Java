import java.util.Random;

public class BankAccount {
    private String accNum;
    private double accBal;
    private double savingsBal;
    private static int accCounter = 0;



    public BankAccount() {
        setAccNum();
        accCounter++;
    }

    public static int accCounter(){ 
        return accCounter;
    }

    public double getAccBal() {
        return accBal;
    }

    public void setAccBal(double accBal) {
        this.accBal = accBal;
    }

    public void setSavingsBal(double savingsBal) {
        this.savingsBal = savingsBal;
    }

    public double getSavingsBal() {
        return savingsBal;
    }

    // public static double moneyTrack(){
    //     return getAccBal();
    // }
    public void setAccNum() {
        long x = 12345678900L;
        long y = 23456789000L;
        Random r = new Random();
        long number = x+((long)(r.nextDouble()*(y-x)));
        this.accNum = String.valueOf(number);
        // return String.valueOf(number);
    }

    public String getAccNum() {
        return accNum;
    }

    public double getTotalBal() {
        return getAccBal() + getSavingsBal();
    }

    public void withdrawChecking (int amount) {
        if(getAccBal() < Double.valueOf(amount)){
            System.out.println("Insufficient Funds");
        } else {
            setAccBal(getAccBal()-Double.valueOf(amount));
        }
    }

    public void withdrawSavings(int amount) {
        if(getAccBal() < Double.valueOf(amount)){
            System.out.println("Insufficient Funds");
        } else {
            setAccBal(getSavingsBal()-Double.valueOf(amount));
        }
    }
    

}