package org.springframework.security.saml.web;

import org.opensaml.common.SAMLException;
import org.opensaml.saml2.core.AuthnRequest;
import org.opensaml.saml2.metadata.AssertionConsumerService;
import org.opensaml.saml2.metadata.SingleSignOnService;
import org.opensaml.saml2.metadata.provider.MetadataProviderException;
import org.springframework.security.saml.context.SAMLMessageContext;
import org.springframework.security.saml.websso.WebSSOProfileImpl;
import org.springframework.security.saml.websso.WebSSOProfileOptions;

public class ConfigurableWebSsoProfile extends WebSSOProfileImpl {

    @Override
    protected AuthnRequest getAuthnRequest(final SAMLMessageContext context,
                                           final WebSSOProfileOptions options,
                                           final AssertionConsumerService assertionConsumer,
                                           final SingleSignOnService bindingService)
        throws SAMLException, MetadataProviderException {

        CustomWebSSOProfileOptions opts = (CustomWebSSOProfileOptions) options;
        AuthnRequest request = super.getAuthnRequest(context, options, assertionConsumer, bindingService);
        request.setAssertionConsumerServiceURL(opts.getAcsUrl());
        return request;
    }
}
