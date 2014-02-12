package math;

import java.math.BigInteger;
import java.util.ArrayList;

public class Calculator
{
  Fraction[] rs = new Fraction[8];

  /*
   * @param String expression
   * 
   * @return Fraction
   * 
   * @purpose compute a Fraction from the String expression, supporting
   * operations + - * / ^ and assignment = to memory elements r0 to r7,
   * following order of operations, given that expression follows the correct
   * format.
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
          } // first tries to parse the number as an integer
        catch (Exception e)
          {
            if (vals[i].charAt(0) == 'r'
                && (Character.getNumericValue(vals[i].charAt(1)) > 7
                    || Character.getNumericValue(vals[i].charAt(1)) < 0 || vals[i].length() != 2))
              {
                throw new Exception("Only r0 to r7 allowed.");
              } // in case use of r is invalid
            else if (vals[i].charAt(0) == 'r')
              {
                nums.add(rs[Character.getNumericValue(vals[i].charAt(1))]);
              } // parses r and uses Fraction value stored in r
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
                  } // tries to parse a fraction
                catch (DivideByZeroException e0)
                  {
                    throw e0;
                  } // in case of divide by 0 error
                catch (Exception e1)
                  {
                    throw new Exception("Expression malformed. Error at "
                                        + vals[i] + "asd");
                  } // anything else is an error
              } // else it must be a fraction
          } // if integer parse is unsuccessful continue parsing
        if (i < vals.length - 1)
          ops.add(vals[i + 1]);
        // adds operation to ops array
      } // iterates through tokens from split, putting each in a number
        // (Fraction) array or an operation (String) array
    for (int i = ops.size() - 1; i > 0; i--)
      {
        if (ops.get(i).equals("=") && !ops.get(i - 1).equals("="))
          {
            throw new Exception("Expression malformed. Error at " + ops.get(i));
          } // if an = is not at index 0 or does not have another =
            // immediately preceding, it is illegal
      } // iterates through every operation from the right
    int index = -1;
    while ((index = ops.lastIndexOf("^")) != -1)
      {
        Fraction temp =
            nums.get(index).expt(nums.get(index + 1).num.intValue());
        setNum(index, temp, nums, ops);
      } // performs every ^ operation (from the right first)
    while ((index = ops.indexOf("*")) != -1)
      {
        Fraction temp = nums.get(index).multiplyBy(nums.get(index + 1));
        setNum(index, temp, nums, ops);
      } // performs every * operation
    while ((index = ops.indexOf("/")) != -1)
      {
        Fraction temp = nums.get(index).divideBy(nums.get(index + 1));
        setNum(index, temp, nums, ops);
      } // performs every / operation
    while ((index = ops.indexOf("+")) != -1)
      {
        Fraction temp = nums.get(index).addTo(nums.get(index + 1));
        setNum(index, temp, nums, ops);
      } // performs every + operation
    while ((index = ops.indexOf("-")) != -1)
      {
        Fraction temp = nums.get(index).subtractBy(nums.get(index + 1));
        setNum(index, temp, nums, ops);
      } // performs every - operation
    int index3;
    while ((index3 = ops.lastIndexOf("=")) != -1)
      {
        if (vals[index3 * 2].charAt(0) != 'r')
          throw new Exception("Expression malformed. Error at "
                              + vals[index3 * 2]);
        // cannot assign value to an element that is not an r
        rs[Character.getNumericValue(vals[index3 * 2].charAt(1))] =
            nums.get(index3 + 1);
        setNum(index3, nums.get(index3 + 1), nums, ops);
      } // performs every = operation (lowest precedence)
    if (ops.size() != 0)
      {
        throw new Exception("Expression malformed. Error at " + ops.get(0));
      } // any operation remaining must be illegal
    return nums.get(0);
  } // evaluate(String)

  /*
   * @param int index, Fraction temp, ArrayList<Fraction> nums,
   * ArrayList<String> ops
   * 
   * @return void
   * 
   * @purpose update number and operation arrays with new value, removing old
   * value and operation
   */
  private void setNum(int index, Fraction temp, ArrayList<Fraction> nums,
                      ArrayList<String> ops)
  {
    nums.set(index, temp);
    nums.remove(index + 1);
    ops.remove(index);
  } // setNum(int, Fraction, ArrayList<Fraction>, ArrayList<String>)
} // class Calculator
