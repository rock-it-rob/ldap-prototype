package com.robsite.auth.config;

/**
 * <code>LdapConfigurationException</code> is a situation when the ldap
 * configuration is unable to be initialized.
 *
 * @author Rob Benton
 */
public class LdapConfigurationException extends RuntimeException
{
  public LdapConfigurationException(String s) { super(s); }
}
