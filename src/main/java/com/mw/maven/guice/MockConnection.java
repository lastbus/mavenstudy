package com.mw.maven.guice;

/**
 * Created by make on 2017/7/5.
 */
public class MockConnection {

    public void connect(){
        System.out.println("Connecting to the mock database");
    }

    public void disConnect(){
        System.out.println("Dis-connecting from the mock database");
    }


}
