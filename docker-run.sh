#!/bin/sh

ARGS=""
if [ -n "${IDP_METADATA}" ]; then
    ARGS="${ARGS} -DidpMetadata="${IDP_METADATA}""
fi

if [ -n "${IDP_METADATA_TYPE}" ]; then
    ARGS="${ARGS} -DidpMetadataType="${IDP_METADATA_TYPE}""
fi

if [ -n "${METADATA_TYPE}" ]; then
    ARGS="${ARGS} -DmetadataType="${METADATA_TYPE}""
fi

if [ -n "${INCLUDE_SCOPING}" ]; then
    ARGS="${ARGS} -DincludeScoping="${INCLUDE_SCOPING}""
fi

if [ -n "${METADATA_LOCATION}" ]; then
    ARGS="${ARGS} -DmetadataLocation="${METADATA_LOCATION}""
fi

if [ -n "${RELAY_STATE}" ]; then
    ARGS="${ARGS} -DrelayState="${RELAY_STATE}""
fi

if [ -n "${NAMEID_FORMAT}" ]; then
    ARGS="${ARGS} -DnameIdFormat="${NAMEID_FORMAT}""
fi

if [ -n "${ALLOWED_IDP1}" ]; then
    ARGS="${ARGS} -DallowedIdP1="${ALLOWED_IDP1}""
fi

if [ -n "${ACS_URL}" ]; then
    ARGS="${ARGS} -DacsUrl="${ACS_URL}""
fi

if [ -n "${SIGN_AUTHN_REQUESTS}" ]; then
    ARGS="${ARGS} -DsignAuthnRequests="${SIGN_AUTHN_REQUESTS}""
fi

if [ -n "${FORCED_AUTHN}" ]; then
    ARGS="${ARGS} -DforcedAuthn="${FORCED_AUTHN}""
fi

if [ -n "${AUTHN_REQUEST_BINDING_OPTIONAL}" ]; then
    ARGS="${ARGS} -DauthnRequestBindingOptional="${AUTHN_REQUEST_BINDING_OPTIONAL}""
fi

if [ -n "${AUTHN_CONTEXT}" ]; then
    ARGS="${ARGS} -DauthnContext="${AUTHN_CONTEXT}""
fi

if [ -n "${SP_KEYSTORE_PATH}" ]; then
    ARGS="${ARGS} -Dsp.sslKeystorePath="${SP_KEYSTORE_PATH}""
fi

if [ -n "${SP_KEYSTORE_PASSWORD}" ]; then
    ARGS="${ARGS} -Dsp.sslKeystorePassword="${SP_KEYSTORE_PASSWORD}""
fi


echo "Running SAML2 sample application with ${ARGS}"
./gradlew jettyRunWar --stacktrace ${ARGS}
