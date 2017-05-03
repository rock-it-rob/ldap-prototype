package com.robsite.auth.challenge;

/**
 * <code>Authenticate</code> is a lambda interface that provides a method for
 * authenticating a user.
 *
 * @author Rob Benton
 */
public interface Authenticate
{
  /**
   * Authenticates the current user and password combo.
   *
   * @param user     username
   * @param password Password to use for authenticating user.
   * @return <code>true</code> if the authentication was successful; otherwise
   * returns false.
   */
  boolean authenticate(String user, String password);
}
