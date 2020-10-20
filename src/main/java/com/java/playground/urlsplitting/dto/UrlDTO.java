package com.java.playground.urlsplitting.dto;

public class UrlDTO {

    private String protocol;
    private String domain;
    private String path;

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "UrlDTO{" +
                "protocol='" + protocol + '\'' +
                ", domain='" + domain + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
