package edu.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ExprTest {
    @Test
    @DisplayName("Negative Constant")
    void negConst() {
        Expr expr = new Expr.Negate(new Expr.Constant(10));

        double result = expr.evaluate();

        assertThat(result).isEqualTo(-10);
    }

    @Test
    @DisplayName("Constant")
    void constant() {
        Expr expr = new Expr.Constant(55);

        double result = expr.evaluate();

        assertThat(result).isEqualTo(55);
    }

    @Test
    @DisplayName("Exponent")
    void exponent() {
        Expr expr = new Expr.Exponent(new Expr.Constant(2), 10);

        double result = expr.evaluate();

        assertThat(result).isEqualTo(1024);
    }

    @Test
    @DisplayName("Addition of Constants")
    void addConst() {
        Expr expr = new Expr.Addition(
            new Expr.Constant(5),
            new Expr.Constant(-11)
        );

        double result = expr.evaluate();

        assertThat(result).isEqualTo(-6);
    }

    @Test
    @DisplayName("Addition of Additions")
    void addAdditions() {
        Expr expr = new Expr.Addition(
            new Expr.Addition(
                new Expr.Constant(1),
                new Expr.Constant(55)
            ),
            new Expr.Addition(
                new Expr.Constant(10),
                new Expr.Constant(20)
            )
        );

        double result = expr.evaluate();

        assertThat(result).isEqualTo(86);
    }

    @Test
    @DisplayName("Multiplication of Constants")
    void mulConst() {
        Expr expr = new Expr.Multiplication(
            new Expr.Constant(23),
            new Expr.Constant(3)
        );

        double result = expr.evaluate();

        assertThat(result).isEqualTo(69);
    }
}
