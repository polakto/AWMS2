package com.support.android.designlibdemo.tests;

import android.test.InstrumentationTestCase;

import com.support.android.designlibdemo.subjectOfTesting;

/**
 * Created by Dell on 19.11.2015.
 */
public class ExampleTest extends InstrumentationTestCase {
    /**
     * This is template for all your tests. In general, you need to define class, variables or
     * something different and in the end of this method there need to be method assertEquals(x,y)
     * where are you comparing the results and then the android studio will show you results of
     * your test method.
     *
     * @throws Exception
     */
    public void test() throws Exception {
        final int expected = 1;
        final int reality = 5;
        assertEquals(expected, reality);
    }

    public void test2() throws Exception {
        final int expected = 2;
        final int reality = 2;
        assertEquals(expected, reality);
    }

    public void test3() throws Exception {
        final int expected = 3;
        final int reality = 5;
        assertEquals(expected, reality);
    }

    public void test4() throws Exception {
        final int expected = 1;
        final int reality = 1;
        assertEquals(expected, reality);
    }

    public void test5() throws Exception {
        final int expected = 6;
        subjectOfTesting testedClass = new subjectOfTesting();
        int reality = testedClass.sum(6, 9);

        assertEquals(expected, reality);
    }

    public void test6() throws Exception {
        final int expected = 15;
        subjectOfTesting testedClass = new subjectOfTesting();
        int reality = testedClass.sum(6, 9);

        assertEquals(expected, reality);
    }
}
