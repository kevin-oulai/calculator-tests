package com.kevin.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kevin.calculator.Calculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {
    // Calculator calculator;

    @ParameterizedTest(name = "{index} => a={0}, b={1}, attendu={2}")
    @CsvSource({
            "0,1,1",
            "1,2,3",
            "-2,2,0",
            "0,0,0",
            "-1,-2,-3",
    })
    void test_add(int a, int b, int attendu){
        // GIVEN
        int resultat = Calculator.add(a,b);

        // THEN
        assertThat(resultat).isEqualTo(attendu);
    }

    @BeforeEach
    public void setUp(){
        // calculator = new Calculator();
    }

    @AfterEach
    public void tearDown(){
        // calculator = null;
    }

    @Test
    void devrait_renvoyer_3_quand_add_1_et_2(){
        // GIVEN
        int a = 1;
        int b = 2;

        // WHEN
        int resultat = Calculator.add(a,b);

        // THEN
        assertThat(resultat).isEqualTo(3);
    }

    @Test
    void devrait_renvoyer_0_quand_add_a_et_b_et_quand_a_et_b_sont_opposes(){
        // GIVEN
        int a = 2;
        int b = -2;

        // WHEN
        int resultat = Calculator.add(a,b);

        // THEN
        assertThat(resultat).isEqualTo(0);
    }

    @Test
    void devrait_renvoyer_3_quand_divide_6_par_2(){
        // GIVEN
        int a = 6;
        int b = 2;

        // WHEN
        int resultat = Calculator.divide(a,b);

        // THEN
        assertThat(resultat).isEqualTo(3);
    }

    @Test
    void devrait_renvoyer_1_quand_divide_a_et_b_et_a_egal_b(){
        // GIVEN
        int a = 6;
        int b = 6;

        // WHEN
        int resultat = Calculator.divide(a,b);

        // THEN
        assertThat(resultat).isEqualTo(1);
    }



}
