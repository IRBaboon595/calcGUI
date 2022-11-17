package com.example.calcgui;

import java.util.ArrayList;

public class mathAction implements mathOperation{
    @Override
    public double run(){
        return 0;
    }

    @Override
    public void getArgs(ArrayList<Double> al)
    {

    }

    /*public double firstNum() {
        return m_firstNum;
    }

    public void setFirstNum(double m_firstNum) {
        this.m_firstNum = m_firstNum;
    }

    public double secondNum() {
        return m_secondNum;
    }

    public void setSecondNum(double m_secondNum) {
        this.m_secondNum = m_secondNum;
    }*/

    protected double m_firstNum = 0;
    protected double m_secondNum = 0;
}
