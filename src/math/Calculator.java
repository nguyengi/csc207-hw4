package math;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class Calculator
{
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
        catch (NumberFormatException e)
          {
            int slash = vals[i].indexOf('/');
            System.out.println((slash + 1) + " " + (vals[i].length() - 1));
            nums.add(new Fraction(
                                  new BigInteger(vals[i].substring(0, slash)),
                                  new BigInteger(
                                                 vals[i].substring(slash + 1,
                                                                   vals[i].length()))));
          }
        if (i < vals.length - 1)
          ops.add(vals[i + 1]);
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

    // System.out.println (Arrays.toString (nums.toArray ()));
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
