package com.kevin.calculator;

public class ErreurDivisionParZero extends RuntimeException{
    public ErreurDivisionParZero(){
        super("Division par zéro impossible");
    }
}