package com.robsite.auth.config;

import com.robsite.auth.challenge.Authenticate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * <code>AuthConfiguration</code> is a spring configuration bean. It is the
 * main configuration class and should be invoked with an annotation-aware
 * spring context.
 *
 * @author Rob Benton
 */
@Configuration
@ComponentScan
public class AuthConfiguration
{
  /**
   * Returns the default authentication implementation. This implementation is
   * empty and always returns true.
   *
   * @return {@link Authenticate} a bean initialized for the current context.
   */
  @Bean
  @Profile("default")
  public Authenticate authenticateDefault()
  {
    return (u, p) -> true;
  }

  /**
   * This implementation of the {@link Authenticate} interface returns a class
   * that uses ldap to perform authentication.
   *
   * @return {@link Authenticate}
   */
  @Bean
  @Profile("ldap")
  public Authenticate authenticateLdap()
  {
    return new Authenticate()
    {
      @Override
      public boolean authenticate(String user, String password)
      {
        return true;
      }
    };
  }
}
