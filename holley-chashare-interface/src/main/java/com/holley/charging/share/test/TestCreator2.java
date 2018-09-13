package com.holley.charging.share.test;

public class TestCreator2 extends TestAbsCreator {

    public TestCreator2(Test t) {
        super(t);
    }

    @Override
    public String content() {
        return "creater2" + t.content();
    }

}
