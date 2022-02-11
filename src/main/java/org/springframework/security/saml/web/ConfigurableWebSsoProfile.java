package org.springframework.security.saml.web;

import org.opensaml.common.SAMLException;
import org.opensaml.saml2.core.AuthnRequest;
import org.opensaml.saml2.metadata.AssertionConsumerService;
import org.opensaml.saml2.metadata.SingleSignOnService;
import org.opensaml.saml2.metadata.provider.MetadataProviderException;
import org.opensaml.ws.message.encoder.MessageEncodingException;
import org.springframework.security.saml.context.SAMLMessageContext;
import org.springframework.security.saml.websso.WebSSOProfileImpl;
import org.springframework.security.saml.websso.WebSSOProfileOptions;

public class ConfigurableWebSsoProfile extends WebSSOProfileImpl {
    private CustomWebSSOProfileOptions options;

    public void setOptions(final CustomWebSSOProfileOptions options) {
        this.options = options;
    }

    @Override
    protected AuthnRequest getAuthnRequest(final SAMLMessageContext context,
                                           final WebSSOProfileOptions options,
                                           final AssertionConsumerService assertionConsumer,
                                           final SingleSignOnService bindingService)
        throws SAMLException, MetadataProviderException {

        CustomWebSSOProfileOptions opts = (CustomWebSSOProfileOptions) options;
        AuthnRequest request = super.getAuthnRequest(context, options, assertionConsumer, bindingService);
        request.setAssertionConsumerServiceURL(opts.getAcsUrl());
        if (opts.isAuthnRequestBindingOptional()) {
            request.setProtocolBinding(null);
        }
        return request;
    }

    @Override
    protected void sendMessage(final SAMLMessageContext context, final boolean sign)
        throws MetadataProviderException, SAMLException, MessageEncodingException {
        super.sendMessage(context, sign || this.options.isSignAuthnRequests());
    }

    @Override
    protected void sendMessage(final SAMLMessageContext context, final boolean sign, final String binding)
        throws MetadataProviderException, SAMLException, MessageEncodingException {
        super.sendMessage(context, sign || this.options.isSignAuthnRequests(), binding);
    }
}
