package com.example.calcgui;

import java.util.ArrayList;

public class multiplication implements mathOperation
{
    public multiplication(){}
    public multiplication(double first, double second)
    {
        m_firstNum = first;
        m_secondNum = second;
    }

    @Override
    public double run(){
        double result = m_firstNum * m_secondNum;
        return result;
    }

    @Override
    public void getArgs(ArrayList<Double> al)
    {
        m_firstNum = al.get(0);
        m_secondNum = al.get(1);
    }

    double m_firstNum = 0;
    double m_secondNum = 0;
}
