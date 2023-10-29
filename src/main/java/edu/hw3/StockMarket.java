package edu.hw3;

import java.util.PriorityQueue;
import org.jetbrains.annotations.NotNull;

public class StockMarket {
    private final PriorityQueue<Stock> stocks;

    public StockMarket() {
        this.stocks = new PriorityQueue<>();
    }

    public void add(Stock stock) {
        this.stocks.add(stock);
    }

    public void remove(Stock stock) {
        this.stocks.remove(stock);
    }

    public Stock mostValuableStock() {
        return this.stocks.peek();
    }

    public record Stock(Integer price) implements Comparable<Stock> {

        @Override
        public int compareTo(@NotNull Stock other) {
            return -this.price.compareTo(other.price);
        }

    }

}
