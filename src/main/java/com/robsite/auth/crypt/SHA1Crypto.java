package com.robsite.auth.crypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * The <code>SHA1Crypto</code> class provides functionality for hashing values
 *  using the SHA1 algorithm.
 *
 * @author Rob Benton
 */
public class SHA1Crypto
{
  private static final String ALGORITHM = "SHA-1";

  /**
   * Creates a new default instance.
   */
  public SHA1Crypto() {}

  /**
   * Generates a digest object for SHA-1.
   *
   * @return <code>MessageDigest</code> set for SHA-1 hashing.
   */
  private MessageDigest createDigest()
  {
    try
    {
      return MessageDigest.getInstance(ALGORITHM);
    } catch (NoSuchAlgorithmException e)
    {
      throw new RuntimeException(e);
    }
  }

  /**
   * Hashes a string using the SHA-1 algorithm.
   *
   * @param message the source string to hash.
   * @return the <code>String</code> value of the resulting hash.
   */
  public String digest(String message)
  {
    MessageDigest messageDigest = createDigest();
    messageDigest.update(message.getBytes());

    return new String(messageDigest.digest());
  }
}
