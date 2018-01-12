public class Calculator implements Operations {
    private double answer;
    private String sign;
    private double operand1;
    private double operand2;

    
    public Calculator() {

    }

    public String getOperation(){
        return sign;
    }
    public void setOperation(String sign) {
        if(sign == "+" || sign == "-"){
            this.sign = sign;
        } else {
            System.out.println("Invalid input");
        }
    }

    public void setOperand1(double x){
        this.operand1 = x;
    }

    public double getOperand1(){
        return operand1;
    }

    public double getOperand2() {
        return operand2;
    }

    public void setOperand2(double y) {
        this.operand2 = y;
    }

    public double calculate(){
        if(sign == "+"){
            answer = getOperand1() + getOperand2();
        } else if(sign == "-"){
            answer = getOperand1() - getOperand2();
        }
        return answer;
    }

    public double getResult(){
        return answer;
    }


    public static void main(String[] args){
        Calculator one = new Calculator();
        one.setOperation("-");
        System.out.println(one.getOperation());
        one.setOperand1(2);
        one.setOperand2(3);
        one.calculate();
        System.out.println(one.getResult());
    }
}