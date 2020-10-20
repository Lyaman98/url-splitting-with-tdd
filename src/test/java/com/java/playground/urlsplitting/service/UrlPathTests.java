package com.java.playground.urlsplitting.service;

import com.java.playground.urlsplitting.dto.UrlDTO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UrlPathTests {

    UrlSplittingService urlSplittingService;

    @Before
    public void setup() {
        urlSplittingService = new UrlSplittingService();
    }

    @Test
    public void pathShouldBeNotNull() {
        UrlDTO result = urlSplittingService.splitURL("ftp://a.large.site/my-path");
        assertNotNull(result.getPath());
    }
    @Test
    public void pathShouldBeEmpty() {
        UrlDTO result = urlSplittingService.splitURL("ftp://a.large.site");
        assertTrue(result.getPath().isEmpty());
    }
    @Test
    public void pathShouldNotBeEmpty() {
        UrlDTO result = urlSplittingService.splitURL("ftp://a.large.site/my-path");
        assertFalse(result.getPath().isEmpty());
    }
    @Test
    public void pathWithEmptyProtocol() {
        UrlDTO result = urlSplittingService.splitURL("a.large.site/my-path");
        assertEquals(result.getPath(), "my-path");
    }
    @Test
    public void pathWithNonEmptyProtocol() {
        UrlDTO result = urlSplittingService.splitURL("ftp://a.large.site/my-path");
        assertEquals(result.getPath(), "my-path");
    }
}
