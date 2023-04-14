package model;

public class Calculator {
    public static double calculate(double firstOperand,double secondOperand,String math) throws ArithmeticException{
       if (math.equals("addition")){
           return firstOperand+secondOperand;
       } else if (math.equals("subtraction")){
           return firstOperand-secondOperand;
       }else if(math.equals("multiplition")){
           return firstOperand*secondOperand;
       } else if (math.equals("division")) {
           return firstOperand/secondOperand;
       }else {
           return firstOperand%secondOperand;
       }

    }
}
