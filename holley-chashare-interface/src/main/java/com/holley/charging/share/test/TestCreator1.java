package com.holley.charging.share.test;

public class TestCreator1 extends TestAbsCreator {

    public TestCreator1(Test t) {
        super(t);
    }

    @Override
    public String content() {
        return "creater1" + t.content();
    }

}
