package com.mw.maven.guice;

import com.google.inject.Provider;

/**
 * Created by make on 2017/7/5.
 */
public class ConnectionProvider implements Provider<MockConnection> {

    @Override
    public MockConnection get() {

        // Do some customization mechanism here.
        MockConnection connection = new MockConnection();
        // Do some customization mechanism here too.
        return connection;
    }
}

