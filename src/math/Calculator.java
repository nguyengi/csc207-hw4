package math;

import java.math.BigInteger;
import java.util.ArrayList;

public class Calculator
{
  Fraction[] rs = new Fraction[8];
  /*
   * @params 
   * @return
   * Purpose
   */

  public Fraction evaluate(String expression)
    throws Exception
  {
    ArrayList<Fraction> nums = new ArrayList<Fraction>();
    ArrayList<String> ops = new ArrayList<String>();
    String[] vals = expression.split(" ");
    for (int i = 0; i < vals.length; i += 2)
      {
        try
          {
            nums.add(new Fraction(new BigInteger(vals[i])));
          }
        catch (Exception e)
          {
            if (vals[i].charAt(0) == 'r'
                && (Character.getNumericValue(vals[i].charAt(1)) > 7
                    || Character.getNumericValue(vals[i].charAt(1)) < 0 || vals[i].length() != 2))
              {
                throw new Exception("Only r0 to r7 allowed.");
              }
            else if (vals[i].charAt(0) == 'r')
              {
                nums.add(rs[Character.getNumericValue(vals[i].charAt(1))]);
              }
            else
              {
                int slash = vals[i].indexOf('/');
                try
                  {
                    nums.add(new Fraction(
                                          new BigInteger(
                                                         vals[i].substring(0,
                                                                           slash)),
                                          new BigInteger(
                                                         vals[i].substring(slash + 1,
                                                                           vals[i].length()))));
                  }
                catch (DivideByZeroException e0)
                  {
                    throw e0;
                  }
                catch (Exception e1)
                  {
                    throw new Exception("Expression malformed. Error at "
                                        + vals[i] + "asd");
                  }
              }
          }
        if (i < vals.length - 1)
          ops.add(vals[i + 1]);
      }
    int index1;
    for (int i = ops.size() - 1; i > 0; i--)
      {
        if (ops.get(i).equals("=") && !ops.get(i - 1).equals("="))
          {
            throw new Exception("Expression malformed. Error at " + ops.get(i)
                                + "HI");
          }
      }
    int index = -1;
    while ((index = ops.lastIndexOf("^")) != -1)
      {
        Fraction temp =
            nums.get(index).expt(nums.get(index + 1).num.intValue());
        setNum(index, temp, nums, ops);
      }
    while ((index = ops.indexOf("*")) != -1)
      {
        Fraction temp = nums.get(index).multiplyBy(nums.get(index + 1));
        setNum(index, temp, nums, ops);
      }
    while ((index = ops.indexOf("/")) != -1)
      {
        Fraction temp = nums.get(index).divideBy(nums.get(index + 1));
        setNum(index, temp, nums, ops);
      }
    while ((index = ops.indexOf("+")) != -1)
      {
        Fraction temp = nums.get(index).addTo(nums.get(index + 1));
        setNum(index, temp, nums, ops);
      }
    while ((index = ops.indexOf("-")) != -1)
      {
        Fraction temp = nums.get(index).subtractBy(nums.get(index + 1));
        setNum(index, temp, nums, ops);
      }
    int index3;
    while ((index3 = ops.lastIndexOf("=")) != -1)
      {
        if (vals[index3 * 2].charAt(0) != 'r')
          throw new Exception("Expression malformed. Error at "
                              + vals[index3 * 2]);
        rs[Character.getNumericValue(vals[index3 * 2].charAt(1))] =
            nums.get(index3 + 1);
        setNum(index3, nums.get(index3 + 1), nums, ops);
      }
    if (ops.size() != 0)
      {
        throw new Exception("Expression malformed. Error at " + ops.get(0));
      }
    return nums.get(0);
  }

  private void setNum(int index, Fraction temp, ArrayList<Fraction> nums,
                      ArrayList<String> ops)
  {
    nums.set(index, temp);
    nums.remove(index + 1);
    ops.remove(index);
  }
}
