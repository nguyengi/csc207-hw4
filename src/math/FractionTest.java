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
    assertEquals("Test hash code 3/4 = 6/8",
                 new Fraction(new BigInteger("3"), new BigInteger("4")).hashCode(),
                 new Fraction(new BigInteger("6"), new BigInteger("8")).hashCode());

    assertEquals("Test hash code 10/4 = 5/2",
                 new Fraction(new BigInteger("10"), new BigInteger("4")).hashCode(),
                 new Fraction(new BigInteger("5"), new BigInteger("2")).hashCode());

    assertEquals("Test hash code 100/-4 = 50/-2",
                 new Fraction(new BigInteger("100"), new BigInteger("-4")).hashCode(),
                 new Fraction(new BigInteger("50"), new BigInteger("-2")).hashCode());

    assertEquals("Test hash code 100/-4 = 50/-2",
                 new Fraction(new BigInteger("100"), new BigInteger("-4")).hashCode(),
                 new Fraction(new BigInteger("50"), new BigInteger("-2")).hashCode());

  } // testHashCode

  @Test
  public void testFractionBigIntegerBigInteger()
    throws Exception
  {
    assertEquals("Test Fraction (BigInteger, BigInteger) 1/2 = 2/4",
                 new Fraction(new BigInteger("1"), new BigInteger("2")),
                 new Fraction(BigInteger.valueOf(2), BigInteger.valueOf(4)));

    assertEquals("Test Fraction (BigInteger, BigInteger) 63/9 = 7/1",
                 new Fraction(new BigInteger("63"), new BigInteger("9")),
                 new Fraction(BigInteger.valueOf(7), BigInteger.valueOf(1)));

    assertEquals("Test Fraction (BigInteger, BigInteger) 640 = 640/1",
                 new Fraction(new BigInteger("640")),
                 new Fraction(BigInteger.valueOf(640), BigInteger.valueOf(1)));

    assertEquals("Test Fraction (BigInteger, BigInteger) 934/-1 = -934",
                 new Fraction(new BigInteger("934"), new BigInteger("-1")),
                 new Fraction(BigInteger.valueOf(-934)));
  }

  @Test
  public void testFractionBigInteger()
    throws Exception
  {
    Fraction fraction1 = new Fraction(BigInteger.valueOf(4567891));
    Fraction fraction2 = new Fraction(BigInteger.valueOf(-123456));
    Fraction fraction3 = new Fraction(BigInteger.valueOf(5315 * 3));
    Fraction fraction4 = new Fraction(BigInteger.valueOf(0));
    assertEquals("Fraction (4567891/1)", BigInteger.valueOf(4567891),
                 fraction1.getNumerator());
    assertEquals("Fraction (-123456/1)", BigInteger.valueOf(-123456),
                 fraction2.getNumerator());
    assertEquals("Fraction (15945/1)", BigInteger.valueOf(15945),
                 fraction3.getNumerator());
    assertEquals("Fraction (0/1)", BigInteger.valueOf(0),
                 fraction4.getNumerator());
  }

  @Test
  public void testGetNumerator()
    throws Exception
  {
    Fraction fraction1 = new Fraction(BigInteger.valueOf(60));
    Fraction fraction2 =
        new Fraction(BigInteger.valueOf(1), BigInteger.valueOf(60));
    Fraction fraction3 =
        new Fraction(BigInteger.valueOf(4), BigInteger.valueOf(16));
    Fraction fraction4 =
        new Fraction(BigInteger.valueOf(16), BigInteger.valueOf(-160));
    // When Fraction has no denominator
    assertEquals("Numerator of (60/1)", BigInteger.valueOf(60),
                 fraction1.getNumerator());

    // Normal Fraction
    assertEquals("Numerator of (1/60)", BigInteger.valueOf(1),
                 fraction2.getNumerator());

    // When Fraction can be simplified, will return simplified fraction terms
    assertEquals("Numerator of (4/16)", BigInteger.valueOf(1),
                 fraction3.getNumerator());

    // When Denominator is Negative, will return affected numerator
    assertEquals("Numerator of (16/-160)", BigInteger.valueOf(-1),
                 fraction4.getNumerator());

  } // getNumerator Test

  @Test
  public void testGetDenominator()
    throws Exception
  {
    Fraction fraction1 = new Fraction(BigInteger.valueOf(5));
    Fraction fraction2 =
        new Fraction(BigInteger.valueOf(1), BigInteger.valueOf(60));
    Fraction fraction3 =
        new Fraction(BigInteger.valueOf(16), BigInteger.valueOf(160));
    Fraction fraction4 =
        new Fraction(BigInteger.valueOf(-96), BigInteger.valueOf(-3));
    // When Fraction has no explicit denominator, will return denom val of 1.
    assertEquals("Denominator of (5/1)", BigInteger.valueOf(1),
                 fraction1.getDenominator());

    // Normal Fraction
    assertEquals("Denominator of (1/60)", BigInteger.valueOf(60),
                 fraction2.getDenominator());
    // When Fraction can be simplified, will return simplified fraction terms
    assertEquals("Denominator of (16/160)", BigInteger.valueOf(10),
                 fraction3.getDenominator());
    // When Denominator is Negative, will return simplified (if possible)
    // positive denom
    assertEquals("Denominator of (-96/-3)", BigInteger.valueOf(1),
                 fraction4.getDenominator());

  } // getDenominator Test

  @Test
  public void testSetNumerator()
    throws Exception
  {
    Fraction fraction1 =
        new Fraction(BigInteger.valueOf(5), (BigInteger.valueOf(3)));
    assertEquals("Check numerator of original Fraction1 (5/3)",
                 BigInteger.valueOf(5), fraction1.getNumerator());
    fraction1.setNumerator(BigInteger.valueOf(2));
    assertEquals("Set Numerator  of (5/3) to (2)", BigInteger.valueOf(2),
                 fraction1.getNumerator());
    fraction1.setNumerator(BigInteger.valueOf(-67));
    assertEquals("Set Numerator  of (2/3) to (-67)", BigInteger.valueOf(-67),
                 fraction1.getNumerator());
    fraction1.setNumerator(BigInteger.valueOf(0));
    assertEquals("Set Numerator  of (-67/3) to (0)", BigInteger.valueOf(0),
                 fraction1.getNumerator());
  } // setNumerator Test

  @Test
  public void testSetDenominator()
    throws Exception
  {
    Fraction fraction1 =
        new Fraction(BigInteger.valueOf(50), (BigInteger.valueOf(363)));
    assertEquals("Check Denominator of original Fraction1 (50/363)",
                 BigInteger.valueOf(363), fraction1.getDenominator());
    fraction1.setDenominator(BigInteger.valueOf(60));
    assertEquals("Set Denominator  of (50/363) to (60)", BigInteger.valueOf(6),
                 fraction1.getDenominator());
    fraction1.setDenominator(BigInteger.valueOf(-1));
    assertEquals("Set Denominator  of (50/60) to (-1)", BigInteger.valueOf(1),
                 fraction1.getDenominator());
    fraction1.setDenominator(BigInteger.valueOf(789456464));
    assertEquals("Set Denominator  of (50/-1) to (789456464)",
                 BigInteger.valueOf(789456464), fraction1.getDenominator());
  } // setNumerator Test

  /*
   * @purpose test equals
   */
  @Test
  public void testEqualsObject()
    throws Exception
  {
	assertEquals("Test equals", false, new Fraction(new BigInteger("9833"),
		new BigInteger("1")).equals(new Fraction(BigInteger.valueOf(7),
		BigInteger.valueOf(12))));
	assertEquals("Test equals", false, new Fraction(new BigInteger("9833"),
		new BigInteger("1")).equals(BigInteger.valueOf(9833)));
	assertEquals("Test equals", true, new Fraction(new BigInteger("19666"),
		new BigInteger("2")).equals(new Fraction(BigInteger
		.valueOf(9833), BigInteger.valueOf(1))));
	assertEquals("Test equals", false, new Fraction(new BigInteger("545"),
		new BigInteger("12")).equals(new Fraction(BigInteger
		.valueOf(12), BigInteger.valueOf(545))));
  } // testEqualsObject()

  /*
   * @purpose test multiplyBy
   */
  @Test
  public void testMultiplyBy()
    throws Exception
  {
	assertEquals(
		"Test multiply",
		"68831/72",
		new Fraction(new BigInteger("9833"), new BigInteger("6"))
			.multiplyBy(
				new Fraction(BigInteger.valueOf(7), BigInteger
					.valueOf(12))).toString());
	assertEquals(
		"Test multiply",
		"1",
		new Fraction(new BigInteger("554"), new BigInteger("5"))
			.multiplyBy(
				new Fraction(BigInteger.valueOf(5), BigInteger
					.valueOf(554))).toString());
	assertEquals(
		"Test multiply",
		"0",
		new Fraction(new BigInteger("0"), new BigInteger("6"))
			.multiplyBy(
				new Fraction(BigInteger.valueOf(771239821),
					BigInteger.valueOf(12123123)))
			.toString());
	assertEquals(
		"Test multiply",
		"-983981729837891273982122313",
		new Fraction(new BigInteger("983981729837891273982122313"),
			new BigInteger("-1")).multiplyBy(
			new Fraction(BigInteger.valueOf(2), BigInteger
				.valueOf(2))).toString());
  } // testMultiplyBy()

  /*
   * @purpose test addTo
   */
  @Test
  public void testAddTo()
    throws Exception
  {
	assertEquals(
		"Test add",
		"19673/12",
		new Fraction(new BigInteger("9833"), new BigInteger("6"))
			.addTo(new Fraction(BigInteger.valueOf(7), BigInteger
				.valueOf(12))).toString());
	assertEquals(
		"Test add",
		"100",
		new Fraction(new BigInteger("99"), new BigInteger("1")).addTo(
			new Fraction(BigInteger.valueOf(2), BigInteger
				.valueOf(2))).toString());
	assertEquals(
		"Test add",
		"-10000000000000000000000",
		new Fraction(new BigInteger("-19999999999999999999999"),
			new BigInteger("2")).addTo(
			new Fraction(BigInteger.valueOf(1), BigInteger
				.valueOf(-2))).toString());
	assertEquals(
		"Test add",
		"0",
		new Fraction(new BigInteger("-12"), new BigInteger("7")).addTo(
			new Fraction(BigInteger.valueOf(24), BigInteger
				.valueOf(14))).toString());
  } // testAddTo()

  /*
   * @purpose test subtractBy
   */
  @Test
  public void testSubtractBy()
    throws Exception
  {
	assertEquals(
		"Test subtract",
		"6553/4",
		new Fraction(new BigInteger("9833"), new BigInteger("6"))
			.subtractBy(
				new Fraction(BigInteger.valueOf(7), BigInteger
					.valueOf(12))).toString());
	assertEquals(
		"Test subtract",
		"-100",
		new Fraction(new BigInteger("-99"), new BigInteger("1"))
			.subtractBy(
				new Fraction(BigInteger.valueOf(2), BigInteger
					.valueOf(2))).toString());
	assertEquals(
		"Test subtract",
		"10000000000000000000000",
		new Fraction(new BigInteger("20000000000000000000001"),
			new BigInteger("2")).subtractBy(
			new Fraction(BigInteger.valueOf(1), BigInteger
				.valueOf(2))).toString());
	assertEquals(
		"Test subtract",
		"0",
		new Fraction(new BigInteger("-12"), new BigInteger("7"))
			.subtractBy(
				new Fraction(BigInteger.valueOf(12), BigInteger
					.valueOf(-7))).toString());
  } // testSubtractBy()

  /*
   * @purpose test divideBy
   */

  @Test
  public void testDivideBy()
    throws Exception
  {
	assertEquals("Test divide", "1",
		new Fraction(new BigInteger("10"), new BigInteger("1"))
			.divideBy(new Fraction(BigInteger.valueOf(10)))
			.toString());
	assertEquals("Test divide", "-1",
		new Fraction(new BigInteger("-128"), new BigInteger("1"))
			.divideBy(new Fraction(BigInteger.valueOf(128)))
			.toString());
	assertEquals("Test divide", "49/5",
		new Fraction(new BigInteger("40353607"), new BigInteger(
			"588245"))
			.divideBy(new Fraction(BigInteger.valueOf(7)))
			.toString());
	assertEquals("Test divide", "123/8",
		new Fraction(new BigInteger("123"), new BigInteger("-1"))
			.divideBy(new Fraction(BigInteger.valueOf(-8)))
			.toString());
  } // testDivideBy()

  /*
   * @purpose test expt
   */
  @Test
  public void testExpt()
    throws Exception
  {
	assertEquals("Test expt", "100", new Fraction(new BigInteger("10"),
		new BigInteger("1")).expt(2).toString());
	assertEquals("Test expt", "81/49", new Fraction(new BigInteger("-9"),
		new BigInteger("7")).expt(2).toString());
	assertEquals("Test expt", "-10604499373/40353607", new Fraction(
		new BigInteger("13"), new BigInteger("-7")).expt(9).toString());
	assertEquals("Test expt", "0", new Fraction(new BigInteger("0"),
		new BigInteger("10")).expt(3).toString());
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
