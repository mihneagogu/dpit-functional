package com.company;

public class IntWrapper {

    private int inner;
    public IntWrapper(int val) {
       this.inner = val;
    }

    public boolean isEven() {
        return inner % 2 == 0;
    }

    public int next() {
        return inner + 1;
    }

    @Override
    public String toString() {
        return "Wrapper of: " + ((Integer) inner).toString();
    }

    public int timesTwo() { return inner * 2; }


}
