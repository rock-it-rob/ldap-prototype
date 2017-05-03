package com.robsite.auth.test;

import com.robsite.auth.challenge.Authenticate;
import com.robsite.auth.config.AuthConfiguration;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * <code>TestAuthenticate</code> is a junit class for unit testing the
 * {@link com.robsite.auth.challenge.Authenticate} class.
 *
 * @author Rob Benton
 */
public class TestAuthenticate
{
  private static final String PROPERTIES = "/account.properties";

  private String user;
  private String password;

  /**
   */
  public TestAuthenticate()
  {
    Properties p = new Properties();
    InputStream is = this.getClass().getResourceAsStream(PROPERTIES);
    try
    {
      p.load(is);
    }
    catch (IOException e)
    {
      throw new RuntimeException("Could not load test properties.");
    }
    this.user = p.getProperty("user");
    this.password = p.getProperty("password");
  }

  @Test
  public void testDefault()
  {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(com.robsite.auth.config.AuthConfiguration.class);
    Authenticate auth = context.getBean(Authenticate.class);
    System.out.println("Authenticating dummy/dummy");
    assertTrue(auth.authenticate("dummy", "dummy"));
  }

  @Test
  public void testLdap()
  {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.getEnvironment().addActiveProfile("ldap");
    context.register(AuthConfiguration.class);
    context.refresh();
    Authenticate auth = context.getBean(Authenticate.class);
    System.out.println("Authenticating " + this.user + "/" + this.password);
    assertTrue(auth.authenticate(this.user, this.password));
  }
}
