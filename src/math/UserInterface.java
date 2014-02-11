package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class UserInterface
{
  public static void main(String[] args)
    throws Exception
  {
    String input = "";
    Calculator calc = new Calculator();
    BufferedReader eyes = new BufferedReader(new InputStreamReader(System.in));
    while (true)
      {
        System.out.print("Enter expression (Q to quit): ");
        input = eyes.readLine();
        if(input.equalsIgnoreCase("Q")){
          System.out.println("Quitting calculator.");
          return;
        }
        try
          {
            System.out.println(calc.evaluate(input));
          }
        catch (Exception e)
          {
            System.out.println(e.getMessage());
          }
      }
  }
}
