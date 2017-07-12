package com.mw.maven;

import junit.framework.TestCase;
import org.easymock.EasyMock;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by make on 2017/7/8.
 */
public class CurrencyTest extends TestCase {

    @Test
    public void testToEuros() throws IOException {
        Currency expected = new Currency(3.75, "EUR");
        Currency testObject = new Currency(2.50, "USD");

        ExchangeRate mock = EasyMock.createMock(ExchangeRate.class);

        EasyMock.expect(mock.getRate("USD", "EUR")).andReturn(1.5).times(1);
//        EasyMock.expect(mock.getRate("USD", "CAD")).andReturn(1.5);

        EasyMock.replay(mock);

        Currency actual = testObject.toEuros(mock);

        assertEquals(expected, actual);
        EasyMock.verify(mock);

    }

    @Test
    public void testExchangeRateServerUnavailable() throws IOException {
        Currency testObject = new Currency(2.50, "USD");

        ExchangeRate mock = EasyMock.createMock(ExchangeRate.class);
        EasyMock.expect(mock.getRate("USD", "EUR")).andThrow(new IOException());
        EasyMock.replay(mock);
        Currency actual = testObject.toEuros(mock);
        assertNull(actual);
    }

}
