package com.robsite.auth.test;

import com.robsite.auth.crypt.SHA1Crypto;
import org.junit.Test;

/**
 * @author Rob Benton
 */
public class TestSHA1Crypto
{
  @Test
  public void hashSHA1()
  {
    SHA1Crypto sha1Crypto = new SHA1Crypto();
    String src = "testing";
    String dest = sha1Crypto.digest(src);
    System.out.format("Source: %s -> SHA-1 -> %s\n", src, dest);
    System.out.flush();
  }
}
