package org.springframework.security.saml.web;

import org.slf4j.bridge.SLF4JBridgeHandler;

/**
 * Extend ClassLoaderLeakPreventorListener to override standard logger (route it to slf4j) so we can control logging.
 * This might risk classloader leak but we just want threads stopped.
 */
public class ClassLoaderLeakPreventorListener
        extends se.jiderhamn.classloader.leak.prevention.ClassLoaderLeakPreventorListener {
    static {
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
    }
}
