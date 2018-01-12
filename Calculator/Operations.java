public interface Operations {

    public void setOperation(String sign);
    void setOperand1(double x);
    public double getOperand1();
    void setOperand2(double y);
    public double getOperand2();
    double calculate();
    public double getResult();
}