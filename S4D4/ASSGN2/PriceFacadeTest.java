package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PriceFacadeTest {

    @Spy
    private PriceFacade priceFacade = new PriceFacade(new PriceCalculator());

    @Before
    public void setUp() {
        doThrow(new ArithmeticException()).when(priceFacade).getPrice(50.0);
    }

    @Test
    public void testGetPriceReturnsDefaultOnException() {
        double price = priceFacade.getPrice(50.0);
        assertEquals(100.0, price, 0.0);
        verify(priceFacade).getPrice(50.0);
    }

    @Test
    public void testGetPriceAfterResetCallsRealMethod() {
        Mockito.reset(priceFacade);
        double price = priceFacade.getPrice(50.0);
        assertEquals(55.0, price, 0.0); // 50 + 50*0.1
        verify(priceFacade).getPrice(50.0);
    }
}