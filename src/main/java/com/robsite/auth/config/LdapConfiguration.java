package com.robsite.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * <code>LdapConfiguration</code> contains beans for working with LDAP
 * authentication.
 *
 * @author Rob Benton
 */
@Configuration
public class LdapConfiguration
{
  private static final String LDAP_PROPERTIES = "/ldap.properties";

  /**
   * LDAP template bean.
   *
   * @param contextSource autowired in from another bean.
   * @return <code>LdapTemplate</code>
   */
  @Bean
  public LdapTemplate ldapTemplate(@Autowired ContextSource contextSource)
  {
    return new LdapTemplate(contextSource);
  }

  /**
   * The ldap context source bean.
   *
   * @return <code>ContextSource</code>
   */
  @Bean
  public ContextSource contextSource()
  {
    LdapContextSource ldapContextSource = new LdapContextSource();
    Properties p = new Properties();
    InputStream is = this.getClass().getResourceAsStream(LDAP_PROPERTIES);
    String dn;
    String password;
    String url;
    String base;
    try
    {
      p.load(is);
      dn = p.getProperty("dn");
      password = p.getProperty("password");
      url = p.getProperty("url");
      base = p.getProperty("base");
    }
    catch (IOException e)
    {
      throw new LdapConfigurationException("Unable to load properties.");
    }
    if (dn == null || dn.length() == 0) { throw new LdapConfigurationException("Missing dn property."); }
    if (password == null || password.length() == 0) { throw new LdapConfigurationException("Missing password property"); }
    if (url == null || url.length() == 0) { throw new LdapConfigurationException("Missing url property."); }
    if (base == null || base.length() == 0) { throw new LdapConfigurationException("Missing base property."); }
    ldapContextSource.setUserDn(dn);
    ldapContextSource.setPassword(password);
    ldapContextSource.setUrl(url);
    ldapContextSource.setBase(base);

    return ldapContextSource;
  }
}
