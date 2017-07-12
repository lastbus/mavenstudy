package com.mw.maven.guice;

import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * Created by make on 2017/7/5.
 */

public class AddModule implements Module {

    public void configure(Binder binder) {
        binder.bind(Add.class).to(SimpleAdd.class);
    }

}
