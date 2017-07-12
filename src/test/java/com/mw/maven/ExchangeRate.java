package com.mw.maven;

import java.io.IOException;

/**
 * Created by make on 2017/7/8.
 */
public interface ExchangeRate {

    double getRate(String inputCurrency, String outputCurrency) throws IOException;

}
