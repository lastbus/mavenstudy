package com.mw.maven.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Created by make on 2017/7/5.
 */
public class MultipleDependencyTest {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector();
        Person person = injector.getInstance(Person.class);
        person.diplayInfo();
    }


}
