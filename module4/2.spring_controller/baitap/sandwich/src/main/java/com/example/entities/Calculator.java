package com.example.entities;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
    private int firstOperand=0;
    private int secondOperand=0;
    public int plus(){
        return this.firstOperand+this.secondOperand;
    }
    public int minus(){
        return this.firstOperand-this.secondOperand;
    }
    public int multiple(){
        return this.firstOperand*this.secondOperand;
    }
    public float divide(){
        return (float) (this.firstOperand)/(this.secondOperand);
    }

    public int getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(int firstOperand) {
        this.firstOperand = firstOperand;
    }

    public int getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(int secondOperand) {
        this.secondOperand = secondOperand;
    }
}
