package com.java.playground.urlsplitting.service;

import com.java.playground.urlsplitting.dto.UrlDTO;
import com.java.playground.urlsplitting.exception.InvalidUrlException;

public class UrlSplittingService {

    private static final String COLON_WITH_DOUBLE_SLASHES = "://";

    public UrlDTO splitURL(String url) {
        UrlDTO urlDTO = new UrlDTO();
        urlDTO.setDomain(getDomain(url));
        urlDTO.setPath(getPath(url));
        urlDTO.setProtocol(getProtocol(url));

        if (urlDTO.getDomain().isEmpty()) {
            throw new InvalidUrlException("Url is invalid");
        }

        return urlDTO;
    }

    private String getProtocol(String url) {
        String protocol;
        int endOfProtocolIndex = url.indexOf(COLON_WITH_DOUBLE_SLASHES);
        if (endOfProtocolIndex != -1){
            protocol = url.substring(0, endOfProtocolIndex);
        }else {
            protocol = "";
        }
        return protocol;
    }

    private String getDomain(String url) {
        String protocol = getProtocol(url);
        int index;
        if (!protocol.isEmpty()) {
            index = protocol.length() + COLON_WITH_DOUBLE_SLASHES.length();
        }else {
            index = 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (index != url.length() && url.charAt(index) != '/') {
            stringBuilder.append(url.charAt(index));
            index++;
        }
        return stringBuilder.toString();
    }
    private String getPath(String url){
        String domain = getDomain(url);
        String protocol = getProtocol(url);
        int index;

        if (protocol.isEmpty()){
            index = domain.length() + 1;
        }else {
            index = (protocol.length() + COLON_WITH_DOUBLE_SLASHES.length() + domain.length()) + 1;

        }
        if (index - 1 != url.length()) {
            return url.substring(index);
        }
        return "";
    }
}
