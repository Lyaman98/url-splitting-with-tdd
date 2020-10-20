package com.java.playground.urlsplitting.service;

import com.java.playground.urlsplitting.dto.UrlDTO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UrlDomainTests extends BaseClassTest{

    @Test
    public void domainShouldBeNotNull() {
        UrlDTO result = urlSplittingService.splitURL("ftp://a.large.site/my-domain");
        assertNotNull(result.getDomain());
    }
    @Test
    public void domainShouldNotBeEmpty() {
        UrlDTO result = urlSplittingService.splitURL("ftp://a.large.site/my-domain");
        assertFalse(result.getDomain().isEmpty());
    }
    @Test
    public void domainWithEmptyProtocol() {
        UrlDTO result = urlSplittingService.splitURL("a.large.site/my-domain");
        assertEquals(result.getDomain(), "a.large.site");
    }
    @Test
    public void domainWithNonEmptyProtocol() {
        UrlDTO result = urlSplittingService.splitURL("ftp://a.large.site/my-domain");
        assertEquals(result.getDomain(), "a.large.site");
    }

}
