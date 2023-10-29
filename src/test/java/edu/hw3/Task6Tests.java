package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Tests {

    @Test
    @DisplayName("One value")
    void test1() {
        var sm = new StockMarket();

        sm.add(new StockMarket.Stock(10));

        assertThat(sm.mostValuableStock().price()).isEqualTo(10);
    }

    @Test
    @DisplayName("Add many")
    void test2() {
        var sm = new StockMarket();

        sm.add(new StockMarket.Stock(10));
        sm.add(new StockMarket.Stock(15));
        sm.add(new StockMarket.Stock(7));
        sm.add(new StockMarket.Stock(25));
        sm.add(new StockMarket.Stock(17));

        assertThat(sm.mostValuableStock().price()).isEqualTo(25);
    }

    @Test
    @DisplayName("Remove most valuable")
    void test3() {
        var sm = new StockMarket();

        sm.add(new StockMarket.Stock(10));
        sm.add(new StockMarket.Stock(15));
        sm.add(new StockMarket.Stock(7));
        var s = new StockMarket.Stock(25);
        sm.add(s);
        sm.add(new StockMarket.Stock(12));

        assertThat(sm.mostValuableStock().price()).isEqualTo(25);
        sm.remove(s);
        assertThat(sm.mostValuableStock().price()).isEqualTo(15);
    }
}
