package com.kevin.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kevin.calculator.Calculator;

public class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    @Test
    void devrait_renvoyer_3_quand_add_1_et_2(){
        // GIVEN
        int a = 1;
        int b = 2;

        // WHEN
        int resultat = calculator.add(a,b);

        // THEN
        assertThat(resultat).isEqualTo(3);
    }

    @Test
    void devrait_renvoyer_3_quand_divide_6_par_2(){
        // GIVEN
        int a = 6;
        int b = 2;

        // WHEN
        int resultat = calculator.divide(a,b);

        // THEN
        assertThat(resultat).isEqualTo(3);
    }

}
