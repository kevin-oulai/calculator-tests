package com.kevin.calculator;

import java.util.HashSet;
import java.util.Set;

public class Calculator {
    public static int add(int opG, int opD){
        if (Math.abs(opG)/2 + Math.abs(opD)/2 > 1073741823){
            throw new ErreurAdditionLimiteInteger();
        }
        return opG + opD;
    }

    public static int divide(int opG, int opD){
        if (opD == 0){
            throw new ErreurDivisionParZero();
        }
        return opG /  opD;
    }

    public static Set<Integer> ensembleChiffres(int pNombre){
        Set<Integer> returned = new HashSet<>();
        String str = Integer.toString(pNombre);

        for (int i = 0; i < str.length(); i++){
            int chiffre;
            try{
                chiffre = Integer.parseInt(String.valueOf(str.charAt(i)));
            }
            catch (NumberFormatException nfe){
                continue;
            }
            returned.add(chiffre);
        }

        return returned;
    }

}
