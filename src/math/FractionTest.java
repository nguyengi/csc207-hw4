package math;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class FractionTest
{

  @Test
  public void testHashCode()
    throws Exception
  {
    assertEquals("Test hash code",
                 new Fraction(new BigInteger("3"), new BigInteger("4")).hashCode(),
                 new Fraction(new BigInteger("6"), new BigInteger("8")).hashCode());
  }

  @Test
  public void testFractionBigIntegerBigInteger()
  {
    
  }

  @Test
  public void testFractionBigInteger()
  {
    
  }

  @Test
  public void testGetNumerator()
  {

  }

  @Test
  public void testGetDenominator()
  {

  }

  @Test
  public void testSetNumerator()
  {

  }

  @Test
  public void testSetDenominator()
  {

  }

  @Test
  public void testEqualsObject()
  {

  }

  @Test
  public void testMultiplyBy()
  {

  }

  @Test
  public void testAddTo()
  {

  }

  @Test
  public void testSubtractBy()
  {

  }

  @Test
  public void testDivideBy()
    throws Exception
  {
    assertEquals("Test divide",
                 "1",
                 new Fraction(new BigInteger("10"), new BigInteger("1")).divideBy(new Fraction(BigInteger.valueOf(10))).toString());
    assertEquals("Test divide",
                 "-1",
                 new Fraction(new BigInteger("-128"), new BigInteger("1")).divideBy(new Fraction(BigInteger.valueOf(128))).toString());
    assertEquals("Test divide",
                 "49/5",
                 new Fraction(new BigInteger("40353607"), new BigInteger("588245")).divideBy(new Fraction(BigInteger.valueOf(7))).toString());
  }

  @Test
  public void testExpt()
    throws Exception
  {
    assertEquals("Test expt",
                 "100",
                 new Fraction(new BigInteger("10"), new BigInteger("1")).expt(2)
                                                                        .toString());
    assertEquals("Test expt",
                 "81/49",
                 new Fraction(new BigInteger("-9"), new BigInteger("7")).expt(2)
                                                                        .toString());
    assertEquals("Test expt",
                 "-10604499373/40353607",
                 new Fraction(new BigInteger("13"), new BigInteger("-7")).expt(9)
                                                                         .toString());
    assertEquals("Test expt",
                 "0",
                 new Fraction(new BigInteger("0"), new BigInteger("10")).expt(3)
                                                                        .toString());
  }

  @Test
  public void testToString()
    throws Exception
  {
    assertEquals("Test toString",
                 "3/4",
                 new Fraction(new BigInteger("6"), new BigInteger("8")).toString());
    assertEquals("Test toString",
                 "998",
                 new Fraction(new BigInteger("998"), new BigInteger("1")).toString());
    assertEquals("Test toString", "961748941/982451653",
                 new Fraction(new BigInteger("961748941"),
                              new BigInteger("982451653")).toString());
    assertEquals("Test toString",
                 "-311/4",
                 new Fraction(new BigInteger("622"), new BigInteger("-8")).toString());
  }

}
