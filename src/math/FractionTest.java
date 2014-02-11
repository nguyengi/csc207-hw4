package math;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class FractionTest
{

  @Test
  public void testHashCode() throws Exception
  {
    assertEquals("Test hash code",
                 new Fraction(new BigInteger("3"), new BigInteger("4")).hashCode(),
                 new Fraction(new BigInteger("6"), new BigInteger("8")).hashCode());
  }

//  @Test
//  public void testFractionBigIntegerBigInteger()
//  {
//    fail("Not yet implemented");
//  }
//
//  @Test
//  public void testFractionBigInteger()
//  {
//    fail("Not yet implemented");
//  }
//
//  @Test
//  public void testGetNumerator()
//  {
//    fail("Not yet implemented");
//  }
//
//  @Test
//  public void testGetDenominator()
//  {
//    fail("Not yet implemented");
//  }
//
//  @Test
//  public void testSetNumerator()
//  {
//    fail("Not yet implemented");
//  }
//
//  @Test
//  public void testSetDenominator()
//  {
//    fail("Not yet implemented");
//  }
//
//  @Test
//  public void testEqualsObject()
//  {
//    fail("Not yet implemented");
//  }
//
//  @Test
//  public void testMultiplyBy()
//  {
//    fail("Not yet implemented");
//  }
//
//  @Test
//  public void testAddTo()
//  {
//    fail("Not yet implemented");
//  }
//
//  @Test
//  public void testSubtractBy()
//  {
//    fail("Not yet implemented");
//  }
//
//  @Test
//  public void testDivideBy()
//  {
//    fail("Not yet implemented");
//  }
//
//  @Test
//  public void testExpt()
//  {
//    fail("Not yet implemented");
//  }
//
//  @Test
//  public void testToString()
//  {
//    fail("Not yet implemented");
//  }

}
