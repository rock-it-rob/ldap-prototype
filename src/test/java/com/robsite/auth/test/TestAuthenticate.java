package com.robsite.auth.test;

import com.robsite.auth.challenge.Authenticate;
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
  private AnnotationConfigApplicationContext context;

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
    this.context = new AnnotationConfigApplicationContext(com.robsite.auth.config.AuthConfiguration.class);
  }

  @Test
  public void testDefault()
  {
    Authenticate auth = this.context.getBean(Authenticate.class);
    System.out.println("Authenticating dummy/dummy");
    assertTrue(auth.authenticate("dummy", "dummy"));
  }
}
