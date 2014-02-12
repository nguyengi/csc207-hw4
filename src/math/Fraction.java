package math;

import java.math.BigInteger;

public class Fraction
{
  BigInteger num, denom;

  public Fraction (BigInteger num, BigInteger denom) throws Exception
  {
    this.num = num;
    this.denom = denom;
    if(denom.intValue() < 0){
      this.num = num.negate();
      this.denom = denom.negate();
    }
    if (this.denom.intValue () == 0)
      {
        throw new DivideByZeroException ("Denominator cannot be 0.");
      }
    simplify ();
  } // Fraction (BigInteger, BigInteger)
  
  public Fraction (BigInteger val)
  {
    this.num = val;
    this.denom = BigInteger.valueOf (1);
  } // Fraction (BigInteger)

  public BigInteger
    getNumerator ()
  {
    return this.num;
  } // getNumerator ()

  public BigInteger
    getDenominator ()
  {
    return this.denom;
  } // getDenominator ()
  

  public void
    setNumerator (BigInteger num)
  {
    this.num = num;
  } // setNumerator ()

  public void
    setDenominator (BigInteger denom)
  {
    this.denom = denom;
  } // setDenominator ()

  @Override
  public int
    hashCode ()
  {
    int result = 1;
    result = 31 * result * ((denom == null) ? 0 : denom.hashCode ());
    result = result + 37 * ((num == null) ? 0 : num.hashCode ());
    return result;
  } // hashCode ()

  @Override
  public boolean
    equals (Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass () != obj.getClass ())
      return false;
    Fraction other = (Fraction) obj;
    if (denom == null)
      {
        if (other.denom != null)
          return false;
      }
    else if (!denom.equals (other.denom))
      return false;
    if (num == null)
      {
        if (other.num != null)
          return false;
      }
    else if (!num.equals (other.num))
      return false;
    return true;
  } // equals (Object)

  public Fraction
    multiplyBy (Fraction multiplier)
      throws Exception
  {
    return new Fraction (this.num.multiply (multiplier.num),
                         this.denom.multiply (multiplier.denom));
  } // multiplyBy(Fraction)

  public Fraction
    addTo (Fraction val)
      throws Exception
  {
    return new Fraction (this.num.multiply (val.denom)
                                 .add (val.num.multiply (this.denom)),
                         this.denom.multiply (val.denom));
  } // addTo(Fraction)

  public Fraction
    subtractBy (Fraction val)
      throws Exception
  {
    return addTo (new Fraction (val.num.negate (), val.denom));
  } // subtractBy (Fraction)

  public Fraction
    divideBy (Fraction divisor)
      throws Exception
  {
    return multiplyBy (new Fraction (divisor.denom, divisor.num));
  } // divideBy (Fraction)

  public Fraction
    expt (int power)
      throws Exception

  {
    return new Fraction (this.num.pow (power), this.denom.pow (power));
  }// expt (int)
  
  @Override
  public String toString()
  {
    if(this.denom.intValue() == 1)
      return num.toString();
    return num.toString () + "/" + denom.toString ();
  }//toString ()

  private void
    simplify ()
  {
    BigInteger val = this.num.gcd (this.denom);
    this.num = this.num.divide (val);
    this.denom = this.denom.divide (val);
  } // simplify ()

} // Fraction Class
