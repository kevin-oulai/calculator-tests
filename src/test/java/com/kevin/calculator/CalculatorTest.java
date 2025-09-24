package com.kevin.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

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
    void devrait_lever_une_exception_si_a_plus_b_depasse_limite_integer(){
        // GIVEN
        int a = -2147483640;
        int b = -8;

        // WHEN
        Throwable thrown = catchThrowable(() -> Calculator.add(a,b));

        // THEN
        assertThat(thrown)
                .isInstanceOf(ErreurAdditionLimiteInteger.class)
                .hasMessage("L'addition dépasse la limite d'un entier");
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
    void devrait_renvoyer_1_quand_divide_a_et_b_et_a_egaux_b(){
        // GIVEN
        int a = 6;
        int b = 6;

        // WHEN
        int resultat = Calculator.divide(a,b);

        // THEN
        assertThat(resultat).isEqualTo(1);
    }

    @Test
    void devrait_lever_une_exception_si_b_egal_a_zero(){
        // GIVEN
        int a = 6;
        int b = 0;

        // WHEN
        Throwable thrown = catchThrowable(() ->  Calculator.divide(a,b));

        // THEN
        assertThat(thrown)
                .isInstanceOf(ErreurDivisionParZero.class)
                .hasMessage("Division par zéro impossible");
    }

    @Test
    void devrait_renvoyer_une_liste_contenant_le_chiffre_si_nombre_inf_a_10(){
        // GIVEN
        int nombre = 6;

        // WHEN
        Set<Integer> resultat = Calculator.ensembleChiffres(nombre);

        // THEN
        Set<Integer> attendu = new HashSet<>();
        attendu.add(nombre);
        assertThat(resultat).isEqualTo(attendu);
    }

    @Test
    void devrait_renvoyer_une_liste_contenant_6_7_9_si_on_donne_7679(){
        // GIVEN
        int nombre = 7679;

        // WHEN
        Set<Integer> resultat = Calculator.ensembleChiffres(nombre);

        // THEN
        Set<Integer> attendu = new HashSet<>();
        attendu.add(6);
        attendu.add(7);
        attendu.add(9);
        assertThat(resultat).isEqualTo(attendu);
    }

    @Test
    void devrait_renvoyer_une_liste_contenant_1_si_on_donne_moins_11(){
        // GIVEN
        int nombre = -11;

        // WHEN
        Set<Integer> resultat = Calculator.ensembleChiffres(nombre);

        // THEN
        Set<Integer> attendu = new HashSet<>();
        attendu.add(1);
        assertThat(resultat).isEqualTo(attendu);
    }
}
