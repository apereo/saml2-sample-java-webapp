package org.springframework.security.saml.web;

import org.springframework.http.HttpStatus;

import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * This is {@link StatusServlet}.
 *
 * @author Misagh Moayyed
 * @since 6.4.0
 */
public class StatusServlet extends GenericServlet {
    @Override
    public void service(final ServletRequest req, final ServletResponse res) {
        try {
            HttpServletResponse response = HttpServletResponse.class.cast(res);
            response.setStatus(HttpStatus.OK.value());
            response.getWriter().println("OK");
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
