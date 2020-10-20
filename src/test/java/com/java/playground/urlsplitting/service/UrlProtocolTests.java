package com.java.playground.urlsplitting.service;

import com.java.playground.urlsplitting.dto.UrlDTO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UrlProtocolTests extends BaseClassTest{

    @Test
    public void protocolShouldBeNotNull() {
        UrlDTO result = urlSplittingService.splitURL("ftp://a.large.site/my-protocol");
        assertNotNull(result.getProtocol());
    }
    @Test
    public void protocolShouldNotBeEmpty() {
        UrlDTO result = urlSplittingService.splitURL("ftp://a.large.site/my-protocol");
        assertFalse(result.getProtocol().isEmpty());
    }
    @Test
    public void protocolShouldBeEmpty() {
        UrlDTO result = urlSplittingService.splitURL("a.large.site/my-protocol");
        assertTrue(result.getProtocol().isEmpty());
    }
    @Test
    public void protocolShouldBeHTTPS() {
        UrlDTO result = urlSplittingService.splitURL("https://a.large.site/my-protocol");
        assertEquals("https", result.getProtocol());
    }
}
