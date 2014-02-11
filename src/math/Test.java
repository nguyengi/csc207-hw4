package math;

import java.math.BigInteger;

public class Test
{
  public static void main(String[] args) throws Exception{
    System.out.println (new Calculator ().evaluate ("2/3 + 3 + 5/6 * 2 ^ 2 - -3"));
    System.out.println (new BigInteger ("12").negate ());
  }
}
