package com.java.playground.urlsplitting.service;

import org.junit.Before;

public class BaseClassTest {

    UrlSplittingService urlSplittingService;

    @Before
    public void setup() {
        urlSplittingService = new UrlSplittingService();
    }

}
