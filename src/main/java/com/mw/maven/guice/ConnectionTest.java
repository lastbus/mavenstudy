package com.mw.maven.guice;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * Created by make on 2017/7/5.
 */
public class ConnectionTest {


    public static void main(String args[]){
        Injector injector = Guice.createInjector(
                new Module(){
                    @Override
                    public void configure(Binder binder) {
                        binder.bind(MockConnection.class).toProvider(
                                ConnectionProvider.class);
                    }
                }
        );

        MockConnection connection =
                injector.getInstance(MockConnection.class);
        connection.connect();
        connection.disConnect();
    }

}
