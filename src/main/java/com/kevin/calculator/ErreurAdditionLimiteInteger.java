package com.kevin.calculator;

public class ErreurAdditionLimiteInteger extends RuntimeException{
    public ErreurAdditionLimiteInteger(){
        super("L'addition dépasse la limite d'un entier");
    }
}
