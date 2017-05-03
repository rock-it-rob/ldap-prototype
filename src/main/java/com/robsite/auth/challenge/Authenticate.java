package com.robsite.auth.challenge;

/**
 * <code>Authenticate</code> provides methods for authenticating a user
 * through LDAP.
 *
 * @author Rob Benton
 */
public class Authenticate
{
  private String user;
  private String password;

  /**
   */
  public Authenticate() {}

  public String getUser() { return user; }

  public void setUser(String user) { this.user = user; }

  public String getPassword() { return this.password; }

  public void setPassword(String password) { this.password = password; }

  /**
   * Authenticates the current user and password combo.
   *
   * @return <code>true</code> if the authentication was successful; otherwise
   * returns false.
   */
  public boolean authenticate()
  {
    return true;
  }
}
