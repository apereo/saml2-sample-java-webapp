package org.springframework.security.saml.web;

import org.springframework.security.saml.websso.WebSSOProfileOptions;

public class CustomWebSSOProfileOptions extends WebSSOProfileOptions {
    private static final long serialVersionUID = -6802921791141304832L;

    private boolean signAuthnRequests;

    private String acsUrl;

    private boolean authnRequestBindingOptional;

    public boolean isAuthnRequestBindingOptional() {
        return authnRequestBindingOptional;
    }

    public void setAuthnRequestBindingOptional(final boolean authnRequestBindingOptional) {
        this.authnRequestBindingOptional = authnRequestBindingOptional;
    }

    public boolean isSignAuthnRequests() {
        return signAuthnRequests;
    }

    public void setSignAuthnRequests(final boolean signAuthnRequests) {
        this.signAuthnRequests = signAuthnRequests;
    }

    public String getAcsUrl() {
        return acsUrl;
    }

    public void setAcsUrl(final String acsUrl) {
        this.acsUrl = acsUrl;
    }
}
