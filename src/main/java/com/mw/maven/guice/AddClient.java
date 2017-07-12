package com.mw.maven.guice;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Created by make on 2017/7/5.
 */
public class AddClient {

    public static void main(String[] args) {

        Injector inject = Guice.createInjector(new AddModule());
        Add add = inject.getInstance(Add.class);
        System.out.println(add.add(10, 20));
    }

}
