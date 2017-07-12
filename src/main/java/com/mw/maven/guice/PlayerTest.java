package com.mw.maven.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Created by make on 2017/7/5.
 */
public class PlayerTest {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector();
        Player player = injector.getInstance(Player.class);
        player.name = "David Boon";
        System.out.println(player);
    }


}
