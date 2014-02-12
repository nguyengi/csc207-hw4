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

  /*
   * @purpose test equals
   */
  @Test
  public void testEqualsObject() throws Exception
  {
    assertEquals("Test equals",
                 false,
                 new Fraction(new BigInteger("9833"), new BigInteger("1")).equals(new Fraction(BigInteger.valueOf(7), BigInteger.valueOf(12))));
    assertEquals("Test equals",
                 false,
                 new Fraction(new BigInteger("9833"), new BigInteger("1")).equals(BigInteger.valueOf(9833)));
    assertEquals("Test equals",
                 true,
                 new Fraction(new BigInteger("19666"), new BigInteger("2")).equals(new Fraction(BigInteger.valueOf(9833), BigInteger.valueOf(1))));
    assertEquals("Test equals",
                 false,
                 new Fraction(new BigInteger("545"), new BigInteger("12")).equals(new Fraction(BigInteger.valueOf(12), BigInteger.valueOf(545))));
  } // testEqualsObject()

  /*
   * @purpose test multiplyBy
   */
  @Test
  public void testMultiplyBy() throws Exception
  {
    assertEquals("Test multiply",
                 "68831/72",
                 new Fraction(new BigInteger("9833"), new BigInteger("6")).multiplyBy(new Fraction(BigInteger.valueOf(7), BigInteger.valueOf(12))).toString());
    assertEquals("Test multiply",
                 "1",
                 new Fraction(new BigInteger("554"), new BigInteger("5")).multiplyBy(new Fraction(BigInteger.valueOf(5), BigInteger.valueOf(554))).toString());
    assertEquals("Test multiply",
                 "0",
                 new Fraction(new BigInteger("0"), new BigInteger("6")).multiplyBy(new Fraction(BigInteger.valueOf(771239821), BigInteger.valueOf(12123123))).toString());
    assertEquals("Test multiply",
                 "-983981729837891273982122313",
                 new Fraction(new BigInteger("983981729837891273982122313"), new BigInteger("-1")).multiplyBy(new Fraction(BigInteger.valueOf(2), BigInteger.valueOf(2))).toString());
  } // testMultiplyBy()

  /*
   * @purpose test addTo
   */
  @Test
  public void testAddTo() throws Exception
  {
	  assertEquals("Test add",
              "19673/12",
              new Fraction(new BigInteger("9833"), new BigInteger("6")).addTo(new Fraction(BigInteger.valueOf(7), BigInteger.valueOf(12))).toString());
	  assertEquals("Test add",
              "100",
              new Fraction(new BigInteger("99"), new BigInteger("1")).addTo(new Fraction(BigInteger.valueOf(2), BigInteger.valueOf(2))).toString());
	  assertEquals("Test add",
              "-10000000000000000000000",
              new Fraction(new BigInteger("-19999999999999999999999"), new BigInteger("2")).addTo(new Fraction(BigInteger.valueOf(1), BigInteger.valueOf(-2))).toString());
	  assertEquals("Test add",
              "0",
              new Fraction(new BigInteger("-12"), new BigInteger("7")).addTo(new Fraction(BigInteger.valueOf(24), BigInteger.valueOf(14))).toString());
  } // testAddTo()
  
  /*
   * @purpose test subtractBy
   */
  @Test
  public void testSubtractBy() throws Exception
  {
	  assertEquals("Test subtract",
              "6553/4",
              new Fraction(new BigInteger("9833"), new BigInteger("6")).subtractBy(new Fraction(BigInteger.valueOf(7), BigInteger.valueOf(12))).toString());
	  assertEquals("Test subtract",
              "-100",
              new Fraction(new BigInteger("-99"), new BigInteger("1")).subtractBy(new Fraction(BigInteger.valueOf(2), BigInteger.valueOf(2))).toString());
	  assertEquals("Test subtract",
              "10000000000000000000000",
              new Fraction(new BigInteger("20000000000000000000001"), new BigInteger("2")).subtractBy(new Fraction(BigInteger.valueOf(1), BigInteger.valueOf(2))).toString());
	  assertEquals("Test subtract",
              "0",
              new Fraction(new BigInteger("-12"), new BigInteger("7")).subtractBy(new Fraction(BigInteger.valueOf(12), BigInteger.valueOf(-7))).toString());
  } // testSubtractBy()
  
  /*
   * @purpose test divideBy
   */

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
    assertEquals("Test divide",
            "123/8",
            new Fraction(new BigInteger("123"), new BigInteger("-1")).divideBy(new Fraction(BigInteger.valueOf(-8))).toString());
  } // testDivideBy()

  /*
   * @purpose test expt
   */
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
  } // testExpt()

  /*
   * @purpose test toString
   */
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
  } // testToString()

} // class FractionTest
