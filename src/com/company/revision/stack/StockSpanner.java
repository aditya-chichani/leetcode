package com.company.revision.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpanner {
    private List<Integer> stocks;
    private List<Integer> spans;
    private Stack<Integer> spanStack;

    public StockSpanner() {
        stocks = new ArrayList<>();
        spans = new ArrayList<>();
        spanStack = new Stack<>();
    }

    public int next(int price) {
        stocks.add(price);
        //return stockSpanUsingDP(stocks);
        return stockSpanUsingStack(stocks);
    }

    private int stockSpanUsingDP(List<Integer> stocks) {
        int span = 1;
        int n = stocks.size() - 1;
        for (int i = n - 1; i >= 0 && stocks.get(i) <= stocks.get(n); i = i - spans.get(i)) {
            span += spans.get(i);
        }
        spans.add(span);
        return span;
    }

    // PGE
    private int stockSpanUsingStack(List<Integer> stocks) {
        int n = stocks.size() - 1;
        while (!spanStack.isEmpty() && stocks.get(spanStack.peek()) <= stocks.get(n)) {
            spanStack.pop();
        }
        int top = spanStack.isEmpty() ? -1 : spanStack.peek();
        spanStack.push(n);
        return n - top;
    }
}
