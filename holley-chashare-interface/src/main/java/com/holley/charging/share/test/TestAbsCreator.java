package com.holley.charging.share.test;

public abstract class TestAbsCreator implements Test {

    protected Test t;

    TestAbsCreator(Test t) {
        this.t = t;
    }
}
