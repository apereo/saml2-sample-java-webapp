#!/bin/sh
docker run -p 9876:9876 -it --rm --name=sp \
 -v /etc/cas/config/saml/idp-metadata.xml:/etc/cas/config/saml/idp-metadata.xml \
 -v /etc/cas/thekeystore:/etc/cas/thekeystore apereo/saml2-sp
