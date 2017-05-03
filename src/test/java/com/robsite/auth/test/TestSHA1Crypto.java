package com.robsite.auth.test;

import com.robsite.auth.crypt.SHA1Crypto;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Rob Benton
 */
public class TestSHA1Crypto
{
  private final String SOURCE = "testing";
  private final String DIGEST = "dc724af18fbdd4e59189f5fe768a5f8311527050";

  @Test
  public void hashSHA1()
  {
    SHA1Crypto sha1Crypto = new SHA1Crypto();
    String dest = sha1Crypto.digest(SOURCE);
    System.out.format("Source: %s -> SHA-1 -> %s\n", SOURCE, dest);
    System.out.flush();
    assertEquals(DIGEST, dest);
  }
}
