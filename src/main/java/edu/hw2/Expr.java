package edu.hw2;

public sealed interface Expr {
    double evaluate();

    record Constant(double value) implements Expr {
        @Override
        public double evaluate() {
            return this.value;
        }
    }

    record Negate(Expr value) implements Expr {
        @Override
        public double evaluate() {
            return -this.value.evaluate();
        }
    }

    record Exponent(Expr value, int power) implements Expr {
        @Override
        public double evaluate() {
            return Math.pow(value.evaluate(), power);
        }
    }

    record Addition(Expr value1, Expr value2) implements Expr {
        @Override
        public double evaluate() {
            return value1.evaluate() + value2.evaluate();
        }
    }

    record Multiplication(Expr value1, Expr value2) implements Expr {
        @Override
        public double evaluate() {
            return value1.evaluate() * value2.evaluate();
        }
    }
}
