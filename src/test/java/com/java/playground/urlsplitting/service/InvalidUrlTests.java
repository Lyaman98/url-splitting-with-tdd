package com.java.playground.urlsplitting.service;

import com.java.playground.urlsplitting.dto.UrlDTO;
import com.java.playground.urlsplitting.exception.InvalidUrlException;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InvalidUrlTests extends BaseClassTest {


    @Test
    public void testWithValidUrl(){
       assertDoesNotThrow(()->{
            urlSplittingService.splitURL("ftp://a.large.site/my-domain");
        });
    }
    @Test
    public void testWithInvalidUrl(){
        Exception exception = assertThrows(InvalidUrlException.class,()->{
            urlSplittingService.splitURL("ftp://");
        });
        assertFalse(exception.getMessage().isEmpty());
    }
}
