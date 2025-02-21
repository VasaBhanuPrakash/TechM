package com.example.base.configuration.securityconfig;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Step 2
 * Now, we will register springSecurityFilterChain with the war.
 * To register, Spring Security provides a base class AbstractSecurityWebApplicationInitializer that we need to extend.
 * For Spring MVC application, SecurityWebApplicationInitializer will look like below.
 * This code will register the springSecurityFilterChain for every URL in our application.
 */
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
}
