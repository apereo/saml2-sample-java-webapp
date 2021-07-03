package org.springframework.security.saml.web;

import org.springframework.security.saml.websso.WebSSOProfileOptions;

public class CustomWebSSOProfileOptions extends WebSSOProfileOptions {
    private static final long serialVersionUID = -6802921791141304832L;
    
    private String acsUrl;

    public String getAcsUrl() {
        return acsUrl;
    }

    public void setAcsUrl(final String acsUrl) {
        this.acsUrl = acsUrl;
    }
}
