package ru.stqa.pft.sandbox;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class PrimeTests {

  @Test
  public void testPrime(){
    Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));
  }

  @Test
  public void testNonPrime(){
    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2));
  }
}
