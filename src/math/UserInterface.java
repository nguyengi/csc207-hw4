package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Parameters: String[] args
 * Preconditions: The only numeric inputs the calculator can take are integers or fractions in the form BigInteger/BigInteger.
 * The first and last values entered cannot be operations, thus they can only be r-storage values, or numbers.
 * There must be one space in-between each number and operation value.
 * For fractions, do not put a space between the numerator, the slash, and the denominator. a/b
 * For division, put a space between the numbers you want to divide and the slash. G / H
 * The only legal operators are: + - * / ^ =
 * Postconditions: Will return an accurate fraction or integer answer if math expression entered is valid. Otherwise, will return a specific error message.
 *
 */

public class UserInterface
{
  public static void main(String[] args)
    throws Exception
  {
    String input = "";
    Calculator calc = new Calculator();
    BufferedReader eyes = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Welcome to the Calculator! ");
    System.out.println("There must be a space between each term and operation:");
    System.out.println("Ex) 71 + 256");
    System.out.println("To assign values to the storage elements, they must be listed first:");
    System.out.println("Ex) r0 = r2 = r5 = 4");
    System.out.println("To quit, type Q as a single command");
    System.out.println("Ex) Q");

    System.out.println(" ");
    while (true)
      {
        System.out.print("Enter expression (Q to quit): ");
        input = eyes.readLine();
        if (input.equalsIgnoreCase("Q"))
          {
            System.out.println("Quitting calculator.");
            return;
          } // Quit Calculator Function
        try
          {
            System.out.println(calc.evaluate(input));
          } // Evaluate expression
        catch (Exception e)
          {
            System.out.println(e.getMessage());
          } // catch Exceptions
      } // Calculator Loop
  } // Calculator Main
} // UserInterface Class